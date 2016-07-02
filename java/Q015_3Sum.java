package com.leet.q011;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class Q015_3Sum {

	// O(N^2): put all numbers in a set, for each number n, traverse the each
	// rest number b and see if (target-a-b) is in the set
	public List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> lists = new ArrayList<>();

		Arrays.sort(nums);

		// create set
		Set<Integer> set = new HashSet<>();
		for (int i : nums)
			set.add(i);
		
		System.out.println("Set: ");
		for (int n : set) {
		    System.out.print(n+" ");
		}
		
		for (int i = 0; i < nums.length - 2; i++) {
			for (int j = i + 1; j < nums.length - 1; j++) {
				int a = nums[i];
				int b = nums[j];
				set.remove(a);
				set.remove(b);				
				int c = 200-a-b;
				if(set.contains(c)){
					List<Integer> list = new ArrayList<>();
					list.add(a);
					list.add(b);
					list.add(c);
					lists.add(list);
					set.add(a);
					set.add(b);
				}
				
			}
		}

		return lists;
	}

}
