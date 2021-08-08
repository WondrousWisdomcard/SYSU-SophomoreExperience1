# Experimental Report 12 : Implementation of PRIM Algorithm Using binary min-Heap

## Description of Work 12-1 and data structures applied

Represent the graph with an Adjacency List

#### 邻接表结构
    typedef struct AdjacencyNode //邻接表的边表的每一个节点
    {
        double edgeWeight; //边权
        int adacentVertex; //与边关联的一个点
        struct AdjacencyNode *next;
    } AdjacencyNode;

    typedef struct VertexNode //定点表
    {
        int vertexIndex; //顶点编号
        AdjacencyNode *edgeList; //边链
    } VertexNode;

    typedef struct AdjacencyList //邻接表
    {
        VertexNode vertexList[MAXSIZE]; //顶点数组
        int numOfVertices; //图的总点数
        int numOfEdges; //图的总边数
    } AdjacencyList;

    AdjacencyList adjacencyList; //邻接表

    //方法：
    void InitAdjacencyList(int n); //初始化邻接表
    void createEdge(int vertex1, int vertex2, double weight);//添加一条顶点为vertex1和vertex2,边权为weight的无向边
    void getTestGraph(); //生成课件Lecture29中Page47那个九顶点无向图
    void clearAdjacencyList(); //清空链表
    void showGraph(); //打印邻接表

Determine data structures for the binary min-heap of improved Prim’s algorithm

#### Prim数组
    
    //Prim算法用到的数组和堆，我们用一个数据存储Prim算法需要的内容，堆中存储的是该数组的index    
    typedef struct PrimNode
    {
        int vertexIndex; // 顶点自身的编号
        int visited; //是否访问过，1为已访问，0为未访问
        int distance; //最近距离
        int parent; // 父母节点的编号
        int posInHeap; //在堆中的位置，用于在距离更新后调整堆结构
    } PrimNode;

    typedef struct PrimArray
    {
        PrimNode array[MAXSIZE]; //Prim需要的数组
        int numOfVertices;
    } PrimArray;

    PrimArray primArray;//Prim需要的数组
    //方法：
    void InitPrimArray(AdjacencyList adjacencyList); //初始化Prim数组

#### 堆结构

    int Heap[MAXSIZE + 1];
    //小根堆结构，Heap[0]存储堆的Size，堆内[1 ~ MAXSIZE-1]存储的是每一个PrimNode的index
    //堆内的所有index对应的primArray.array[index].visited 必须等于0
    //方法：
    void downToTop(int i);//从下往上调整堆
    void topToDown(int i);//从上往下调整堆
    int Pop();
    void Push(int index);

    //其余方法：
    void showHeap(); //打印堆
    void showResult(); //打印Prim数组生成结果

Implement the improved Prim’s algorithm using binary min-heap in C language.

参考程序中Prim()函数

程序输出结果，与课件中的结果相同：（上半部分是邻接表，下半部分是数组）

    C->|F:5.0|->|E:2.0|->|B:2.0|
    D->|H:8.0|->|G:9.0|->|E:11.0|->|B:2.0|->|A:1.0|
    E->|I:5.0|->|H:1.0|->|G:4.0|->|F:3.0|->|D:11.0|->|C:2.0|->|B:6.0|->|A:8.0|
    F->|I:8.0|->|H:7.0|->|E:3.0|->|C:5.0|->|B:1.0|
    G->|H:6.0|->|E:4.0|->|D:9.0|
    H->|I:3.0|->|G:6.0|->|F:7.0|->|E:1.0|->|D:8.0|
    I->|H:3.0|->|F:8.0|->|E:5.0|
    | A | 1 | 0 | @ | 
    | B | 1 | 2 | D |
    | C | 1 | 2 | B |
    | D | 1 | 1 | A |
    | E | 1 | 2 | C |
    | F | 1 | 1 | B |
    | G | 1 | 4 | E |
    | H | 1 | 1 | E |
    | I | 1 | 3 | H |

## Run time analysis

假设无向图有n个顶点，m条边，初始化邻接表的时间和空间都是O(m)，初始化Prim数组的时间和空间都是/theta(n),堆的初始化时间为/theta(1)，空间为/theta(n)。

Prim程序最外层While共循环n次，每次Pop需要O(ln(n))的时间，因而有总时间复杂度为O(nln(n))，而里层的While共执行\theta(m)次，因为所有邻接表长度和为2m。考虑最坏情况每次都要Push，每次Push需要O(ln(n))的时间,因而这部分综时间复杂度为O(mln(n)),因而有邻接表堆优化Prim算法时间复杂度为O((m+n)ln(n))即**O(mln(n))**。

### What happened if we represent the graph in an Adjacency Matrix of lower triangular

对于下三角邻接矩阵：

假设无向图有n个顶点，m条边，初始化邻接表的时间和空间都是O(n^2)，初始化Prim数组的时间和空间都是/theta(n),堆的初始化时间为/theta(1)，空间为/theta(n)。

Prim程序最外层While共循环n次，每次Pop需要O(ln(n))的时间，因而有总时间复杂度为O(nln(n))，而里层的While共执行\theta(1/2*n^2)次，考虑最坏情况每次都要Push，每次Push需要O(n^2*ln(n))的时间,因而这部分综时间复杂度为O(n^2*ln(n)),因而有邻接表堆优化Prim算法时间复杂度为O((n^2+n)ln(n))即**O(n^2ln(n))**。