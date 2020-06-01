package leetcode.problems.easy;

// https://leetcode.com/problems/increasing-decreasing-string/
public class IncreasingDecreasingString {

	public static void main(String[] args) {
		IncreasingDecreasingString o = new IncreasingDecreasingString();
		System.out.println(o.sortString("aaaabbbbcccc"));
		System.out.println(o.sortString("rat"));
		System.out.println(o.sortString("leetcode"));
		System.out.println(o.sortString("ggggggg"));
		System.out.println(o.sortString("spo"));
	}

	public String sortString(String s) {
		StringBuilder result = new StringBuilder("");
		int[] counter = new int[26];
		for (char c : s.toCharArray())
			counter[c - 'a']++;
		int low, high;
		while (result.length() != s.length()) {
			low = getLow(counter, -1);
			while (low != 26) {
				result.append((char) (low + 'a'));
				low = getLow(counter, low);
			}
			high = getHigh(counter, 26);
			while (high != -1) {
				result.append((char) (high + 'a'));
				high = getHigh(counter, high);
			}
		}
		return result.toString();
	}

	private int getLow(int[] arr, int x) {
		int i = x + 1;
		for (; i < arr.length; i++) {
			if (arr[i] != 0) {
				arr[i]--;
				return i;
			}
		}
		return i;
	}

	private int getHigh(int[] arr, int x) {
		int i = x - 1;
		for (; i >= 0; i--) {
			if (arr[i] != 0) {
				arr[i]--;
				return i;
			}
		}
		return i;
	}

}
