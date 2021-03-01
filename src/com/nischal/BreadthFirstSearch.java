package com.nischal;

import java.util.LinkedList;
import java.util.Queue;

public class BreadthFirstSearch {
	TreeNode root;

	public void computeBFS() {
		Queue<TreeNode> queue=new LinkedList<>();
		if(root !=null) {
			queue.add(root);
			while(!queue.isEmpty()) {
				TreeNode visitedNode=queue.remove();
				System.out.print(visitedNode.data +"  ");
				if(visitedNode.left!=null) {
					queue.add(visitedNode.left);
				}
				if(visitedNode.right!=null) {
					queue.add(visitedNode.right);
				}
			}	
		}else {
			System.out.println("Tree is empty");
		}
	}

	public static void main(String[] args) {
		BreadthFirstSearch tree = new BreadthFirstSearch();
		tree.root = new TreeNode(15);
		tree.root.left = new TreeNode(10);
		tree.root.right = new TreeNode(20);
		tree.root.left.left = new TreeNode(8);
		tree.root.left.right = new TreeNode(12);
		tree.computeBFS();
	}
}
