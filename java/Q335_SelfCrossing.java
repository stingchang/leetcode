/*
*   Author: Sting Chang
*   Date: 07/03/2016
*   Node: can't figure out by my own, refer to online solution: 
*   http://www.cnblogs.com/grandyang/p/5216856.html
*   https://discuss.leetcode.com/topic/38084/re-post-2-o-n-c-0ms-solutions/2
*/

public class Solution {
    public boolean isSelfCrossing(int[] x) {
        if(x == null || x.length<4)
            return false;
            
        boolean isGrowSpiral = x[2]>x[0];
        int len = x.length;
        
        for(int i = 3; i<len; i++){
            if(!isGrowSpiral && x[i]>=x[i-2])
                return true;
            
            if(isGrowSpiral && x[i]<=x[i-2]){
                isGrowSpiral = false;
                x[i-1] = x[i]+(i>=4?x[i-4]:0)>=x[i-2] ? x[i-1]-x[i-3]: x[i-1];
            }    
        }
        return false;
    }
    
}
