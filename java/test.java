package com.sting.test;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class Test {

	public static void main(String[] args) {
//		// value, count
//		int[] arr = { 1, 3, 3, 3, 1, 1, 4, 5, 5, 5 };
//		// System.out.println(singleNumber(arr));
//
//		Set<Integer> s1 = new HashSet<>();
//		Set<Integer> s2 = new HashSet<>();
//		Set<Integer> s3 = new HashSet<>();
//		s1.add(1);
//		s1.add(2);
//		s1.add(3);
//		s2.add(3);
//		s2.add(4);
//		s2.add(5);
//		System.out.println("s1 = " + s1);
//		System.out.println("s2 = " + s2);
//		s3.addAll(s1);
//		s1.addAll(s2);
//		System.out.println("s1 union s2 = " + s1);
//		s1.clear();
//		s1.addAll(s3);
//		System.out.println("s1 = " + s1 + ", s2 = " + s2 + ", s3 = " + s3);
//		s1.retainAll(s2);
//		System.out.println("s1 retainAll s2 = " + s1);
//		s1.clear();
//		s1.addAll(s3);
//		System.out.println("s1 = " + s1 + ", s2 = " + s2 + ", s3 = " + s3);
//		s1.removeAll(s2);
//		System.out.println("s1 removeall s2 = " + s1);

		Map<Integer, Integer> map  =new HashMap<>();
		map.put(1, 1);
		map.put(2, 2);
		System.out.println(map.values());
		
	}

	public static int singleNumber(int[] nums) {
		// value, count
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			if (!map.containsKey(nums[i])) {
				map.put(nums[i], 1);
			} else {
				map.put(nums[i], map.get(nums[i]) + 1);
			}
		}
		int result = 0;
		Iterator<Entry<Integer, Integer>> it = map.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry<Integer, Integer> pair = it.next();
			// System.out.println(pair.getKey() + " = " + pair.getValue());
			// it.remove(); // avoids a ConcurrentModificationException
			if (pair.getValue() % 3 != 0) {
				return pair.getKey();
			}
		}
		return result;

	}
}
