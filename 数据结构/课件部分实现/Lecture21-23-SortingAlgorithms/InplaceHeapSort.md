# Experimental Report 10 : In-place Heap Sorting 

## Description of Work 10-1 and data structures applied

Determine the array structures for a complete max-heap
Input a linear list of 20 random numbers, building a complete max-heap to store the numbers by the process of in-place heapification
Implement an in-place sorting, making use of POP operation for the built complete max-heaps .

#### Data Structure: a array to store a max-heap and the result of sorting

    int Heap[capacity + 1]; 
    // Heap[0] is to store the size of heap

#### Functions for push and pop:

    void InnerTopToDown(int i);
    //调整堆顶的元素，如果它不是最大的则向下调整，直到数组符合堆结构，用在Pop中

    void InnerDownToTop(int i);
    //调整堆数组里第i个元素，如果它的值大于它父母节点的值则与它的父母节点进行交换，直到它的值小于它父母节点的值
    //用在Push和将随机的数组调整成大根堆中

#### The process of Heap Sort:

    Heap[0] = capacity;
    randomGetArray(Heap+1); //创建随机数组

    //堆化
    for(int i = capacity; i >=1; i--){
        InnerDownToTop(i); //从堆的末端到顶端依次进行DownToTop的调整
    }

    //排序
    for(int i = capacity; i >= 1; i--){
        Heap[i] = Pop();//Pop出最大的元素直至堆空，并逆序插入数组内
    }

    showHeap(); //得到排好序的数组

## Testing cases of Work 10-1

#### Test1:  main函数随机测试输出结果
    
    Initial: HeapSize: 20    66 23 92 48 125 42 25 91 22 84 75 52 110 11 67 30 120 89 87 43
    MaxHeap: HeapSize: 20    125 120 110 87 89 92 67 66 23 84 75 52 42 11 25 30 91 48 22 43
    AfterHeapSort: HeapSize: 0    11 22 23 25 30 42 43 48 52 66 67 75 84 87 89 91 92 110 120 125

#### Test2: 

    Initial: HeapSize: 20    100 101 5 109 76 29 77 1 12 42 2 19 18 105 46 51 23 70 20 68 
    MaxHeap: HeapSize: 20    109 105 100 101 76 29 5 51 70 68 2 19 18 77 46 23 1 20 12 42 
    AfterHeapSort: HeapSize: 0    1 2 5 12 18 19 20 23 29 42 46 51 77 68 70 76 100 101 105 109 

可以看到排序后的数组是有序的，即排序成功，与此同时排序过程并没有申请大于等于n的辅助空间，排序的过程都在数组Heap里面进行，因此排序是Inplace的。

## Run time analysis

考虑排序过程：

    //建堆
    for(int i = capacity; i >=1; i--){
        InnerDownToTop(i);  
    }
    //令h为为堆的高度，建堆的时间复杂度为 
    //sum_{k=0}^{h}(h-k)2^k = (2^{h+1}-1)-(h+1) = n-lg(n+1) = O(n)。

    //排序
    for(int i = capacity; i >= 1; i--){
        Heap[i] = Pop();
        //Pop的平均时间复杂度/最坏时间复杂度为O(ln(i)) 
    } 
    //因此这个循环的时间复杂度是/theta (ln(1) + ln(2) + ... ln(n)) = /theta ln(n!) = O(nln(n))。

综上有：堆排序的时间复杂度为O(nln(n)) + O(n) = **O(nln(n))**