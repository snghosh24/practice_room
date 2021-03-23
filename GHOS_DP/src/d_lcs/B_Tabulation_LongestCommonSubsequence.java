package d_lcs;
// Bottom-up
public class B_Tabulation_LongestCommonSubsequence {

	static int[][] DP;
	
	static int max(int a, int b) {
		return (a > b) ? a : b;
	}
	
	public static int lcs(String x, String y,int m ,int n) {
		
		if(m==0||n==0) {
			return 0;
		}
		
		if (DP[m][n] != -1)											
	        return DP[m][n];
		
		if(x.charAt(m-1)==y.charAt(n-1)) {
			return DP[m][n]= 1+lcs(x, y, m-1, n-1);
		}
		else {
			return DP[m][n]=max(lcs(x, y, m, n-1), lcs(x, y, m-1, n));
		}
	}

	public static void main(String[] args) {
		String s1="acegi";
		String s2="abcd";
		int m=s1.length();
		int n=s2.length();
		
		DP=new int[m+1][n+1];	
		for(int i=0;i<m+1;i++)
			for(int j=0;j<n+1;j++)
				 DP[i][j] = -1; 
		
		System.out.println("Longest commom subsequence length="+lcs(s1, s2, m, n));
	}
}
