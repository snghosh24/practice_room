package b_01knapsack;
/*
 Problem statement: one array will be given i.e int[] arr={1,1,2,3};
 diff=1;
 
 find the subsets sum whose difference will be 1;
 
 {1,1,2} & {3}       index 0,1,2 & index 3
 {1,2} & {1,3}       index 0,2 & index 1,3
 {1,2} & {1,3}       index 1,2 & index 0,3
 
 count of subsets sum=3
 
 Approach:
 suppose the sums of 2 subsets are s1 & s2.
 
     s1+s2=total_sum
 (+) s1-s2=diff
 =================
 	2*s1=diff+total_sum
 =>   s1=(diff+total_sum)/2;
 
 So, the problem reduces to the problem of count of subset sum with given sum s1.
 */

public class H_CountOfSubsetsSum_WithGivenDifference {

	public static int countOfSubsetSumWithGivenDiff(int arr[], int sum, int n) {

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

					DP[i][j] = DP[i - 1][j - arr[i - 1]] + DP[i - 1][j];
				} else {

					DP[i][j] = DP[i - 1][j];
				}
			}
		}
		return DP[n][sum];
	}

	public static void main(String[] args) {

		int arr[] = { 1,1,2,3 };
		int diff = 1;
		int n = arr.length;
		
		int total_sum=0;
		for(int i=0;i<n;i++) {
			total_sum=total_sum+arr[i];
		}
		
		int sum=(diff+total_sum)/2;

		System.out.println("Count of Subset Sum with diff '" +diff+ "'=" + countOfSubsetSumWithGivenDiff(arr, sum, n));
	}

}

/*
 input:
 arr[]={ 1,1,2,3 } 
 diff=1
 
 output: 
 Count of Subset Sum with diff '1'=3 
*/