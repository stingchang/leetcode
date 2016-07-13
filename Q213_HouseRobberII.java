package com.leet.q211;


public class Q213_HouseRobberII {
	// calculate max value from 0 to send last, and max value from 1 to last
	// return the alrger one
	
	public int rob(int[] nums) {
		if (nums == null || nums.length == 0)
			return 0;
		if (nums.length == 1)
			return nums[0];

		int takeFirst = findMax(nums, 0);
		int takeLast = findMax(nums, 1);
		return Math.max(takeFirst, takeLast);
	}

	public int findMax(int[] arr, int shift) {
		int len = arr.length - 1;
		int[] rob = new int[len];
		int[] skip = new int[len];

		rob[0] = arr[shift];
		skip[0] = 0;
		for (int i = 1; i < len; i++) {
			rob[i] = arr[i + shift] + skip[i - 1];
			skip[i] = Math.max(rob[i - 1], skip[i - 1]);
		}
		return Math.max(rob[len - 1], skip[len - 1]);
	}
	// public int rob(int[] nums) {
	// if(nums == null)
	// return 0;
	// int len = nums.length;
	// // case 1, even numbers
	// if(len%2 == 0){
	// int odd = 0;
	// int even = 0;
	// for(int i =0; i<len; i++){
	// if(i%2==0)
	// even += nums[i];
	// else
	// odd += nums[i];
	// }
	// return Math.max(even, odd);
	// }

	// if(len==1)
	// return nums[0];

	// // case 2 odd numbers
	// // create four arrays
	// int[] preOdd = new int[len];
	// int[] preEven = new int[len];
	// int[] postOdd = new int[len];
	// int[] postEven = new int[len];

	// // from front
	// for(int i =0; i< len; i++){
	// // odd
	// if(i%2==1){
	// if(i==1){
	// preOdd[i] = 0;
	// } else {
	// preOdd[i] = preOdd[i-2] + nums[i-2];
	// }
	// preEven[i] = preEven[i-1] + nums[i-1];
	// }
	// // even
	// else {
	// if(i==0){
	// preEven[i] = 0;
	// preOdd[i] = 0;
	// } else {
	// preEven[i] = preEven[i-2] + nums[i-2];
	// preOdd[i] = preOdd[i-1] + nums[i-1];
	// }
	// }
	// }

	// // from back
	// for(int i =len-1; i>=0; i--){
	// // odd
	// if(i%2==1){
	// if(i==len-2){
	// postOdd[i] = 0;
	// } else {
	// postOdd[i] = postOdd[i+2] + nums[i+2];
	// }
	// postEven[i] = postEven[i+1] + nums[i+1];
	// }
	// // even
	// else {
	// if(i==len-1){
	// postEven[i] = 0;
	// postOdd[i] = 0;
	// } else {
	// postEven[i] = postEven[i+2] + nums[i+2];
	// postOdd[i] = postOdd[i+1] + nums[i+1];
	// }
	// }
	// }

	// // traverse and find max(preOdd+postEven, preEven+postOdd)
	// int max = 0;
	// for(int i = 0; i< len; i++){
	// int curMax = Math.max(preOdd[i]+postEven[i], postOdd[i]+preEven[i]);
	// max = Math.max(max, curMax);
	// }
	// return max;
	// }
}

// if there are even numbers, compare sum of numbers at even index and sum of
// numsers at odd index

// if there are odd numbers, each position of max value = max(even Index before
// + odd index after, odd Index before + even index after)
// we create four arrays
// preOdd = sum of Odd nuber from 0 to current index(exclusive)
// preEven = sum of even nuber from 0 to current index(exclusive)
// postOdd = sum of Odd nuber from last to current index(exclusive)
// prostEven = sum of even nuber from last to current index(exclusive)

// from 0~last, find max of max(preOdd+postEven, preEven+postOdd)
