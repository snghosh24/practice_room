package others;

import java.util.Arrays;

public class A_Fibonacci {

	public static int fibRecursion(int n) {

		if (n <= 1) {
			return n;
		}

		return fibRecursion(n - 1) + fibRecursion(n - 2);
	}

	
	static int DP[];
	public static int fibMemoization(int n) {

		if (n <= 1) {
			return n;
		}

		if(DP[n]!=-1) {
			return DP[n];
		}
		
		return DP[n]=fibRecursion(n - 1) + fibRecursion(n - 2);
	}
	
	public static int fibTabulation(int n) {

		int DP[]=new int[n+1];
		
		for(int i=0;i<n;i++) {
			if(i<=1) {
				DP[i]=i;
			}
			
			DP[i]=DP[i-1]+DP[i-2];
		}
		
		return DP[n];
	}

	public static void main(String[] args) {

		int n = 9;
		
		//Using recursion
		System.out.println(n + "th fibonacci number using recursion=" + fibRecursion(n));
		
		//Using memoization
		DP=new int[n+1];
		Arrays.fill(DP, -1);
		System.out.println(n + "th fibonacci number using memoization=" + fibRecursion(n));
		
		//Using Tabulation
		System.out.println(n + "th fibonacci number using tabulation=" + fibRecursion(n));
	}

}
