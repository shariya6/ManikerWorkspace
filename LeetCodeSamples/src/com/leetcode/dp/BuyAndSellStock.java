package com.leetcode.dp;

public class BuyAndSellStock {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] prices = {1, 3, 2, 8, 4, 9};
		System.out.println(stockWithFees(prices , 2));
	}
	
	static int profit(int[] prices){
		
		int curr = 0;
		int total = 0;
		
		for(int i = 1; i < prices.length; i++){
			 curr = Math.max(0, curr+prices[i] - prices[i-1]);
			 total = Math.max(curr, total);
		}
		return total;
	}

	static int maxProfit(int[] prices){
		
		int max = 0; 
		//int result = 0;
		for(int i = 1 ; i < prices.length; i++){
			
			int result = prices[i] - prices[i -1];
			if(result > 0){
				max += result ;
			}
		}
		return max ;
	}
	
	static int profitWithCooling(int[] prices){
		int n = prices.length;
		if(n == 0 ){
			return 0;
		}
		int s0 = 0 , s1 = 0 , s2 = 0;
		int s0p = 0 , s1p = -prices[0] , s2p = 0;
		
		for(int p : prices){
			s0 = Math.max(s0p, s2p);
			s1 = Math.max(s1p , s0p - p);
			s2 = Math.max(s1p+p, s2p);
			s0p = s0;
			s1p = s1;
			s2p = s2;
		}
		
		return Math.max(s0, s2);
	}
	
	static int stockWithFees(int[] prices , int fee){
		
		int sell = 0;
		int buy = 0/*-prices[0]*/;
		int max = 0;
		
		for(int i = 1 ; i < prices.length; i++){
			
			sell = Math.max(sell, (prices[i] + buy - fee));
			buy = Math.max(sell - prices[i] , buy);
			max = Math.max(sell, max);
		}
		return max ; 
	}
}
