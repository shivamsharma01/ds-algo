package prepbytes.topic.maths;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class HeroVillain {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		byte t = scan.nextByte();
		while (t-- > 0) {
			int heroes = scan.nextInt() - 1;
			List<Integer> factors = factors(scan.nextInt());
			for (int i = 0; i < heroes; i++) {
				int heroPower = scan.nextInt();
				Iterator<Integer> itr = factors.iterator();
				while (itr.hasNext()) {
					if (heroPower % itr.next() != 0) {
						itr.remove();
					}
				}
			}
			System.out.println(factors.size() + 1);
		}
	}

	private static List<Integer> factors(int n) {
		List<Integer> factors = new ArrayList<>();
		for (int i = 2; i <= n; i++) {
			if (n % i == 0)
				factors.add(i);
		}
		return factors;
	}

}
