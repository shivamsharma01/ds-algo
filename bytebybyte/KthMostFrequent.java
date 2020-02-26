package bytebybyte;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class KthMostFrequent {
	public static void main(String[] args) {
		String[] s = { "a", "a", "a", "b", "b", "c", "c", "c", "c", "d" };
		String out = kthMostFrequent(s, 2);
		System.out.println(out);
	}

	public static String kthMostFrequent(String[] strings, int k) {
		if (k > strings.length) {
			return null;
		}
		Map<String, Integer> map = new HashMap<>();
		for (String string : strings) {
			Integer val = map.get(string);
			if (val == null) {
				val = 0;
			}
			map.put(string, ++val);
		}
		List<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());
		Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
			@Override
			public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2) {
				Integer i1 = o1.getValue();
				Integer i2 = o2.getValue();
				return i2.compareTo(i1);
			}
		});
		if (list.size() >= k) {
			return list.get(k - 1).getKey();
		}
		return null;
	}
}
