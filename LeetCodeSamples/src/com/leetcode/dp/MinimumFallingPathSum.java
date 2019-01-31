package com.leetcode.dp;

import java.util.Arrays;

public class MinimumFallingPathSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[][] A =  {{-51,-35,74} , {-62,14,-53} , {94, 61,-10}};
		/*int k = 1;
		for(int i = 0 ; i < 3 ; i++){
			for(int j = 0 ; j < 3 ; j++){
				A[i][j] = k;
				k++;
			}
		}*/
		System.out.println(minFallingPathSum(A));
	}
	public static int minFallingPathSum(int[][] A) {
		  for (int i = 1; i < A.length; ++i)
		    for (int j = 0; j < A.length; ++j){
		    	//System.out.println("A["+ i +"]["+j+"] = Math.min(A[ "+ i-1+"]["+j+"] ,Math.min(A["+i-1+"][Math.max(0 ,"+j-1+")] , A[ " +i-1+"][Math.min("+A.length - 1+" ," +j+1+")]))");
		      A[i][j] += Math.min(A[i - 1][j], Math.min(A[i - 1][Math.max(0, j - 1)], A[i - 1][Math.min(A.length - 1, j + 1)]));
		    }
		  return Arrays.stream(A[A.length - 1]).min().getAsInt();
		} 
	
	
/*    for(int i = 1; i < A.length; i++){
        for(int j = 0; j < A.length; j++){
            
            A[i][j] += Math.max(A[i-1][j] , Math.max(A[i-1][Math.max(0,j-1)] , A[i-1][Math.min(A.length-1 , j+1)]));
        }
    }
    return Arrays.stream(A[A.length -1]).min().getAsInt();*/
	static int findMin(int[][] A){
		
		int len = A.length;
		int[] dp = new int[len];
		int k = 0;
		for(int i = 0; i < len ; i++){
			dp[i] = A[k][i];
		}
		
		for(int j =1; j < len ; j++){
			for(int i = 0; i < len; i++){
				if(i == 0 ){
					dp[i] = Math.min(dp[i]+A[j][i], A[j][i+1]+dp[i]);
				}else if (i == len-1){
					dp[i] = Math.min(dp[i]+A[j][i], A[j][i-1]+dp[i]);
				}else{
					dp[i] = Math.min(dp[i]+A[j][i], Math.min(dp[i] + A[j][i - 1 ], dp[i]+A[j][i+1]));
				}
			}
			
		}
		Arrays.sort(dp);
		return dp[0];
		
	}

}
