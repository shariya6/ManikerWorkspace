package com.leetcode.dp;

public class TwoKeysKeyboard {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
System.out.println(minimumSteps(4));
		
	}
	
	static int minimumSteps(int n){
		
		if(n == 1){
			return 0;
		}
		if(n == 2){
			return 2;
		}
		if(n % 2 == 0){
			return (n/2)+2;
		}
		if(n % 3 == 0){
			return (n/3)+3;
		}
		if(n % 5 == 0){
			return (n/5)+5;
		}
		
		return n;
		
	}

}
