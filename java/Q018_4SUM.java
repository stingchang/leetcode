/**
 * @author stingchang
 * */

package com.leet.q011;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Q018_4SUM {
	public List<List<Integer>> fourSum(int[] nums, int target) {
		Arrays.sort(nums);

		List<List<Integer>> lists = new ArrayList<>();
		Set<String> keySet = new HashSet<>();
		int len = nums.length;
		for (int i = 0; i < len - 3; i++) {
			for (int j = i + 1; j < len - 2; j++) {
				int diff = target - (nums[i] + nums[j]);
				int a = j + 1, b = len - 1;
				while (a < b) {
					if (nums[a] + nums[b] == diff) {
						String key = genKey(nums[i], nums[j], nums[a], nums[b]);
						if (!keySet.contains(key)) {
							List<Integer> list = new ArrayList<>();
							list.add(nums[i]);
							list.add(nums[j]);
							list.add(nums[a]);
							list.add(nums[b]);
							lists.add(list);
							keySet.add(key);
						}
						a++;
						b--;
					} else if (nums[a] + nums[b] > diff) {
						b--;
					} else {
						a++;
					}
				}
			}
		}

		return lists;
	}

	public String genKey(int a, int b, int c, int d) {
		ArrayList<Integer> list = new ArrayList<>();
		list.add(a);
		list.add(b);
		list.add(c);
		list.add(d);
		Collections.sort(list);
		return list.get(0) + "_" + list.get(1) + "_" + list.get(2) + "_" + list.get(3);
	}

	public String genKey(Set<Integer> s1, Set<Integer> s2, int[] arr) {
		List<Integer> list = new ArrayList<>();
		for (Integer i : s1) {
			if (s2.contains(i))
				return "";
			list.add(arr[i]);
		}
		for (Integer i : s2) {
			list.add(arr[i]);
		}

		Collections.sort(list);
		// key: a-b-c-d-

		String key = list.get(0) + "-" + list.get(1) + "-" + list.get(2) + "-" + list.get(3);
		return key;
	}

	public static void main(String[] args) {
		Q018_4SUM t = new Q018_4SUM();
		int[] nums = { -3, -2, -1, 0, 0, 1, 2, 3 };
		int target = 0;
		List<List<Integer>> lists = t.fourSum(nums, target);
		for (List<Integer> list : lists) {
			System.out.println(list);
		}
	}
}
