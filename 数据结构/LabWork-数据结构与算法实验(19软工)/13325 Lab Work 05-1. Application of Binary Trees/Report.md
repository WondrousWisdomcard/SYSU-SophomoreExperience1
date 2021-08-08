# Lab Work 05-1. Application of Binary Trees

## Description of Work 05-1
A left-child-right-sibling binary tree (LCRS) is a binary tree used to store a general rooted ordered tree by the following consideration:
	The first child of each node is its left subtree in LCRS
	The next sibling of each node is its right subtree in LCRS
	The transformation of a general rooted ordered tree into a LCRS binary tree has been called the Knuth Transform
Determine the data structures for general rooted ordered trees and binary trees
Implement the Knuth Transform in C
Show by examples that a post-order traversal of the original tree is identical to the in-order traversal of the Knuth Transform

## Data Structure applied
### Data structure of general rooted ordered trees and its nodes
					typedef struct GeneralNode{
						int val;
						struct GeneralNode* child[MAX];
					}GeneralNode;

					typedef struct GeneralTree{
						GeneralNode* root;
					}GeneralTree;
					
### Data structure of binary trees and its nodes
					typedef struct BinaryNode{
						int val;
						struct BinaryNode* left;
						struct BinaryNode* right;
					}BinaryNode;

					typedef struct BinaryTree{
						BinaryNode* root; 
					}BinaryTree;
					
## Testing cases of Work 05-1
### Test1
我们通过CreateGeneralTreeTest()生成了一棵普通的书，它的结构如下图：(根节点0有四个儿子1，2，3，4，节点3有两个儿子5，6
			0
				-> 1
				-> 2
				-> 3
							-> 5
							-> 6
				-> 4
				
调用KnuthTransFormNode()生成一棵二叉树（LCRS TREE)，
然后再分别调用	PostOrderTraversalOfGeneralTree(tree.root);和InOrderTraversalOfBinaryTree(bintree.root);函数查看两棵树的遍历情况。
运行程序结果如下图：

			 Post Order Traversal Of General Tree:
			 1  2  5  6  3  4  0
			 In Order Traversal Of Binary Tree:
			 1  2  5  6  3  4  0

			--------------------------------
			Process exited after 0.4398 seconds with return value 0
			请按任意键继续. . .

可以观察到原本树的后序遍历和经过Knuth变换后得到的树的中序遍历结果相同。

## Runtime Analysis of the program implementing the Knuth Transform

设 KnuthTransFormNode为O（1），有KnuthTransForm（）复杂度为O(N),N为节点总数。
