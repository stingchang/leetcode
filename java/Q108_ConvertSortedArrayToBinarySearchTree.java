/**
 * @author stingchang
 * */
package com.leet.q101;

public class Q108_ConvertSortedArrayToBinarySearchTree {
	public TreeNode sortedArrayToBST(int[] nums) {
		if (nums == null || nums.length == 0)
			return null;
		int a = 0;
		int b = nums.length - 1;
		return toBSTHelper(nums, a, b);
	}

	public TreeNode toBSTHelper(int[] nums, int a, int b) {
		if (a > b)
			return null;
		int mid = a + (b - a) / 2;
		TreeNode root = new TreeNode(nums[mid]);
		root.left = toBSTHelper(nums, a, mid - 1);
		root.right = toBSTHelper(nums, mid + 1, b);

		return root;
	}
}
