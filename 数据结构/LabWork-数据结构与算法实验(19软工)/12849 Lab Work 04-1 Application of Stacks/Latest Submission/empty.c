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
