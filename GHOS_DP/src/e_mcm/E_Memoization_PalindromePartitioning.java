package e_mcm;

import java.util.Arrays;

public class E_Memoization_PalindromePartitioning {

	static int[][] DP = new int[100][100];// this size will be depend on constraint
	
	public static boolean isPalindrome(String s,int i, int j) {
		
		while(i<j) {
			if(s.charAt(i++)!=s.charAt(j--)) {
				return false;
			}
			
			
		}
		
		return true;
	}

	public static int palindromePartition(String s, int i, int j) {
		
		if(i>=j) {
			return 0;
		}
		
		if(isPalindrome(s, i, j)) {
			return 0;
		}
		
		if (DP[i][j] != -1) {
			return DP[i][j];
		}
		
		int result=Integer.MAX_VALUE;
		
		for(int k=i; k<=j-1;k++) {
			
			int temp=1+palindromePartition(s, i, k)+palindromePartition(s, k+1, j);
			
			if(temp<result) {
				result=temp;
			}
			
		}
		
		return DP[i][j]=result;
	}
	
	public static void main(String[] args) {


		String s="nitin";
		

		for (int[] row : DP)
			Arrays.fill(row, -1);
		
		System.out.println("Minimum partition Required: "+palindromePartition(s, 0, s.length()-1));

	}
}

/*
output:
Minimum partition Required: 0
*/
