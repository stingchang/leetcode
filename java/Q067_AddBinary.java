/**
 * 
 * @author Sting Chang
 * */

package com.leet.q061;

public class Q067_AddBinary {

    // use StringBuilder
    public String addBinary(String a, String b) {
        if(a==null || a.length() ==0)
            return b;
        if(b==null || b.length() ==0)
            return a;    
            
        char[] arrA = a.toCharArray();
        char[] arrB = b.toCharArray();
        int indexA = arrA.length-1;
        int indexB = arrB.length-1;
        StringBuilder sb = new StringBuilder();
        
        char carry = '0';
        while(indexA>=0 && indexB>=0){
            int numOne = 0;
            
            if(arrA[indexA--] == '1')
                numOne++;
            
            if(arrB[indexB--] == '1')
                numOne++;
                
            if(carry == '1')
                numOne++;      
            
            sb.append( (numOne%2 == 1) ? 1 : 0 );
            carry = numOne>1?'1':'0'; 
        }
        
        while(indexA>=0){
            int numOne = 0;
            
            if(arrA[indexA--] == '1')
                numOne++;
            if(carry == '1')
                numOne++;      
            
            sb.append( (numOne%2 == 1) ? 1 : 0 );
            carry = numOne>1?'1':'0'; 
        }
        while(indexB>=0){
            int numOne = 0;
            
            if(arrB[indexB--] == '1')
                numOne++;
            if(carry == '1')
                numOne++;      
            
            sb.append( (numOne%2 == 1) ? 1 : 0 );
            carry = numOne>1?'1':'0';   
        }
        if(carry=='1')
            sb.append('1');
        return (sb.reverse()).toString();
    }
    
    
    // This method will cause NumberFormatException if input string too long
    public String addBinary2(String a, String b) {
        int aVal = Integer.parseInt(a);
        int bVal = Integer.parseInt(b);
        int sum = aVal + bVal;
    
        // return Integer.toBinaryRepresentation(sum);
        return Integer.toBinaryString(sum);
    }
	    
	    public static void main(String[] args){
	    	Q067_AddBinary q = new Q067_AddBinary();
	    	String result = q.addBinary("0", "0");
	    	System.out.println("result = "+result);
	    }
	}
