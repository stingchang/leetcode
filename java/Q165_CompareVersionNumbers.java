/**
 * @author stingchang
 * */
package com.leet.q161;

import java.util.StringTokenizer;

public class Q165_CompareVersionNumbers {
	public int compareVersion(String version1, String version2) {
		StringTokenizer s1 = new StringTokenizer(version1, ".");
		StringTokenizer s2 = new StringTokenizer(version2, ".");
		while (s1.hasMoreTokens() && s2.hasMoreTokens()) {
			int v1 = Integer.parseInt(s1.nextToken());
			int v2 = Integer.parseInt(s2.nextToken());
			if(v1>v2)
				return 1;
			if(v1<v2)
				return -1;
		}
		while(s1.hasMoreElements()){
			if(Integer.parseInt(s1.nextToken())>0)
				return 1;
		}
			
		while(s2.hasMoreElements()){
			if(Integer.parseInt(s2.nextToken())>0)
				return -1;
		}
		
		return 0;
	}

	public static void main(String[] args) {
		Q165_CompareVersionNumbers q = new Q165_CompareVersionNumbers();
		int version = q.compareVersion("1", "0");
		System.out.println(version);
	}
}
