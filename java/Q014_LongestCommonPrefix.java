public class Q014_LongestCommonPrefix {

	public String longestCommonPrefix(String[] strs) {
		// find longest common prefix of the first 2, then compare with
		// third,...
		if(strs.length == 0)
			return "";
		if(strs.length == 1)
			return strs[0];
		
		String prefix =  longestCommonPrefix(strs[0], strs[1]);
		for(int i = 2; i< strs.length; i++){
			prefix = longestCommonPrefix(prefix, strs[i]);
		}
		return prefix;
	}

	public String longestCommonPrefix(String a, String b) {
		if (a.length() == 0 || b.length() == 0)
			return "";

		int length = 0;
		boolean same = true;
		while (same) {
			if (length == a.length())
				return a;
			if (length == b.length())
				return b;
			if (a.charAt(length) == b.charAt(length))
				length++;
			else
				same = false;
		}

		return a.substring(0, length);
	}

}
