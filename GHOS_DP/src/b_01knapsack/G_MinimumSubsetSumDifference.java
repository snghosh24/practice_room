package b_01knapsack;
/*
 Problem statement: one array will be given i.e int arr[]={1, 2, 7};
 
 To find: minimum difference with the subset sum
 
 s1=1+2+7=9   (s1=sum of the first subset {1,2,7}
 s2=0		  (s2=sum of the second subset{} i.e null subset)
 diff= s1-s2 = 10-0 = 10
 
 s1=2+7=9   (s1=sum of the first subset {2,7}
 s2=1		  (s2=sum of the second subset1{1} i.e null subset)
 diff= s1-s2 = 9-1 = 8
 
 s1=1+7=8   (s1=sum of the first subset {1,7}
 s2=2		  (s2=sum of the second subset1{2} i.e null subset)
 diff= s1-s2 = 8-2 = 6
 
 s1=7   (s1=sum of the first subset {7}
 s2=1+2		  (s2=sum of the second subset1{1,2} i.e null subset)
 diff= s1-s2 = 7-3 = 4 (this is the minimum difference)
 
 Approach:
 s1 & s2 will lie between the range 0 to 10(total sum of the array)
 
    s1-s2=diff
 => range-s2-s2=diff
 => diff= range- 2s2
  
So, we just need to find sum of any subset
   we can get difference by this formula=>  range-2s2 or range-2s1
  

initialize the DP[][] as subset sum problem where the sum will be total sum of the array.
the last row will be set as sub problems where sum will be in the range of 0 to total sum

until the half length of the last row each value with 'true' will define the sum of 1st subset.

get the differences by the formula => range-2*s1 and identify the minimum one.
 */
public class G_MinimumSubsetSumDifference {
	
	public static int subsetSumDifference(int arr[], int sum,int n) {
		
		boolean[] lastRow=getLatRow(arr, sum, n);
		
		int min_diff=Integer.MAX_VALUE;
		for(int i=0;i<=lastRow.length/2;i++) {
			if(lastRow[i]==true) {
				min_diff=sum-2*i;
			}
		}
		
		return min_diff;
	}

	public static boolean[] getLatRow(int arr[], int sum, int n) {

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
		
		boolean lastRow[]=new boolean[sum];
		
		for(int i=0;i<sum;i++) {
			lastRow[i]=DP[n][i];
		}
		
		return lastRow;
	}

	public static void main(String[] args) {

		int arr[] = { 1, 2, 7};
		int n = arr.length;
		int sum = 0;
		for (int i = 0; i < n; i++) {
			sum = sum + arr[i];

		}

		System.out.println("sum=" + sum);
		System.out.println("Minimum subset sum diff="+subsetSumDifference(arr, sum, n));
	}

}

/*
sum=10
true false false false false false false false false false false
true true  false false false false false false false false false 
true true  true  true  false false false false false false false 
true true  true  true  false false false true  true  true  true 

range-2*s1=10-2*0=10     for i=0
range-2*s1=10-2*1=8      for i=1
range-2*s1=10-2*2=6      for i=2
range-2*s1=10-2*3=4      for i=3

Minimum subset sum diff=4
*/
