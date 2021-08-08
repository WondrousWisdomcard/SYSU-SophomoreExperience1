//问题描述：
////设有 M = 8 个有序队列，每个队列的关键字从小到大排列，需要将这些队列元素归并成一个新的从小到大的有序队列。
//算法描述：
////构造一个有 M 个结点的完全小顶堆 H，每个堆结点固定对应一个队列，堆结点的值是其对应队列的队首元素的值（可以通过指针描述）。
////利用这个小顶堆实现 M-路归并排序。
/* 
排序的每一趟是：
1).堆顶结点的值即为当前的最小值。设堆顶结点对应队列 K，输出 top(K)；
2).Dequeue(K)，成功时队首元素被更新并仍然由堆顶结点描述；失败时队列 K 为空，此时 pop(H) 删除堆顶结点，将堆尾结点作为新的堆顶；
3).针对堆顶实施 Percolating 维护，注意到结点移动时仍然保持与原队列的对应关系不变。
4).直至所有队列为空，此时堆也被清空，排序结束。

设计适当的数据结构（包括队列结构和堆结构）求解上述问题。
*/

#include<stdio.h>
#include<stdlib.h>
#include<time.h>

//DATA AREA
#define CAPACITY 10
#define M 8
#define RANDOMMAX 200
int Heap[M + 1];
int SortedArray[M * CAPACITY];
int RandomArray[M * CAPACITY];
int PointerArray[M];

void show(){
    printf("Heap: \n");
    for(int i = 0; i < M + 1; i ++){
        printf("%d ",Heap[i]);
    }   
    printf("\n");

    printf("RandomArray: ");
    printf("\n%d: ",PointerArray[0]);
    for(int i = 0; i < M * CAPACITY; i++){
        printf("%d ",RandomArray[i]);
        if((i + 1) % CAPACITY == 0 && i + 1 != M * CAPACITY)
        {
            printf("\n%d: ",PointerArray[(i + 1) / CAPACITY]);
        }
    }   
    printf("\n");
}

//FUNCTION AREA

void sort(int l, int r){
    for(int i = l; i < r; i++){
        for(int j = l; j < i; j++)
        {
            if(RandomArray[i] < RandomArray[j]){
                int t = RandomArray[i];  
                RandomArray[i] = RandomArray[j];  
                RandomArray[j] = t;  
            }
        }
    }
}

void initPointersAndArray(void){
    int i;
    for(i = 0; i < M; i ++){
        PointerArray[i] = i * CAPACITY;
    }
    for(i = 0; i < M-1; i ++){
        sort(PointerArray[i],PointerArray[i+1]);
    }
    sort(PointerArray[M-1],M * CAPACITY);
}

int pointersOutOfBound(int i){
    return (PointerArray[i] < i * CAPACITY || PointerArray[i] > (i + 1) * CAPACITY - 1);
}

int alreadyHave(int n, int *arr, int i){
    for(int j = 0; j < i; j++){
        if(arr[j] == n) return 1;
    }
    return 0;
}

void randomGetArray(int *arr, int size){
    srand(time(NULL));
    for(int i = 0; i < size ; i++){
        int n = 0;
        while(n == 0 || alreadyHave(n, arr, i)){
            n = rand() % RANDOMMAX;
        }
        arr[i] = n;
    }
}

void innerDownToTop(int i){
    while(i > 1){
        if(!pointersOutOfBound(Heap[i]) && !pointersOutOfBound(Heap[i]) && (RandomArray[PointerArray[Heap[i]]] < RandomArray[PointerArray[Heap[i/2]]])){
            int temp = Heap[i];
            Heap[i] = Heap[i/2];
            Heap[i/2] = temp;
            i = i / 2;
        }
        else{
            break;
        }
    } 
}

void push(int pointerIndex){
    if(Heap[0] == M){
        printf("FULL HEAP\n");
        return;
    }
    Heap[0]++;
    Heap[Heap[0]] = pointerIndex;
    int heapIndex = Heap[0];
    innerDownToTop(heapIndex); 
}

void buildHeap(){
    for(int i = 0; i < M; i++){
        push(i);
    }
}

void innerTopToDown(int i){ //不检查pointersOutOfBound
    while(i <= Heap[0]){
        if(2*i <= Heap[0] && 2*i+1 <= Heap[0])
        {
            if(RandomArray[PointerArray[Heap[2*i+1]]] < RandomArray[PointerArray[Heap[2*i]]] && RandomArray[PointerArray[Heap[i]]] > RandomArray[PointerArray[Heap[2*i+1]]]){
                int temp = Heap[i];
                Heap[i] = Heap[2*i+1];
                Heap[2*i+1] = temp;
                i = 2 * i + 1;
            }
            else if(RandomArray[PointerArray[Heap[2*i+1]]] > RandomArray[PointerArray[Heap[2*i]]] && RandomArray[PointerArray[Heap[i]]] > RandomArray[PointerArray[Heap[2*i]]]){
                int temp = Heap[i];
                Heap[i] = Heap[2*i];
                Heap[2*i] = temp;
                i = 2 * i;
            }
            else{
                break;
            }
        }
        else if(2*i <= Heap[0] && RandomArray[PointerArray[Heap[i]]] > RandomArray[PointerArray[Heap[2*i]]]){
            int temp = Heap[i];
            Heap[i] = Heap[2*i];
            Heap[2*i] = temp;
            i = 2 * i;
        }
        else{
            break;
        }
    }
}

int pop(){
    if(Heap[0] == 0){
        return -1;
    }
    //Heap里面是Pointer的Index
    int min = RandomArray[PointerArray[Heap[1]]];
    PointerArray[Heap[1]]++;
    if(pointersOutOfBound(Heap[1])){
        Heap[1] = Heap[Heap[0]];
        Heap[0]--;
        innerTopToDown(1);
    }
    else{
        innerTopToDown(1);
    }
    return min;
}

int mergesort(){
    printf("Merge Sort:\n");
    for(int i = 0; i < M * CAPACITY; i++){
        SortedArray[i] = pop();
        printf("%d ", SortedArray[i]);
    }
}

int main(){
    randomGetArray(RandomArray, M * CAPACITY);
    initPointersAndArray();
    buildHeap();
    show();
    mergesort();
    return 0;
}
