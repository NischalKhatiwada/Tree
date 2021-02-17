package com.nischal;

public class BinarySearchTree {
	TreeNode root;

	public boolean searchBST(int data) {
		TreeNode t = root;
		if (t != null) {
			while (t != null) {
				if (data == t.data) {
					System.out.println(data + " is found");
					return true;
				} else if (data < t.data) {
					t = t.left;
				} else if (data > t.data) {
					t = t.right;
				}
			}
		} else {
			System.out.println("Tree is empty");
		}
		return false;
	}

	public static void main(String[] args) {
		BinarySearchTree t= new BinarySearchTree();
		t.searchBST(12);
		BinarySearchTree tree = new BinarySearchTree();
		tree.root = new TreeNode(15);
		tree.root.left = new TreeNode(10);
		tree.root.right = new TreeNode(20);
		tree.root.left.left = new TreeNode(8);
		tree.root.left.right = new TreeNode(12);
		System.out.println("Is 122 in the tree ? " + tree.searchBST(122));
		System.out.println("Is 12 in the tree ?" + tree.searchBST(12));
		
	}
}
