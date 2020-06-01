package prepbytes.marathon.stackAndQueue;

import java.io.IOException;
import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeSet;

public class QuizTest {
	public static void main(String args[]) throws IOException {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int[] marks = new int[n];
		for (int i = 0; i < n; i++)
			marks[i] = scan.nextInt();
		for (int i = 0; i < n; i++)
			marks[i] += scan.nextInt();
		for (int i = 0; i < n; i++)
			marks[i] += scan.nextInt();
		TreeSet<Integer> set = new TreeSet<Integer>();
		for (int i = 0; i < n; i++)
			set.add(marks[i]);
		byte Q = scan.nextByte();
		while (Q-- > 0) {
			byte q = scan.nextByte();
			if (set.size() < q)
				System.out.println(-1);
			else {
				Iterator<Integer> itr = set.iterator();
				int count = 0;
				while (++count != q) {
					itr.next();
				}
				System.out.println(itr.next());
				itr.remove();
			}
		}
	}
}
