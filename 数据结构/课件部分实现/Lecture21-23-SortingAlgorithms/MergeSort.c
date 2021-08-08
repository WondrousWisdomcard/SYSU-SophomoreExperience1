#include<stdio.h>

int count = 0;

void Merge(int* a,int l,int m,int r){
    int i1 = l, i2 = m, k = 0;
    int t[r-l+1];
    while(i1 < m && i2 < r){
        if(a[i1] < a[i2]){
            t[k++] = a[i1++];
        }
        else{
            t[k++] = a[i2++];
        }
    }
    while(i1 < m){
        t[k++] = a[i1++];
    }
    while(i2 < r){
        t[k++] = a[i2++];
    }
    for(int i = 0; i < r-l; i++){
        a[l+i] = t[i];
        //printf("%d ",t[i]);
    }
    //printf("\n");
}

void MergeSort(int* a, int l, int r){
    if(r - l <= 6){
        for(int i = l; i < r; i++){
            for(int j = i; j < r; j++){
                count++;
                if(a[j] < a[i]){
                    int t = a[j];
                    a[j] = a[i];
                    a[i] = t;
                }
            }
        }
    }
    else{
        int m = (l+r)>>1;
        MergeSort(a,l,m);
        MergeSort(a,m,r);
        Merge(a,l,m,r); 
    }
}

int main(){
    int arr[20] = {21,19,12,26,13,55,33,40,5,7,14,22,20,27,56,34,41,6,8,15};
    MergeSort(arr,0,20);
    for(int i = 0; i < 20; i++){
        printf("%d ",arr[i]);
    }
}