package b_01knapsack;

public class A_Recursive_01Knapsack {

	static int max(int a, int b) {
		return (a > b) ? a : b;
	}

	public static int knapsack(int w[], int val[], int W, int n) {

		if (n == 0 || W == 0) {
			return 0;
		}

		if (w[n - 1] <= W) {
			return max(val[n - 1] + knapsack(w, val, W - w[n - 1], n - 1), knapsack(w, val, W, n - 1));
		} else {
			return knapsack(w, val, W, n - 1);
		}
	}

	public static void main(String[] args) {

		int w[] = { 2, 4, 2, 5, 1 };
		int val[] = { 5, 3, 4, 2, 7 };
		int W = 7;
		int n = val.length;
		
		System.out.println("Max profit="+knapsack(w, val, W, n));
	}

}

/*
output:
Max profit=16

Time complexity:O(2^n).
Auxiliary Space complexity: O(1). 
*/