package com.leetcode.dp;

public class PatternMatchingString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    public static boolean isMatch(String s, String p) {
        
    	if(s.isEmpty() && p.isEmpty()){
    		return true;
    	}
    	
    	if(s.trim().length() > 0 && p.isEmpty()){
    		return false;
    	}
    	
    	if(p.equals("*")){
    		return true;
    	}
    	int j = 0 ; 
    	for(int i =0 ; i < p.length() ; i++){
    		
    		char c = p.charAt(i);
    		
    		if(c == '?'){
    			j++;
    		}else if(c == '*'){
    			
    			while(j < s.length() && i+1 < p.length()){
    				if(s.charAt(j) == p.charAt(i) || s.charAt(j) == p.charAt(i+1)){
    					
    				}
    				  
    			}
    			
    		}
    		
    			
    		
    	}
    	
    	
    	return true;
    		
    }

}
