package b_01knapsack;

import java.util.Arrays;

//Memoization or Top-down approach
public class Memoization_01Knapsack {
	
	static int DP[][];
	
	static int max(int a, int b) {
		return (a > b) ? a : b;
	}

	public static int knapsack(int w[], int val[], int W, int n) {

		if (n == 0 || W == 0) {
			return 0;
		}
		
		 if (DP[n][W] != -1)
		        return DP[n][W];

		if (w[n - 1] <= W) {
			return DP[n][W]= max(val[n - 1] + knapsack(w, val, W - w[n - 1], n - 1), knapsack(w, val, W, n - 1));
		} else {
			return DP[n][W]=knapsack(w, val, W, n - 1);
		}
	}

	public static void main(String[] args) {

		int w[]   = { 2, 4, 2, 5, 1 };
		int val[] = { 5, 3, 4, 2, 7 };
		int W = 7;
		int n = val.length;

		DP=new int[n+1][W+1];
		for(int i = 0; i < n + 1; i++)   
	        for(int j = 0; j < W + 1; j++)   
	            DP[i][j] = -1;  
		System.out.println("Max profit=" + knapsack(w, val, W, n));
	}

}

/*
output:
Max profit=16

Time complexity:O(n*W).
Auxiliary Space complexity: O(n*W).
*/
