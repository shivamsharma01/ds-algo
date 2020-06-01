package prepbytes.topic.fundamentals;

import java.util.Scanner;

public class BoxesAndToys {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int boxes = sc.nextInt(), ans = 0;
		while (boxes-- > 0) {
			if (sc.nextInt() - sc.nextInt() < -1)
				ans++;
		}
		System.out.println(ans);
	}
}
