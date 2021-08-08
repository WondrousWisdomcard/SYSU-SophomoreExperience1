# Experimental Report 11 : Implementation of an M-way Merge Sort by Making Use of min-Heap

## Description of Work 11-1 and data structures applied

### 问题描述

设有 M = 8 个有序队列，每个队列的关键字从小到大排列，需要将这些队列元素归并成一个新的从小到大的有序队列。

算法描述：
构造一个有 M 个结点的完全小顶堆 H，每个堆结点固定对应一个队列，堆结点的值是其对应队列的队首元素的值（可以通过指针描述）。
利用这个小顶堆实现 M-路归并排序。

排序的每一趟是：

1. 堆顶结点的值即为当前的最小值。设堆顶结点对应队列 K，输出 top(K)；

2. Dequeue(K)，成功时队首元素被更新并仍然由堆顶结点描述；失败时队列 K 为空，此时 pop(H) 删除堆顶结点，将堆尾结点作为新的堆顶；

3. 针对堆顶实施 Percolating 维护，注意到结点移动时仍然保持与原队列的对应关系不变。

4. 直至所有队列为空，此时堆也被清空，排序结束。

### 实现策略

    #define CAPACITY 10
    #define M 8
    #define RANDOMMAX 1000
    int Heap[M + 1]; //Heap的第一个元素用于记录当前Heap的大小
    int SortedArray[M * CAPACITY];
    int RandomArray[M * CAPACITY];
    int PointerArray[M];

初始随机值被放在SortedArray中，它模拟二级存储的一段连续地址，大小是 8*10 个，即有8个长度为10的已经排好序的块，我们将对其进行8路归并排序，其中PointerArray数组记录下每一块的起始地址(RandomArray的下标)。 

我使用了一个长为M的数组作为堆，堆中储存的是**PointerArray的下标**，在对通过POP将排好序的数组写入SortedArray中。

### 功能函数

    void initPointersAndArray(void);
    //初始化指针数组PointerArray和为Random数组的每一块排好序

    int pointersOutOfBound(int i);
    //检查指针数组PointerArray是否越界
    //例如PointerArray/[1/]是负责第二块内存的指针，已知每一块的大小是10个元素，如果PointerArray/[1/] = 20 即越界，因为它“管辖”的范围是10-19.

    int alreadyHave(int n, int *arr, int i);
    void randomGetArray(int *arr, int size);
    //生成随机化数组

    void innerTopToDown(int i);
    //调整堆顶的元素，如果它不是最大的则向下调整，直到数组符合堆结构，用在pop中
    //需要注意的是“最大”的定义，由于Heap里记录的是指针数组的下标，所以比较的东西是RandomArray[PointerArray[Heap[i]]];

    void innerDownToTop(int i);
    //调整堆数组里第i个元素，如果它的值大于它父母节点的值则与它的父母节点进行交换，直到它的值小于它父母节点的值
    //用在push和将随机的数组调整堆中

    void push(int pointerIndex);
    int pop();

    void buildHeap();
    //通过一一将指针数组下标一一PUSH，并调整建堆

    int mergesort(); 
    //通过不断地POP，直至栈空，最后输出结果的过程

## Testing cases of Work 11-1

### Test1输出结果

CAPACITY = 5时：

    Heap: 
    8 5 7 0 1 4 2 6 3 
    RandomArray: 
    0: 10 44 52 89 167 
    5: 29 42 73 90 133 
    10: 31 37 66 70 98 
    15: 33 91 95 139 194 
    20: 55 121 123 140 171 
    25: 7 45 124 153 188 
    30: 47 64 141 177 190 
    35: 27 61 76 144 154 
    Merge Sort:
    7 10 27 29 31 33 37 42 44 45 47 52 55 61 64 66 70 73 76 89 90 91 95 98 121 123 124 133 139 140 141 144 153 154 167 171 177 188 190 194     

可以看到，得到的结果排好了序

### Test2输出结果

CAPACITY = 10时：

    Heap:
    8 4 0 2 7 1 5 6 3
    RandomArray:
    0: 7 30 34 40 51 84 111 122 126 132
    10: 14 26 64 99 134 135 137 155 162 178
    20: 18 37 54 66 117 133 149 152 180 191
    30: 31 58 76 82 85 94 100 101 104 176
    40: 6 13 17 38 61 87 121 175 192 195
    50: 45 55 102 108 139 141 160 165 190 197
    60: 73 79 86 89 129 138 143 151 156 199
    70: 19 20 23 53 56 72 127 142 181 185
    Merge Sort:
    6 7 13 14 17 18 19 20 23 26 30 31 34 37 38 40 45 51 53 54 55 56 58 61 64 66 72 73 76 79 82 84 85 86 87 89 94 99 100 101 102 104 108 111 117 121 122 126 127 129 132 133 134 135 137 138 139 141 142 143 149 151 152 155 156 160 162 165 175 176 178 180 181 185 190 191 192 195 197 199

可以看到，得到的结果排好了序

## Run time analysis

    buildHeap();
    //调用了M次PUSH，M次PUSH的建堆的时间复杂度是
    //令h为为堆的高度，建堆的时间复杂度为 
    //sum_{k=0}^{h}(h-k)2^k = (2^{h+1}-1)-(h+1) = M-lg(M+1) = O(M)。

    mergesort();
    //调用了M * CAPACITY次POP，虽然堆只有8个元素，但是每次POP后都需调用innerTopToDown(1);来维护堆。
    时间复杂度为 CAPACITY * ((ln(1) + ln(2) + ... ln(M))) = /CAPACITY * ln(M!) = O (CAPACITY * M * ln(M)) = O(n) 
    //n为待排序元素总数
		
	因此有时间复杂度为O(n).