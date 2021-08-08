#include<stdio.h>

typedef struct Date
{
	int month;
	int date;
	int year;
	int week;
}Date;

Date NextDate(Date b)
{
	Date a;
	if(b.month<1 || b.month>12 || b.year<1812 || b.year>3000 || b.date<1 || b.date > 31)
	{
		a.month = 0;
		a.date = 0;
		a.year = 0;
		a.week = 0;
		return a;
	}
	a.month = b.month;
	a.date = b.date;
	a.year = b.year;
	
	a.week = b.week+1;
	if(a.week > 6)
	{
		a.week = 0;
	}
	
	//last day of a year 
	if(b.month ==12 && b.date == 31)
	{
		a.year++;
		a.month =1;
		a.date = 1;
		return a;
	}
	
	//last day of february
	if(b.year%400 == 0 || (b.year%4 == 0 && b.year%100 != 0)) // is lunar year
	{
		if(b.month == 2 && b.date== 29)
		{
			a.month++;
			a.date= 1;
			return a;
		}
	}
	else
	{
		if(b.month == 2 && b.date==28)
		{
			a.month++;
			a.date= 1;
			return a;
		}
	}
	
	//normal day
	if(b.month == 1 || b.month == 3 || b.month == 5 || b.month ==7 || b.month == 8 || b.month == 10 || b.month ==12)
	{
		if(a.date == 31)
		{
			a.date = 1;
			a.month++;
			return a;
		}
		else
		{
			a.date++;
			return a;
		}
	}
	else
	{
		if(a.date == 30)
		{
			a.date = 1;
			a.month ++;
			return a;
		}
		else
		{
			a.date++;
			return a;
		}
	}
}


Date init;
void PrintMonthCalendar()
{
	printf("SUN MON TUE WED THU FRI SAT\n");
		if(init.date == 1)
		{
			for(int i = 0; i < init.week; i++)
			{
				printf("    ");
			}
			printf(" %d  ",init.date);
			if(init.week == 6)
			{
				printf("\n");
			}
		}
		for(int i = init.week; ; i++)
		{
			init = NextDate(init);
			if(init.date < 10)
			printf(" %d  ",init.date);
			else
			printf(" %d ",init.date);
			if(NextDate(init).month > init.month || NextDate(init).year > init.year)
			{
				init = NextDate(init);
				break;
			}
			if(init.week == 6)
			{
				printf("\n");
			}
	}
}
void GetMonth(int i)
{
	printf("\n         ");
	switch(i)
	{
		case 1:
		printf("JANUARY");
		break;
		case 2:
		printf("FEBRUARY");
		break;
		case 3:
		printf("MARCH");
		break;
		case 4:
		printf("APRIL");
		break;
		case 5:
		printf("MAY");
		break;
		case 6:
		printf("JUNE");
		break;
		case 7:
		printf("JULY");
		break;
		case 8:
		printf("AUGUST");
		break;
		case 9:
		printf("SEPTEMBER");
		break;
		case 10:
		printf("OCTOBER");
		break;
		case 11:
		printf("NOVEMBER");
		break;
		case 12:
		printf("DECEMBER");
		break;
	}
	printf("  \n");
}
void PrintCalendar()
{
	init.year = 2021;
	init.month = 1;
	init.date = 1;
	init.week = 5;
	
	printf("\n   2021 MONTHLY CALENDAR\n\n");
	
	for(int i = 1; i <= 12 ;i++)
	{
		GetMonth(i);
		PrintMonthCalendar();
		printf("\n");
	}
	
}

int main()
{
	PrintCalendar();
	return 0;
}