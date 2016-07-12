/**
 * @author stingchang
 * */
package com.leet.q231;

//Given an array [a0, a1, a2, a3...ak]
//Construct two arrays
//m = [1, 1*a0, 1*a1*a0, 1*a0*a1, ..., 1*a0*...*ak-1]
//n = [a1*a2*...ak*1, ..., ak-1*ak*1, ak, 1]
//result[i] = m[i]*n[i]
public class Q238_ProductOfArrayExceptSelf {
	public int[] productExceptSelf(int[] nums) {
		int len = nums.length;
		int[] a = new int[len];
		int[] b = new int[len];

		a[0] = 1;
		for (int i = 1; i < len; i++) {
			a[i] = a[i - 1] * nums[i - 1];
		}

		b[len - 1] = 1;
		for (int i = len - 2; i >= 0; i--) {
			b[i] = b[i + 1] * nums[i + 1];
		}

		for (int i = 0; i < len; i++) {
			a[i] = a[i] * b[i];
		}

		return a;
	}
}
