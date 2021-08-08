# Lab Work 11-1. Implementation of an M-way Merge Sort by Making Use of min-Heap

### Lab Work 11-1. Implementation of an M-way Merge Sort by Making Use of min-Heap

**Note:** Programming in C

问题描述：

设有 M = 8 个有序队列，每个队列的关键字从小到大排列，需要将这些队列元素归并成一个新的从小到大的有序队列。

算法描述：

构造一个有 M 个结点的完全小顶堆 H，每个堆结点固定对应一个队列，堆结点的值是其对应队列的队首元素的值（可以通过指针描述）。利用这个小顶堆实现 M-路归并排序。

排序的每一趟是：

1. 堆顶结点的值即为当前的最小值。设堆顶结点对应队列 K，输出 top(K)；
2. Dequeue(K)，成功时队首元素被更新并仍然由堆顶结点描述；失败时队列 K 为空，此时 pop(H) 删除堆顶结点，将堆尾结点作为新的堆顶；
3. 针对堆顶实施 Percolating 维护，注意到结点移动时仍然保持与原队列的对应关系不变。

直至所有队列为空，此时堆也被清空，排序结束。

设计适当的数据结构（包括队列结构和堆结构）求解上述问题。

思考：你没有更好的想法，不妨试试看。

(End)