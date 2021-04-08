package e_mcm;

public class L_Recursive_EggDroppingProblem {

	public static int eggDrop(int e, int f) {
		
		if (f == 1 || f == 0)
			return f;

		// We need k trials for one egg
		// and k floors
		if (e == 1)
			return f;

		int min = Integer.MAX_VALUE;
		int temp;

		// Consider all droppings from
		// 1st floor to kth floor and
		// return the minimum of these
		// values plus 1.
		for (int i = 1; i <= f; i++) {
			temp = Math.max(eggDrop(e - 1, i - 1), eggDrop(e, f - i));
			if (temp < min)
				min = temp;
		}

		return min + 1;
	}

	public static void main(String[] args) {
		int e = 8, f = 30;
        System.out.print("Minimum number of "
                         + "trials in worst case with "
                         + e + " eggs and " + f+ " floors is " + eggDrop(e, f));
	}
}
