#include<stdio.h>

#define MAX_SIZE 100

// The structure to store element
typedef struct Triple{
    int r; //row
    int c; //column
    int val; //value
}Triple;

// The structure of sparse matrix
typedef struct Matrix{
    int rn; // row number
    int cn; // column number
    int tn; // number of nonzero elements
    Triple data[MAX_SIZE];
}Matrix;

void TransMatrix(Matrix a, Matrix b) //O(cn*tn) ; tn ~ m*n ; O(m*n^2)
{
    b.rn = a.cn;
    b.cn = a.rn;
    b.tn = a.tn;

    int ele_num = a.tn;
    int index_col;
    int index_a = 0, index_b = 0;
    for(index_col = 1; index_col <= a.cn; index_col++)
    {
        for(index_a = 0; index_a < ele_num; index_a++)
        {
            if(a.data[index_a].c == index_col)
            {
                b.data[index_b].r = a.data[index_a].c;
                b.data[index_b].c = a.data[index_a].r;
                b.data[index_b].val = a.data[index_a].val;
                index_b++;
            }
        }
    }
}

//若能预先确定矩阵a中的每一列的第一个非零元素再矩阵b中应有的位置，则在转置时课直接放入b的恰当位置
//先求矩阵a中每一列的非零个数，用辅助数组num[]存起来
//用另一个数组cpot[]存放每一列的第一个非零元素再矩阵b中应有的位置
//有对应关系：cpot[0] = 1; cpot[c] = cpot[c-1] + num[c-1];
void FastTransMatrix(Matrix a, Matrix b) //O(tn) ; tn ~ m*n ; O(m*n)
{
    b.rn = a.cn;
    b.cn = a.rn;
    b.tn = a.tn;

    int num[MAX_SIZE],cpot[MAX_SIZE];
    //我们可以把cpot理解成一个全是索引的数组，cpot[c]代表矩阵a第c列的当前索引，也是矩阵b第c行的当前索引

    for(int i = 0; i < a.cn; i++)
    {
        num[i] = 0;
    }

    //求矩阵a每一列非零元素的个数
    for(int i = 0; i < a.tn; i++) 
    {
        num[a.data[i].c]++;
    }

    cpot[0] = 1;
    for(int i = 1; i < a.tn; i++)
    {
        cpot[i] = cpot[i-1] + num[i-1];
    }

    int index_a;
    for(index_a = 0; index_a < a.tn; index_a++)
    {
        b.data[cpot[a.data[index_a].c]].c = a.data[index_a].r;
        b.data[cpot[a.data[index_a].c]].r = a.data[index_a].c;
        b.data[cpot[a.data[index_a].c]].val = a.data[index_a].val;
        cpot[a.data[index_a].c]++;
    }
}

int main()
{
    
}