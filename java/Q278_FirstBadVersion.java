/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */


public class Solution extends VersionControl {
    
    // Solution from: http://www.jiuzhang.com/solutions/first-bad-version/
    // don't know why 
    // pass: "int mid = start + (end - start) / 2;"
    // not pass: mid = (start+ end)/2;
    public int firstBadVersion(int n) {
        int start = 1, end = n;
        while (start + 1 < end) {
                
            int mid = start + (end - start) / 2;
            if (isBadVersion(mid)) {
                end = mid;
            } else {
                start = mid;
            }
        }
            
        if (isBadVersion(start)) {
            return start;
        }
        return end;
    }
    
    public int firstBadVersion2(int n) {
        return findVersion(1, n);
    }
    
    public int findVersion(int start, int end){
        if(isBadVersion(start))
            return start;
        
        int mid = 0;
        while(start+1<end){
            mid = (start+ end)/2;
            
            // boolean cur = isBadVersion(mid);
            if(isBadVersion(mid)){
                end = mid;
            } else 
                start = mid;
            
            
            // if(cur && !pre)
            //     return mid;
                
            // if(pre){
            //     end = mid-1;
            // } else {
            //     start = mid+1;
            // }
                
        }
        // System.out.println("Start = "+start+", end = "+end);
        return isBadVersion(start)?start:end;
    }
    
    // do a binary search to find out first isBadVersion(v) == true;
    // Runtime Error Message:
    // Line 20: java.lang.StackOverflowError
    // Last executed input:
    // 2126753390 versions
    // 1702766719 is the first bad version. 

    // public int findVersion(int start, int end){
    //     int mid = (start+ end)/2;
    //     boolean isBad = isBadVersion(mid);
    //     if(isBad){
    //         if(mid ==1 || !isBadVersion(mid-1))
    //             return mid;
    //         return findVersion(start, mid-1);
    //     } else {
    //         if(isBadVersion(mid+1))
    //             return mid+1;
    //         return findVersion(mid+1, end);
    //     }
    // }
}
