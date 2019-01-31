package com.leetcode.dp;

import java.util.Arrays;

public class MaximumProductSubarray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums1 = {-1, -2,-9,-6};
		//int[] nums1 = {0,2};
		//int[] nums1 = {-3, 0 , 1, -2};
		System.out.println(maxProduct(nums1));
	}
	
	public static int maxProduct(int[] nums) {
		int n = nums.length;
		int[] dp = new int[n];
		int[] minDp = new int[n];
		dp[n-1] = nums[n-1];
		minDp[n -1] = nums[n-1];
		int result = nums[0];
		
		for(int i = n-2; i >=0 ; i--){
			if(nums[i] > 0){
				dp[i] = Math.max(nums[i] , nums[i]*dp[i+1]);
				minDp[i] = Math.min(nums[i], nums[i]*dp[i+1]);
			}else{
				dp[i] = Math.max(nums[i], nums[i]*minDp[i+1]);
				minDp[i] = Math.min(nums[i], nums[i]*dp[i+1]);
			}
			result = Math.max(result, dp[i]);
		}
		Arrays.sort(dp);
		return dp[n-1]; 
	} 
	//good one 
	public int maxProduct1(int[] nums) {
	    int[] max = new int[nums.length];
	    int[] min = new int[nums.length];
	 
	    max[0] = min[0] = nums[0];
	    int result = nums[0];
	 
	    for(int i=1; i<nums.length; i++){
	        if(nums[i]>0){
	            max[i]=Math.max(nums[i], max[i-1]*nums[i]);
	            min[i]=Math.min(nums[i], min[i-1]*nums[i]);
	        }else{
	            max[i]=Math.max(nums[i], min[i-1]*nums[i]);
	            min[i]=Math.min(nums[i], max[i-1]*nums[i]);
	        }
	 
	        result = Math.max(result, max[i]);
	    }
	 
	    return result;
	}
}
