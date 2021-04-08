package e_mcm;

public class J_Recursive_ScrambledString {

	public static boolean isScrambled(String x, String y) {

		if (x.equals(y)) {
			return true;
		}

		if (x.length() != y.length() || x.length() <= 1 || y.length() <= 1) {
			return false;
		}

		int n = x.length();
		boolean flag = false;

		for (int i = 1; i <= n - 1; i++) {

			// Condition-I
			if ((isScrambled(x.substring(0, i), y.substring(n - i, n))
					&& isScrambled(x.substring(i, n), y.substring(0, n-i)))) {
					
				flag= true;
				break;
			}
			
			if (isScrambled(x.substring(0, i), y.substring(0, i))
					&& isScrambled(x.substring(i, n), y.substring(i, n))) {
					
				flag= true;

			}

		}

		return flag;
	}

	public static void main(String[] args) {

		String x = "great";
		String y = "egtra";

		System.out.println("Are " + x + " and " + y + " scrambled String? : " + (isScrambled(x, y) ? "Yes" : "No"));

	}

}
