package com.leetcode.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
 
public class ShoppingOffers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		

/*[0,0,0]
[[1,1,0,4],[2,2,1,9]]
[1,1,1]

[1,1,1]
[[1,1,1,0],[2,2,1,1]]
[1,1,0]

[9,9]
[[1,1,1]]
[2,2]
*/

		List<Integer> price = new ArrayList<Integer>();
		price.add(0);
		price.add(0);
		price.add(0);
		
		List<List<Integer>> special = asList(
                asList(1,1,0,4),
                asList(2,2,1,9)
                
              );
		List<Integer> needs = new ArrayList<Integer>();
		needs.add(1);
		needs.add(1);
		needs.add(1);
		
		System.out.println(shoppingOffers(price, special , needs));
	}
	
	 public static <T> List<T> asList(T ... items) {
	        List<T> list = new ArrayList<T>();
	        for (T item : items) {
	            list.add(item);
	        }
	        return list;
	    }
	
	 public static int shoppingOffers1(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
		 if(null == needs || null == price || null == special){
			 return 0;
		 }
		 int len = special.size();
		 int l = special.get(0).size() - 1;
		 int[] dp = new int[len];
		 
		 
		 for(int i  =0 ; i < special.size(); i++){
			 int value = 0; 
			 for(int j = 0 ; j < special.get(i).size()-1; j++){
				 value += needs.get(j)* price.get(j);
				 int balance = needs.get(j) - special.get(i).get(j);
				 if(balance >= 0 && dp[i] != -1) {
					 dp[i] = dp[i] +( balance*price.get(j));
				 }else{
					 dp[i] = -1;
				 }
			 }
			 if(dp[i] >= 0){
			  dp[i] = dp[i] + special.get(i).get(l);
			  dp[i] = Math.min(dp[i], value);
			 }else{
				 dp[i] = value;
			 }
		 }
		 int min = Arrays.stream(dp).filter(i -> i >= 0).min().orElse(0);
		 return min; 
	   }
	 
	 public static int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
	    	return helper(price, special, needs, 0);
	    }
	    
	    private static int helper(List<Integer> price, List<List<Integer>> special, List<Integer> needs, int pos) {
	    	int local_min = directPurchase(price, needs);
	    	for (int i = pos; i < special.size(); i++) {
	    		List<Integer> offer = special.get(i);
	    		List<Integer> temp = new ArrayList<Integer>();
	        	for (int j= 0; j < needs.size(); j++) {
	        		if (needs.get(j) < offer.get(j)) { // check if the current offer is valid
	        			temp =  null;
	        			break;
	        		}
	        		temp.add(needs.get(j) - offer.get(j));
	        	}
	        	
	    		if (temp != null) { // use the current offer and try next
	    			local_min = Math.min(local_min, offer.get(offer.size() - 1) + helper(price, special, temp, i)); 
	    		}
	    	}

	    	return  local_min;
	    }
	    
	    private static int directPurchase(List<Integer> price, List<Integer> needs) {
	    	int total = 0;
	    	for (int i = 0; i < needs.size(); i++) {
	    		total += price.get(i) * needs.get(i);
	    	}
	    	
	    	return total;
	    }

}
