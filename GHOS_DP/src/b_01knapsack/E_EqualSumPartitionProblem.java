package b_01knapsack;
/*
 Problem statement: 
 
 an array will be given i.e {1,2,3,4}
 
 if we partition the given array into 2 sub arrays, is there any chance that 2 sub arrays 
 will have equal/same sum?
 
 output=T/F
 
 How to reduce the problem:
 If there is a possibility to get 2 sub arrays with equal sum
 then the total sum of the given array shoud always be even.
 
 if the total sum of the given array is odd i.e 21
 then it's not possible to have sub arrays with equal sum.
 
 So, if the total sum==odd then return false.
 
 Next we need to find if there is at least one sub array with sum=total-sum/2
 then there must be another sub array with sum=total-sum/2
 
 For example:
 {1,2,3,4} sum=10
 
 so there is a possibility of equal sum partition as the total sum is even i.e 10.
 now we need to find a subset which will have the sum 5.
 
 if found the other sub set will must have the same sum 5.
 
 So, It is nothing but subset Sum problem with different requirements
 */

public class E_EqualSumPartitionProblem {
	
	public static boolean equalSumPartition(int arr[]) {
		
		int sum=0;
		int n=arr.length;

		for(int i=0;i<n ;i++) {
			sum=sum+arr[i];
		}
		
		if(sum%2==1) {
			return false;
		}
		else {
			return subsetSum(arr, sum/2, n);
		}
		
	}

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

		int arr[] = { 1, 5, 11, 5 , 2};

		System.out.println("Equal Sum Partition possible? :" + equalSumPartition(arr));
	}

}
/*
 input:{ 1, 5, 11, 5}
 output: true
 
 input:{ 1, 5, 11, 5 ,4}
 output: false
 
*/
