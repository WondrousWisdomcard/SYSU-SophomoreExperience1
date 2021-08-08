#include<stdio.h>
#include<math.h>
int main()
{
	printf("Let n be a positive integer with specified initial value. Design and implement a program to find the least number N such that g(n)>=f(n) when n>N. \n\n (1) n=1, f(n)=n and g(n)=nln(n).\n(2) n=1, f(n)=n^10 and g(n)=2^n.\n(3) n=2, f(n)=2^n and g(n)=n!.\n");
	int n = 1;
	for(;;n++)
	{
		if(n*log(n) - n >= 0)
		{
			break;
		}
	}
	printf("part1: %d is the least number such that g(n)>=f(n)\n\n",n);
	int j = 1;
	for(j = n; j < n + 10;j++)
	{
		printf("part1: %d g(n)= %lf f(n)= %d\n",j,j*log(j),j);
	}
	int i = 1;
	for(;i<10;i++)
	{
		if(pow(2,i) - pow(i,10) >= 0)
		{
		printf("part2: %d is the such that g(n)>=f(n)\n",i);
		}
	}
	n = 10;
	for(;;n++)
	{
		if(pow(2,n) - pow(n,10) >= 0)
		{
			break;
		}
	}
	printf("part2: %d is the least number such that g(n)>=f(n)\n\n",n);
	
	j = n; 
	for(j = n; j < n + 10; j++)
	{
		printf("part2: %d g(n)= %lf f(n)= %lf \n",j,pow(2,j),pow(j,10));
	}
	
	n = 2;
	long long int s = 1;
	for(;;n++)
	{
		s = s*n; //compute n!
		if(s - pow(2,n) >= 0)
		{
			break;
		}
	}
	printf("part3: %d is the least number such that g(n)>=f(n)\n\n",n);
	j = n; 
	for(j = n; j < n + 10; j++)
	{
		s = s * j;
		printf("part3: %d g(n)= %lld f(n)= %lf \n",j,s,pow(2,j));
	}
	
	return 0;
}