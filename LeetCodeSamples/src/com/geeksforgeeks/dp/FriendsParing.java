package com.geeksforgeeks.dp;

public class FriendsParing {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(pairFriends(4));
	}
	
	static int pairFriends(int n){
	
		int[] dp = new int[n+1];
		dp[0] = 0;
		dp[1] = 1;
		
		if(n == 1){
			return 1; 
		}
		
		for(int i = 2; i <= n ;i++){
			
			dp[i] = dp[i-1]+ i-1;
		}
		
		return dp[n] ;
	}

}
