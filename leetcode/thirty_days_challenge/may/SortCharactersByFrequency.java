package leetcode.thirty_days_challenge.may;

import java.util.PriorityQueue;

public class SortCharactersByFrequency {

	public static void main(String[] args) {
		new SortCharactersByFrequency().frequencySort("tree");
		new SortCharactersByFrequency().frequencySort("cccaaa");
		new SortCharactersByFrequency().frequencySort("Aabb");
	}

	public String frequencySort(String s) {
		if (s == null || s.length() == 0)
			return s;

		int[] cnt_arr = new int['z' + 1];
		for (char c : s.toCharArray()) {
			cnt_arr[c]++;
		}

		PriorityQueue<Character> pq = new PriorityQueue<>((a, b) -> cnt_arr[b] - cnt_arr[a]);
		for (int i = 0; i < 'z' + 1; i++) {
			pq.offer((char) i);
		}

		StringBuilder sb = new StringBuilder();
		while (!pq.isEmpty()) {
			Character c = pq.poll();
			for (int i = 0; i < cnt_arr[c]; i++) {
				sb.append(c);
			}
		}

		return sb.toString();
	}

}
