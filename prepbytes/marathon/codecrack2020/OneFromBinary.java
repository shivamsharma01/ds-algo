package prepbytes.marathon.codecrack2020;

import java.util.Scanner;

public class OneFromBinary {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		byte t = sc.nextByte();
		while (t-- > 0) {
			int operations = 0;
			char[] input = sc.next().toCharArray();
			int left = 0, right = input.length - 1;
			while (left < right) {
				operations++;
				if (input[right] == '1') {
					boolean found = false;
					for (int i = right; i >= left; i--) {
						if (input[i] == '1')
							input[i] = '0';
						else {
							input[i] = '1';
							found = true;
							break;
						}
					}
					if (!found) {
						input[left] = '1';
						operations++;
					}
				} else {
					right--;
				}
			}
			System.out.println(operations);
		}
	}
}
