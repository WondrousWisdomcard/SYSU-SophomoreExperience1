# Lab Work 06-1. Balance Rotations of AVL Trees

## Description of Work 06-1
An AVL tree is a binary search tree where every node in the tree has a balance factor of -1, 0 or +1. But any insertion into the AVL tree may cause violations of balance in four cases: Left-Left, Left-Right, Right-Right, and Right-Left. Single Rotations and Double Rotations are introduced to fix these cases.

1. Determine the data structures for an AVL tree
2. Implement an insertion into the AVL tree
3. Implement the four possible rotations to fix violations of balance caused by the insertion.

## Data structures and Function

### Data Structure

	typedef struct Node{
			int val;
			int depth;  //为了方便将树可视化
			struct Node* left;
			struct Node* right;
			struct Node* parent;
	}Node;
	
	typedef struct Tree{
			Node* root;  
			//根节点的爸爸，为空元素。
			//为了方便根节点的创建，删除和调整，规定root的左二子是AVL树真正的根节点
	}Tree;

### Function Lists

	void initTree();
	// 创建树

	void clear(Node* node); 
	// 负责递归释放节点

	void deleteTree(); 
	// 删除树

	void depthMaintain(Node* node, int i); 
	// 对每一个节点深度的维护，以便于输出一棵树

	int getHeight(Node* node); 
	// 通过递归获得一个节点的高度

	int getBalanceFactor(Node* node); 
	// 计算并返回一个结点的平衡因子

	int isBalance(Node* node); 
	// 判断以该节点为根的子树是否是平衡的

	Node* findUnbalancedParents(Node *node); 
	// 以某个节点往上找，找出他的第一个不平衡祖先并返回

	void AVLTransform(Node* temp); 
	// AVL转换，需要分情况讨论四种不同类型

	Node* insertNode(Node* node,int val); 
	// 插入新元素

	void show(Node* node); 
	// 可视化一棵树
	
	/*
	下面是一棵有三个节点的二叉搜索树
	表示根节点值为2且有两儿子，左二子的值为1而右儿子的值为3，左右儿子的儿子节点均为空
		Val: 2 | Depth: 0 | Parents: -1 | BalanceFactor: 0
			Val: 1 | Depth: 1 | Parents: 2 | BalanceFactor: 0
				Empty Left
				Empty Right
			Val: 3 | Depth: 1 | Parents: 2 | BalanceFactor: 0
		    	Empty Left
				Empty Right
	
	一行：Val: 2 | Depth: 0 | Parents: -1 | BalanceFactor: 0
	表示值为2的节点的深度是0，它的父母节点为空（-1），它的平衡因子是0；
									
	*/
	
	void insertAndBalance(int val);
	// 插入并平衡该树，如果插入节点后需要平衡，会打印平衡前后树的形态

	int initTreeByArray(int* arr,int size); 
	// 用一个数组初始化一棵树

## Testing cases

#### 测试样例1 - 测试Right-Left and Left-Left - form PPT Lecture12 Page 10 

	void test1()
	{
		printf("\n\nTEST1 - Right-Left and Left-Left\n");
		int arr1[10] = {36,12,44,7,17,38,45,3,10,27};
		initTree();
		initTreeByArray(arr1, 10);
		printf("\nINIT: Init a tree form Lecture12 Page 10\n");

		printf("\nSTEP1: insert 23 - Right-Left AVL Transform\n");
		insertAndBalance(23); //插入节点23，并平衡

		printf("\nSTEP2: insert 6 - Left-Left AVL Transform This will chage the root of the tree)\n");
		insertAndBalance(6); //插入节点6，并平衡

		printf("\nSTEP3: insert 29 - Normal Insert without AVL Transform\n");
		insertAndBalance(29);
		show(tree.root->left);

		deleteTree();
	}
	
##### 运行输出：

    Before Balance
    Val: 36 | Depth: 0 | Parents: -1 | BalanceFactor: 2
        Val: 12 | Depth: 1 | Parents: 36 | BalanceFactor: -1
            Val: 7 | Depth: 2 | Parents: 12 | BalanceFactor: 0
                Val: 3 | Depth: 3 | Parents: 7 | BalanceFactor: 0
                        Empty Left
                        Empty Right
                Val: 10 | Depth: 3 | Parents: 7 | BalanceFactor: 0
                        Empty Left
                        Empty Right
            Val: 17 | Depth: 2 | Parents: 12 | BalanceFactor: -2
                Empty Left
                Val: 27 | Depth: 3 | Parents: 17 | BalanceFactor: 1
                    Val: 23 | Depth: 4 | Parents: 27 | BalanceFactor: 0
                        Empty Left
                        Empty Right
                    Empty Right
        Val: 44 | Depth: 1 | Parents: 36 | BalanceFactor: 0
            Val: 38 | Depth: 2 | Parents: 44 | BalanceFactor: 0
                    Empty Left
                    Empty Right
            Val: 45 | Depth: 2 | Parents: 44 | BalanceFactor: 0
                    Empty Left
                    Empty Right

    After Balance
    Val: 36 | Depth: 0 | Parents: -1 | BalanceFactor: 1
        Val: 12 | Depth: 1 | Parents: 36 | BalanceFactor: 0
            Val: 7 | Depth: 2 | Parents: 12 | BalanceFactor: 0
                Val: 3 | Depth: 3 | Parents: 7 | BalanceFactor: 0
                    Empty Left
                    Empty Right
                Val: 10 | Depth: 3 | Parents: 7 | BalanceFactor: 0
                    Empty Left
                    Empty Right
            Val: 23 | Depth: 2 | Parents: 12 | BalanceFactor: 0
                Val: 17 | Depth: 3 | Parents: 23 | BalanceFactor: 0
                    Empty Left
                    Empty Right
                Val: 27 | Depth: 3 | Parents: 23 | BalanceFactor: 0
                    Empty Left
                    Empty Right
        Val: 44 | Depth: 1 | Parents: 36 | BalanceFactor: 0
            Val: 38 | Depth: 2 | Parents: 44 | BalanceFactor: 0
                Empty Left
                Empty Right
            Val: 45 | Depth: 2 | Parents: 44 | BalanceFactor: 0
                Empty Left
                Empty Right

插入23后，平衡前，我们可以看到 Val: 36， Val: 17的平衡因子分别为 2， -2，由于23的插入导致了树失去平衡；而平衡过后，以27为根节点的子树做了调整，调整部分从 17->(right)27->(left)23 变成了 17(left)<-23->(right)27，使得整棵树回归平衡（所有平衡因子的绝对值小于二）；
同时我们可以看到平衡前树的高度为4，平衡后树的高度为3。
																	
	STEP2: insert 6 - Left-Left AVL Transform This will chage the root of the tree)

    Before Balance
    Val: 36 | Depth: 0 | Parents: -1 | BalanceFactor: 2
        Val: 12 | Depth: 1 | Parents: 36 | BalanceFactor: 1
            Val: 7 | Depth: 2 | Parents: 12 | BalanceFactor: 1
                Val: 3 | Depth: 3 | Parents: 7 | BalanceFactor: -1
                    Empty Left
                    Val: 6 | Depth: 4 | Parents: 3 | BalanceFactor: 0
                        Empty Left
                        Empty Right
                Val: 10 | Depth: 3 | Parents: 7 | BalanceFactor: 0
                    Empty Left
                    Empty Right
            Val: 23 | Depth: 2 | Parents: 12 | BalanceFactor: 0
                Val: 17 | Depth: 3 | Parents: 23 | BalanceFactor: 0
                    Empty Left
                    Empty Right
                Val: 27 | Depth: 3 | Parents: 23 | BalanceFactor: 0
                    Empty Left
                    Empty Right
        Val: 44 | Depth: 1 | Parents: 36 | BalanceFactor: 0
            Val: 38 | Depth: 2 | Parents: 44 | BalanceFactor: 0
                Empty Left
                Empty Right
            Val: 45 | Depth: 2 | Parents: 44 | BalanceFactor: 0
                Empty Left
                Empty Right

    After Balance
    Val: 12 | Depth: 0 | Parents: -1 | BalanceFactor: 0
        Val: 7 | Depth: 1 | Parents: 12 | BalanceFactor: 1
            Val: 3 | Depth: 2 | Parents: 7 | BalanceFactor: -1
                Empty Left
                Val: 6 | Depth: 3 | Parents: 3 | BalanceFactor: 0
                    Empty Left
                    Empty Right
            Val: 10 | Depth: 2 | Parents: 7 | BalanceFactor: 0
                Empty Left
                Empty Right
        Val: 36 | Depth: 1 | Parents: 12 | BalanceFactor: 0
            Val: 23 | Depth: 2 | Parents: 36 | BalanceFactor: 0
                Val: 17 | Depth: 3 | Parents: 23 | BalanceFactor: 0
                    Empty Left
                    Empty Right
                Val: 27 | Depth: 3 | Parents: 23 | BalanceFactor: 0
                    Empty Left
                    Empty Right
            Val: 44 | Depth: 2 | Parents: 36 | BalanceFactor: 0
                Val: 38 | Depth: 3 | Parents: 44 | BalanceFactor: 0
                    Empty Left
                    Empty Right
                Val: 45 | Depth: 3 | Parents: 44 | BalanceFactor: 0
                    Empty Left
                    Empty Right


可以看到，插入6导致了不平衡点的产生，且这个不平衡的节点是根节点，通过转换，根节点从12变成了10，整棵树回归平衡；同时我们可以看到平衡前树的高度为4，平衡后树的高度为3。

#### 测试样例2 - 测试Left-Left and Left-Right 

	void test2(){
        printf("\n\nTEST2 - Right-Right and Left-Right\n");
        int arr1[10] = {10,5,12,1,11,21,27};
        initTree();
        initTreeByArray(arr1, 7);

        printf("\nINIT: Init a tree\n");
        show(tree.root->left);
        
        printf("\nSTEP1: insert 30 - Right-Right AVL Transform\n");
        insertAndBalance(30);

        printf("\nSTEP2: insert 3 - Left-Right AVL Transform\n");
        insertAndBalance(3);

        deleteTree();
    }
	
##### 运行输出：

    STEP1: insert 30 - Right-Right AVL Transform

    Before Balance
    Val: 10 | Depth: 0 | Parents: -1 | BalanceFactor: -2
        Val: 5 | Depth: 1 | Parents: 10 | BalanceFactor: 1
            Val: 1 | Depth: 2 | Parents: 5 | BalanceFactor: 0
                Empty Left
                Empty Right
            Empty Right
        Val: 12 | Depth: 1 | Parents: 10 | BalanceFactor: -2
            Val: 11 | Depth: 2 | Parents: 12 | BalanceFactor: 0
                Empty Left
                Empty Right
            Val: 21 | Depth: 2 | Parents: 12 | BalanceFactor: -2
                Empty Left
                Val: 27 | Depth: 3 | Parents: 21 | BalanceFactor: -1
                    Empty Left
                    Val: 30 | Depth: 4 | Parents: 27 | BalanceFactor: 0
                        Empty Left
                        Empty Right

    After Balance
    Val: 10 | Depth: 0 | Parents: -1 | BalanceFactor: -1
        Val: 5 | Depth: 1 | Parents: 10 | BalanceFactor: 1
            Val: 1 | Depth: 2 | Parents: 5 | BalanceFactor: 0
                Empty Left
                Empty Right
            Empty Right
        Val: 12 | Depth: 1 | Parents: 10 | BalanceFactor: -1
            Val: 11 | Depth: 2 | Parents: 12 | BalanceFactor: 0
                Empty Left
                Empty Right
            Val: 27 | Depth: 2 | Parents: 12 | BalanceFactor: 0
                Val: 21 | Depth: 3 | Parents: 27 | BalanceFactor: 0
                    Empty Left
                    Empty Right
                Val: 30 | Depth: 3 | Parents: 27 | BalanceFactor: 0
                    Empty Left
                    Empty Right

插入30后，平衡前，我们可以看到 Val: 21, Val: 12, Val: 10的平衡因子都为-2，由于30的插入导致了树失去平衡；而平衡过后，以21为根节点的子树做了调整，调整部分从 21->(right)27->(right)30 变成了 21(left)<-27->(right)30，使得整棵树回归平衡（所有平衡因子的绝对值小于二）；
同时我们可以看到平衡前树的高度为4，平衡后树的高度为3。

    STEP2: insert 3 - Left-Right AVL Transform

    Before Balance
    Val: 10 | Depth: 0 | Parents: -1 | BalanceFactor: 0
        Val: 5 | Depth: 1 | Parents: 10 | BalanceFactor: 2
            Val: 1 | Depth: 2 | Parents: 5 | BalanceFactor: -1
                Empty Left
                Val: 3 | Depth: 3 | Parents: 1 | BalanceFactor: 0
                    Empty Left
                    Empty Right
            Empty Right
        Val: 12 | Depth: 1 | Parents: 10 | BalanceFactor: -1
            Val: 11 | Depth: 2 | Parents: 12 | BalanceFactor: 0
                Empty Left
                Empty Right
            Val: 27 | Depth: 2 | Parents: 12 | BalanceFactor: 0
                Val: 21 | Depth: 3 | Parents: 27 | BalanceFactor: 0
                    Empty Left
                    Empty Right
                Val: 30 | Depth: 3 | Parents: 27 | BalanceFactor: 0
                    Empty Left
                    Empty Right

    After Balance
    Val: 10 | Depth: 0 | Parents: -1 | BalanceFactor: -1
        Val: 3 | Depth: 1 | Parents: 10 | BalanceFactor: 0
            Val: 1 | Depth: 2 | Parents: 3 | BalanceFactor: 0
                Empty Left
                Empty Right
            Val: 5 | Depth: 2 | Parents: 3 | BalanceFactor: 0
        Val: 12 | Depth: 1 | Parents: 10 | BalanceFactor: -1
            Val: 11 | Depth: 2 | Parents: 12 | BalanceFactor: 0
                Empty Left
                Empty Right
            Val: 27 | Depth: 2 | Parents: 12 | BalanceFactor: 0
                Val: 21 | Depth: 3 | Parents: 27 | BalanceFactor: 0
                    Empty Left
                    Empty Right
                Val: 30 | Depth: 3 | Parents: 27 | BalanceFactor: 0
                    Empty Left
                    Empty Right

插入3后，平衡前，我们可以看到 Val: 5 的平衡因子为 2; 而平衡过后，以27为根节点的子树做了调整，调整部分从 5->(left)1->(right)3 变成了 1(left)<-3->(right)5，使得整棵树回归平衡（所有平衡因子的绝对值小于二）；
同时我们可以看到平衡前树的高度为4，平衡后树的高度为3。
