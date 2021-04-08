package e_mcm;

import java.util.Arrays;

public class N_Memoization_EggDroppingProblem_Optimized {

	static int[][] DP;

	public static int eggDrop(int e, int f) {

		if (f == 1 || f == 0)
			return f;

		// We need k trials for one egg
		// and k floors
		if (e == 1)
			return f;

		if (DP[e][f] != -1) {
			return DP[e][f];
		}

		int min = Integer.MAX_VALUE;
		int temp;

		// Consider all droppings from
		// 1st floor to kth floor and
		// return the minimum of these
		// values plus 1.
		for (int i = 1; i <= f; i++) {
			
			int low,high;
			if(DP[e-1][i-1]!=-1) {
			    low=DP[e-1][i-1];
			}
			else {
				low=eggDrop(e-1, i-1);
			}
			if(DP[e][f-i]!=-1) {
			    high=DP[e][f-i];
			}
			else {
				high=eggDrop(e, f-i);
			}
			temp = Math.max(low,high);
			
			if (temp < min)
				min = temp;
		}

		return DP[e][f] = min + 1;
	}

	public static void main(String[] args) {
		int e = 20, f = 2000;

		DP = new int[e + 1][f + 1];
		for (int[] row : DP)
			Arrays.fill(row, -1);
		System.out.print("Minimum number of " + "trials in worst case with " + e + " eggs and " + f + " floors is ="
				+ eggDrop(e, f));
	}
}
