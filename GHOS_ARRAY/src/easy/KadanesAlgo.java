package easy;

import java.util.ArrayList;

public class KadanesAlgo {

	static ArrayList<Integer> subarraySum(int[] arr, int n, int s) {

		// Your code here
		ArrayList<Integer> result = new ArrayList<>();
		int sum = 0;
		int start = 0;
		for (int i = 0; i < arr.length; i++) {

			if (sum < s) {
				sum = sum + arr[i];
			}
			while (sum > s) {
				sum = sum - arr[start];
				start++;
			}
			if (sum == s) {
				result.add(start + 1);
				result.add(i + 1);
				break;
			}

		}

		return result;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int arr[]= {135, 101, 170, 125, 79, 159, 163, 65, 106, 146, 82, 28, 162, 92, 196, 143, 28, 37, 192, 5, 103, 154, 93, 183, 22, 117, 119, 96, 48, 127, 172, 139, 70, 113, 68, 100, 36, 95, 104, 12, 123, 134};

		System.out.println(subarraySum(arr, arr.length, 468));
	}

}
