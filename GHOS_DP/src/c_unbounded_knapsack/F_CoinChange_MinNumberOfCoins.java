package c_unbounded_knapsack;
/*
 Problem statement:
 one array will be given i.e int coins[]={ 1, 2, 3, 4 };
 sum = 10;
 
 To find the minimum number of coins to get a sum value of 10.
 
 Initialization:
 to get a valid sum with 0 number of coins: it needs infinite number of coins
 So, if i=0 and j=valid sum the row is initialized with INTEGER.MAX_VALUE-1.
 
  to get a valid sum of 0 with n number of coins: it needs 0 number of coins
 So, if j=0 and i=valid number of coins the column is initialized with '0'.
 
 the second row is initialized also
 in case the sum required which is not possible with given 1 coin then it will return INTEGER.MAX_VALUE-1.
 and if sum required which is possible with given 1 coin then it will return number of coins=sum/coin_value.
 
 */
public class F_CoinChange_MinNumberOfCoins {

	static int min(int a, int b) {
		return (a < b) ? a : b;
	}

	public static int findMinNumberOfCoins(int arr[], int sum, int n) {

		int DP[][] = new int[n + 1][sum + 1];

		for (int i = 0; i <= n; i++) {

			for (int j = 0; j <= sum; j++) {

				if (i == 0) {
					DP[i][j] = Integer.MAX_VALUE - 1; 			  //Initialization of first row
				}


				if (i == 1) {
					if (j == 0) {
						DP[i][j] = 0;    						  //Initialization of first column
					}
					
					if (j % arr[0] == 0) {                        //Initialization of second row
						DP[i][j] = j / arr[0];
					} else {
						DP[i][j] = Integer.MAX_VALUE - 1;
					}
				}
			}
		}


		for (int i = 1; i <= n; i++) {

			for (int j = 1; j <= sum; j++) {

				if (arr[i - 1] <= j) {
					// DP[i][j] = DP[i - 1][j - arr[i - 1]] + DP[i - 1][j];
					DP[i][j] = min(1 + DP[i][j - arr[i - 1]], DP[i - 1][j]);  // As here 1 is added if the coin is picked
																			  // and INTEGER.MAX_VALUE+1 will produce the negative number
																			  // So, INTEGER.MAX_VALUE-1 was given at the time of initialization
				} else {

					DP[i][j] = DP[i - 1][j];
				}
			}
		}

		/*for (int i = 0; i <= n; i++) {

			for (int j = 0; j <= sum; j++) {
				System.out.print(DP[i][j] + " ");
			}
			System.out.println();
		}*/

		return DP[n][sum];
	}

	public static void main(String[] args) {

		int coins[] = { 2, 3, 4 };
		int sum = 10;
		int n = coins.length;

		System.out.println("Min no. of coins to get sum of '" + sum + "'  :" + findMinNumberOfCoins(coins, sum, n));
	}

}
/*
 input:
 int coins[] = { 2, 3, 4 };
 int sum = 10;
 
 output:
 Min no. of coins to get sum of '10'  :3
 
 */
