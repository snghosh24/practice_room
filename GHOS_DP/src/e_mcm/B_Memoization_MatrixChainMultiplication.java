package e_mcm;

import java.util.Arrays;

//Memoization or Top-Down approach
public class B_Memoization_MatrixChainMultiplication {

	static int[][] DP = new int[100][100];// this size will be depend on constraint

	public static int MatrixChainOrder(int arr[], int i, int j) {

		if (i >= j) {
			return 0;
		}

		if (DP[i][j] != -1) {
			return DP[i][j];
		}

		int result = Integer.MAX_VALUE;

		for (int k = i; k < j; k++) {
			
			int cost = MatrixChainOrder(arr, i, k) + MatrixChainOrder(arr, k + 1, j) + arr[i - 1] * arr[k] * arr[j];

			if (cost < result)
				result = cost;
		}

		return DP[i][j]=result;
	}

	public static void main(String[] args) {
		int arr[] = { 1, 2, 3, 4, 3 };
		int n = arr.length;

		for (int[] row : DP)
			Arrays.fill(row, -1);

		System.out.println("Minimum number of multiplications is: " + MatrixChainOrder(arr, 1, n - 1));

	}
}
