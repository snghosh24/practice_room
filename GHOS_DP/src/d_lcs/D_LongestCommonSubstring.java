package d_lcs;

public class D_LongestCommonSubstring {

	public static int lcs(String x, String y, int m, int n) {

		int DP[][] = new int[m + 1][n + 1];

		int result = 0;
		for (int i = 0; i <= m; i++) {
			for (int j = 0; j <= n; j++) {
				if (i == 0 || j == 0)
					DP[i][j] = 0;
				else if (x.charAt(i - 1) == y.charAt(j - 1)) {
					DP[i][j] = DP[i - 1][j - 1] + 1;
				    result = Integer.max(result,
                        DP[i][j]);
				}
				else
					DP[i][j] =0;
			}
		}
		return result;
	}

	public static void main(String[] args) {
		String s1 = "abcdxyz";
		String s2 = "xyzabcd";
		int m = s1.length();
		int n = s2.length();

		System.out.println("Longest commom substring length=" + lcs(s1, s2, m, n));
	}
}
