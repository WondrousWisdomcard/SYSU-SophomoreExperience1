// 要点：
// 1. erase in BST
// 2. next bigger node or last small node
// 3. find the k th node with tree_size (and maintain)

#include<stdio.h>
#include<stdlib.h>
typedef struct Node{
    int val;
    int size;
    int height;
    struct Node* left;
    struct Node* right;
}Node;

typedef struct Tree{
    Node* root;
}Tree;

////////
Tree tree;
////////

void initTree(){
    tree.root = NULL;
} // 通过测试


int insert(Node* node,int val){
    if(node == NULL){
        node = (Node*)malloc(sizeof(Node));
        node->left = NULL;
        node->right = NULL;
        node->val = val;
        node->height = 0;
        node->size = 1;
        tree.root = node; /////////////////
        return 1;
    }
    else if(node->left == NULL && node->val > val){
        node->left = (Node*)malloc(sizeof(Node));
        node->left->left = NULL;
        node->left->right = NULL;
        node->left->val = val;

        node->left->height = node->height + 1;
        node->left->size = 1;
        node->size += node->left->size;
        return 1;
    }
    else if(node->right == NULL && node->val < val){
        node->right = (Node*)malloc(sizeof(Node));
        node->right->left = NULL;
        node->right->right = NULL;
        node->right->val = val;
        
        node->right->height = node->height + 1;
        node->right->size = 1;
        node->size += node->right->size;
        return 1;
    }
    else if(node->left != NULL && node->val > val){
        return insert(node->left,val);
    }
    else if(node->right != NULL && node->val < val){
        return insert(node->right,val);
    }
    else if(node->val == val){
        return 0;
    }
    
} // 通过测试

int initTreeByArray(int* arr,int size){
    if(size == 0){
        tree.root = NULL;
        return 1;
    }
    else{
        for(int i = 0; i < size; i++){
            if(insert(tree.root,arr[i]) == 0){
                printf("INSERT ERROR AT VAL: %d\n",arr[i]);
            }
        }
        return 1;
    }
} // 通过测试

void heightMaintain(Node* node, int i){//height + i for each node in Tree node
    if(node == NULL)
    return;
    heightMaintain(node->left, i);
    heightMaintain(node->right, i);
    node->height += i;
}

int erase(Node* node,int val){
    if(node == NULL){
        return 0;
    }
    if(node->left == NULL && node->val > val){
        return 0;
    }
    else if(node->right == NULL && node->val < val){
        return 0;
    }
    
    else if(node->left != NULL && node->left->val == val){ // node's left is erased
        Node* tempLeft = node->left->left;
        Node* tempRight = node->left->right;
        if(tempLeft == NULL && tempRight == NULL){ // no child
            free(node->left);
            node->size--;
            node->left = NULL;
        }
        else if(tempLeft != NULL && tempRight == NULL){ // left child
            free(node->left);
            node->size--;
            node->left = tempLeft;
            heightMaintain(tempLeft,-1);//高度减一
        }
        else if(tempLeft == NULL && tempRight != NULL){ // right child
            free(node->left);
            node->size--;
            node->left = tempRight;
            heightMaintain(tempRight,-1);//高度减一
        }
        else if(tempLeft != NULL && tempRight != NULL){ // two children
            Node* tempLeftest = tempRight;
            int tempHeight = node->left->height;
            int tempSize = node->left->size - 1;
            while(tempLeftest->left != NULL){
                if(tempLeftest->left->left != NULL){
                    tempLeftest = tempLeftest->left;
                    tempLeftest->size--;
                }
                else{
                    break;
                }
            }
            free(node->left);
            Node* tempLeftestRight = tempLeftest->left->right;
            heightMaintain(tempLeftestRight,-1);
            tempLeftest->left->left = tempLeft;
            tempLeftest->left->right =tempRight;
            tempLeftest->left->size = tempSize;
            tempLeftest->left->height = tempHeight;
            node->left = tempLeftest->left;
            tempLeftest->left = tempLeftestRight;
        }
    }
    else if(node->right != NULL && node->right->val == val){ // node's right is erased
        Node* tempLeft = node->right->left;
        Node* tempRight = node->right->right;
        if(tempLeft == NULL && tempRight == NULL){ // no child
            free(node->right);
            node->size--;
            node->right = NULL;
        }
        else if(tempLeft != NULL && tempRight == NULL){ // left child
            free(node->right);
            node->size--;
            node->right = tempLeft;
            heightMaintain(tempLeft,-1);//高度减一
        }
        else if(tempLeft == NULL && tempRight != NULL){ // right child
            free(node->right);
            node->size--;
            node->right = tempRight;
            heightMaintain(tempRight,-1);//高度减一
        }
        else if(tempLeft != NULL && tempRight != NULL){ // two children
            Node* tempLeftest = tempRight;
            int tempHeight = node->right->height;
            int tempSize = node->right->size - 1;
            while(tempLeftest->left != NULL){
                if(tempLeftest->left->left != NULL){
                    tempLeftest = tempLeftest->left;
                    tempLeftest->size--;
                }
                else{
                    break;
                }
            }
            free(node->right);
            Node* tempLeftestRight = tempLeftest->left->right;
            heightMaintain(tempLeftestRight,-1);
            tempLeftest->left->left = tempLeft;
            tempLeftest->left->right =tempRight;
            tempLeftest->left->size = tempSize;
            tempLeftest->left->height = tempHeight;
            node->right = tempLeftest->left;
            tempLeftest->left = tempLeftestRight;
        }
    }
    else if(node->left != NULL && node->val > val){
        return erase(node->left,val);
    }
    else if(node->right != NULL && node->val < val){
        return erase(node->right,val);
    }
} // 通过测试,有漏洞:不能删除头节点,应该要添加三个if -【头节点特例】

Node* front(Node* node){
    Node* temp = node;
    while(temp->left != NULL){
        temp = temp->left;
    }
    return temp;
} // 通过测试

Node* back(Node* node){
    Node* temp = node;
    while(temp->right != NULL){
        temp = temp->right;
    }
    return temp;
} // 通过测试

void clear(Node* node){
    if(node != NULL){
        clear(node->left);
        clear(node->right);
        free(node);
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
} // 通过测试

int empty(Node* node){
    if(node == NULL){
        return 1;
    }
    else{
        return 0;
    }
}

void show(Node* node){
    if(node == NULL)
    return;

    for(int i = 0; i < node->height; i++) printf("\t");
    printf("VAL: %d | SIZE: %d | HEIGHT: %d\n", node->val, node->size, node->height);
    if(node->left == NULL){
        for(int i = 0; i < node->height+1; i++) 
        printf("\t");
        printf("EMPTY LEFT\n");
    }
    else{
        show(node->left);
    }
    if(node->right == NULL){
        for(int i = 0; i < node->height+1; i++) 
        printf("\t");
        printf("EMPTY RIGHT\n");
    }
    else{
        show(node->right);
    }
} // 通过测试

int main(){
    int arr1[10] = {5,4,3,2,1,6,7,8,9,10};
    initTree();
    initTreeByArray(arr1, 10);
    show(tree.root);
    
    

    clear(tree.root);
    return 0;
}

void test1_insert(){
    insert(tree.root,1);
    show(tree.root);
    insert(tree.root,9);
    show(tree.root);
    insert(tree.root,20);
    show(tree.root);
}

void test2_find_front_back(){
    printf("TREE'S FRONT: %d\n",front(tree.root)->val);
    printf("TREE'S BACK: %d\n",back(tree.root)->val);
    printf("11'S FRONT: %d\n",front(find(tree.root,11))->val);
    printf("11'S BACK: %d\n",back(find(tree.root,11))->val);
}

void test3_erase(){
    erase(tree.root,13);
    show(tree.root);
    erase(tree.root,4);
    show(tree.root);
    erase(tree.root,2);
    show(tree.root);
}