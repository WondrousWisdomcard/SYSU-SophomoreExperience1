# Lab Work 04. Application of Stacks

19335286 郑有为

## 实验目的：

Design a C program to implement:
(1) Arithmetic expression translation: from in-fix to post-fix notation
(2) Evaluation of an arithmetic expression in post-fix notation
Ref. to Sec.3.6.3, Weiss, Data Structures & Algorithm Analysis in C++, 4th Edition

使用栈来将中缀算数表达式转化为后缀算数表达式，并利用后缀表达式算出其结果。

在本篇实验中，我们考虑的运算符只包括加减乘除和左右括号，并且考虑的运算数只在0~9之间的十个整数，不考虑多位数，小数和负数。

## 程序说明：
	char infix[50]; //存储中缀表达式
	int i = 0;//中缀表达式的遍历索引
	char postfix[50];//存储后缀表达式
	int pi = 0;//后缀表达式的遍历索引
	
	char s[50];//用于存储运算符的栈
	int top = 0;//指向栈顶的上面那一个空点
	//操作栈的三个函数分别是pop,push和isEmpty
	
	函数isNum用来检查字符是否为数字
	函数isOpe用来检查是否为运算符
	函数itsPri用来返回操作符的优先级
	
	函数showPost用于生成后缀表达式储存在postfix中并输出
	
	int ds[20]; //数字栈，用来计算后缀表达式
	int dtop = 0; //数字栈的索引
	//数字函数分别是dpop,dpush。
	
	函数compute用于计算表达式结果并打印出来
	
## 运行测例:

#### test1:

input: 2+3

output: 23+

						The result is 5 

#### test2:

input: 2+3-5\*2

output: 23+52\*-

            The result is -5 
						
#### test3:

input:(2+3)\*5

output: 23+5\*

            The result is 25 

#### test4:

input:2+3+5+9

output: 23+5+9+

            The result is 

#### test5:

input: (2+5\*4)+(3/1)\*2

output: 254\*+31/2\*+

The result is 28 

#### test6: 分母为零的情况

input: 2/0+5

output: 20/5+

            error of 0 as denominator
					
## Runtime Analysis:

pop,push,is寒暑 的复杂度都为 O(1)

**showPost函数 O(n^2) \\生成后缀表达式**

**compute函数 O(n) \\利用后缀表达式进行计算**

---
