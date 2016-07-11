/**
 * @author stingchang
 * */
package com.leet.q181;

public class Q189_RotateArray {
	// divide the array into two parts, [0~k-1][k~len-1]
	// reverse the whole array and then reverse two sub arrays
	// example [ 1 2 3 4 5 6], k =2
	// => [ 6 5 4 3 2 1], => [6 5][4 3 2 1]
	public void rotate(int[] nums, int k) {
		if (nums == null)
			return;
		int len = nums.length;
		if (len <= 1)
			return;

		reverse(nums, 0, len - 1);
		k %= len;
		reverse(nums, 0, k - 1);
		reverse(nums, k, len - 1);
	}

	public void reverse(int[] nums, int a, int b) {
		for (int i = 0; i < (b - a + 1) / 2; i++) {
			int tmp = nums[a + i];
			nums[a + i] = nums[b - i];
			nums[b - i] = tmp;
		}
	}

	// create a method which shift one position at a time
	// call the method k times
	// this method will exceed time limitation
	public void rotate2(int[] nums, int k) {
		if (nums == null)
			return;
		int len = nums.length;
		if (len <= 1)
			return;

		k = k % len;
		for (int i = 0; i < k; i++) {
			shift(nums);
		}
	}

	public void shift(int[] nums) {
		int len = nums.length;
		int tmp = nums[len - 1];
		for (int i = len - 1; i >= 1; i--) {
			nums[i] = nums[i - 1];
		}
		// System.out.println(Arrays.toString(nums));
		nums[0] = tmp;

	}
}
// k = k%len
// tmp = arr[len-1]
// for i = len-1~0
// t = i-k<0 ? i-k+len : i-k;
// arr[i] = arr[t]
