package c_unbounded_knapsack;
//Tabulation or Bottom-up approach
public class B_Tabulation_UnboundedKnapsack {

	static int DP[][];                                                  //change-1
	
	static int max(int a, int b) {
		return (a > b) ? a : b;
	}

	public static int knapsack(int w[], int val[], int W, int n) {

		if (n == 0 || W == 0) {
			return 0;
		}
		
		 if (DP[n][W] != -1)											//change-3
		        return DP[n][W];

		if (w[n - 1] <= W) {
			//return DP[n][W]= max(val[n - 1] + knapsack(w, val, W - w[n - 1], n - 1), knapsack(w, val, W, n - 1));
			return DP[n][W]= max(val[n - 1] + knapsack(w, val, W - w[n - 1], n ), knapsack(w, val, W, n - 1));
		} else {
			return DP[n][W]=knapsack(w, val, W, n - 1);
		}
		
		//change-4: stored the result in DP and then returned
	}

	public static void main(String[] args) {

		int w[]   = { 2, 4, 2, 5, 1 };
		int val[] = { 5, 3, 4, 2, 7 };
		int W = 7;
		int n = val.length;

		DP=new int[n+1][W+1];								//change-2: initialized DP with -1
															// size of the DP will be based on the variables which are not constant
		for(int i = 0; i < n + 1; i++)   
	        for(int j = 0; j < W + 1; j++)   
	            DP[i][j] = -1;  
		
		System.out.println("Max profit=" + knapsack(w, val, W, n));
	}

}
