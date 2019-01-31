package com.leetcode.dp;

import java.util.HashMap;
import java.util.Map;

public class ContinuousSubArraySum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = {0,0};
		System.out.println(checkSubArray(array, 0));

	}
	 public static boolean checkSubarraySum1(int[] nums, int k) {
	        k = k == 0 ? Integer.MAX_VALUE : k;
	        int[] remainder = new int[nums.length];
	        remainder[0] = nums[0] % k;
	        
	        for (int i = 1; i < nums.length; i++) {
	        	int sum = nums[i];
	            for (int j = i-1; j >= 0; j--) {
	               /*remainder[j] = (remainder[j] + nums[i]) % k;
	                if (remainder[j] == 0 && j < i) {
	                    return true;
	                }*/
	            	sum += nums[j];
	            	if(sum%k == 0){
	            		return true;
	            	}
	            	
	            }
	        }
	        return false;
	    }
	 
	 public static boolean checkSubarraySum(int[] nums, int k) {
		 
		// corner case 1: according to the question, the result's length has to be >=2
	        if(nums.length<=1) return false;
	        // corner case 2: two continuous "0" will form a subarray which has sum = 0. 0 * k == 0 will always be true. (k doesn't matter here)
	        for (int i = 0; i < nums.length - 1; i++) {
	            if (nums[i] == 0 && nums[i + 1] == 0) return true;
	        }
	        // corner case 3: now K cannot be 0 anymore
	        if(k==0) return false;
	        
	        Map<Integer, Integer> map = new HashMap<>();
	        map.put(0, -1);
	        int sum = 0;
	        for(int i=0; i<nums.length; i++)
	        {
	            sum +=nums[i];
	            int remainder = sum%k;
	            if(map.containsKey(remainder))
	            {
	                int pre = map.get(remainder);
	                //corner case 4: if i=1, pre = -1, won't work
	                if(i-pre+1>2||(i-pre+1==2&&pre!=-1)) return true;
	            }else
	                map.put(remainder, i);                
	        }
	        return false;        
	    }
	 public static boolean checkSubarraySum2(int[] nums, int k) {
		 Map<Integer, Integer> map = new HashMap<Integer, Integer>(){{put(0,-1);}};;
		 int runningSum = 0;
		 for (int i=0;i<nums.length;i++) {
			 runningSum += nums[i]; 	
			 if (k != 0) runningSum %= k; 
			 Integer prev = map.get(runningSum);
			 if (prev != null) {
				 if (i - prev > 1) return true;
			 }
			 else map.put(runningSum, i);
		 }
		 return false;
	 }
	 
	 public static boolean checkSubArray(int[] nums, int k){
		   
	        if(nums.length == 1){
	            return false;
	        }
	          
	        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
	        
	        map.put(0, -1);
	        int sum = 0;
	        
	        for(int i = 0; i < nums.length ; i++){
	            
	            sum += nums[i];
	            
	            if(k != 0)
	                sum %= k ;
	                Integer prev = map.get(sum);
	                if(prev != null){
	                    if(i - prev > 1){
	                        return true;
	                    }
	                }else{
	                    map.put(sum,i);
	                }
	            
	        }
	        return false;

	 }
}
