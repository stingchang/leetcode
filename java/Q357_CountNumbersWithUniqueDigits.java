/**
 * @author stingchang
 * Solution: http://www.cnblogs.com/grandyang/p/5582633.html
 * */
package com.leet.q351;

public class Q357_CountNumbersWithUniqueDigits {
	public int countNumbersWithUniqueDigits(int n) {
		if (n == 0)
			return 1;
		if (n == 1)
			return 10;

		int[] arr = new int[n];
		arr[0] = 10;
		arr[1] = 9 * (10 - 1);
		for (int i = 2; i < n; i++) {
			arr[i] = arr[i - 1] * (10 - i);
		}
		int sum = 0;
		for (int i = 0; i < n; i++) {
			sum += arr[i];
		}
		return sum;
	}
}

// n = 3
// 9*(10-1)(10-2) = 81*8 = 648
// n = 2
// 9*(10-1) = 81
// n = 1
// 10
//
// int[n] k = [10, a1, a2, a3, a4]
// ak = ak-1 * (10-k-1)
