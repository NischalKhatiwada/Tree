package com.nischal;

import java.util.Stack;

public class DepthFirstSearch {
	TreeNode root;

	public void inorderTravesal() {
		if (root == null) {
			System.out.println("Tree is Empty");
		} else {
			Stack<TreeNode> stackedNode = new Stack<>();
			TreeNode curr = root;
			while (curr != null || stackedNode.size() > 0) {
				while (curr != null) {
					stackedNode.push(curr);
					curr = curr.left;
				}
				curr = stackedNode.pop();
				System.out.print(curr.data + " ");
				curr = curr.right;
			}
			System.out.println("");
		}
	}

	public void preorderTraversal() {
		if (root == null) {
			return;
		}

		Stack<TreeNode> nodeStack = new Stack<>();
		nodeStack.push(root);

		while (!nodeStack.isEmpty()) {
			TreeNode t = nodeStack.pop();
			System.out.print(t.data + "  ");
			if (t.right != null) {
				nodeStack.push(t.right);
			}
			if (t.left != null) {
				nodeStack.push(t.left);
			}
		}
		System.out.println();
	}

	public void postOrderTraversal() {
		if (root == null) {
			System.out.println("Tree is Empty");
		} else {
			Stack<TreeNode> stackedNode = new Stack<>();
			TreeNode curr = root;
			while (curr != null || stackedNode.size() > 0) {
				if (curr != null) {
					stackedNode.push(curr);
					curr = curr.left;
				} else {
					TreeNode temp = stackedNode.peek().right;
					if (temp != null) {
						curr = temp;
					} else {
						temp = stackedNode.pop();
						System.out.print(temp.data + "  ");
						while (!stackedNode.isEmpty() && temp == stackedNode.peek().right) {
							temp = stackedNode.pop();
							System.out.print(temp.data + "  ");
						}

					}
				}
			}
		}
	}

	public void deleteByMerging(int data) {
		TreeNode p = root, prev = null;
		while (p != null && p.data != data) {
			prev = p;
			if (p.data < data) {
				p = p.right;
			} else {
				p = p.left;
			}
		}
		TreeNode node = p, temp;
		if (p != null && p.data == data) {
			if (node.right == null) {
				node = node.left;

			} else if (node.left == null) {
				node = node.right;
			} else {
				temp = node.left;
				while (temp.right != null) {
					temp = temp.right;
				}
				temp.right = node.right;
				node = node.left;
			}
			if (p == root) {
				root = node;
			} else if (prev.left == p) {
				prev.left = node;
			} else {
				prev.right = node;
			}
		} else if (root != null) {
			System.out.println("Element not founfd in  tree");
		} else {
			System.out.println("Tree is empty");
		}
	}

	public static void main(String[] args) {
		DepthFirstSearch tree = new DepthFirstSearch();
		tree.root = new TreeNode(10);
		tree.root.left = new TreeNode(6);
		tree.root.right = new TreeNode(21);
		tree.root.left.left = new TreeNode(1);
		tree.root.left.right = new TreeNode(8);
		tree.root.right.left = new TreeNode(13);
		tree.root.right.right = new TreeNode(25);
		tree.root.right.left.left = new TreeNode(12);
		tree.root.right.left.right = new TreeNode(18);
		System.out.println("Inorder Traversal");
		tree.inorderTravesal();
		System.out.println("Preorder");
		tree.preorderTraversal();
		System.out.println("Post Order traversal");
		tree.postOrderTraversal();
		tree.deleteByMerging(10);
		System.out.println();
		tree.inorderTravesal();
	}
}
