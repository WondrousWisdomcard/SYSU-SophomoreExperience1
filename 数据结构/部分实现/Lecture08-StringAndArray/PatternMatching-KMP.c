#include<stdio.h>
#include<string.h>

#define MAX_SIZE 1024
int next[MAX_SIZE];
char s1[MAX_SIZE];
char s2[MAX_SIZE];

void getNext(char* p)
{
    next[0] = -1;
    int j = 0, k = -1; //k是前缀的屁股，j是当前后缀的屁股
    while(j < strlen(p) - 1)
    {
        if(k == -1 || p[k] == p[j])
        {
            j++;
            k++;
            next[j] = k;
        }
        else
        {
            k = next[k];
        }
    }
}
int KMP_index(char* t,char* patt)
{
    int i = 0, j = 0;
    while(j < 0 || i < strlen(t) && j < strlen(patt))
    {
        if((j == -1) || (t[i] == patt[j]))
        {
            i++;
            j++;
        } 
        else
        {
            j = next[j];
        }
    }
    if(j == strlen(patt)) 
        return i-j;
    else
        return -1;
}
int main()
{
    scanf("%s",s1);
    scanf("%s",s2);
    getNext(s2);
    for(int i = 0; i < strlen(s2); i++)
    {
        printf("%d ",next[i]);
    }
    printf("\n%d\n",KMP_index(s1,s2));
    return 0;
}