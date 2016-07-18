/**
 * @author stingchang
 * @answer: https://www.hrwhisper.me/leetcode-house-robber-iii/
 * */
package com.leet.q331;

import com.leet.*;

public class Q337_HouseRobberIII {
    public int rob(TreeNode root) {
        int[] values = value(root);
        return values[0];
    }
    
    public int[] value(TreeNode root){
        int[] values = {0, 0};
        if(root!=null) {
            int[] left = value(root.left);
            int[] right = value(root.right);
            
            values[1] = left[0]+right[0]; // skip current
            values[0] = Math.max(root.val+left[1]+right[1], values[1]);
        }
        
        return values;
    }
}
