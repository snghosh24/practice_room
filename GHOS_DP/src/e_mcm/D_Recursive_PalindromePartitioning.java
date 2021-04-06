package e_mcm;
/*
Problem statement:
a string will be given: "abaabb"
To find: minimum number of partitions required to find palindromic substrings ot of the given string

a|b|a|a|b|b -->5
aba|a|b|b --> 4
aba|a|bb -->3
a|baab|b -->3
a|b|aa|bb --> 4    etc

So, minimum no of partition required=3

i>=j means either string is empty or string hash only one character

 */
public class D_Recursive_PalindromePartitioning {
	
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
		
		int result=Integer.MAX_VALUE;
		
		for(int k=i; k<=j-1;k++) {
			
			int temp=1+palindromePartition(s, i, k)+palindromePartition(s, k+1, j);
			
			if(temp<result) {
				result=temp;
			}
			
		}
		
		return result;
	}
	
	public static void main(String[] args) {


		String s="abaabb";
		
		System.out.println("Minimum partition Required: "+palindromePartition(s, 0, s.length()-1));

	}

}
