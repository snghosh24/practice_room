package b_01knapsack;
/*

 Number of different ways to assighn the sign(+/-) to the each element of the given array
 so that the sum will be same as given sum.
 
 the given array is int[] arr={1,1,2,3};
 sum=1;
 
 we can assign the sign in below ways
 
  +1 +1 +2 -3=1
  +1 -1 -2 +3=1
  -1 +1 -2 +3=1

nNumber of ways to get sum '1'=3

 So, the problem is reduced form of count of subsets sum with given diff
 */
public class I_TargetSum {

	
	public static int targetSum(int arr[], int sum, int n) {

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
		int sum = 1;
		int n = arr.length;
		
		int total_sum=0;
		for(int i=0;i<n;i++) {
			total_sum=total_sum+arr[i];
		}
		
		int sumOfSubset=(sum+total_sum)/2;

		System.out.println("Number of ways to get sum '" +sum+ "'=" + targetSum(arr, sumOfSubset, n));
	}

}

/*
input:
arr[]={ 1,1,2,3 } 
sum=1

output: 
Number of ways to get sum '1'=3
*/
