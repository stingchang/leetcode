/**
 * @author stingchang
 * */
package com.leet.q091;

public class Q096_UniqueBinarySearchTrees {
	public int numTrees(int n) {
		if (n <= 1)
			return 1;

		int[] ways = new int[n + 1];
		ways[0] = 1;
		ways[1] = 1;
		for (int i = 2; i <= n; i++) {
			int sum = 0;
			for (int j = 0; j < i; j++) {
				sum += ways[j] * ways[i - j - 1];
			}
			ways[i] = sum;
		}

		return ways[n];
	}
}

// f0 = 1
// f1 = 1
// f2 = f(1)*f(0) + f(0)*f(1)
// f3 = f(2)*f(0) + f(1)*f(1) + f(0)*f(2)
// f4 = f3*f0 + f2*f1 + f1*f(2) + f0*f3;
