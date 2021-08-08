/*
Lab Work 08-1. Double Hashing
Note: Programming in C

Consider a hash table with M = 64 bins. 
Given a 12-bit unsigned number
take the lowest 6 bits as the primary hash function to get the bin number
and the highest 6 bits as the secondary hash function to get the jump size.

Determine the array structures for a hash table
Hash a list of 40 random 12-bit positive numbers
Calculate the average number of probes
*/
#include<stdio.h>
#include<stdlib.h>
#include<time.h>

unsigned int M[64]; //a hash table with M = 64 bins (2^6)
int num_of_probes = 0; 

unsigned int hash_bin(unsigned int n){
    return n % 64;
}
unsigned int hash_jump(unsigned int n){
    return (n >> 6) | 1;
}

int double_hashing(unsigned int * ranArr, int n){ // n = 40;
    num_of_probes = 0;
    for(int j = 0; j < 64; j++){ // initialize, define 0 as empty bin
        M[j] = 0;
    }

    for(int i = 0; i < n; i++){
        int k = hash_bin(ranArr[i]);
        while(M[k] != 0){
            k = (k + hash_jump(ranArr[i])) % 64; 
            num_of_probes ++;
        }
        M[k] = ranArr[i];
        num_of_probes ++;
    }
    return 1;
}

int alreadyHave(unsigned int n, unsigned int *arr, int i){
    for(int j = 0; j < i; j++){
        if(arr[j] == n) return 1;
    }
    return 0;
}
void randomGetArray(unsigned int *arr){
    srand(time(NULL));
    for(int i = 0; i < 40 ; i++){
        int n = 0;
        while(n == 0 || alreadyHave(n, arr, i)){
            n = rand() % 4048; // 4048 = 2^12
        }
        arr[i] = n;
    }
}

void test2(){
    unsigned int arr[40];
    randomGetArray(arr);
    int n = 40;
    /*for(int i = 0; i < n; i++){
        printf("Val: %4d Hash_bin: %2d Hash_jump: %2d \n", arr[i],hash_bin(arr[i]),hash_jump(arr[i]));
    }*/

    double_hashing(arr,n);
    for(int i = 0; i < 64; i++){
        printf("Bin:%2d Val:%4d |",i,M[i]);
        if((i+1) % 8 == 0) printf("\n");
    }
    printf("Total Num of Probe: %d \n",num_of_probes);
    printf("Average Num of Probe: %lf \n",(double)num_of_probes/n);
}


int main(){
    //test();
    test2();
    
    return 0;
}