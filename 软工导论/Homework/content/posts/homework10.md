---
author: "Wondrous WisdomCard"
date: 2020-10-28
linktitle: Creating a New Theme
title: Homework of Week 10
tags: [  
    "Abstract Data Types",
    "Algorithms"
]
categories: [
    "Homework"
]
---


### 1. Bubble Sort the list: 33, 56, 17, 8, 95, 22。Make sure the final result is from small to large. Write out the list after the 2nd pass.  
   
Starting with the last list element, we compare successive pairs of elements, swapping whenever the bottom element of the pair is smaller than the one above it

    1st:
    33 56 17 8 22 95
    33 56 17 8 22 95
    33 56 8 17 22 95
    33 8 56 17 22 95
    8 33 56 17 22 95

    2nd:
    8 33 56 17 22 95
    8 33 56 17 22 95
    8 33 17 56 22 95
    8 17 33 56 22 95
    8 17 33 56 22 95

    after the 2nd pass:
    8 17 33 56 22 95

### 2. Give a sorted array as list={60,65,75,80,90,95}. Design an algorithm to insert the value of x into the sorted array. Then test the algorithm with value 50,67,99. 思考：为什么选择插入点在list头上、中间、尾巴上的三个数作为算法测试的数据，你能解释吗？
   
    int list[20] = {60,65,75,80,90,95,-1};
    void insert(int n){
        int i;
        for(i = 0; i < 20; i++){
            if(n < list[i])
            break;
            else if(list[i+1] != -1 && list[i] > n && list[i+1] < n){
                i++;
                break;
            }
            else if(list[i] == -1)
            break;
        }
        for(int j = 19; j >= i+1; j--){
            list[j] = list[j-1];
        }
        list[i] = n;
    }
    int main(){
        insert(50);
        insert(67);
        insert(99);
        for(int i = 0; i < 20; i++){
            if(list[i] == -1)
            break;
            cout<<" "<<list[i];
        }
    }
    //输出： 50 60 65 67 75 80 90 95 99

头上、中间、尾巴上的三个数作为算法测试的数据，代表了显示数据的三种典型输入，由于链表的特性，选择插入点在list头上、中间、尾巴的实际操作可能会有差别，可用于测试设计者考虑是否完善。

### 3. What is the state of the stack after the following sequence of Push and Pop operations? Push “anne”; Push “get”; Push “your” ; Pop; Push “my” Push “gun” 

    stack: 
    Push “anne”:        |anne|null
    Push “get”:         |anna|get|null
    Push “your”:        |anna|get|your|null
    Pop:                |anna|get|null
    Push “my”:          |anna|get|my|null
    Push “gun”:         |anna|get|my|gun|null
    
the state of the stack after the following sequences:   |anna|get|my|gun|null


---

课堂笔记：

1. In computing, we view data from three perspectives 
    Application level • View of the data within a particular problem 
    Logical level • An abstract view of the data values (the domain) and the set of operations to manipulate them 
    Implementation level • A specific representation of the structure to hold the data items and the coding of the operations in a programming language

2. **容器** is to hold**持有** and manipulate**操纵** other objects
   
3. 名词意味着**概念**或者**数据**

4. 隐藏：（信息隐藏）（过程隐藏）（控制隐藏）

5. 算法在逻辑视图上解决问题





