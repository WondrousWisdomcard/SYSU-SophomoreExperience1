/*
Determine the array structures for a complete max-heap
Input a linear list of 20 random numbers, building a complete max-heap to store the numbers by the process of in-place heapification
Implement an in-place sorting, making use of POP operation for the built complete max-heaps .
*/

#include<stdio.h>
#include<stdlib.h>
#include<time.h>
#define capacity 20

int Heap[capacity + 1]; // Heap[0] is to store the size of heap

void InnerTopToDown(int i){
    while(i <= Heap[0]){
        int now = Heap[i];
        if(2*i <= Heap[0] && 2*i+1 <= Heap[0]){
            if(now < Heap[2 * i] && Heap[2*i] > Heap[2*i+1]){
                int temp = Heap[i];
                Heap[i] = Heap[2*i];
                Heap[2*i] = temp;
                i = 2 * i;
            }
            else if(now < Heap[2 * i + 1] && Heap[2*i] < Heap[2*i+1]){
                int temp = Heap[i];
                Heap[i] = Heap[2*i+1];
                Heap[2*i+1] = temp;
                i = 2 * i + 1;
            }
            else break;
        }
        else if(2*i <= Heap[0] && now < Heap[2 * i]){
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
void InnerDownToTop(int i){
    while(i > 1){
        if(Heap[i] > Heap[i/2]){
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

int Pop(){
    if(Heap[0] == 0){
        return -1;
    }
    int top = Heap[1];
    Heap[1] = Heap[Heap[0]];
    Heap[0]--;
    InnerTopToDown(1);
    return top;
}
void Push(int val){
    if(Heap[0] == capacity){
        printf("FULL HEAP\n");
        return;
    }

    Heap[0]++;
    Heap[Heap[0]] = val;

    int i = Heap[0];
    InnerDownToTop(i);
}

void showHeap(){
    printf("HeapSize: %d    ",Heap[0]);
    for(int i = 1; i < capacity + 1; i++){
        printf("%d ",Heap[i]);
    }
    printf("\n");
}

int alreadyHave(int n, int *arr, int i){
    for(int j = 0; j < i; j++){
        if(arr[j] == n) return 1;
    }
    return 0;
}
void randomGetArray(int *arr){
    srand(time(NULL));
    for(int i = 0; i < capacity ; i++){
        int n = 0;
        while(n == 0 || alreadyHave(n, arr, i)){
            n = rand() % 128;
        }
        arr[i] = n;
    }
}

int main(){
    Heap[0] = capacity;
    randomGetArray(Heap+1);
    printf("Initial: ");
    showHeap();

    for(int i = capacity; i >=1; i--){
        InnerDownToTop(i);
    }
    printf("MaxHeap: ");
    showHeap();

    for(int i = capacity; i >= 1; i--){
        Heap[i] = Pop();
    }
    printf("AfterHeapSort: ");
    showHeap();

    return 0;
}