/**
 * @author stingchang
 * */
package com.leet.q071;

public class Q074_SearchA2DMatrix {
	public boolean searchMatrix(int[][] matrix, int target) {
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
			return false;
		return binarySearch(matrix, target, matrix[0].length, 0, matrix[0].length * matrix.length - 1);
	}

	public boolean binarySearch(int arr[][], int target, int len, int a, int b) {
		if (b < a)
			return false;
		int mid = a + (b - a) / 2;
		int r = mid / len;
		int c = mid % len;
		if (arr[r][c] == target)
			return true;
		if (arr[r][c] < target) {
			return binarySearch(arr, target, len, mid + 1, b);
		} else {
			return binarySearch(arr, target, len, a, mid - 1);
		}
	}
}
