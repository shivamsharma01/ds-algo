package prepbytes.topic.search;

import java.util.Scanner;

public class BooksLeft {

	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt(), left = -1, right = n - 1, k = scan.nextInt();
		boolean isLeftHasGreaterChapter = false;
		int val;
		for (int i = 0; i < n; i++) {
			val = scan.nextInt();
			if (!isLeftHasGreaterChapter && val <= k)
				left = i;
			else {
				isLeftHasGreaterChapter = true;
				if (val > k)
					right = i;
			}
		}
		System.out.println(right - left);
	}

}
