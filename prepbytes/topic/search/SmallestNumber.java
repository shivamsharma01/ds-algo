package prepbytes.topic.search;

import java.util.Scanner;

public class SmallestNumber {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int[] counter = new int[100001];
		for (int i = 0; i < n; i++) {
			counter[scan.nextInt()]++;
		}
		int k = scan.nextInt();
		for (int i = 0; i < counter.length; i++) {
			if (counter[i] == k) {
				System.out.println(i);
				break;
			}
		}
	}

}
