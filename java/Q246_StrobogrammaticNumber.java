/**
 * @author stingchang
 * */

// didn't purchase leetcode premium, so this was not verified correct answer
package com.leet.q241;

import java.util.HashSet;
import java.util.Set;

public class Q246_StrobogrammaticNumber {
	// 0 1 6-9 8

	public boolean isStroPramaticnumber(String str) {

		// Map<Character, Character> map = new HashMap<>();
		Set<Character> set = new HashSet<>();
		set.add('0');
		set.add('1');
		set.add('6');
		set.add('9');
		set.add('8');

		if (str == null)
			return false;
		if (str == null)
			return false;

		char[] arr = str.toCharArray();
		int len = arr.length;
		for (int i = 0; i < len / 2; i++) {
			if (set.contains(arr[i]) && set.contains(arr[len - i - 1])) {
				if (arr[i] != arr[len - i - 1])
					return false;
			} else {
				return false;
			}
		}
		return true;
	}
}
