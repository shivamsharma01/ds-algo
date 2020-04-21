package MissingInAP;

import java.util.Scanner;

public class MissingInAP {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		byte t = scan.nextByte();
		while (t-- > 0) {
			int n = scan.nextInt(), a = scan.nextInt(), b = scan.nextInt();
			int d = b - a, missingTerm = 0;
			boolean foundMissing = false;
			for (int i = 2; i < n; i++) {
				a = b;
				b = scan.nextInt();
				if (b - a == d || foundMissing)
					continue;
				else {
					foundMissing = true;
					if (b - a > d) {
						missingTerm = (b + a) / 2;
					} else {
						missingTerm = d / 2;
					}
				}
			}
			System.out.println(missingTerm);
		}
	}

}
