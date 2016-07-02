package com.leet.q031;
/*
 The count-and-say sequence is the sequence of integers beginning as follows:
1, 11, 21, 1211, 111221, ...

1 is read off as "one 1" or 11.
11 is read off as "two 1s" or 21.
21 is read off as "one 2, then one 1" or 1211.
Given an integer n, generate the nth sequence.

Note: The sequence of integers will be represented as a string.
 */
public class Q038_CountAndSay {
    public String countAndSay(int n) {
        if(n==1)
            return "1";
        String countSay ="1";
        for(int i =1; i<n; i++){
            countSay = genNewString(countSay);
        }
        return countSay;
    }
    private String genNewString(String str){
        char tmp = str.charAt(0);
        int count = 1;
        StringBuilder sb = new StringBuilder();
        for(int i =1; i< str.length(); i++){
            if(tmp == str.charAt(i))
                count++;
            else{
                sb.append(count);
                sb.append(tmp);
                
                tmp = str.charAt(i);
                count = 1;
            }    
        }
        
        sb.append(count);
        sb.append(tmp);
        
        return sb.toString();
    }
}
