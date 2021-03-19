package b_01knapsack;
/*
 Problem statement:
 input:
 there is a given array arr[]={1,2,3,4};
 and a sum=10;
 
 output:
 to find that if any of the subset of the given array is sum upto the given sum i.e 10;
 o/p: true/false
 
 Similarities to knapsack:
 arr[] is equivalend to w[];
 sum is equivalent to W
 
 for a valid target sum with 0 elements in the array is not possible
 So, the first row of the matrix DP[][] will be 'false' i.e if i==0 DP[i][j]=false
 
 for a target sum which is 0 with valid number of elements inside the array is always possible
 as null subset is always sum upto 0.
 So, the first column of the matrix DP[][] will be 'true' i.e if j==0 DP[i][j]=false
 
 */
public class D_SubsetSumProblem {

	public static boolean subsetSum(int arr[], int sum, int n) {

		boolean DP[][] = new boolean[n + 1][sum + 1];

		for (int i = 0; i <= n; i++) {

			for (int j = 0; j <= sum; j++) {

				if (i == 0) {
					DP[i][j] = false;
				}

				if (j == 0) {
					DP[i][j] = true;
				}
			}
		}

		for (int i = 1; i <= n; i++) {

			for (int j = 1; j <= sum; j++) {

				if (arr[i - 1] <= j) {

					DP[i][j] = DP[i - 1][j - arr[i - 1]] || DP[i - 1][j];
				} else {

					DP[i][j] = DP[i - 1][j];
				}
			}
		}
		return DP[n][sum];
	}

	public static void main(String[] args) {

		int arr[] = { 1, 2, 3, 4 };
		int sum = 9;
		int n = arr.length;

		System.out.println("Subset Sum possible? :" + subsetSum(arr, sum, n));
	}
}
/*
input=1/2/3/4/5/6/7/8/9/10
output=true

input=11/12/13....
output=false
*/