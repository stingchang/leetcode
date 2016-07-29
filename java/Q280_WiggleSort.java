/**
 * @author stingchang
 * */
package com.leet.q271;

import java.util.Arrays;

public class Q280_WiggleSort {

	// [1,2,3,4,5,6]
	// [1,3,2,4,5,6]
	// [1,3,2,5,4,6]

	// 1. sort the array first
	// 2. swap(2,3) swap(4,5) swap(6,7)...

	public void sort(int[] arr) {
		Arrays.sort(arr);
		int index = 1;
		while (index + 1 < arr.length) {
			// swap(arr, index, index+1);
			int tmp = arr[index];
			arr[index] = arr[index + 1];
			arr[index + 1] = tmp;
		}
	}

}
