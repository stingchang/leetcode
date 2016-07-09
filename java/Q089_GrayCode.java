/**
 * @author 	Sting Chang
 * 
 * */

package com.leet.q081;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
 The gray code is a binary numeral system where two successive values differ in only one bit.

Given a non-negative integer n representing the total number of bits in the code, print the sequence of gray code. A gray code sequence must begin with 0.

For example, given n = 2, return [0,1,3,2]. Its gray code sequence is:

00 - 0
01 - 1
11 - 3
10 - 2
Note:
For a given n, a gray code sequence is not uniquely defined.

For example, [0,2,3,1] is also a valid gray code sequence according to the above definition.

For now, the judge is able to judge based on one instance of gray code sequence. Sorry about that.
 */

// 0 
// 1 : 0 1
// 2 : 00 01 11 10 
// 3 : 000 001 011 010 100 101 111 110
// list of n = ("0"+each element of list of grayCode(n-1))+("1"+each element of list of reversed grayCode(n-1))

public class Q089_GrayCode {
    public static List<Integer> grayCode(int n) {
    	List<Integer> list = new ArrayList<>();
    	list.add(0);
    	if(n<=0)
    		return list;
    	
    	for(int i = 0; i< n; i++){
    		List<Integer> tmp = new ArrayList<>();    		
    		tmp.addAll(list);
    		Collections.reverse(tmp);
    		//System.out.print("tmp = "+tmp);
    		
    		for(int j=0; j<tmp.size(); j++){
    			tmp.set(j, (int) (tmp.get(j)+Math.pow(2, i)));
    		}
    		//System.out.print(", reversed tmp = "+tmp);
    		list.addAll(tmp);
    		//System.out.print(", list +reversed = "+list);
    	}
    	//System.out.println(", result = "+list);
		return list;
    }
    public static void main(String[] args){
    	grayCode(2);
    }
}
