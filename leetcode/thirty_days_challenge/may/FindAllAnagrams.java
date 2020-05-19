package leetcode.thirty_days_challenge.may;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindAllAnagrams {
	public static void main(String[] args) {
		FindAllAnagrams o = new FindAllAnagrams();
		System.out.println(o.findAnagrams("aaaba", "ba"));
	}

	public List<Integer> findAnagrams(String s, String p) {
		List<Integer> list = new ArrayList<>();
		char[] arrS = s.toCharArray(), arrP = p.toCharArray();
		int[] countInAnagram = new int[26], countInCur = new int[26];
		for (char c : arrP)
			countInAnagram[c - 'a']++;
		int index = 0, in, length = 0, anagramLength = p.length(), i;
		while (index != arrS.length) {
			i = arrS[index] - 'a';
			if (countInAnagram[i] == 0) {
				length = 0;
				Arrays.fill(countInCur, 0);
			} else if (countInAnagram[i] > countInCur[i]) {
				countInCur[i]++;
				length++;
				if (length == anagramLength) {
					list.add(index - length + 1);
					countInCur[arrS[index - length + 1] - 'a']--;
					length--;
				}
			} else {
				in = index - length;
				while (arrS[in] != arrS[index])
					countInCur[arrS[in++] - 'a']--;
				length = index - in;
				if (length == anagramLength) {
					list.add(index - length + 1);
					countInCur[arrS[index - length + 1] - 'a']--;
					length--;
				}
			}
			index++;
		}
		return list;
	}

}
