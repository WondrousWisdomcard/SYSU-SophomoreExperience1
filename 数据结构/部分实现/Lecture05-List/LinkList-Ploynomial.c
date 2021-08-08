/* DSAA Lab work3 2020-10-03
使用静态链表完成实验，即申请一个Node数组，用栈管理未被使用的数组元素，时用链表表示多项式，如下所示：

    //数据结构：
    typedef struct Node{
    float coeff; //系数部分
    int expn; //指数部分
    int next; //数组下标（模拟指针）
    }Node;

    Node Storage[MAXSIZE];

    typedef struct List{
        int head; //链表的头个元素的索引，用-1表示NULL
    }List;

    //函数包括：
    void initStack(List* stack); //栈的随机初始化
    void initPloy(List* ploy); //多项式链表的初始化
    void deleteNode(List* ploy,List* stack,int tarExpn); // 删除元素，释放空间（入栈）
    void insertNode(List* ploy,List* stack,float _coeff,int _expn); //插入元素，多项式链表以指数expn从高到低排序
    List* addToAugend(List* ploy1, List* ploy2,List* stack); //多项式链表相加
    void deleteList(List* ploy,List* stack); //删除链表，整体入栈
    void printPloy(List* ploy); //格式化输出多项式链表
    void printStack(List* stack); //格式化输出栈
*/


#include<stdio.h>
#include<time.h>
#include<stdlib.h>

#define MAXSIZE 30

typedef struct Node{
    float coeff; //系数部分
    int expn; //指数部分
    int next; //迷你指针
}Node;

Node Storage[MAXSIZE];

typedef struct List{
    int head; //链表的头个元素的索引，用-1表示NULL
    int error;
}List;


void initStack(List* stack) //栈的初始化，RandomNext的
{
    srand(time(NULL));
    int a[MAXSIZE];
    int t;
    for(int i = 0; i < MAXSIZE; i++)
    {
        t = rand() % MAXSIZE;
        a[i] = t;   //赋值
        for(int j = 0; j < i; j++)
        {   //循环判断
            if(a[j] == t)
            {
                i--;    //如果相等 把i减1，跳出循环
                break;
            }
        }
    }

    stack->head = a[0];
    int i;
    for(i = 0; i < MAXSIZE; i++)
    {
        Storage[a[i]].next = a[i+1]; 
        Storage[a[i]].coeff = 0;
        Storage[a[i]].expn = 0;
    }
    Storage[a[i-1]].next = -1;
}

void initPloy(List* ploy) //多项式链表的初始化
{
    ploy->head = -1;
}

void deleteNode(List* ploy,List* stack,int tarExpn)// 删除元素 把链表的头元素还给栈，给栈头，通过指数查找删除
{
    int temp = ploy->head;
    int pretemp;
    if(temp == -1) //空多项式
    {
        return;
    }
    if(Storage[temp].expn == tarExpn) //要删头号
    {
        int temp2 = ploy->head;
        ploy->head = Storage[temp].next;
        int temp3 = stack->head;
        Storage[temp2].next = temp3;
        stack->head = temp2;
        return;
    }
    while(temp != -1)
    {
        pretemp = temp;
        temp = Storage[temp].next;
        if(Storage[temp].expn == tarExpn)
        {
            int postemp = Storage[temp].next;
            Storage[pretemp].next = postemp;
            int stacktemp = stack->head;
            stack->head = temp;
            Storage[temp].next = stacktemp;
        }
    }
}

void insertNode(List* ploy,List* stack,float _coeff,int _expn) // 插入元素 把栈的头元素贴给链表,要保证多项式链表指数部分有序 从高到低排序
{
    if(_coeff == 0)
    {
        return;
    }

    int temp = ploy->head;
    int temp2;
    if(temp == -1) //空多项式
    {
        int pos = stack->head;
        stack->head = Storage[pos].next;

        Storage[pos].coeff = _coeff;
        Storage[pos].expn = _expn;

        ploy->head = pos;
        Storage[pos].next = -1;
        return;
    }

    if(Storage[temp].expn < _expn) //加入的项为新最高项
    {
        int pos = stack->head;
        stack->head = Storage[pos].next;

        Storage[pos].coeff = _coeff;
        Storage[pos].expn = _expn;

        int temp3 = ploy->head;
        ploy->head = pos;
        Storage[pos].next = temp3;
        return;
    }

    if(Storage[temp].expn == _expn) //加入的项同为新最高项，无需增项
    {
        Storage[temp].coeff += _coeff;
        if(Storage[temp].coeff == 0)
        {
            deleteNode(ploy,stack,_expn);
        }
        return;
    }

    while(temp != -1 && Storage[temp].expn > _expn) //其余情况
    {
        temp2 = temp;
        temp = Storage[temp].next;
    }
    if(temp != -1 && Storage[temp].expn < _expn)
    {
        int pos = stack->head;
        stack->head = Storage[pos].next;

        Storage[pos].coeff = _coeff;
        Storage[pos].expn = _expn;

        Storage[temp2].next = pos;
        Storage[pos].next = temp;
        return;
    }
    else if(temp != -1 && Storage[temp].expn == _expn)
    {
        Storage[temp].coeff += _coeff;
        if(Storage[temp].coeff == 0)
        {
            deleteNode(ploy,stack,_expn);
        }
        return;
    }
    else if(temp == -1) //插入新的最小项
    {
        int pos = stack->head;
        stack->head = Storage[pos].next;

        Storage[pos].coeff = _coeff;
        Storage[pos].expn = _expn;

        Storage[temp2].next = pos;
        Storage[pos].next = temp;
        return;
    }
}

List* addToAugend(List* ploy1, List* ploy2,List* stack)// 加等于改变被加链表，并删除多余的节点
{
    int temp1 = ploy1->head;
    while(temp1 != -1)
    {
        float _coeff = Storage[temp1].coeff;
        int _expn = Storage[temp1].expn;
        insertNode(ploy2,stack,_coeff,_expn);
        temp1 = Storage[temp1].next;
    }
    ploy1->head = -1;
    return ploy2;
}

void deleteList(List* ploy,List* stack) //把一条多项式链表的所有节点归还给栈
{
    int temp = ploy->head;
    int temp2;
    while(temp != -1)
    {
        temp2 = Storage[temp].next;
        int stacktemp = stack->head;
        stack->head = temp;
        Storage[temp].next = stacktemp;
        temp = temp2;
    }
}

void printPloy(List* ploy)// 格式化输出多项式链表 
{
    printf("P(x) = ");
    int i = ploy->head;
    if(i == -1)
    {
        printf("0\n");
        return;
    }
    while(i != -1)
    {
        if(Storage[i].coeff > 0 && ploy->head == i)
            printf("%f", Storage[i].coeff);
        else if(Storage[i].coeff > 0 && ploy->head != i)
            printf("+ %f", Storage[i].coeff);
        else if(Storage[i].coeff < 0)
            printf("- %f", -Storage[i].coeff);

        if(Storage[i].expn != 0)
            printf("*x^%d ",Storage[i].expn);
        else
            printf(" ");
        
        i = Storage[i].next;
    }
    printf("\n");
}

void printStack(List* stack) // 格式化输出栈
{
    int i = stack->head;
    printf("HEAD -> ");
    if(i == -1)
    {
        printf("NULL\n");
        return;
    }
    while(i != -1)
    {
        printf("%d -> ",i);
        i = Storage[i].next;
    }
    printf("NULL\n");
}

int main()
{
    
    List stack;
    List ploy1,ploy2; // 多项式链表以指数从大到小有序

    //空初始化和输出显示
    initPloy(&ploy1);
    initPloy(&ploy2);
    initStack(&stack);
    printPloy(&ploy1);
    printPloy(&ploy2);
    printStack(&stack);

    //构造LP,LQ
    int lengthPloy1,lengthPloy2;
    printf("Please input the init length of Ploy1 and Ploy2\n");
    scanf("%d%d",&lengthPloy1,&lengthPloy2);
    for(int i=0;i<lengthPloy1; i++)
    {
        printf("Please input the %dth element's coeff and expn of Ploy1\n",i);
        float coeff;
        int expn;
        scanf("%f%d",&coeff,&expn);
        insertNode(&ploy1,&stack,coeff,expn);
        printPloy(&ploy1);
        printStack(&stack);
    }
    for(int i=0;i<lengthPloy2; i++)
    {
        printf("Please input the %d th element's coeff and expn of Ploy2\n",i);
        float coeff;
        int expn;
        scanf("%f%d",&coeff,&expn);
        insertNode(&ploy2,&stack,coeff,expn);
        printPloy(&ploy2);
        printStack(&stack);
    }

    //加法测试
    List* ploy3 = addToAugend(&ploy1, &ploy2, &stack);
    printPloy(ploy3);

    //删除多项式
    printStack(&stack);
    deleteList(&ploy1,&stack);
    printPloy(&ploy1);
    printStack(&stack);
    deleteList(&ploy2,&stack);
    printPloy(&ploy2);
    printStack(&stack);
    return 0; 
}

/*

*/