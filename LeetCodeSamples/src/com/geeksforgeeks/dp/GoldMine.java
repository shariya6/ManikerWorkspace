package com.geeksforgeeks.dp;

public class GoldMine {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	static int getMaxGold(int[][] gold){
		
		
		int row = gold.length;
		int col = gold[0].length;
		int[][] dp = new int[row][col];
		
		for(int i = col -1 ; i >= 0; i--){
			
			for(int j = 0; j < row  ; j++){
			
				int right = (i == col-1) ? 0 : dp[j][i+1];
				int rightup = (j == 0 || i == col-1) ? 0 : dp[j-1][i+1];
				int rightdown = (j == row -1) ? 0 : dp[j+1][i+1]; 
			}
		}
		
		return row;
	}
}
