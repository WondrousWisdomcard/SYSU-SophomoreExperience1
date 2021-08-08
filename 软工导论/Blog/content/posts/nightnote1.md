---
author: "Wondrous WisdomCard"
date: 2020-09-24
linktitle: Creating a New Theme
title: NightNote - 1
categories: [
    "NightNote"
]
tags: [
    "Leetcode"
]
---

今天注册了Leetcode账号，并研究了第一道题 **#1 两数之和** https://leetcode-cn.com/problems/two-sum/。
我分别使用C和Java写了题，还看了看使用哈希表的题解。

## C做法：

Note: The returned array must be malloced, assume caller calls free().

    int* twoSum(int* nums, int numsSize, int target, int* returnSize){
        int * result = (int *)malloc(sizeof(int) * 2);
        for(int i = 0; i < numsSize-1 ; i++)
        {
            for(int j = i + 1; j < numsSize; j++)
            {
                if(nums[i] + nums[j] == target)
                {
                    result[0] = i;
                    result[1] = j;
                    *returnSize = 2;
                    return result;
                }
            }
        }
        return result;
    }
这里需要注意的是malloc的语法，太久不用忘记了

### 关于malloc和free的语法的复习

    #include <stdlib.h>
        void *malloc(size_t size);
            //功能：在堆中申请空间
            //size:要申请的空间的大小（字节数）　　　
            //返回值类型：void * 该类型表明malloc返回的地址空间中的数据类型是不确定，必须经过强制类型转换才可以使用。
            //返回值：成功时，返回malloc申请的空间的起始地址，失败时，返回NULL。
            //特点：malloc申请的空间为连续空间；
            //malloc申请的是没有初始化的空间；
        void free(void *ptr);
            //参数ptr: 
            //1)不能传NULL 
            //2)不能给ptr传申请的空间的一部分 
            //3)不能释放已经被释放的空间
            //4)不能使用已经被释放的空间

---
## Java做法：

    class Solution {
        public int[] twoSum(int[] nums, int target) {
            for(int i = 0; i < nums.length; i++)
            {
                for(int j = i + 1; j < nums.length; j++)
                {
                    if(nums[i] + nums[j] == target)
                    {
                        return new int [] {i,j};
                    }
                }
            }
            return new int [2];
        }
    }

数组的长度的获取：**数组名.length** （没有括号）

注意一下return的形式：**return new int [] {i,j};**

---
## 使用哈希表的O(n)复杂度代码
参考题解 https://leetcode-cn.com/problems/two-sum/solution/liang-shu-zhi-he-by-leetcode-2/

    class Solution {
        public int[] twoSum(int[] nums, int target) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                map.put(nums[i], i);
            }
            for (int i = 0; i < nums.length; i++) {
                int complement = target - nums[i];
                if (map.containsKey(complement) && map.get(complement) != i) {
                    return new int[] { i, map.get(complement) };
                }
            }
            throw new IllegalArgumentException("No two sum solution");
        }
    }

### 哈希表的概念
参考博客 https://blog.csdn.net/woshimaxiao1/article/details/83661464

哈希表通过哈希函数，在记录的存储位置和它的关键字之间建立一个确定的对应关系，使每个关键字和结构中一个唯一的存储位置相对应。

哈希表的实现，与普通数组相比，是以空间换时间，将查找时间从O(n)降低到(近似)O(1)。

哈希函数f: 存储位置 = f(关键字) ，这个函数f一般称为哈希函数，这个函数的设计好坏会直接影响到哈希表的优劣。

### Java中的集合HashMap的用法
参考博客 https://blog.csdn.net/weixin_43263961/article/details/86427533

参考博客 https://blog.csdn.net/zhaobin0731/article/details/98962624?utm_medium=distribute.pc_relevant.none-task-blog-BlogCommendFromMachineLearnPai2-1.channel_param

增 — map.put(“4”, “c”);

删 — map.remove(“4”);

改 — map.put(“4”, “d”);

查 — map.containsKey(“2”); 和 map.containsValue(“b”);
