package com.leetcode.dp;

import java.util.Arrays;

public class MaximumLengthOfPairChain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[][] pairs = {{3,4},{2,3},{1,2}};
		System.out.println(findLongestChain1(pairs));
	}
	
public static int findLongestChain(int[][] pairs) {
        
        int len = pairs.length;
        int b = pairs[0][1];
        int count = 1; 
        
        for(int i =1 ; i < len; i++){
            
            if(pairs[i][0] > b){
                count++;
                b = pairs[i][0];
            }
        }
        return count;
    }

public static int findLongestChain1(int[][] pairs) {
	Arrays.sort(pairs, (a, b) -> a[0] - b[0]);
	int N = pairs.length;
	int[] dp = new int[N];
	Arrays.fill(dp, 1);

	for (int j = 1; j < N; ++j) {
		for (int i = 0; i < j; ++i) {
			if (pairs[i][1] < pairs[j][0])
				dp[j] = Math.max(dp[j], dp[i] + 1);
		}
	}

	int ans = 0;
	for (int x: dp) if (x > ans) ans = x;
	return ans;
}

}
