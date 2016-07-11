/**
 * @author stingchang
 * */
package com.leet.q341;

public class Q342_PowerOfFour {

	public boolean isPowerOfFour(int num) {
		int sqrt = (int) (Math.sqrt(num));
		return (num>0) && (sqrt*sqrt == num) && ((num&(num-1))==0);
	}
}

// Solution:
// https://discuss.leetcode.com/topic/50835/c-simple-solution-using-sqrt-and-power-of-2-without-using-any-magic-pre-calculated-number
