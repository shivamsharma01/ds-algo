package prepbytes.marathon.SearchingAndSorting;

import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeSet;

public class First {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		byte t = scan.nextByte();
		while (t-- > 0) {
			TreeSet<Integer> tSet = new TreeSet<>();
			int n = scan.nextInt();
			int X = scan.nextInt();
			for (int i = 0; i < n; i++)
				tSet.add(scan.nextInt());
			int ans = 0;
			Iterator<Integer> e = tSet.iterator();
			while (e.hasNext()) {
				int i = e.next();
				if (i <= X) {
					ans++;
					X -= i;
				} else {
					break;
				}
			}
			System.out.println(ans);
		}
	}

}
