/**
 * @author stingchang
 * */
package com.leet.q341;

/*
http://bookshadow.com/weblog/2016/04/19/leetcode-integer-break/
when n>3 break it into 3*3*3... or 2*3*3... or 2*2*3*3...
*/
public class Q343_IntegerBreak {
	public int integerBreak(int n) {
		if (n == 2)
			return 1;
		if (n == 3)
			return 2;
		int total = 1;
		while (n > 0) {
			if (n % 3 == 1) {
				total *= (2 * 2);
				n -= 4;
			} else if (n % 3 == 2) {
				total *= 2;
				n -= 2;
			} else {
				total *= 3;
				n -= 3;
			}
		}
		return total;
	}
}
