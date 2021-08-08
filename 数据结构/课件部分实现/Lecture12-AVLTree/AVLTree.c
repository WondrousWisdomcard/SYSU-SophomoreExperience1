#include<stdio.h>
#include<stdlib.h>
typedef struct Node{
    int val;
    int depth; //为了方便将树可视化
    struct Node* left;
    struct Node* right;
    struct Node* parent;
}Node;

typedef struct Tree{
    Node* root; //根节点的爸爸，为空元素为了方便根节点的删除和调整，规定root的左二子是树的根节点
}Tree;

///////////
Tree tree;
///////////

void initTree(){ // 创建树
    tree.root = (Node*)malloc(sizeof(Node));
    tree.root->parent = NULL;
    tree.root->left = NULL;
    tree.root->right = NULL;
    tree.root->depth = -1;
}

void clear(Node* node){
    if(node != NULL){
        clear(node->left);
        clear(node->right);
        free(node);
    }
}

void deleteTree(){ // 删除树
    clear(tree.root->left);
    free(tree.root);
}

void depthMaintain(Node* node, int i){ //方便树的可视化
    if(node == NULL)
    return;
    depthMaintain(node->left, i);
    depthMaintain(node->right, i);
    node->depth += i;
}

int getHeight(Node* node){
    if(node == NULL)
    return -1;
    int h = 0;
        int l = getHeight(node->left);
        h = h > 1 + l ? h : 1 + l;
        int r = getHeight(node->right);
        h = h > 1 + r ? h : 1 + r;
    return h;
}

int getBalanceFactor(Node* node) //这个height有问题 我们维护的和课件上的height不是同一个东西，而且而这没有关系，我们维护的叫depth
{
    int bf = 0;
    if(node == NULL)
    return 0;
    else if(node->left == NULL && node->right == NULL){
        bf = 0;
    }
    else if(node->left != NULL && node->right == NULL){
        bf = getHeight(node->left)+1;
    }
    else if(node->left == NULL && node->right != NULL){
        bf =  -getHeight(node->right)-1;
    }
    else if(node->right != NULL && node->left != NULL){
        bf = getHeight(node->left) - getHeight(node->right);
    }
    return bf;
}

int isBalance(Node* node){
    int bf = getBalanceFactor(node);
    return (bf == 0 || bf == 1 || bf == -1);
}

Node* findUnbalancedParents(Node *node){ // 判断树是否平衡 node指不平衡的插入后/删除后爸爸路径第一个不平衡的点
    while(isBalance(node)){
        node = node->parent;
        if(node == tree.root)
        {
            return NULL;
        }
    }
    return node;
}

void AVLTransform(Node* temp){ // 四种AVL转换, temp指最近一个不平衡点，麻烦的是对高度和父母的维护,不麻烦，画图
    //判断是四种类型中的哪一种
    // 1.left-left
    if(getBalanceFactor(temp) == 2 && getBalanceFactor(temp->left) == 1){
        Node* f = temp;
        Node* b = temp->left;
        Node* bl = b->left;
        Node* br = b->right;
        Node* fr = f->right;

        if(f->parent->left == f)
        f->parent->left = b;
        else
        f->parent->right = b;

        b->parent = f->parent;
        b->right = f;
        b->depth--;

        f->parent = b;
        f->left = br;
        f->depth++;

        depthMaintain(bl,-1);
        if(br != NULL)
        br->parent = f;
        depthMaintain(fr,1);
    }
    // 2.right-right
    else if(getBalanceFactor(temp) == -2 && getBalanceFactor(temp->right) == -1){
        Node* f = temp;
        Node* b = temp->right;
        Node* bl = b->left;
        Node* br = b->right;
        Node* fl = f->left;

        if(f->parent->left == f)
        f->parent->left = b;
        else
        f->parent->right = b;

        b->parent = f->parent;
        b->left = f;
        b->depth--;

        f->parent = b;
        f->right = bl;
        f->depth++;

        depthMaintain(br,-1);
        if(bl != NULL)
        bl->parent = f;
        depthMaintain(fl,1);
    }
    // 3.left-right
    else if(getBalanceFactor(temp) == 2 && getBalanceFactor(temp->left) == -1){
        Node* f = temp;
        Node* b = f->left;
        Node* d = b->right;
        Node* bl = b->left;
        Node* fr = f->right;
        Node* dl = d->left;
        Node* dr = d->right;
        
        if(f->parent->left == f)
        f->parent->left = d;
        else
        f->parent->right = d;

        d->parent = f->parent;
        d->left = b;
        d->right = f;
        d->depth -= 2;

        b->parent = d;
        b->right = dl;

        f->parent = d;
        f->left = dr;
        f->depth ++;

        if(dl != NULL)
        dl->parent = b;
        depthMaintain(dl,-1);

        if(dr != NULL)
        dr->parent = f;
        depthMaintain(dr,-1);

        depthMaintain(fr,1);
    }
    // 4.right-left
    else if(getBalanceFactor(temp) == -2 && getBalanceFactor(temp->right) == 1){
        Node* f = temp;
        Node* b = f->right;
        Node* d = b->left;
        Node* br = b->right;
        Node* fl = f->left;
        Node* dl = d->left;
        Node* dr = d->right;
        
        if(f->parent->left == f)
        f->parent->left = d;
        else
        f->parent->right = d;

        d->parent = f->parent;
        d->left = f;
        d->right = b;
        d->depth -= 2;

        b->parent = d;
        b->left = dr;

        f->parent = d;
        f->right = dl;
        f->depth ++;

        if(dl != NULL)
        dl->parent = f;
        depthMaintain(dl,-1);

        if(dr != NULL)
        dr->parent = b;
        depthMaintain(dr,-1);

        depthMaintain(fl,1);
    }
}

Node* insertNode(Node* node,int val){ //调用该函数时应该传入的参数是root->left!!!
    if(node == NULL){
        node = (Node*)malloc(sizeof(Node));
        node->left = NULL;
        node->right = NULL;
        node->val = val;
        node->depth = 0;
        node->parent = tree.root;
        tree.root->left = node;
        return node; //ok
    }
    else if(node->left == NULL && node->val > val){
        node->left = (Node*)malloc(sizeof(Node));
        node->left->left = NULL;
        node->left->right = NULL;
        node->left->val = val;

        node->left->depth = node->depth + 1;
        node->left->parent = node;
        return node;
    }
    else if(node->right == NULL && node->val < val){
        node->right = (Node*)malloc(sizeof(Node));
        node->right->left = NULL;
        node->right->right = NULL;
        node->right->val = val;
        
        node->right->depth = node->depth + 1;
        node->right->parent = node;
        return node;
    }
    else if(node->left != NULL && node->val > val){
        return insertNode(node->left,val);
    }
    else if(node->right != NULL && node->val < val){
        return insertNode(node->right,val);
    }
    else if(node->val == val){
        return NULL;
    }
    
}

void show(Node* node){
    if(node == NULL)
    return;

    for(int i = 0; i < node->depth; i++) printf("\t");
    printf("Val: %d | Depth: %d | Parents: %d | BalanceFactor: %d\n", node->val, node->depth, node->parent == tree.root?-1:node->parent->val,getBalanceFactor(node));
    if(node->left == NULL){
        for(int i = 0; i < node->depth+1; i++) 
        printf("\t");
        printf("Empty Left\n");
    }
    else{
        show(node->left);
    }
    if(node->right == NULL){
        for(int i = 0; i < node->depth+1; i++) 
        printf("\t");
        printf("Empty Right\n");
    }
    else{
        show(node->right);
    }
}

void insertAndBalance(int val){
    Node* temp1 = insertNode(tree.root->left,val);
    
    if(temp1 != NULL){
        Node* temp2 = findUnbalancedParents(temp1);
        if(temp2 != NULL){
            ////////////////////////////////
            printf("\nBefore Balance\n");
            show(tree.root->left);
            /////////////////////////////////
            AVLTransform(temp2);
            /////////////////////////////////
            printf("\nAfter Balance\n");
            show(tree.root->left);
            /////////////////////////////////
        }
    }
}

int initTreeByArray(int* arr,int size){
    if(size == 0){
        tree.root->left = NULL;
        return 1;
    }
    else{
        for(int i = 0; i < size; i++){
            insertAndBalance(arr[i]);
        }
        return 1;
    }
}

void test1()
{
    printf("\n\nTEST1 - Right-Left and Left-Left\n");
    int arr1[10] = {36,12,44,7,17,38,45,3,10,27};
    initTree();
    initTreeByArray(arr1, 10);

    printf("\nINIT: Init a tree form Lecture12 Page 10\n");
    show(tree.root->left);
    
    printf("\nSTEP1: insert 23 - Right-Left AVL Transform\n");
    insertAndBalance(23);

    printf("\nSTEP2: insert 6 - Left-Left AVL Transform This will chage the root of the tree)\n");
    insertAndBalance(6);

    printf("\nSTEP3: insert 29 - Normal Insert without AVL Transform\n");
    insertAndBalance(29);
    show(tree.root->left);

    deleteTree();
}

void test2(){
    printf("\n\nTEST2 - Right-Right and Left-Right\n");
    int arr1[10] = {10,5,12,1,11,21,27};
    initTree();
    initTreeByArray(arr1, 7);

    printf("\nINIT: Init a tree\n");
    show(tree.root->left);
    
    printf("\nSTEP1: insert 30 - Right-Right AVL Transform\n");
    insertAndBalance(30);

    printf("\nSTEP2: insert 3 - Left-Right AVL Transform\n");
    insertAndBalance(3);

    deleteTree();
}

int main(){
    test1();
    test2();
    return 0;
}

/*

Node* deleteNode(Node* node,int val){ // 删除新节点，要进行高度，父母结点的维护，要进行平衡的维护，返回删除节点的父母节点
    if(node == NULL){
        return NULL;
    }
    if(node->left == NULL && node->val > val){
        return NULL;
    }
    else if(node->right == NULL && node->val < val){
        return NULL;
    }
    
    else if(node->left != NULL && node->left->val == val){ // node's left is erased
        Node* tempLeft = node->left->left;
        Node* tempRight = node->left->right;
        if(tempLeft == NULL && tempRight == NULL){ // no child
            free(node->left);
            node->left = NULL;
        }
        else if(tempLeft != NULL && tempRight == NULL){ // left child
            free(node->left);
            node->left = tempLeft;
            tempLeft->parent = node;
            depthMaintain(tempLeft,-1);//高度减一
        }
        else if(tempLeft == NULL && tempRight != NULL){ // right child
            free(node->left);
            node->left = tempRight;
            tempRight->parent = node;
            depthMaintain(tempRight,-1);//高度减一
        }
        else if(tempLeft != NULL && tempRight != NULL){ // two children
            Node* tempLeftest = tempRight;
            int tempHeight = node->left->depth;
            while(tempLeftest->left != NULL){
                if(tempLeftest->left->left != NULL){
                    tempLeftest = tempLeftest->left;
                }
                else{
                    break;
                }
            }
            free(node->left);
            Node* tempLeftestRight = tempLeftest->left->right;
            depthMaintain(tempLeftestRight,-1);
            tempLeftest->left->left = tempLeft;
            tempLeft->parent = tempLeftest->left;
            tempLeftest->left->right =tempRight;
            tempRight->parent = tempLeftest->left;

            tempLeftest->left->depth = tempHeight;
            tempLeftest->left->parent = node;
        
            node->left = tempLeftest->left;
            tempLeftest->left = tempLeftestRight;
            tempLeftestRight->parent = tempLeftest;
        }
        return node;
    }
    else if(node->right != NULL && node->right->val == val){ // node's right is erased
        Node* tempLeft = node->right->left;
        Node* tempRight = node->right->right;
        if(tempLeft == NULL && tempRight == NULL){ // no child
            free(node->right);
            node->right = NULL;
        }
        else if(tempLeft != NULL && tempRight == NULL){ // left child
            free(node->right);
            node->right = tempLeft;
            tempLeft->parent = node;
            depthMaintain(tempLeft,-1);//高度减一
        }
        else if(tempLeft == NULL && tempRight != NULL){ // right child
            free(node->right);
            node->right = tempRight;
            tempRight->parent = node;
            depthMaintain(tempRight,-1);//高度减一
        }
        else if(tempLeft != NULL && tempRight != NULL){ // two children
            Node* tempLeftest = tempRight;
            int tempHeight = node->right->depth;
            while(tempLeftest->left != NULL){
                if(tempLeftest->left->left != NULL){
                    tempLeftest = tempLeftest->left;
                }
                else{
                    break;
                }
            }
            free(node->right);
            Node* tempLeftestRight = tempLeftest->left->right;
            depthMaintain(tempLeftestRight,-1);
            tempLeftest->left->left = tempLeft;
            tempLeft->parent = tempLeftest->left;
            tempLeftest->left->right =tempRight;
            tempRight->parent = tempLeftest->left;

            tempLeftest->left->depth = tempHeight;
            tempLeftest->left->parent = node;

            node->right = tempLeftest->left;
            tempLeftest->left = tempLeftestRight;
            tempLeftestRight->parent = tempLeftest;
        }
        return node;
    }
    else if(node->left != NULL && node->val > val){
        return deleteNode(node->left,val);
    }
    else if(node->right != NULL && node->val < val){
        return deleteNode(node->right,val);
    }
}

void deleteAndBalance(int val){
    Node* temp1 = deleteNode(tree.root,val);
    
    while(temp1 != NULL && temp1 != tree.root){
        Node* temp2 = findUnbalancedParents(temp1);
        if(temp2 != NULL){
            AVLTransform(temp2);
        }
        temp1 = temp1->parent;
    }
}

Node* find(Node* node,int val){
    if(node == NULL){
        return NULL;
    }
    else{
        if(node->val == val){
            return node;
        }
        else if(node->val > val){
            return find(node->left,val);
        }
        else if(node->val < val){
            return find(node->right,val);
        }
    }
}

*/