/*
 * Author: Sting Chang
 * Date: 07/02/2016
 * Approach1:
 *      1. Use two indices, i = 0~len-1, j= i+1~len
 *      2. check whether (words[i]+words[j]) and (words[j]+words[i]) are palindrome
 *
 * Approach2:
 *      1. Use a HashMap<String, int> to track each word and it's index in array
 *      2. For each word S, divide it into Sl and Sr, s = 0~len-1 and r = len-1~0, 
 *          a. if Sl isPalindrome and map has Sr.reverse, add(Sr.reverse.index, S.index)
 *          b. if Sr isPalindrome and map has Sl.reverse, add(S.index, Sl.reverse.index)
 **/

public class Solution {
   	public List<List<Integer>> palindromePairs(String[] words) {
		List<List<Integer>> lists = new ArrayList<>();
		if (words == null || words.length == 0) {
			return lists;
		}

		Map<String, Integer> map = new HashMap<>();

		for (int i = 0; i < words.length; i++) {
			map.put(words[i], i);
		}

		int len = words.length;
		for (int s = 0; s < len; s++) {

			// find palindrome of current -> abcd / dcba
			String curReverse = reverse(words[s]);
		//	System.out.println(words[s] + " reverse = " + curReverse);
			if (map.containsKey(curReverse) && map.get(curReverse) != s) {
				List<Integer> list = new ArrayList<>();
				int v = map.get(curReverse);
				list.add(s);
				list.add(v);
				lists.add(list);
			}
			
			if(isPalindrome(words[s]) && map.containsKey("") && s!=map.get("")){
				List<Integer> list = new ArrayList<>();
				list.add(s);
				list.add(map.get(""));
				lists.add(list);
				list = new ArrayList<>();
				list.add(map.get(""));
				list.add(s);
				lists.add(list);
			}
			
			// find palindrome of substring -> [a bcd][ab cd][abc d]
			for (int i = 1; i < words[s].length(); i++) {
				int strLen = words[s].length();
				String left = words[s].substring(0, i);
				String right = words[s].substring(i, strLen);
				String lReverse = reverse(left);
				String rReverse = reverse(right);

				// System.out.print(" left= " + left + ", right = " + right + "
				// : search \'" + lReverse + "\' and \'"
				// + rReverse + "\'");

				if (isPalindrome(left)) {

					if (map.containsKey(rReverse)) {
						List<Integer> list = new ArrayList<>();
						list.add(map.get(rReverse));
						list.add(s);
						lists.add(list);

						// System.out.print(" ; map has " + rReverse);
					}
				}
				if (isPalindrome(right)) {

					if (map.containsKey(lReverse)) {
						List<Integer> list = new ArrayList<>();
						list.add(s);
						list.add(map.get(lReverse));
						lists.add(list);

						// System.out.print(" ; map has " + lReverse);
					}
				}
				// System.out.println();
			}
		}

		return lists;
	}

	boolean isPalindrome(String str) {
		char[] arr = str.toCharArray();
		int len = arr.length;
		for (int i = 0; i < len / 2; i++) {
			if (arr[i] != arr[len - 1 - i])
				return false;
		}
		return true;
	}

	String reverse(String str) {
		StringBuilder sb = new StringBuilder();
		for (int i = str.length() - 1; i >= 0; i--) {
			sb.append(str.charAt(i));
		}
		return sb.toString();
	}
}
