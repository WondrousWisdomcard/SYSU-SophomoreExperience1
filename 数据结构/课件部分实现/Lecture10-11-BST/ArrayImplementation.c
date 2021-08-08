#include<stdio.h>
#include<stdlib.h>

int cap = 8;

typedef struct Node{
    int val;
}Node;
// 标志位 -1 表示未被使用

///////////
Node* Tree = NULL;
///////////

void createTree(){
    if(Tree == NULL)
    Tree = (Node*)malloc(sizeof(Node)*cap);
    Tree[0].val = 0;
    for(int i = 1; i < cap; i++)
    {
        Tree[i].val = -1;
    }
}
void deleteTree(){
    free(Tree);
}

void expandTree(){
    Node* temp = (Node*)malloc(sizeof(Node)*cap*2);
    temp[0].val = Tree[0].val;
    for(int i = 1; i < cap; i++){
        temp[i].val = Tree[i].val;
    }
    for(int i = cap; i < cap*2; i++){
        temp[i].val = -1;
    }
    free(Tree);
    Tree = temp;
    cap = cap*2;
}

int insert(int val){
    if(Tree[0].val == 0){
        Tree[1].val = val;
        Tree[0].val = 1;
        return 1;
    }
    int i = 1;
    while(Tree[i].val != -1 && i < cap){
        if(Tree[i].val == val){
            return 0;
        }
        else if(Tree[i].val > val){
            i = i*2;
        }
        else if(Tree[i].val < val){
            i = i*2 + 1;
        }
    }
    if(i >= cap){
        expandTree();
        return insert(val);
    }
    else{
        Tree[i].val = val;
        Tree[0].val++;
        return 1;
    }
}

int delete(int val){
    //好麻烦呀
}

int find(int val){
    if(Tree[0].val == 0){
        return -1;
    }
    else{
        int i = 1;
        while(Tree[i].val != -1 && i < cap){
            if(Tree[i].val == val){
                return i;
            }
            else if(Tree[i].val > val){
                i = i*2;
            }
            else if(Tree[i].val < val){
                i = i*2 + 1;
            }
        }
    }
    return -1;
}

void Inorder(int i){
    if(Tree[i].val == -1 || i >= cap)
    return;
    Inorder(2*i);
    printf("%d ", Tree[i].val);
    Inorder(2*i+1);
}

void showArray(){
    printf("Size: %d \n",Tree[0].val);
    printf("Cap: %d \n",cap);
    for(int i=1; i < cap; i++){
        printf("%d ", Tree[i].val);
    }
    printf("\n");
}

int main(){
    createTree();
    showArray();
    
    


    deleteTree();
    return 0;
}
void test_insert(){
    insert(2);
    showArray();
    insert(3);
    showArray();
    insert(1);
    showArray();
}
void test_expend_find(){
    insert(1);
    insert(10);
    insert(2);
    insert(6);
    insert(4);
    insert(3);
    insert(8);
    insert(5);
    showArray();

    printf("Find 10 in index %d\n",find(10));
    printf("Find 6 in index %d\n",find(6));
    printf("Find 1 in index %d\n",find(1));
    printf("Find 100 in index %d\n",find(100));
}
void test_inorder(){
    insert(1);
    insert(10);
    insert(2);
    insert(6);
    insert(4);
    insert(3);
    insert(8);
    insert(5);
    Inorder(1);
}