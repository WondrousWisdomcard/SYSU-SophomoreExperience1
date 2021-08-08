# Lab Work 07-2. Haffman Coding

## Description of Lab Work 07-1 and data structures applied

### The data structures for a binary Huffman tree

我们使用类似于静态链表的方式，创建Node数组，并将数组下标(int)视作数组的地址：

    typedef struct Node{
        int weight;
        int left;
        int right;
        int parent;
    }Node;

为存放每一个权值点对应的二进制编码，我们使用结构体Code来存放内容：

    typedef struct Code{
        int weight;
        char* code;
    }Code;

### Design and implement a Huffman coding prototype

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

### Implement the algorithm of creating a binary Huffman tree for a given postive integer sequence

    Node* generateHuffmanTree(int* arr, int n){ //给定权值int数组，new一颗Node树，以Node数组的形式存储
        Node* nodeArr = (Node*)malloc(sizeof(Node) * (2 * n + 1));
        for(int i = 0; i < 2 * n - 1 ; i++){ //给数组赋初始值，前n各为叶子结点
            nodeArr[i].weight = i < n ? arr[i] : 0;
            nodeArr[i].left = -1;
            nodeArr[i].right = -1;
            nodeArr[i].parent = -1;
        }

        for(int j = n; j < 2 * n - 1; j++){
            int w1 = 9999, w2 = 9999;
            int p1 = -1, p2 = -1;
            int i1,i2 = 0;
            for(i1 = 0; i1 < j; i1++){ //找出权值最小的节点
                if(nodeArr[i1].parent == -1){
                    if(nodeArr[i1].weight < w1){
                        w1 = nodeArr[i1].weight;
                        p1 = i1;
                    }
                }
            }
            for(i2 = 0; i2 < j; i2++){ //找出权值第二小的节点
                if(nodeArr[i2].parent == -1 && i2 != p1){
                    if(nodeArr[i2].weight < w2){
                        w2 = nodeArr[i2].weight;
                        p2 = i2;
                    }
                }
            }

            nodeArr[j].left = p1; //节点的连接
            nodeArr[j].right = p2;
            nodeArr[j].weight = w1 + w2;
            
            if(p1 != -1) nodeArr[p1].parent = j;
            if(p2 != -1) nodeArr[p2].parent = j;
        }

        return nodeArr; //返回数组头节点
    }

    Code* generateHuffmanCode(Node* nodeArr, int n){ // 生成哈夫曼编码并存储在Code数组中并返回
        Code* codeArr = (Code*)malloc(sizeof(Code)*n);
        int now,front = -1;
        int count = 0;

        char code[2*n+1]; //赋初始值
        for(int i = 0; i < 2*n+1; i++){
            code[i] = 0;
        }
        code[2*n] = '\0';

        for(int i = 0; i < n; i++){ //循环：找每一个权值点的编码
            count = 0;
            now = i;
            front = nodeArr[now].parent;
            while(front != -1){ //往前遍历直至访问根节点
                if(nodeArr[front].left == now){
                    code[count++] = '0'; //左二子赋值0
                }
                else if(nodeArr[front].right == now){
                    code[count++] = '1'; //右儿子赋值1
                }
                now = front;
                front = nodeArr[front].parent;
            }

            codeArr[i].weight = nodeArr[i].weight;
            codeArr[i].code = (char*)malloc((   count+1) * sizeof(char));
            for(int j = 0; j < count; j++){ //反转数组，存下编码
                codeArr[i].code[j] = code[count - j - 1];
            }
            codeArr[i].code[count] = '\0';
        }
        return codeArr; //返回Code节点数组
    }

## Testing cases of Lab Work 07-1

    测试函数：

    void test1(){
        printf("\nTest1:\n");
        int arr[9] = {2,1,1,2,3,3,4,6,15};
        Node* nodeArr = generateHuffmanTree(arr,9); //生成树数组
        Code* codeArr = generateHuffmanCode(nodeArr,9); //生成编码数组
        //for(int i = 0; i < 2*9-1; i++){
        //    printf("W:%d L:%d R:%d P:%d \n",nodeArr[i].weight,nodeArr[i].left, nodeArr[i].right, nodeArr[i].parent);
        //}
        showHuffmanCode(codeArr,9);
        deleteHuffmanCode(codeArr,9); //删除树数组
        deleteHuffmanTree(nodeArr,9); //删除编码数组
    }

### Test1:

    //测例：arr[9] = {2,1,1,2,3,3,4,6,15}; 
    //选自蔡老师Lecture15 PPT案例
    //输出：

    Test1:
    Weight:  2  Code:     1000
    Weight:  1  Code:    10100
    Weight:  1  Code:    10101
    Weight:  2  Code:     1001
    Weight:  3  Code:     1011
    Weight:  3  Code:     1110
    Weight:  4  Code:     1111
    Weight:  6  Code:      110
    Weight: 15  Code:        0

### Test2:

    //测例，以该数组为权值生成哈夫曼树
    int arr[5] = {2,6,4,3,15}; 

    // decode测试
    char code[5] = {'1','1','1','0','\0'};
    int de = decodeHuffmanCode(nodeArr,5,code,4); //2

    int de3 = decodeHuffmanCode(nodeArr,5,code,3); //不是叶子节点

    // decode测试2
    char code2[5] = {'0','\0'};
    int de2 = decodeHuffmanCode(nodeArr,5,code2,1);//15

    //输出：

    Test2:
    1110 's weight is 2
    [Decode Error] 1110 's weight is -1
    0 's weight is 15
    Weight:  2  Code:     1110
    Weight:  6  Code:       10
    Weight:  4  Code:      110
    Weight:  3  Code:     1111
    Weight: 15  Code:        0

---