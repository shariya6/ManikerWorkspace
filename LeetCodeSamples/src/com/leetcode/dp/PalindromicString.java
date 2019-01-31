package com.leetcode.dp;

import java.util.ArrayList;
import java.util.List;

public class PalindromicString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(allPalindromeSubstring("abaab"));
	}
	
	 public static List<String> allPalindromeSubstring(String s) 
	    { 
	        List<String> list = new ArrayList<String>(); 
	  
	        // moving the pivot from starting till end of the string 
	        for (float pivot = 0; pivot < s.length(); pivot += .5) { 
	  
	            // set radius to the first nearest element 
	            // on left and right 
	            float palindromeRadius = pivot - (int)pivot; 
	  
	            // if the position needs to be compared has an element 
	            // and the characters at left and right matches 
	            while ((pivot + palindromeRadius) < s.length() 
	                   && (pivot - palindromeRadius) >= 0
	                   && s.charAt((int)(pivot - palindromeRadius)) 
	                          == s.charAt((int)(pivot + palindromeRadius))) { 
	  
	                list.add(s.substring((int)(pivot - palindromeRadius), 
	                                     (int)(pivot + palindromeRadius + 1))); 
	  
	                // increasing the radius by 1 to point to the 
	                // next elements in left and right 
	                palindromeRadius++; 
	            } 
	        } 
	  
	        return list; 
	    } 
	 
    public static int countSubstrings(String s) {
        
    	int n = s.length();
    	int dp[][] = new int [n][n];
    	int count  = 0; 
    	
    	for(int i = 0 ; i < n; i ++){
    		dp[i][i] = 1 ;
    	}
    	count = n; 
    	
    	for(int j = 0 ; j < n-1 ; j++){

    		if(s.charAt(j) == s.charAt(j+1)){
    			dp[j][j+1] = 1;
    			count += 1;
    		}else
    			dp[j][j+1] =  0;
    	}
    	
    	for(int k = 2; k < n; k++){
    		
    		for (int i = 0 ; i < n - k ; i++){
    			
    			int j = k+i;
    			
    			if(s.charAt(i) == s.charAt(j) && dp[i+1][j-1] == 1){
    				dp[i][j] = 1;
    				count += 1;
    			}
    		}
    	}
    	return count;
    	
    }
    
    static int countPS(int i , int j, String s){
    	
    	if(i == j){
    		return 1;
    	}
    	if(j == i+1 ){
    		return s.charAt(i) == s.charAt(j) ? 1 : 0;
    	}
    	else{
    		return countPS(i, j-1, s) + countPS(i+1, j, s) ; 
    	}
    }

}
