#include<stdio.h>
#define m 20
int count = 0;


void BubbleSort(int* a,int n){
    for(int i = 0; i < n; i++){
        for(int j = 0; j < i; j++)
        {
            count++;
            if(a[i] < a[j]){
                int t = a[i];  
                a[i] = a[j];  
                a[j] = t;  
            }
        }
    }
}

void BubbleSortPlus(int* a,int n){
    int max;
    for(int i = n - 1; i > 0; i--){
        max = a[0];  
        int sorted = 1;  
        for(int j = 0; j < i; j++)
        {
            count++;
            if(a[j] < max){
                a[j-1] = a[j];  
                sorted = 0;
            }
            else{
                a[j-1] = max;  
                max = a[j];  
            }
        }
        a[i] = max;  
        if(sorted == 1){
              break;
        }
    }
}

int main(){
    int arr[m] = {21,19,12,26,13,55,33,40,5,7,14,22,20,27,56,34,41,6,8,15};
    int arr2[m] = {21,19,12,26,13,55,33,40,5,7,14,22,20,27,56,34,41,6,8,15};
    BubbleSort(arr,m);
    printf("Count: %d\n",count);
    for(int i = 0; i < m; i++){
        printf("%d ",arr[i]);
    }
    count = 0;
    BubbleSortPlus(arr2,m);
    printf("\nPlus Count: %d\n",count);
    for(int i = 0; i < m; i++){
        printf("%d ",arr2[i]);
    }
}