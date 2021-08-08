#include<stdio.h>
#include<stdlib.h>

#define MAX 10

//general rooted ordered trees 
typedef struct GeneralNode{
	int val;
	struct GeneralNode* child[MAX];
}GeneralNode;

typedef struct GeneralTree{
	GeneralNode* root;
}GeneralTree;


///////////////////////
GeneralTree tree;

void CreateGeneralTreeTest(){
	tree.root = (GeneralNode*)malloc(sizeof(GeneralNode));
	tree.root->val = 0;
	for(int i = 0; i < 4; i++){
		tree.root->child[i] = (GeneralNode*)malloc(sizeof(GeneralNode));
		tree.root->child[i]->val = 1 + i; 
		tree.root->child[i]->child[0] = NULL;
	}
	tree.root->child[4] = NULL;
	for(int i = 0; i < 2; i++){
		tree.root->child[2]->child[i] = (GeneralNode*)malloc(sizeof(GeneralNode));
		tree.root->child[2]->child[i]->val = i + 5;
		tree.root->child[2]->child[i]->child[0] = NULL;
	}
	tree.root->child[2]->child[2] = NULL;
}

void PostOrderTraversalOfGeneralTree(GeneralNode* node){
	if(node == NULL){
		return;
	}
	for(int i = 0; i < MAX; i++){
		if(node->child[i] == NULL){
			break;
		}
		PostOrderTraversalOfGeneralTree(node->child[i]);
	}
	printf(" %d ",node->val);
}

void ClearGeneralTree(GeneralNode* node){
	if(node == NULL){
		return;
	}
	for(int i = 0; i < MAX; i++){
		if(node->child[i] == NULL){
			break;
		}
		ClearGeneralTree(node->child[i]);
	}
	free(node);
}

//binary trees
typedef struct BinaryNode{
	int val;
	struct BinaryNode* left;
	struct BinaryNode* right;
}BinaryNode;

typedef struct BinaryTree{
	BinaryNode* root; 
}BinaryTree;

///////////////////////
BinaryTree bintree;

void InitBinaryTree(){
	bintree.root = NULL;
}

void InOrderTraversalOfBinaryTree(BinaryNode* node){
	if(node == NULL){
		return;
	}
	InOrderTraversalOfBinaryTree(node->left);
	printf(" %d ",node->val);
	InOrderTraversalOfBinaryTree(node->right);
}

void ClearBinaryTree(BinaryNode* node){
	if(node == NULL){
		return;
	}
	ClearBinaryTree(node->left);
	ClearBinaryTree(node->right);
	free(node);
}

void KnuthTransFormNode(GeneralNode* gnode, BinaryNode* bnode){
	BinaryNode* tempBnode = bnode;
	for(int i = 0; i < MAX; i++){
		if(gnode->child[i] == NULL)
		{
			break;
		}
		else
		{
			BinaryNode* newBnode = (BinaryNode*)malloc(sizeof(BinaryNode));
			newBnode->val = gnode->child[i]->val;
			newBnode->left = NULL;
			newBnode->right = NULL;
			
			if(i == 0){
				bnode->left = newBnode;
				tempBnode = newBnode;
			}
			else{
				tempBnode->right = newBnode;
				tempBnode = newBnode;
			}
			
			KnuthTransFormNode(gnode->child[i], newBnode);	
		}
	}
}

void KnuthTransForm(){
	
	bintree.root = (BinaryNode*)malloc(sizeof(BinaryNode));
	bintree.root->val = tree.root->val;
	bintree.root->left = NULL;
	bintree.root->right = NULL;
	
	KnuthTransFormNode(tree.root, bintree.root);
}



int main(){
	
	CreateGeneralTreeTest();
	InitBinaryTree();
	KnuthTransForm();
	printf(" Post Order Traversal Of General Tree: \n");
	PostOrderTraversalOfGeneralTree(tree.root);
	printf("\n In Order Traversal Of Binary Tree: \n");
	InOrderTraversalOfBinaryTree(bintree.root);
	printf("\n");
	ClearGeneralTree(tree.root);
	ClearBinaryTree(bintree.root);
	
	return 0;
} 