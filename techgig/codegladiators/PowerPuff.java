package techgig.codegladiators;

import java.util.Scanner;

public class PowerPuff {
	public static void main(String args[]) throws Exception {
		Scanner scan = new Scanner(System.in);
		long[] baseIngredients = new long[scan.nextInt()];
		for (int i = 0; i < baseIngredients.length; i++) {
			baseIngredients[i] = scan.nextLong();
		}
		long min = Long.MAX_VALUE;
		for (int i = 0; i < baseIngredients.length; i++) {
			long totalQuantityOfIngredient = scan.nextLong();
			if (totalQuantityOfIngredient == 0)
				continue;
			long possible = totalQuantityOfIngredient / baseIngredients[i];
			if (possible < min)
				min = possible;
		}
		System.out.println(min);
	}
}
