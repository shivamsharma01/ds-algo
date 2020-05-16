package prepbytes.marathon.codecrack2020;

import java.util.Scanner;

public class MinimumValueXOR {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt(), minXOR = Integer.MAX_VALUE, curXOR, n, count;
		while (t-- > 0) {
			int[] arr = new int[sc.nextInt()];
			for (int i = 0; i < arr.length; i++)
				arr[i] = sc.nextInt();
			for (int i = 0; i < arr.length - 1; i++) {
				for (int j = i + 1; j < arr.length; j++) {
					curXOR = arr[i] ^ arr[j];
					System.out.println(arr[i] + "^" + arr[j] + "=" + curXOR);
					n = curXOR;
					count = 0;
					while (n > 0) {
						++count;
						n &= n - 1;
					}
					if (count == 1) {
						System.out.println("yolo");
						minXOR = Math.min(curXOR, minXOR);
					}
				}
			}
			System.out.println(minXOR == Integer.MAX_VALUE ? -1 : minXOR);
		}
	}
}
