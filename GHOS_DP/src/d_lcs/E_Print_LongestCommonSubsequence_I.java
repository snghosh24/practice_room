package d_lcs;

public class E_Print_LongestCommonSubsequence_I {

	static String max(String a, String b) {
		return (a.length() > b.length()) ? a : b;
	}

	public static String lcs(String x, String y, int m, int n) {

		String DP[][] = new String[m + 1][n + 1];

		for (int i = 0; i <= m; i++) {
			for (int j = 0; j <= n; j++) {
				if (i == 0 || j == 0)
					DP[i][j] = "";
				else if (x.charAt(i - 1) == y.charAt(j - 1))
					DP[i][j] = DP[i - 1][j - 1]+x.charAt(i-1);
				else
					DP[i][j] = max(DP[i - 1][j], DP[i][j - 1]);
				
				System.out.print(DP[i][j]+" ");
			}
			System.out.println();
		}
		return DP[m][n];
	}

	public static void main(String[] args) {
		String s1 = "abcxyz";
		String s2 = "acxmnoz";
		int m = s1.length();
		int n = s2.length();

		System.out.println("Longest commom subsequence=" + lcs(s1, s2, m, n));
	}
}
