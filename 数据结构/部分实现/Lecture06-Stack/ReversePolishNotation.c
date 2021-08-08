/* DSAA Lab Work4 Application of stack
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
*/

#include<stdio.h>
#include<string.h>

char infix[50];
int i = 0;
char postfix[50];
int pi = 0;

char s[50];//stack
int top = 0;//栈顶的上面那一个空点
char pop()
{
	if(top != 0)
	{
		top--;
		return s[top];
	}
	else
	{
		return 0;
	}
}

void push(char c)
{
	s[top] = c;
	top++;
}
int isEmpty()
{
	if(top == 0)
	return 1;
	else
	return 0;
}


int isNum(char c)
{
	if(c >= '0' && c <= '9')
	return 1;
	else
	return 0;
}

int isOpe(char c)
{
	if(c == '+' || c == '-' || c == '*' || c == '/' )
	return 1;
	else
	return 0;
}

int itsPri(char c)
{
	if(c == '+' || c == '-')
	return 1;
	else if(c == '*' || c == '/')
	return 2;
	else
	return 0;
}

void showPost()
{
	int len = strlen(infix);
	
	for(i = 0; i < len; i++)
	{
		char tmp = infix[i];
		if(tmp == '(')
		{
			push(tmp);
		}
		else if(tmp == ')')
		{
			char t = pop();
			while(t != '(')
			{
				postfix[pi] = t;
				pi++;
				t = pop();
			} 
		}
		else if(isNum(tmp))
		{
			postfix[pi] = tmp;
			pi++;
		}
		else if(isOpe(tmp))
		{
			char t = pop();
			if(itsPri(tmp) > itsPri(t))
			{
				push(t);
				push(tmp);
			}
			else
			{
				postfix[pi] = t;
				pi++;
				if(!isEmpty())
				{
					t = pop();
					while(!isEmpty() && itsPri(tmp) <= itsPri(t))
					{
					
						postfix[pi] = t;
						pi++;
						if(!isEmpty())
						t = pop();
					}
				}
				
				if(!isEmpty())
				{
					push(t);
					push(tmp);
				}
				else
				{
					push(tmp);
				}
			}
		}
	}
	while(!isEmpty())
	{
		char t = pop();
		postfix[pi] = t;
		pi++;
	}
	
	printf("%s",postfix);
}

int ds[20];
int dtop = 0;

int dpop()
{
	if(dtop != 0)
	{
		dtop--;
		return ds[dtop];
	}
	else
	{
		return 0;
	}
}

void dpush(int c)
{
	ds[dtop] = c;
	dtop++;
}


void compute()
{
	int len = strlen(postfix);
	
	for(int j = 0; j < len; j++)
	{
		char t = postfix[j];
		if(isNum(t))
		{
			dpush((int)(t-'0'));
		}
		if(isOpe(t))
		{
			int sec = dpop();
			int fir = dpop();
			if(t == '+')
			{
				int res = fir + sec;
				dpush(res);
			}
			else if(t == '-')
			{
				int res = fir - sec;
				dpush(res);
			}
			else if(t == '*')
			{
				int res = fir * sec;
				dpush(res);
			}
			else if(t == '/')
			{
				if(sec == 0)
				{
				printf("error of 0 as denominator");
				return;
				}
				int res = fir / sec;
				dpush(res);
			}
		}
	}
	printf("The result is %d \n",dpop());
}

int main()
{
	scanf("%s",infix);
	showPost();
	printf("\n");
	compute();
	return 0;	
}
