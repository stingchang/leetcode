/**
 * @author stingchang*/
package com.leet.q011;

import java.util.Arrays;

public class Q016_3SumClosest {
	  public int threeSumClosest(int[] nums, int target) {
	        int len = nums.length;
	        // step 1 sort the array
	        int closeNum = nums[0]+nums[1]+nums[2];
	        Arrays.sort(nums);
	        for(int i =0; i< len-2; i++){
	            int a = i+1, b = len-1;
	            while(a<b){
	                int sum = nums[i]+nums[a]+nums[b];
	                if(sum == target)
	                    return target;
	                if(Math.abs(target-sum)<Math.abs(target-closeNum)){
	                    closeNum = sum;
	                }
	                if(sum<target)
	                    a++;
	                else 
	                    b--;
	            }
	        }
	        return closeNum;
	    }
}
