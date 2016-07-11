/**
 * @author stingchang
 * */
package com.leet.q371;

public class SumOfTwoIntegers {

	public int getSum(int a, int b) {

		if (b == 0)
			return a;
		else
			return getSum(a ^ b, (a & b) << 1);

	}
}

// 001
// 010
// for each bitA, bitB
// bitA = bitA^bitB^carry --> 000 001 100 101 111
// carry = carry&bitA&bitB

// 5+3
// 0101
// 0011
// 1000

// ^
// 1 100 010 001 111
// 0 000 110 101 011
//
