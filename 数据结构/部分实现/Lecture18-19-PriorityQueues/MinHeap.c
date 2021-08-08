#include<stdio.h>
#include<stdlib.h>
#include<time.h>
#define capacity 20

int Heap[capacity + 1];

int Pop(){
    if(Heap[0] == 0){
        return -1;
    }
   
    int top = Heap[1];
    Heap[1] = Heap[Heap[0]];
    Heap[0]--;

    int i = 1;
    while(i <= Heap[0]){
        int now = Heap[i];
        if(2*i <= Heap[0] && 2*i+1 <= Heap[0]){
            if(now > Heap[2 * i] && Heap[2*i] < Heap[2*i+1]){
                int temp = Heap[i];
                Heap[i] = Heap[2*i];
                Heap[2*i] = temp;
                i = 2 * i;
            }
            else if(now > Heap[2 * i + 1] && Heap[2*i] > Heap[2*i+1]){
                int temp = Heap[i];
                Heap[i] = Heap[2*i+1];
                Heap[2*i+1] = temp;
                i = 2 * i + 1;
            }
            else break;
        }
        else if(2*i <= Heap[0] && now > Heap[2 * i]){
            int temp = Heap[i];
            Heap[i] = Heap[2*i];
            Heap[2*i] = temp;
            i = 2 * i;
        }
        else{
            break;
        }
    }
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
    while(i > 1){
        if(Heap[i] < Heap[i/2]){
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

void showHeap(){
    printf("Size: %d    ",Heap[0]);
    for(int i = 1; i < Heap[0] + 1; i++){
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
    int arr[capacity];
    randomGetArray(arr);

    for(int i = 0; i < capacity; i++){
        Push(arr[i]);
    }
    showHeap();

    for(int i = 0; i < capacity; i++){
        printf("%d ",Pop());
        //showHeap();
    }

    return 0;
}