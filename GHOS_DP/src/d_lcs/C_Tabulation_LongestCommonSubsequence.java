package d_lcs;
//Tabulation or Bottom-up approach
public class C_Tabulation_LongestCommonSubsequence {

	static int max(int a, int b) {
		return (a > b) ? a : b;
	}
	
	public static int lcs(String x, String y,int m ,int n) {
		
		int DP[][] = new int[m + 1][n + 1]; 
		  
        for (int i = 0; i <= m; i++) { 
            for (int j = 0; j <= n; j++) { 
                if (i == 0 || j == 0) 
                    DP[i][j] = 0; 
                else if (x.charAt(i-1) == y.charAt(j-1)) 
                    DP[i][j] = DP[i - 1][j - 1] + 1; 
                else
                    DP[i][j] = max(DP[i - 1][j], DP[i][j - 1]); 
            } 
        } 
        return DP[m][n]; 
	}

	public static void main(String[] args) {
		String s1="acegi";
		String s2="abcd";
		int m=s1.length();
		int n=s2.length();
		
		
		System.out.println("Longest commom subsequence length="+lcs(s1, s2, m, n));
	}
}
