/**
 * @author stingchang
 * */
package com.leet.q221;

import java.util.ArrayList;
import java.util.List;

public class Q230_KthSmallestElementInABST {

	// Definition for a binary tree node.
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public int kthSmallest(TreeNode root, int k) {
		List<Integer> list = new ArrayList<>();
		list = buildinOrder(root);
		// System.out.println(k+", list = "+list);
		return list.get(k - 1);
	}

	List<Integer> buildinOrder(TreeNode root) {
		List<Integer> list = new ArrayList<>();

		if (root.left != null)
			list.addAll(buildinOrder(root.left));

		list.add(root.val);

		if (root.right != null)
			list.addAll(buildinOrder(root.right));

		return list;
	}

}

// 1. If only querry once, build an list where the elements are inorder
// traversal of BST, return kth from back
// 2. If the funciton is called multiple times, change the data structure
// We track how many nodes greater than or equal to current
// we call this value gt
// if(current node is null) reuturn -1
// if(number==gt) return current value
// if(number<gt) go to right child
// if(number>gt) go to left child, number-=gt
