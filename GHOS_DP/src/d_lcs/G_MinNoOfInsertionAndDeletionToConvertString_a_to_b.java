package d_lcs;

/*
 Problem Statiemment:
 
 2 strings will be given
 a: "heap"
 b: "pea"
 
 "heap"--(delete 'h' from first)--> "eap" --(delete 'p' from last)--> "ea"  --(insert 'p' at first)-->"pea"
 
 Solution:
 1.find LCS
 2. (length of "heap"- length of lcs)+(length of "pea" - length of lcs)
 */
public class G_MinNoOfInsertionAndDeletionToConvertString_a_to_b {

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
		return (x.length() - DP[m][n]) + (y.length() - DP[m][n]);
	}

	public static void main(String[] args) {
		String s1 = "heap";
		String s2 = "peak";
		int m = s1.length();
		int n = s2.length();

		System.out.println("Min number of insertio & deletion required= " + lcs(s1, s2, m, n));
	}

}
