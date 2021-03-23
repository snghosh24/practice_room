package c_unbounded_knapsack;
/*
 given an array representing the piles of coin with given values
 coin[]={1,2,3,4}
 Sum=6
 
 To find the maximum no. of ways to get sum of 6 by adding the coins from the pile
 */
public class E_CoinChange_MaxNumberOfWays {
	
	public static int findMaxNumberOfWays(int arr[], int sum, int n) {

		int DP[][] = new int[n + 1][sum + 1];

		for (int i = 0; i <= n; i++) {

			for (int j = 0; j <= sum; j++) {

				if (i == 0) {
					DP[i][j] = 0;
				}

				if (j == 0) {
					DP[i][j] = 1;
				}
			}
		}

		for (int i = 1; i <= n; i++) {

			for (int j = 1; j <= sum; j++) {

				if (arr[i - 1] <= j) {
					//DP[i][j] = DP[i - 1][j - arr[i - 1]] + DP[i - 1][j];
					DP[i][j] = DP[i][j - arr[i - 1]] + DP[i - 1][j];
				} else {

					DP[i][j] = DP[i - 1][j];
				}
			}
		}
		return DP[n][sum];
	}

	public static void main(String[] args) {

		int coins[] = {1,2,3,4};
		int sum = 6;
		int n = coins.length;

		System.out.println("Max no. of ways to get sum of '"+sum+"'  :" + findMaxNumberOfWays(coins, sum, n));
	}

}
/*
 input:
 int coins[] = {1,2,3,4};
 int sum = 6;
 int n = coins.length;
 
 output:
 Max no. of ways to get sum of '6'  :9
 */
