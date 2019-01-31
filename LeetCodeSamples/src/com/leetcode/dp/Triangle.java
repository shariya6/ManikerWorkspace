package com.leetcode.dp;

import java.util.ArrayList;
import java.util.List;

public class Triangle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<List<Integer>> triangle = asList(
                asList(2),
                asList(3,4),
                asList(6,5,7),
                asList(4,1,8,3)
              );
		
		System.out.println(minimumTotal(triangle));
	}
	
	 public static <T> List<T> asList(T ... items) {
	        List<T> list = new ArrayList<T>();
	        for (T item : items) {
	            list.add(item);
	        }
	        return list;
	    }

	 public static int minimumTotal(List<List<Integer>> triangle) {
	 
		 int len = triangle.size();
		 
		 for(int i = len - 2; i >= 0 ; i-- ){
			 List<Integer> data = triangle.get(i);
			 for (int j = data.size()-1; j >= 0 ; j--){
				 
				 data.set(j, data.get(j)+Math.min((triangle.get(i+1).get(j+1)) ,(triangle.get(i+1).get(j))));
			}
			 triangle.set(i, data);
		 }
		 
		 return triangle.get(0).get(0); 
		          
	 }
}
