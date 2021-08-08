#include<stdio.h>
#include<stdlib.h>
/*
Determine the data structures for a binary Huffman tree
Implement the algorithm of creating a binary Huffman tree for a given postive integer sequence
Design and implement a Huffman coding prototype
*/

typedef struct Node{
    int weight;
    int left;
    int right;
    int parent;
}Node;

typedef struct Code{
    int weight;
    char* code;
}Code;

//函数原型：
Node* generateHuffmanTree(int* arr, int n);
//根据数组的权值生成一颗哈夫曼二叉树，该树利用数组存储，返回数组首地址，该树的根节点在数组最后一个元素

void deleteHuffmanTree(Node* arr, int n);
//删除生成的哈夫曼树数组

Code* generateHuffmanCode(Node* nodeArr,int n);
//哈夫曼编码，将得到的每一个叶子节点的编码存储在结构体Code中

void deleteHuffmanCode(Code* arr,int n);
//删除生成的Code结构体数组

int decodeHuffmanCode(Node* arr, int n, char* code, int m);
//哈夫曼树解码，输入编码数组，返回对应权值

void showHuffmanCode(Code* arr, int n);
//格式： Weight: <weight>  Code: <code>

Node* generateHuffmanTree(int* arr, int n){ //给定权值int数组，new一颗Node树，以Node数组的形式存储
    Node* nodeArr = (Node*)malloc(sizeof(Node) * (2 * n + 1));
    for(int i = 0; i < 2 * n - 1 ; i++){
        nodeArr[i].weight = i < n ? arr[i] : 0;
        nodeArr[i].left = -1;
        nodeArr[i].right = -1;
        nodeArr[i].parent = -1;
    }

    for(int j = n; j < 2 * n - 1; j++){
        int w1 = 9999, w2 = 9999;
        int p1 = -1, p2 = -1;
        int i1,i2 = 0;
        for(i1 = 0; i1 < j; i1++){
            if(nodeArr[i1].parent == -1){
                if(nodeArr[i1].weight < w1){
                    w1 = nodeArr[i1].weight;
                    p1 = i1;
                }
            }
        }
        for(i2 = 0; i2 < j; i2++){
            if(nodeArr[i2].parent == -1 && i2 != p1){
                if(nodeArr[i2].weight < w2){
                    w2 = nodeArr[i2].weight;
                    p2 = i2;
                }
            }
        }

        nodeArr[j].left = p1;
        nodeArr[j].right = p2;
        nodeArr[j].weight = w1 + w2;
        
        if(p1 != -1) nodeArr[p1].parent = j;
        if(p2 != -1) nodeArr[p2].parent = j;
    }

    return nodeArr;
}

void deleteHuffmanTree(Node* arr, int n){ // free掉Node数组
    free(arr);
}

Code* generateHuffmanCode(Node* nodeArr, int n){ // 生成哈夫曼编码并存储在Code数组中并返回
    Code* codeArr = (Code*)malloc(sizeof(Code)*n);
    int now,front = -1;
    int count = 0;

    char code[2*n+1];
    for(int i = 0; i < 2*n+1; i++){
        code[i] = 0;
    }
    code[2*n] = '\0';

    for(int i = 0; i < n; i++){
        count = 0;
        now = i;
        front = nodeArr[now].parent;
        while(front != -1){
            if(nodeArr[front].left == now){
                code[count++] = '0';
            }
            else if(nodeArr[front].right == now){
                code[count++] = '1';
            }
            now = front;
            front = nodeArr[front].parent;
        }

        codeArr[i].weight = nodeArr[i].weight;
        codeArr[i].code = (char*)malloc((count+1) * sizeof(char));
        for(int j = 0; j < count; j++){
            codeArr[i].code[j] = code[count - j - 1];
        }
        codeArr[i].code[count] = '\0';
    }
    return codeArr;
}

void deleteHuffmanCode(Code* arr,int n){ //free掉Code数组
    for(int i = 0; i < n; i++){
        free(arr[i].code);
    }
    free(arr);
}

int decodeHuffmanCode(Node* arr, int n, char* code, int m){ //哈夫曼树解码，输入编码数组，返回对应权值
    int des = 2*n-2;
    for(int i = 0; i < m; i++){
        if(des == -1){
            printf("[Decode Error] ");
            return -1;
        }
        else if(code[i] == '0' && arr[des].left != -1){
            des = arr[des].left;
        }
        else if(code[i] == '1' && arr[des].right != -1){
            des = arr[des].right;
        }
        else{
            printf("[Decode Error] ");
            return -1;
        }
    }
    if(arr[des].left != -1 || arr[des].right != -1){
        printf("[Decode Error] ");
        return -1;
    }
    return arr[des].weight;
}

void showHuffmanCode(Code* arr, int n){ 
    for(int i = 0; i < n; i++){
        printf("Weight: %2d  Code: %8s\n",arr[i].weight,arr[i].code);
    }
}

void test1(){
    printf("\nTest1:\n");
    int arr[9] = {2,1,1,2,3,3,4,6,15};
    Node* nodeArr = generateHuffmanTree(arr,9);
    Code* codeArr = generateHuffmanCode(nodeArr,9);
    //for(int i = 0; i < 2*9-1; i++){
    //    printf("W:%d L:%d R:%d P:%d \n",nodeArr[i].weight,nodeArr[i].left, nodeArr[i].right, nodeArr[i].parent);
    //}
    showHuffmanCode(codeArr,9);
    deleteHuffmanCode(codeArr,9);
    deleteHuffmanTree(nodeArr,9);
}

void test2(){
    printf("\nTest2:\n");
    int arr[5] = {2,6,4,3,15};
    Node* nodeArr = generateHuffmanTree(arr,5);
    Code* codeArr = generateHuffmanCode(nodeArr,5);

    // decode测试
    char code[5] = {'1','1','1','0','\0'};
    int de = decodeHuffmanCode(nodeArr,5,code,4); //2
    printf("%s 's weight is %d\n",code,de);

    int de3 = decodeHuffmanCode(nodeArr,5,code,3); //不是叶子节点
    printf("%s 's weight is %d\n",code,de3);

    // decode测试2
    char code2[5] = {'0','\0'};
    int de2 = decodeHuffmanCode(nodeArr,5,code2,1);//15
    printf("%s 's weight is %d\n",code2,de2);

    //for(int i = 0; i < 2*5-1; i++){
    //    printf("W:%d L:%d R:%d P:%d \n",nodeArr[i].weight,nodeArr[i].left, nodeArr[i].right, nodeArr[i].parent);
    //}

    showHuffmanCode(codeArr,5);
    deleteHuffmanCode(codeArr,5);
    deleteHuffmanTree(nodeArr,5);
}
int main(){
    test1();
    test2();
    return 0;
}