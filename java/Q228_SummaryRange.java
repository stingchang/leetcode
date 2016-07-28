/**
 * @author stingchang
 * */
package com.leet.q221;

import java.util.ArrayList;
import java.util.List;

/*
 Given a sorted integer array without duplicates, return the summary of its ranges.

For example, given [0,1,2,4,5,7], return ["0->2","4->5","7"].
 */

public class Q228_SummaryRange {
	public List<String> summaryRanges(int[] nums) {
		// use two pointers to keep track of start and end of current range
		List<String> list = new ArrayList<>();
		if (nums == null || nums.length == 0)
			return list;
		int start = 0, end = 0;
		for (int i = 0; i < nums.length; i++) {
			if (i != nums.length - 1) {

				if (nums[i + 1] - nums[i] == 1) {
					end++;
				} else {
					if (start == end) {
						list.add(nums[start] + "");

					} else {
						list.add(nums[start] + "->" + nums[end]);
					}
					start = end = i + 1;
				}
			} else {
				if (start == end) {
					list.add(nums[start] + "");

				} else {
					list.add(nums[start] + "->" + nums[end]);
				}
				start = end = i + 1;
			}
		}
		return list;
	}

	public static void main(String[] args) {
		Q228_SummaryRange q = new Q228_SummaryRange();
		int[] arr = { 0, 1, 2, 4, 5, 7 };
		List<String> result = q.summaryRanges(arr);
		for (String s : result)
			System.out.println(s);
	}
}
