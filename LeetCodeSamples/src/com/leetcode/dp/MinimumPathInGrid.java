package com.leetcode.dp;

public class MinimumPathInGrid {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] grid = {{1,3,1},{1,5,1}, {4,2,1}};
		System.out.println(minPathSum(grid));
	}
	
	public static int minPath(int[][] grid, int x, int y){
		
		if(x >= grid.length && y >= grid[0].length){
			return 0;
		}
		if(x == grid.length -1 && y < grid[0].length){
			return grid[x][y];
		}
		
		if(x < grid.length && y == grid[0].length -1){
			return grid[x][y];
		}
		
		int down = minPath(grid, x+1, y);
		int right = minPath(grid, x, y+1);
		
		
		return right > down ? down+grid[x][y] : right + grid[x][y];
	}
	
	public static int minPathSum(int[][] grid){
		int rows = grid.length;
		int cols = grid[0].length;
		
		for(int i = rows - 2 ; i >= 0; --i){
			
			grid[i][cols-1] +=  grid[i+1][cols -1];
		}
		for(int j = cols -2 ; j >= 0 ; --j ){
			grid[rows -1][j] += grid[rows -1 ][j + 1];
		}
		
		for(int i = rows-2 ; i >= 0; i--){
			for(int j = cols-2 ; j >=0 ; j--){
				int right = grid[i+1][j];
				int down = grid[i][j+1];
				grid[i][j] += (right < down) ? right : down ;
			}
		}
		return grid[0][0];
	}
	
    public int minPathSum1(int[][] grid) {
        
        int rows = grid.length;
        int cols = grid[0].length;
        
        for(int i = rows -2 ; i >= 0 ; i--){
            
            grid[i][cols-2 ] += grid[i+1][cols-2];
        }
        for(int j = cols -2 ; j >= 0 ; j--){
            grid[rows-2][j] += grid[rows -2 ][j+1] ;
        }
        
        for(int i = rows -2 ; i >= 0 ; i--){
            for(int j = cols -2 ; j >= 0 ; j--){
                
                int right = grid[i+1][j];
                int down = grid[i][j+1];
                grid[i][j] += (right > down) ? down : right ;
            }
        }
        return grid[0][0];
    }
}
