package prepbytes.marathon.codecrack2020;

import java.io.IOException;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

// incomplete
public class ArnabAndFriend {
	public static void main(String args[]) throws IOException {
		Scanner sc = new Scanner(System.in);
		byte t = sc.nextByte();
		while (t-- > 0) {
			int n = sc.nextInt(), m = 1000000007, num, val;
			TreeMap<Integer, Integer> map = new TreeMap<>();
			long totalPermutations = 1;
			map.put(sc.nextInt(), 1);
			for (int i = 1; i < n; i++) {
				totalPermutations = ((totalPermutations % m) * (i % m)) % m;
				num = sc.nextInt();
				if (map.containsKey(num)) {
					val = map.get(num);
					map.put(num, ++val);
				} else
					map.put(num, 1);
			}
			Set<Map.Entry<Integer, Integer>> e = map.entrySet();
//			e.forEach(f -> {
//				totalPermutations
//			});

		}
	}
}
