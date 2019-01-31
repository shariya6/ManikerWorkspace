package com.leetcode.dp;

public class DeleteAndEarn {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {1,1,1,2,4,5,5,5,6};
		int[] nums1 = {2, 2, 3, 3, 3, 4};
		System.out.println(deleteAndEarn1(nums));

	}
	public static  int deleteAndEarn(int[] nums) {


		int len = nums.length;
		int max = 0;
		for(int i = 0 ; i < len ; i++){
			int j = 0 ; 
			int toFind = nums[i];
			int result = 0;
			while(j < len){
				
				if(nums[j] == nums[i]+1 ) {
					result += 0;
				}else if(nums[j] == nums[i]-1){
					result += 0;
				}else{
					result += nums[j];
				}
					
				j++;
			}
			max = Math.max(max, result);
		}
		return max ; 
	}
	
	public static int deleteAndEarn1(int[] nums) {
        int[] count = new int[10001];
        for (int x: nums) count[x]++;
        int avoid = 0, using = 0, prev = -1;

        for (int k = 0; k <= 10000; ++k) if (count[k] > 0) {
            int m = Math.max(avoid, using);
            if (k - 1 != prev) {
                using = k * count[k] + m;
                avoid = m;
            } else {
                using = k * count[k] + avoid;
                avoid = m;
            }
            prev = k;
        }
        return Math.max(avoid, using);
    }
}
