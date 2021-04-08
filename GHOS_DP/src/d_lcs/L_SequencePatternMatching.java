package d_lcs;
/*
 Problem statement:
 Two strings will be given...
 String x="axy"
 String y="adxcpy"
 
 To check String 'x' is a subsequence of String 'y' or not.
 
 Solution:
 if String 'x' is a subsequence of String 'y'
 then lcs of 'x' & 'y' will be nothing but the string 'x'
 */
public class L_SequencePatternMatching {

	static int max(int a, int b) {
		return (a > b) ? a : b;
	}
	
	public static boolean lcs(String x, String y,int m ,int n) {
		
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
        
        return DP[m][n]==x.length(); 
	}

	public static void main(String[] args) {
		String s1="axy";
		String s2="adxcpy";
		int m=s1.length();
		int n=s2.length();
		
		
		System.out.println("Is sequence pattern matched? ="+lcs(s1, s2, m, n));
	}
}
/*
 input: 
 String s1="axy"
 String s2="adxcpy"
 
 output:
 Is sequence pattern matched? =true
 
  
 */
