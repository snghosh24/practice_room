package b_01knapsack;

//Bottom-up approach
public class C_Tabulation_01Knapsack {

	static int max(int a, int b) {
		return (a > b) ? a : b;
	}

	public static int knapsack(int w[], int val[], int W, int n) {

		int DP[][] = new int[n + 1][W + 1];

		for (int i = 0; i <= n; i++) {

			for (int j = 0; j <= W; j++) {

				if (i == 0 || j == 0) {
					DP[i][j] = 0;
				}

				else if (w[i - 1] <= j) {
					DP[i][j] = max(val[i - 1] + DP[i - 1][j - w[i - 1]], DP[i - 1][j]);
				} else {
					DP[i][j] = DP[i - 1][j];
				}
			}
		}

		return DP[n][W];

	}

	public static void main(String[] args) {

		int w[] = { 2, 4, 2, 5, 1 };
		int val[] = { 5, 3, 4, 2, 7 };
		int W = 7;
		int n = val.length;

		System.out.println("Max profit=" + knapsack(w, val, W, n));
	}

}
/*
output:
Max profit=16

Time Complexity: O(N*W)
Auxiliary Space: O(N*W). 
*/