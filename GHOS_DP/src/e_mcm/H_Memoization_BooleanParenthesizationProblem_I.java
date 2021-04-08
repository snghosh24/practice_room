package e_mcm;

import java.util.HashMap;
import java.util.Map;

public class H_Memoization_BooleanParenthesizationProblem_I {

	static Map<String, Integer> map=new HashMap<>();
	
	public static int booleanParenthesizationWays(String s, int i, int j, boolean isTrue) {

		if (i > j)
			return 0;

		if (i == j) {
			if (isTrue == true) {
				return (s.charAt(i) == 'T') ? 1 : 0;
			} else {
				return (s.charAt(i) == 'F') ? 1 : 0;
			}
		}
		
		String key=i+"_"+j+"_"+isTrue;
		if(map.get(key)!=null) {
			return map.get(key);
		}
		

		int ans = 0;

		for (int k = i + 1; k <= j - 1; k = k + 2) {

			int lt = booleanParenthesizationWays(s, i, k - 1, true);
			int lf = booleanParenthesizationWays(s, i, k - 1, false);
			int rt = booleanParenthesizationWays(s, k + 1, j, true);
			int rf = booleanParenthesizationWays(s, k + 1, j, false);

			if (s.charAt(k) == '&') {

				if (isTrue == true) {
					ans = ans + (lt * rt);
				} else {

					ans = ans + (lt * rf) + (lf * rt) + (lf * rf);
				}
			}

			if (s.charAt(k) == '|') {

				if (isTrue == true) {
					ans = ans + (lt * rt) + (lf * rt) + (lt * rf);
				} else {

					ans = ans + (lf * rf);
				}
			}

			if (s.charAt(k) == '^') {

				if (isTrue == true) {
					ans = ans + (lt * rf) + (lf * rt);
				} else {
					ans = ans + (lt * rt) + (lf * rf);
				}
			}
		}

		map.put(key, ans);
		return ans;
	}

	public static void main(String[] args) {

		long startTime = System.nanoTime();
		String s = "T|T&F^T";
		boolean isTrue = true;
		int i = 0;
		int j = s.length() - 1;
		System.out.println("No of ways= " + booleanParenthesizationWays(s, i, j, isTrue));
		long endTime = System.nanoTime();
		
		System.out.println("Runtime= "+(endTime-startTime));

	}
}
