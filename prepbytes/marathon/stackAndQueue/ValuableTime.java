package prepbytes.marathon.stackAndQueue;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class ValuableTime {
	public static void main(String args[]) throws IOException {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		Queue<Integer> q = new LinkedList<Integer>();
		int[] b = new int[n];
		for (int i = 0; i < n; i++)
			q.add(sc.nextInt());
		for (int i = 0; i < n; i++)
			b[i] = sc.nextInt();
		int count = 0;
		for (int i = 0; i < n; i++) {
			while (q.peek() != b[i]) {
				count++;
				q.add(q.remove());
			}
			q.remove();
			count++;
		}
		System.out.println(count);
	}
}
