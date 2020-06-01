package prepbytes.topic.fundamentals;

import java.util.Scanner;

public class PrepBuddyAndSocks {

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		short t = sc.nextShort();
		while (t-- > 0)
			System.out.println(sc.nextInt() + 1);
	}

}