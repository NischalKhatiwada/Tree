package com.nischal;

public class BSTInsertion {
	TreeNode root;

	//Insertion in binary search tree
		public void insert(int data) {
			TreeNode newNode = new TreeNode(data);
			TreeNode temp = root, prev = null;
			while (temp != null) {
				prev = temp;
				if (temp.data > data) {
					temp = temp.left;
				} else {
					temp = temp.right;
				}
			}
			if (root == null) {
				root = newNode;
			} else if (data > prev.data) {
				prev.right = newNode;
			} else {
				prev.left = newNode;
			}
		}
		
		public static void main(String[] args) {
			BSTInsertion tree= new BSTInsertion();
			tree.insert(23);
			tree.insert(34);
			tree.insert(22);
			System.out.println(tree.root.data);
			System.out.println(tree.root.right.data);
			System.out.println(tree.root.left.data);
		}
}
