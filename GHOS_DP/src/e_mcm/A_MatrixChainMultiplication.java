package e_mcm;
/*
Problem Statement:
Given a sequence of matrices, find the most efficient way to multiply these matrices together. 

The problem is not actually to perform the multiplications, but merely to decide in which order 
to perform the multiplications.

one array will be given which will represent the dimension of the metrices

int[] arr={10,30,20,40}
No of metrices=arr.length-1=4-1=3

A1(10*30)
A2(30*20)
A3(20*40)

Given an array arr[] which represents the chain of matrices such that the i-th matrix
 Ai is of dimension arr[i-1] x arr[i]. --> here we find the value of i=1
 
 We need to write a function MatrixChainOrder() that should return the minimum number 
 of multiplications needed to multiply the chain.
 
 Solution:
 1. Find i & j
 2. Find Base condition
 3. Find k loop scheme
 	scheme 1: k=i; k<j of k==j-1    then recursive call(i to k) + recursive call(k+1 to j)
 	scheme 2: k=i+1; k<=j of k==j    then recursive call(i to k-1) + recursive call(k to j)
 4. calculate cost for temporary answer

 */
public class A_MatrixChainMultiplication {
	
	public static int MatrixChainOrder(int arr[], int i, int j) {
		
		if (i >= j)
            return 0;
 
        int result = Integer.MAX_VALUE;
 
        
        for (int k = i; k < j; k++)
        {
            int cost = MatrixChainOrder(arr, i, k)
                        + MatrixChainOrder(arr, k + 1, j)
                        + arr[i - 1] * arr[k] * arr[j];
 
            if (cost < result)
                result = cost;
        }
 
        return result;
	}

	public static void main(String[] args) {
		int arr[] = { 1, 2, 3, 4, 3 };
        int n = arr.length;
 
        System.out.println(
            "Minimum number of multiplications is: "
            + MatrixChainOrder(arr, 1, n - 1));

	}

}

/*
Minimum number of multiplications is: 30
*/