package b_01knapsack;
/*
Problem statement: 
an array will be given i.e arr[]={2,3,5,6,8,10};
a sum will be given. sum=10

How many subset of the given array is possible with the given sum.

Initialization of DP[][]:
for a valid target sum with 0 elements in the array is not possible
So, the count will be 0 if i==0 i.e for the first row of the matrix.

for a target sum which is 0 with valid number of elements inside the array is always possible
as null subset is always sum upto 0. i.e the count will be 1 if j==0

OR operation will be replace with + operator as the return type is int.
*/
public class F_CountOfSubsetsSum_WithGivenSum {
	

	
	public static int countOfSubsetSum(int arr[], int sum, int n) {

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

		int arr[] = { 2,3,5,6,8,10};
		int sum = 12;
		int n = arr.length;

		System.out.println("Count of Subset Sum :" + countOfSubsetSum(arr, sum, n));
	}

}
/*
input:{ 2,3,5,6,8,10}
sum=10
output:3

input:{ 2,3,5,6,8,10}
sum=12
output:1
*/