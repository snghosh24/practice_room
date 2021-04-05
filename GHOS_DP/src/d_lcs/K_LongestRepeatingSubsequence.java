package d_lcs;

/*
Problem statements: 

one string will be given: "aabgbcaca"

to find longest common subsequence which will be repeating
i.e "abca" is the answer

Solution:
check lcs code and line-I in this code

 */
public class K_LongestRepeatingSubsequence {

	static int max(int a, int b) {
		return (a > b) ? a : b;
	}

	public static int lcs(String x, String y, int m, int n) {

		int DP[][] = new int[m + 1][n + 1];

		for (int i = 0; i <= m; i++) {
			for (int j = 0; j <= n; j++) {
				if (i == 0 || j == 0)
					DP[i][j] = 0;
				else if (x.charAt(i - 1) == y.charAt(j - 1) && i!=j)//line-I change is here
					DP[i][j] = DP[i - 1][j - 1] + 1;
				else
					DP[i][j] = max(DP[i - 1][j], DP[i][j - 1]);
			}
		}
		return DP[m][n];
	}

	public static void main(String[] args) {
		String s1 = "aabgbcaca";
		String s2 = new String(s1);
		int m = s1.length();
		int n = s2.length();

		System.out.println("Longest repeating subsequence length=" + lcs(s1, s2, m, n));
	}
}
