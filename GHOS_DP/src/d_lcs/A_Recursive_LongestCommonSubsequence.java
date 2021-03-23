package d_lcs;

public class A_Recursive_LongestCommonSubsequence{
	
	static int max(int a, int b) {
		return (a > b) ? a : b;
	}
	
	public static int lcs(String x, String y,int m ,int n) {
		
		if(m==0||n==0) {
			return 0;
		}
		
		if(x.charAt(m-1)==y.charAt(n-1)) {
			return 1+lcs(x, y, m-1, n-1);
		}
		else {
			return max(lcs(x, y, m, n-1), lcs(x, y, m-1, n));
		}
	}

	public static void main(String[] args) {
		String s1="abcghi";
		String s2="bdfhij";
		
		System.out.println("Longest commom subsequence length="+lcs(s1, s2, s1.length(), s2.length()));
	}
}
