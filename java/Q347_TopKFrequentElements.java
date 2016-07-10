/**
 * @author stingchang
 * */
package com.leet.q341;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Q347_TopKFrequentElements {
	public List<Integer> topKFrequent(int[] nums, int k) {
		// Use a HashMap to track the frequence

		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			int n = nums[i];
			if (map.containsKey(n)) {
				map.put(n, map.get(n) + 1);
			} else {
				map.put(n, 1);
			}
		}

		List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());
		// Collections.sort(list, new Comparator<Map.Entry<K, V>>()
		Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {
			@Override
			public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
				return o2.getValue() - o1.getValue();
			}
		});

		List<Integer> resultList = new ArrayList<>();
		for (int i = 0; i < k; i++) {
			resultList.add(list.get(i).getKey());
		}
		return resultList;
	}
}
