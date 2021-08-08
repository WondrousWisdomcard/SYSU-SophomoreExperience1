# Experimental Report 9 : Array Implementation of min-Heaps

## Description of Work 09-1 and data structures applied

A complete min-heap is a min-heap with the structure of a complete binary tree which can be stored using an array.

Determine the array structures for a complete min-heap

    int Heap[capacity + 1]; // we use Heap[0] to record the size of Heap

Input a linear list of 20 random numbers, building a complete min-heap to store the numbers. Implement POP and PUSH operations for the min-heaps.

对于POP，我们使用**从上往下**的方法，将最后一个元素送入堆顶，然后依次比较该元素的两个儿子节点（如果只有一个左儿子则无需比较），选最小的进行交换，向下遍历直到堆恢复平衡。

对于PUSH，我们使用**从下往上**的方法，将新插入的元素放入最尾部，将其与父亲节点比较，若该元素小则与父亲节点交换，直到堆恢复平衡。

## Testing cases of Work 09-1

#### 随机数测试样例输出结果：

我们生成了一个有20个元素的随机数数组，然后将其一一Push进堆中，最后在执行Pop直至堆空：

    Size: 20    1 13 11 14 44 15 45 47 43 77 68 52 39 58 49 123 112 93 89 92 
    POP:    1
    POP:    11
    POP:    13
    POP:    14
    POP:    15
    POP:    39
    POP:    43
    POP:    44
    POP:    45
    POP:    47
    POP:    49
    POP:    52
    POP:    58
    POP:    68
    POP:    77
    POP:    89
    POP:    92
    POP:    93
    POP:    112
    POP:    123

#### 正确性检测：

PUSH: 通过实际画图可以得到数组是一个平衡的堆，每个节点都大于其儿子节点。

POP: 通过20此POP成功把堆内的元素清空，并且由于这是一个小顶堆，依次输出的是从小到大排序过后的的数组（堆排序）。

## Run time analysis

由于该堆实际上又是一棵完全二元树，满足树的高度小于等于ln(N)的上取整，这里此时N为堆的元素个数。

PUSH和POP的最坏/平均时间复杂度都满足 **O(ln(n))**

将元素全部PUSH和POP时间复杂度为 /theta (ln(1) + ln(2) + ... ln(n)) = /theta ln(n!) = **O(nln(n))**
