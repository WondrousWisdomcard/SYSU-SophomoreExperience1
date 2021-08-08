---
author: "Wondrous WisdomCard"
date: 2020-10-14
linktitle: Creating a New Theme
title: Homework of Week 7
tags: [  
    "Assembly Language",
    "Compiler",
    "Imperative programming",
    "Functional programming",
    "Procedural programming"
]
categories: [
    "Homework"
]
---

### 1、Program with machine language according to the following c.

    int_8 a = 1;  
    int_8 c = a + 3;  

##### 1）Write your assembly code & machine code 

    ;assembly code
    LOD # 1
    STO X 
    LOD X
    ADD # 3 
    STO Y 
    HLT

**我们假设LOD STO LOD ADD HLT对应的操作码是 0001 0010 0011 0100 1111，设X的存储地址是01010000，Y的存储地址是01010100** 

根据ppt中的指令格式：

The 8-bit instruction specifier（命令指示）

And optionally, the 8-bit operand specifier（操作数）

    0 0 0 X Z Z Z Z b b b b b b b b 

b b b b b b b b operand specifier： 一个数值，或者 一个内存地址

0 0 0 X Z Z Z Z instruction specifier： ZZZZ：操作码 X:寻址模式 1表示操作数是数值 0表示操作数是该地址的内容

    ;machine code
    0001000100000001
    0000001001010000
    0000000101010000
    0001010000000011
    0000001001010100
    0000111100000000

##### 2）Explain machine code execution with the fetch-decode-execute cycle 

一个指令运行周期内：内存 –> 取指令 –> 指令译码 –> 寄存器 –> 取数据 –> 执行指令 –> 处理数据 -> 存储数据 -> 内存

##### 3）Explain functions about  IR, PC, ACC registers in a CPU 

IR：指令寄存器，用来储存执行中指令的暂存器。

PC：程序计数器，用于指示计算机在其程序序列中的位置。

ACC：累加寄存器，用于暂时存放ALU运算结果。

##### 4）Explain physical meaning about vars a & c in a machine

变量a,c存储在内存当中的不同位置，分别占8个字节，即8为二进制数。

---

### 2、简答题 

##### 1）What are stored in memory? 

数据和指令

##### 2）Can a data or a instruction stored in the same place? 

不可以

##### 3） Explain Instruction Format with example instructions.

如 SUB X：00000001 10000000
前八位00000001对应指令内容，后八位10000000对应指令对象。第四位代表寻址模式，表示指令对象是地址还是数据。这条指令指寄存器减去目前在10000000(X)这个地址中的内容后存到寄存器中。

---

### 3、解释以下词汇 from Wikipedia

##### 1）汇编语言（Assembly Language）

Assembly Language is a low-level programming language for a computer, or other programmable device, in which there is a very strong correspondence between the language and the architecture's machine code instructions. Each assembly language is specific to a particular computer architecture.

##### 2）编译（Compiler） 

A compiler is a computer program (or a set of programs) that transforms source code written in a programming language (the source language) into another computer language (the target language), with the latter often having a binary form known as object code. The most common reason for converting source code is to create an executable program.

##### 3）命令式语言（Imperative programming） 

Imperative programming is a programming paradigm that uses statements that change a program's state. In much the same way that the imperative mood in natural languages expresses commands, an imperative program consists of commands for the computer to perform. Imperative programming focuses on describing how a program operates.

##### 4）函数编程语言（Functional programming） 

Functional programming is a programming paradigm — a style of building the structure and elements of computer programs—that treats computation as the evaluation of mathematical functions and avoids changing-state and mutable data. It is a declarative programming paradigm, which means programming is done with expressions or declarations instead of statements. 

##### 5）过程式编程（Procedural programming）

Procedural programming is a programming paradigm, derived from structured programming, based upon the concept of the procedure call. Procedures, also known as routines, subroutines, or functions (not to be confused with mathematical functions, but similar to those used in functional programming), simply contain a series of computational steps to be carried out. Any given procedure might be called at any point during a program's execution, including by other procedures or itself. 

---