package c_unbounded_knapsack;
/*
 Problem statement:
 length array will be given. i.e int[] l={1,2,3,4}
 price array will be given .ie int[] price={2,1,4,3}
 total length to cut from the rod will be given L=5
 
 To cut the pieces from the rod such a way so, we can get Maximum price
 
 
 */
public class D_RodCuttingProblem {
	
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
					//DP[i][j] = max(val[i - 1] + DP[i-1][j - w[i - 1]], DP[i - 1][j]);
					DP[i][j] = max(val[i - 1] + DP[i][j - w[i - 1]], DP[i - 1][j]);
				} else {
					DP[i][j] = DP[i - 1][j];
				}
			}
		}

		return DP[n][W];

	}

	public static void main(String[] args) {

		int[] l=    {1,2,3,4};
		int[] price={2,1,8,4};
		int L = 5;
		int n = l.length;

		System.out.println("Max profit=" + knapsack(l, price, L, n));
	}

}

/*
input:
int[] l=    {1,2,3,4};
int[] price={2,1,8,4};
int L = 5;

output:
Max profit=12
*/