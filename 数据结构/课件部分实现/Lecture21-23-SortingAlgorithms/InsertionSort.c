#include<stdio.h>

int count = 0;

void InsertionSort(int* a, int n){
    for(int i = 1; i < n; i++){
        for(int j = i; j > 0; j--){
            count++;
            if(a[j-1] > a[j]){
                int t = a[j-1];
                a[j-1] = a[j];
                a[j] = t;
            }
            else{
                break; // can reduce the times of if statement
            }
        }
    }
}

int main(){
    int arr[10] = {21,19,12,26,55,33,40,5,7,14};
    InsertionSort(arr,10);
    printf("Count %d\n",count);
    for(int i = 0; i < 10; i++){
        printf("%d ",arr[i]);
    }
}