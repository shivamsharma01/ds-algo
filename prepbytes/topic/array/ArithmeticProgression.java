package prepbytes.topic.array;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

public class ArithmeticProgression {
	public static void main(String args[]) throws IOException {
		Scanner scan = new Scanner(System.in);
		Map<Integer, List<Integer>> map = new TreeMap<Integer, List<Integer>>();
		Set<Integer> filter = new HashSet<>();
		int n = scan.nextInt();
		for (int i = 0; i < n; i++) {
			int e = scan.nextInt();
			boolean isAdded = addToMap(e, i, map);
			if (!isAdded) {
				filter.add(e);
			}
		}
		map.keySet().removeAll(filter);
		System.out.println(map.keySet().size());
		for (Entry<Integer, List<Integer>> iter : map.entrySet()) {
			List<Integer> val = iter.getValue();
			if (val == null) {
				continue;
			}
			if (val.size() == 1) {
				System.out.println(iter.getKey() + " 0");
			} else {
				System.out.println(iter.getKey() + " " + (val.get(1) - val.get(0)));
			}
		}
	}

	public static boolean addToMap(int num, int index, Map<Integer, List<Integer>> map) {
		List<Integer> value = null;
		if (map.containsKey(num)) {
			value = map.get(num);
			if (value == null) {
				return false;
			} else if (value.size() == 2) {
				boolean isAp = (value.get(1) - value.get(0)) == index - value.get(1) ? true : false;
				if (isAp) {
					value.set(0, value.get(1));
					value.set(1, index);
				} else {
					map.put(num, null);
					return false;
				}
			} else {
				value.add(index);
			}
		} else {
			value = new ArrayList<Integer>();
			value.add(index);
			map.put(num, value);
		}
		return true;
	}
}