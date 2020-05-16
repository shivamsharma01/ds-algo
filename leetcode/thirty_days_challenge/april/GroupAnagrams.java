package leetcode.thirty_days_challenge.april;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class GroupAnagrams {
	public List<List<String>> groupAnagrams(String[] strs) {
		// write your code here
		List<String> sdf = new ArrayList<>(Arrays.asList(strs));
		List<List<String>> out = new ArrayList<>();
		Iterator<String> outer = sdf.iterator();
		List<String> l = null;
		while (outer.hasNext()) {
			String cur = outer.next();
			outer.remove();
			l = new ArrayList<String>();
			l.add(cur);
			while (outer.hasNext()) {
				String i = outer.next();
				if (isAnagram(cur, i)) {
					l.add(i);
					outer.remove();
				}
			}
			out.add(l);
			outer = sdf.iterator();
		}
		return out;
	}

	public boolean isAnagram(String s1, String s2) {
		if (s1.length() != s2.length())
			return false;
		int[] a = new int[26];
		for (int i = 0; i < s1.length(); i++) {
			++a[s1.charAt(i) - 'a'];
			--a[s2.charAt(i) - 'a'];
		}
		for (int i = 0; i < 26; i++) {
			if (a[i] != 0)
				return false;
		}
		return true;
	}
}
