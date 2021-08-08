#include<stdio.h>
#include<stdlib.h>
int cap = 3;
int* queue;
int front;
int rear;

void create()
{
    queue = (int*) malloc(sizeof(int)*cap);
    front = rear = 0;
}

int isEmpty()
{
    return front == rear;
}

int isFull()
{
    return (rear + 1) % cap == front;
}

int insert(int x)
{
    if(!isFull())
    {
        queue[rear % cap] = x;
        rear = (rear + 1) % cap;
        return 1;
    }
    else
    return 0;
}

int delete()
{
    if(!isEmpty())
    {
        front = (front + 1) % cap;
        return 1;
    }
    else 
    return 0;
}

int extend()
{
    if(isFull())
    {
        cap = cap * 2;
        int* tmp = (int*)malloc(sizeof(int)*cap);

        if(rear == cap/2 - 1)
        {
            for(int i = 0; i < rear; i++)
            {
                tmp[i] = queue[i];
            }
        }
        else
        {
            for(int i = 0; i < rear; i++)
            {
                tmp[i] = queue[i];
            }

            for(int i = cap/2 - 1; i >= front; i--)
            {
                tmp[cap/2 + i] = queue[i];
            }
            front = cap/2 + front;
        }
        
        
        free(queue);
        queue = tmp;
        return 1;
    }
    else return 0;
}
int clear()
{
    free(queue);
}
void print()
{
    printf("front:%d rear:%d\n",front,rear);
    printf("[INNER ARRAY] QUEUE\n");
    for(int i = 0; i < cap; i++)
    {
        printf("%d ",queue[i]);
    }
    printf("\n");
    printf("[THE QUEUE] QUEUE\n");
    if(front <= rear)
    for(int i = front; i < rear; i++)
    {
        {
            printf("%d ",queue[i]);
        }
    }
    else
    {
        for(int i = front; i < cap; i++)
        {
            printf("%d ",queue[i]);
        }
        for(int i = 0; i < rear; i++)
        {
            printf("%d ",queue[i]);
        }
    }
    printf("\n");
}

int main()
{
    char c;
    int v;
    int s = 1;
    create();
    while(s){
        scanf("%c",&c);
        switch(c){
            case 'i':
            scanf("%d",&v);
            v = insert(v);
            printf("The result is %d\n",v);
            break;
            case 'd':
            v = delete();
            printf("The result is %d\n",v);
            break;
            case 'p':
            print();
            break;
            case 'c':
            clear();
            s = 0;
            break;
            case 'e':
            v = extend();
            printf("The result is %d\n",v);
            break;
        }
    }
    return 0;
}

