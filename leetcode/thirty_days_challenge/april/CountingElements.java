package leetcode.thirty_days_challenge.april;

import java.util.HashSet;
import java.util.Set;

public class CountingElements {
	public int countElements(int[] arr) {
		int[] a = new int[1002];
		Set<Integer> h = new HashSet<>();
		for (int i : arr) {
			h.add(i);
			++a[i];
		}
		int[] count = new int[] { 0 };
		h.forEach(i -> {
			if (a[i + 1] != 0) {
				count[0] += a[i];
			}
		});
		return count[0];
	}
}
