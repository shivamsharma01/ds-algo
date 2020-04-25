package prepbytes.topic.sorting;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class HometownNewspaper {
	public static void main(String args[]) throws IOException {
		Scanner scan = new Scanner(System.in);
		byte t = scan.nextByte();
		while (t-- > 0) {
			List<String> newspaper = new ArrayList<>();
			int n = Integer.parseInt(scan.next());
			scan.nextLine();
			String cur;
			for (int i = 0; i < n; i++)
				newspaper.add(scan.nextLine());
			newspaper.sort(new Comparator<String>() {
				@Override
				public int compare(String o1, String o2) {
					if (o1.endsWith("1") && o2.endsWith("0"))
						return -1;
					else if (o2.endsWith("1") && o1.endsWith("0"))
						return 1;
					else
						return Integer.parseInt(o2.split(" ")[1]) - Integer.parseInt(o1.split(" ")[1]);
				}
			});
			newspaper.forEach(s -> {
				System.out.println(s.split(" ")[0]);
			});
		}
	}

}
