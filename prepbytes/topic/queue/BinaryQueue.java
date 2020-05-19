package prepbytes.topic.queue;

import java.util.Scanner;

public class BinaryQueue {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		byte t = sc.nextByte();
		while (t-- > 0) {
			String n = Integer.toBinaryString(sc.nextInt());
			int i, last;
			StringBuilder start = new StringBuilder("0");
			while (!start.toString().equals(n)) {
				i = start.length() - 1;
				last = start.lastIndexOf("0");
				for (; i > last; i--)
					start.setCharAt(i, '0');
				if (i >= 0)
					start.setCharAt(i, '1');
				else
					start.insert(0, '1');
				System.out.print(start + " ");
			}
		}
	}
}
