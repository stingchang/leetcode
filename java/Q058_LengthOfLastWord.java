package com.leet.q051;

/*
Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word in the string.

If the last word does not exist, return 0.

Note: A word is defined as a character sequence consists of non-space characters only.

For example, 
Given s = "Hello World",
return 5.
*/

public class Q058_LengthOfLastWord {
	public static int lengthOfLastWord(String s) {
		String[] arr = s.split(" ");
		return arr.length >= 1 ? arr[arr.length - 1].length() : 0;

	}
	/*
	 * Second method: Search from end of string, find first character not ' '
	 * and last character not ' ' or end when it is first character
	 */

	public static void main(String[] args) {
		String s1 = ""; // 0
		String s2 = " "; // 0
		String s3 = "  abcd"; // 4
		String s4 = "ab  cd"; // 2
		String s5 = "abcd  "; // 4
		String s6 = "ab  cd  "; // 2
		System.out.println("s1: '" + s1 + "' " + lengthOfLastWord(s1));
		System.out.println("s2: '" + s2 + "' " + lengthOfLastWord(s2));
		System.out.println("s3: '" + s3 + "' " + lengthOfLastWord(s3));
		System.out.println("s4: '" + s4 + "' " + lengthOfLastWord(s4));
		System.out.println("s5: '" + s5 + "' " + lengthOfLastWord(s5));
		System.out.println("s6: " + s6 + "' " + lengthOfLastWord(s6));
	}
}
