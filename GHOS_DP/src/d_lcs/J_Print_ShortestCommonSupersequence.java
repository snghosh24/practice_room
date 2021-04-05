package d_lcs;
/*
Problem statuement:
two strings will be given
a: "aggtab"
b: "gxtxayb"

shortest common supper sequence will be: "aggxtxayb"
"aggxtxayb" has the string "aggtab" in order
"aggxtxayb" has the string "gxtxayb" in order

Solution:
find the lcs of two given strings "aggtab" & "gxtxayb" which is: "gtab"

follow Print LCS with 
*/

public class J_Print_ShortestCommonSupersequence {

	static int max(int a, int b) {
		return (a > b) ? a : b;
	}

	public static String lcs(String x, String y, int m, int n) {

		int DP[][] = new int[m + 1][n + 1];

		for (int i = 0; i <= m; i++) {
			for (int j = 0; j <= n; j++) {
				if (i == 0 || j == 0)
					DP[i][j] = 0;
				else if (x.charAt(i - 1) == y.charAt(j - 1))
					DP[i][j] = DP[i - 1][j - 1] + 1;
				else
					DP[i][j] = max(DP[i - 1][j], DP[i][j - 1]);

				System.out.print(DP[i][j] + " ");
			}
			System.out.println();
		}

		// Print subsequence
		int i = m;
		int j = n;
		String result = "";
		while (i > 0 && j > 0) {
			if (x.charAt(i - 1) == y.charAt(j - 1)) {
				result = result + x.charAt(i - 1);
				i--;
				j--;
			} else {
				if (DP[i][j - 1] >= DP[i - 1][j]) {
					result = result + y.charAt(j-1);
					j--;
				} else {
					result = result + x.charAt(i-1);
					i--;
				}
			}
		}
		
		//added
		while(i>0) {
			result = result + x.charAt(i-1);
			i--;
		}
		while(j>0) {
			result = result + x.charAt(j-1);
			j--;
		}

		StringBuilder sb = new StringBuilder();
		sb.append(result);
		return sb.reverse().toString();
	}

	public static void main(String[] args) {
		String s1 = "aggtab";
		String s2 = "gxtxayb";
		int m = s1.length();
		int n = s2.length();

		System.out.println("Shortest commom super sequence= " + lcs(s1, s2, m, n));
	}
}
