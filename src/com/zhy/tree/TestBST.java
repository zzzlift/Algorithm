package com.zhy.tree;

public class TestBST {
	public static void main(String[] args){
		BinarySearchTree bst=new BinarySearchTree();
		bst.insert(23);
		bst.insert(45);
		bst.insert(16);
		bst.insert(37);
		bst.insert(3);
		bst.insert(99);
		bst.insert(22);
		System.out.println("Inorder traversal:");
		bst.inOrder(bst.root);
		System.out.println("Preorder traversal:");
		bst.preOrder(bst.root);
		System.out.println("Postorder traversal:");
		bst.postOrder(bst.root);
		bst.remove(23);
	}
}
