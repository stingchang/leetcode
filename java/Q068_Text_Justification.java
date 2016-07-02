/*
* Author:   Sting Chang
* Date:     07/02/2016
* Solution: http://www.cnblogs.com/springfor/p/3896168.html
*/

public class Solution {
	public List<String> fullJustify(String[] words, int maxWidth) {
		System.out.println("Input: " + Arrays.toString(words) + ", length = " + maxWidth);
		List<String> list = new ArrayList<>();
		if (words == null || words.length == 0)
			return list;

		int start = 0, end = 0;
		int curLength = 0;

		for (int i = 0; i < words.length; i++) {

			if (i == words.length - 1) {
				if (words[i].length() + 1 + curLength > maxWidth) {
					String str = buildStr(words, start, end, maxWidth);
					list.add(str);
					System.out.println(" Add "+str);
					
					str = buildStr(words, i, i, maxWidth);
					list.add(str);
					System.out.println(" Add "+str);
				} else {
					String str = buildStr(words, start, i, maxWidth);
					list.add(str);
					System.out.println(" Add "+str);
				}
			} else {
				// check if(current string + 1 space + previous string) is short
				// enough
				if (words[i].length() + 1 + curLength > maxWidth) {
					String str = buildStr(words, start, end, maxWidth);
					list.add(str);
					System.out.println(" Add: " + str);

					start = end = i;
					curLength = words[i].length();
					curLength = 0;

				} else {
					curLength += words[i].length()+1;
					end=i;
				}
			}
			System.out.println(" List = " + list);
		}
		return list;
	}

	public String buildStr(String[] words, int start, int end, int width) {
		String b1[] = Arrays.copyOfRange(words, start, end+1);
		// abc df afs, w= 13
		// 1. calculate string width
		// 2. calculate min space in each slot
		// 3. append a word then append a slot, if extra spaces left, append one
		// more space
		int stringWidth = 0;
		for (int i = start; i <= end; i++) {
			stringWidth += words[i].length();
		}
		int spaceSize = (start == end) ? 0 : (width - stringWidth) / (end - start);
		String spaces = "";
		for (int i = 0; i < spaceSize; i++) {
			spaces += " ";
		}

		int spaceLeft = width - spaceSize*(end-start) - stringWidth;
		StringBuilder sb = new StringBuilder();
		System.out.print("Build string: " + "start = " + start + ", end = " + end+ " "+ Arrays.toString(b1) + ", spaces = \"" + spaces + "\"");

		for (int i = start; i <= end; i++) {
			sb.append(words[i]);
			if (i < end) {
				sb.append(spaces);
				if (spaceLeft > 0) {
					sb.append(" ");
					spaceLeft--;
				}
			}
		}
		while(spaceLeft>0){
			sb.append(' ');
			spaceLeft--;
		}
		System.out.println(" return \'"+sb.toString()+"\'");
		return sb.toString();
	}
}
