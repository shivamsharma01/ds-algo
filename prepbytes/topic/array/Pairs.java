package prepbytes.topic.array;

import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Pairs {
	public static void main(String args[]) throws IOException {
		// write your code here
		Scanner scan = new Scanner(System.in);
		int max = scan.nextInt();
		int m = scan.nextInt();
		Set<Integer> aSet = new HashSet<>();
		Set<Integer> bSet = new HashSet<>();
		boolean isAFinal = false;
		boolean isBFinal = false;
		boolean isAPossible = true;
		boolean isBPossible = true;
		int aFixed = scan.nextInt();
		int aFixedOther = Integer.MIN_VALUE;
		int bFixed = scan.nextInt();
		int bFixedOther = Integer.MIN_VALUE;
		for (int i = 0; i < m - 1; i++) {
			int a = scan.nextInt();
			int b = scan.nextInt();
			if (isAPossible) {
				if (isAFinal) {
					if ((aFixed != a && aFixed != b) && (aFixedOther != a && aFixedOther != b)) {
						isAPossible = false;
					}
				} else {
					boolean containsA = aSet.contains(a);
					boolean containsB = aSet.contains(b);
					if (aFixed != a && aFixed != b) {
						if (!containsA && !containsB) {
							if (aSet.isEmpty()) {
								aSet.add(a);
								aSet.add(b);
							} else {
								isAPossible = false;
							}
						} else if (containsA && !containsB) {
							aFixedOther = a;
							isAFinal = true;
						} else if (containsB && !containsA) {
							aFixedOther = b;
							isAFinal = true;
						}
					}
				}
			}
			if (isBPossible) {
				if (isBFinal) {
					if ((bFixed != a && bFixed != b) && (bFixedOther != a && bFixedOther != b)) {
						isBPossible = false;
					}
				} else {
					boolean containsA = bSet.contains(a);
					boolean containsB = bSet.contains(b);
					if (bFixed != a && bFixed != b) {
						if (!containsA && !containsB) {
							if (bSet.isEmpty()) {
								bSet.add(a);
								bSet.add(b);
							} else {
								isBPossible = false;
							}
						} else if (containsA && !containsB) {
							bFixedOther = a;
							isBFinal = true;
						} else if (containsB && !containsA) {
							bFixedOther = b;
							isBFinal = true;
						}
					}
				}
			}
		}
		String status = isAPossible || isBPossible ? "YES" : "NO";
		System.out.println(status);
	}

}
