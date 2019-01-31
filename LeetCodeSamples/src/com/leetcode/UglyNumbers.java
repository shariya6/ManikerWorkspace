package com.leetcode;

public class UglyNumbers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(getNthUglyNo(150));
	}
	
	static int getNthUglyNo(int n){
		
		int i = 1;
		int count = 1;
		
		while(n > count){
			i++;
			if(isUgly(i) == 1){
				count++;
			}
		}
		
		return i;
	}
	
	static int isUgly(int n){
		
		n = maxDivide(n, 2);
		n = maxDivide(n, 3);
		n = maxDivide(n, 5);
		return (n == 1) ? 1 : 0;
	}
	
	static int maxDivide(int a, int b){
		
		while(a % b == 0){
			a = a/b;
		}
		return a;
	}

}
