package com.leetcode;


public class ClimbingStairs {

	

	// Java program to count number of ways to reach n't stair when 
	// a person can climb 1, 2, ..m stairs at a time 

	
	static int[] countBits(int num){
		
		int[] result = new int[num+1];
		
		for(int i = 0 ; i <= num; i++){
			result[i] = countEach(i);
			System.out.print(result[i]+" ");
		}
		return result;
	}
	
	static int countEach(int num){
		
		int result = 0;
		while(num != 0 ){
			if(num%2  == 1){
				result++;
			}
			num = num/2 ;
		}
		return result;
	}
	
	
	
	    // A recursive function used by countWays 
	    static int countWaysUtil(int n, int m) 
	    { 
	        int res[] = new int[n]; 
	        res[0] = 1; res[1] = 1; 
	        for (int i=2; i<n; i++) 
	        { 
	           res[i] = 0; 
	           for (int j=1; j<=m && j<=i; j++) 
	             res[i] += res[i-j]; 
	        } 
	        return res[n-1]; 
	    } 
	       
	    // Returns number of ways to reach s'th stair 
	    static int countWays(int s, int m) 
	    { 
	        return countWaysUtil(s+1, m); 
	    } 
	  
	    // Driver method   
	    public static void main(String[] args) 
	    { 
	        int s = 4, m = 2; 
	        //System.out.println("Nuber of ways = " + fib(9));
	        
	        int[] arr = {3,2,10,4};
	        int[] arr1 = {-2,1};
	       // System.out.println("Result : "+degreeArray(arr1));
	        int count = 1;
	        count += 1 & 5;
	       // System.out.println(count);
	        System.out.println(stoneGame2(arr));
	    } 
	    
	    public static boolean stoneGame1(int[] piles) {
	        int N = piles.length;

	        // dp[i+1][j+1] = the value of the game [piles[i], ..., piles[j]].
	        int[][] dp = new int[N+2][N+2];
	        for (int size = 1; size <= N; ++size)
	            for (int i = 0; i + size <= N; ++i) {
	            	System.out.println("i : " + i);
	                int j = i + size - 1;
	                int parity = (j + i + N) % 2;  // j - i - N; but +x = -x (mod 2)
	                if (parity == 1)
	                    dp[i+1][j+1] = Math.max(piles[i] + dp[i+2][j+1], piles[j] + dp[i+1][j]);
	                else
	                    dp[i+1][j+1] = Math.min(-piles[i] + dp[i+2][j+1], -piles[j] + dp[i+1][j]);
	            }

	        return dp[1][N] > 0;
	    }
	    
	    static boolean stoneGame2(int[] piles){
	    	
	    	int n = piles.length;
	    	int[][] dp = new int[n][n];
	    	for(int i = 0 ; i < n ; ++i){
	    		System.out.println("i :" + i);
	    		dp[i][i] = piles[i];
	    	}
	    	for(int l = 2; l <= n ; ++l){
	    		System.out.println("l : " + l);
	    		for(int i = 0; i < n-l+1; ++i){
	    			System.out.println("I : " + i);
	    			int j = i +l -1;
	    			System.out.println("j : " +j);
	    			dp[i][j] = Math.max(piles[i] - dp[i+1][j], piles[j] - dp[i][j-1]);
	    			System.out.println("dp[" +i+"]["+j+"] = Math.max( " +piles[i] + " - " +dp[i+1][j] + " , " +piles[j] + " - " +dp[i][j-1]+" )" );
 	    			System.out.println("dp[" +i+"]["+j+"] = " +Math.max(piles[i] - dp[i+1][j], piles[j] - dp[i][j-1]) );
	    		}
	    	}
	    	System.out.println("result : " +dp[0][n-1]);
	    	return dp[0][n-1] > 0;
	    }
	    
	    public static boolean stoneGame(int[] piles) {
	        
	        int result[] = new int[piles.length+1];
	        int i = 0; int j = piles.length -1 ;
	        result[0] = 0;
	        int k = 1;
	        
	        while(i <= j && k <= piles.length && i < piles.length && j >= 0){
	            
	            if(piles[i] > piles[j]){
	                if(k == 1){
	                    result[k] = piles[i];
	                }else{
	                     result[k] = result[k-2] + piles[i];
	                }
	                i++;
	            }else{
	                if(k == 1){
	                    result[k] = piles[j];
	                }else{
	                    result[k] = result[k-2] + piles[j];
	                }
	                
	                j--;
	            }
	            k++;
	        }
	        return result[piles.length] < result[piles.length - 1] ? true : false;
	    }
	    static int fib(int n){
	    	
	    	if(n == 1 ){
	    		return 1;
	    	}
	    	if(n == 0){
	    		return 0;
	    	}
	    	return fib(n-1)+fib(n-2);
	    }
	    
	    public static int maxSubArray(int[] nums) {
	        
	        int maxEndH = 0;
	        int maxTillNow = Integer.MIN_VALUE;
	        
	        for(int i = 0 ; i < nums.length; i++){
	            
	            if(maxEndH > maxTillNow){
	                maxTillNow = maxEndH;
	            }
	            if(maxEndH > maxEndH + nums[i]){
	                maxEndH = 0;
	            }else{
	                maxEndH  = maxEndH + nums[i];
	            }
	          }
	        
	        if(maxEndH > maxTillNow ){
	            maxTillNow = maxEndH;
	        }
	        return maxTillNow;
	    }
	    
	    
	    static int maxSumArray(int[] arr){
	    	
	    	int[] solution = new int[arr.length+1];
	    	solution[0] = arr[0];
	    	int result = solution[0];
	    	for(int i = 1; i < arr.length; i++){
	    		solution[i] = Math.max(solution[i-1]+arr[i] , arr[i]);
	    		if(solution[i] > result){
	    			result = solution[i];
	    		}
	    	}

	    	return result;
	    }
	    
	    
	    static int degreeArray(int[] arr){
	    	
	    	int[][] res = new int[2][3];
	    	
	    	return res[0][0];
	    	
	    }
	                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              
	    
/*	    public static  int maxSubArray(int[] nums) {
	        
	        int maxEndH = 0;
	        int maxTillNow = 0;
	        
	        for(int i = 0 ; i < nums.length ; i++){
	            maxEndH = maxEndH + nums[i];
	            if(maxEndH < 0){
	                maxEndH = 0;
	            }
	            else if(maxEndH > maxTillNow){
	                maxTillNow = maxEndH;
	            }
	        }
	        return maxTillNow;
	    }*/
	}

