/*Lab Work 12-1. Implementation of PRIM Algorithm Using binary min-Heap
Note: Programming in C

Refer to the lecture in Prim’s algorithm - Algorithm Analysis - An improvement using binary min-heap.

Represent the graph with an Adjacency List
Determine data structures for the binary min-heap of improved Prim’s algorithm
Implement the improved Prim’s algorithm using binary min-heap in C language.
(End)*/

#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#define MAXSIZE 30
#define INF 9999
#define NON -1
/////////////////////////////////

//边表
typedef struct AdjacencyNode
{
    double edgeWeight;
    int adacentVertex;
    struct AdjacencyNode *next;
} AdjacencyNode;

//顶点表
typedef struct VertexNode
{
    int vertexIndex;
    AdjacencyNode *edgeList;
} VertexNode;

//邻接表
typedef struct AdjacencyList
{
    VertexNode vertexList[MAXSIZE];
    int numOfVertices;
    int numOfEdges;
} AdjacencyList;

AdjacencyList adjacencyList;

void InitAdjacencyList(int n)
{ //n is the number of vertices
    adjacencyList.numOfVertices = n;
    adjacencyList.numOfEdges = 0;
    for (int i = 0; i < n; i++)
    {
        adjacencyList.vertexList[i].vertexIndex = i;
        adjacencyList.vertexList[i].edgeList = NULL;
    }
}

void createEdge(int vertex1, int vertex2, double weight){
    AdjacencyNode* p1 = adjacencyList.vertexList[vertex1].edgeList;
    AdjacencyNode* n1 = (AdjacencyNode*)malloc(sizeof(AdjacencyNode));
    n1->edgeWeight = weight;
    n1->adacentVertex = vertex2;
    adjacencyList.vertexList[vertex1].edgeList = n1; //头插法
    n1->next = p1;
    /*
    AdjacencyNode* p2 = adjacencyList.vertexList[vertex2].edgeList;
    AdjacencyNode* n2 = (AdjacencyNode*)malloc(sizeof(AdjacencyNode));
    n2->edgeWeight = weight;
    n2->adacentVertex = vertex1;
    adjacencyList.vertexList[vertex2].edgeList = n2; //头插法
    n2->next = p2;
    */
}

void getTestGraph(){
    adjacencyList.numOfVertices = 9;
    adjacencyList.numOfEdges = 40;
    //A:
    createEdge(0,1,4);
    createEdge(0,3,1);
    createEdge(0,4,8);
    //B:
    createEdge(1,0,4);
    createEdge(1,2,2);
    createEdge(1,3,2);
    createEdge(1,4,6);
    createEdge(1,5,1);
    //C:
    createEdge(2,1,2);
    createEdge(2,4,2);
    createEdge(2,5,5);
    //D:
    createEdge(3,0,1);
    createEdge(3,1,2);
    createEdge(3,4,11);
    createEdge(3,6,9);
    createEdge(3,7,8);
    //E:
    createEdge(4,0,8);
    createEdge(4,1,6);
    createEdge(4,2,2);
    createEdge(4,3,11);
    createEdge(4,5,3);
    createEdge(4,6,4);
    createEdge(4,7,1);
    createEdge(4,8,5);
    //F:
    createEdge(5,1,1);
    createEdge(5,2,5);
    createEdge(5,4,3);
    createEdge(5,7,7);
    createEdge(5,8,8);
    //G:
    createEdge(6,3,9);
    createEdge(6,4,4);
    createEdge(6,7,6);
    //H:
    createEdge(7,3,8);
    createEdge(7,4,1);
    createEdge(7,5,7);
    createEdge(7,6,6);
    createEdge(7,8,3);
    //I:
    createEdge(8,4,5);
    createEdge(8,5,8);
    createEdge(8,7,3);
}

void clearAdjacencyList(){
    for(int i = 0; i < adjacencyList.numOfVertices; i++){
        AdjacencyNode* p = (adjacencyList.vertexList[i].edgeList);
        while(p != NULL){
            AdjacencyNode* q = p;
            p = p->next;
            if(q != NULL)
            free(q);
        }
    }
}

void showGraph(){
    printf("邻接表：");
    for(int i = 0; i < adjacencyList.numOfVertices; i++){
        AdjacencyNode* p = adjacencyList.vertexList[i].edgeList;
        printf("顶点%c",'A' + adjacencyList.vertexList[i].vertexIndex);
        while(p != NULL){
            printf("->|%c:%.1lf|",'A' + p->adacentVertex,p->edgeWeight);
            p = p->next;
        }
        printf("\n");
    }
}
/////////////////////////////////

typedef struct PrimNode
{
    int vertexIndex; // the vertexIndex of itself
    int visited;
    int distance;
    int parent; // the vertexIndex of parent
    int posInHeap;
} PrimNode;

typedef struct PrimArray
{
    PrimNode array[MAXSIZE];
    int numOfVertices;
} PrimArray;

PrimArray primArray;

void InitPrimArray(AdjacencyList adjacencyList)
{
    primArray.numOfVertices = adjacencyList.numOfVertices;
    for (int i = 0; i < primArray.numOfVertices; i++)
    {
        primArray.array[i].vertexIndex = i;
        primArray.array[i].visited = 0;
        primArray.array[i].distance = INF;
        primArray.array[i].parent = NON;
        primArray.array[i].posInHeap = NON;
    }
    primArray.array[0].distance = 0;
    //从index为0的顶点开始执行Prim算法
}

/////////////////////////////////

int Heap[MAXSIZE + 1];
//小根堆结构，Heap[0]存储堆的Size，堆内[1 ~ MAXSIZE-1]存储的是每一个PrimNode的index
//堆内的所有index对应的primArray.array[index].visited 必须等于0

void downToTop(int i){
    while(i > 1){
        if(primArray.array[Heap[i]].distance < primArray.array[Heap[i/2]].distance){
            int temp = Heap[i];
            Heap[i] = Heap[i/2];
            Heap[i/2] = temp;
            primArray.array[Heap[i]].posInHeap = i;
            primArray.array[Heap[i/2]].posInHeap = i/2;
            i = i / 2;
        }
        else{
            primArray.array[Heap[i]].posInHeap = i;
            break;
        }
    } 
}

void Push(int index){
    if(Heap[0] == MAXSIZE){
        printf("FULL HEAP\n");
        return;
    }
    Heap[0]++;
    Heap[Heap[0]] = index;
    int i = Heap[0];
    downToTop(i);
}

void topToDown(int i){
    while(i <= Heap[0]){

        if(2*i <= Heap[0] && 2*i+1 <= Heap[0]){
            if(primArray.array[Heap[i]].distance > primArray.array[Heap[2*i]].distance
                && primArray.array[Heap[2*i+1]].distance > primArray.array[Heap[2*i]].distance){
                int temp = Heap[i];
                Heap[i] = Heap[2*i];
                Heap[2*i] = temp;
                primArray.array[Heap[i]].posInHeap = i;
                primArray.array[Heap[i*2]].posInHeap = i*2;
                i = 2 * i;
            }
            else if(primArray.array[Heap[i]].distance > primArray.array[Heap[2*i+1]].distance
                && primArray.array[Heap[2*i]].distance > primArray.array[Heap[2*i+1]].distance){
                int temp = Heap[i];
                Heap[i] = Heap[2*i+1];
                Heap[2*i+1] = temp;
                primArray.array[Heap[i]].posInHeap = i;
                primArray.array[Heap[i*2+1]].posInHeap = i*2+1;
                i = 2 * i + 1;
            }
            else break;
        }
        else if(2*i <= Heap[0] && primArray.array[Heap[i]].distance > primArray.array[Heap[2*i]].distance){
            int temp = Heap[i];
            Heap[i] = Heap[2*i];
            Heap[2*i] = temp;
            primArray.array[Heap[i]].posInHeap = i;
            primArray.array[Heap[i*2]].posInHeap = i*2;
            i = 2 * i;
        }
        else{
            primArray.array[Heap[i]].posInHeap = i;
            break;
        }
    }
}

int Pop(){
    if(Heap[0] == 0){
        printf("EMPTY HEAP\n");
        return -1;
    }
 
    int top = Heap[1];
    Heap[1] = Heap[Heap[0]];
    Heap[0]--;

    int i = 1;
    topToDown(i);
    return top;
}

void showHeap(){
    printf("Size: %d\n",Heap[0]);
    for(int i = 1; i < Heap[0] + 1; i++){
        printf("Heap[%d] Index: %d Distance: %d Parents: %d \n",i,Heap[i],
            primArray.array[Heap[i]].distance,primArray.array[Heap[i]].parent);
    }
    printf("\n");
}

void showResult(){
    for(int i = 0; i < primArray.numOfVertices; i++){
        printf("| %c | %d | %d | %c | \n",primArray.array[i].vertexIndex + 'A',primArray.array[i].visited,primArray.array[i].distance,primArray.array[i].parent + 'A');
    }
}

void Prim(){
    InitAdjacencyList(9);
    getTestGraph();
    InitPrimArray(adjacencyList);

    Push(0);
    while(Heap[0] != 0){
        int i = Pop();
        primArray.array[i].visited = 1;
        AdjacencyNode* p = adjacencyList.vertexList[i].edgeList;
        while(p != NULL){
            int v = p->adacentVertex;
            int w = p->edgeWeight;
            if(w < primArray.array[v].distance && primArray.array[v].visited == 0){
                primArray.array[v].distance = w;
                primArray.array[v].parent = i;
                if(primArray.array[v].posInHeap == NON){
                    Push(v);
                }
                else{
                    downToTop(primArray.array[v].posInHeap);
                }
            }
            p = p->next;
        }
    }
    showGraph();
    showResult();
    clearAdjacencyList();
}

int main(){
    Prim();
}

