package prepbytes.topic.maths;

import java.util.Scanner;

public class OperateNumbers {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		short t = scan.nextShort();
		while (t-- > 0) {
			System.out.println(calculateOperations(scan.nextInt(), scan.nextInt()));
		}
	}

	private static int calculateOperations(int p, int q) {
		int count = 0;
		while (p != 0 && q != 0) {
			if (p < q) {
				count += q / p;
				q = q % p;
			} else if (q < p) {
				count += p / q;
				p = p % q;
			} else {
				count += 1;
				break;
			}
		}
		return count;
	}
}
