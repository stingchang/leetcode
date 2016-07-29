/**
 * @author stingchang
 * */
package com.leet.q281;

import java.util.ArrayList;
import java.util.List;

public class Q281_ZigzagIterator {
	private List<Integer> list;
	private int index = 0;

	public Q281_ZigzagIterator(List<List<Integer>> lists) {

		list = new ArrayList<>();

		int maxSize = 0;
		for (List<Integer> list : lists) {
			maxSize = Math.max(maxSize, list.size());
		}
		// ......
		// ...
		// .........
		// ......
		for (int i = 0; i < maxSize; i++) {
			for (int listNum = 0; listNum < lists.size(); listNum++) {
				if (lists.get(listNum).size() > i)
					list.add(lists.get(listNum).get(i));
			}
		}

	}

	public int next() {
		return list.get(index);
	}

	public boolean hasNext() {
		return index < list.size() - 1 ? true : false;
	}
}
