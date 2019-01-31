package com.leetcode.dp;

import java.util.Arrays;

public class UniquePathsMatrix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[][] grid = {{0,0,0},{0,1,0},{0,0,0}};
		System.out.println(uniquePathsWithObstacles(grid));
	}
	
	public static int uniquePathsWithObstacles(int[][] grid) {
     
		int m = grid.length;
		int n = grid[0].length;
		int[][] dp = new int[m][n];
		
		Arrays.fill(dp[0], 1);
		
		
		for(int i = 1 ; i < m ; i++){
			Arrays.fill(dp[i], 1);
		
			for(int j = 1; j < n ; j++){
				
				if(grid[i][j] != 1){
					
					dp[i][j] = dp[i-1][j]+dp[i][j-1];
				}else{
					dp[i][j] = 0; 
				}
			}
		}
	return dp[m-1][n-1];
    }

}
