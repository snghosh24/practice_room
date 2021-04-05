package d_lcs;

/*
Problem statement:
one string will be given: "aebcbda"

minimum number of deletion required to make it palindrome is=2

Solution:
reverse the string "aebcbda" which is "abcbga"

x:  "aebcbda"
y:  "adbcbea"
find lcs of these two strings: "abcba" which is nothing but palindrome

deletecd elements are: 'e' & 'd'

So, if we add these 2 elements then also it will be a palindrome: "aedbcbdea"
So, no of insertion =no of deletion.

Min # of deletion=(length of "agbcba" - length of LCS)
Min # of insertion=(length of "agbcba" - length of LCS)
*/
public class M_MinNoOfInsertionInStringToMakeItPalindrome {

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
		return x.length() - DP[m][n];
	}

	public static void main(String[] args) {
		String s1 = "aebcbda";
		String s2 = new StringBuilder(s1).reverse().toString();
		int m = s1.length();
		int n = s2.length();

		System.out.println(s1);
		System.out.println(s2);
		System.out.println("Min # of insertion required=" + lcs(s1, s2, m, n));
	}
}
