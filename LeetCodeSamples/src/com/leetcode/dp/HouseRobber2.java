package com.leetcode.dp;

public class HouseRobber2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
int[] nums = {1,2,3,1};
System.out.println(rob1(nums));
	}
	public static int rob(int[] nums) {
		
		int len = nums.length;
		int[] dp = new int[len];
		dp[0] = nums[0];
		dp[1] = nums[1];
		
		for(int i = 2 ; i < len ; i++){
			dp[i] = dp[i-2]+nums[i];
		}
		
		if(len %2 != 0 ){

			if(nums[0] > nums[len -1]){
				dp[len -1] -= nums[len -1]; 
			}else{
				dp[len -1 ] -= nums[0];
			}
		}
		return Math.max(dp[len -1], dp[len -2]);
    }
	
	public int robHouse(int[] nums){
		
		int n = nums.length;
		int[] first = new int[n+1];
		int[] second = new int[n+1];
		
		if(n < 2){
			return nums[0];
		}
		
		first[0] = 0 ;
		first[1] = nums[0];
		
		second[0] = second[1] = 0;
		
		for(int i = 2 ; i <= n ; i++ ){
			first[i] = Math.max(first[i-1], second[i -2]+nums[i]);
			second[i] = Math.max(second[i -1], first[i -1] + nums[i]);
		}
		
		return Math.max(first[n-1], second[n]); 
	}
	
/*	Given a list of non-negative integers representing the amount of money of each house, 
	determine the maximum amount of money you can rob tonight without alerting the police.*/
	public static int robHouse1(int[] nums){
		
		int prevNo = 0;
		int prevYes = 0;
		
		for(int n : nums){
			int temp = prevNo ;
			prevNo = Math.max(prevNo, prevYes);
			prevYes = n+temp ; 
		}
		return Math.max(prevNo, prevYes); 
	}
	  public static int rob1(int[] nums) {
	        if(nums.length == 1) {
	            return nums[0];
	        }
	        
	        int fromZero = maxFromRange(nums, 0, nums.length - 1);
	        int fromOne = maxFromRange(nums, 1, nums.length);
	        return Math.max(fromZero, fromOne);
	    }
	    
	    private static int maxFromRange(int[] nums, int start, int end) {
	        int prev2 = 0;
	        int prev1 = 0;
	        for(int i = start; i < end; ++i) {
	            int tmp = Math.max(prev1, prev2 + nums[i]);
	            prev2 = prev1;
	            prev1 = tmp;
	        }
	        
	        return prev1;
	    }
}
