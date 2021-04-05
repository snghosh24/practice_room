package d_lcs;

/*
 Problem statement:
 one string will be given: "agbcba"
 
 minimum number of deletion required to make it palindrome is=1
 
 Solution:
 reverse the string "agbcba" which is "abcbga"
 
 find lcs of these two strings: "abcba"
 
 Min # of deletion=(length of "agbcba" - length of LCS)
 */
public class I_MinNoOfDeletionInStringToMakeItPalindrome {

	static int max(int a, int b) {
		return (a > b) ? a : b;
	}

	public static int lcs(String x, String y, int m, int n) {

		int DP[][] = new int[m + 1][n + 1];

		for (int i = 0; i <= m; i++) {
			for (int j = 0; j <= n; j++) {
				if (i == 0 || j == 0)
					DP[i][j] = 0;
				else if (x.charAt(i - 1) == y.charAt(j - 1))
					DP[i][j] = DP[i - 1][j - 1] + 1;
				else
					DP[i][j] = max(DP[i - 1][j], DP[i][j - 1]);
			}
		}
		return x.length()-DP[m][n];
	}

	public static void main(String[] args) {
		String s1 = "agbcba";
		String s2 = new StringBuilder(s1).reverse().toString();
		int m = s1.length();
		int n = s2.length();

		System.out.println(s1);
		System.out.println(s2);
		System.out.println("Min # of deletion required=" + lcs(s1, s2, m, n));
	}
}
