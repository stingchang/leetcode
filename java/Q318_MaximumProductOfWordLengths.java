/**
 * @author stingchang
 * */
package com.leet;

import java.util.HashMap;
import java.util.Map;

public class Q318_MaximumProductOfWordLengths {

	public int maxProduct(String[] words) {
		Map<String, Integer> map = new HashMap<>();
		for (String s : words) {
			int val = charAppear(s);
			map.put(s, val);
			// System.out.println(java.lang.Integer.toBinaryString(val)+" :
			// "+s);
		}
		int len = words.length;
		int max = 0;
		for (int i = 0; i < len - 1; i++) {
			for (int j = i + 1; j < len; j++) {
				int aVal = map.get(words[i]);
				int bVal = map.get(words[j]);
				// two words no same character
				if ((aVal & bVal) == 0) {
					max = Math.max(max, words[i].length() * words[j].length());
				}
			}
		}
		return max;
	}

	public int charAppear(String s) {
		int value = 0;
		for (int i = 0; i < s.length(); i++) {
			int c = s.charAt(i) - 'a';
			value |= 1 << c;
		}
		return value;
	}
}
