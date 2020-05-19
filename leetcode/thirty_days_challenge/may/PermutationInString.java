package leetcode.thirty_days_challenge.may;

public class PermutationInString {
	public static void main(String[] args) {
		PermutationInString o = new PermutationInString();
		System.out.println(o.checkInclusion("cdefghi", "abcdefghdick"));
	}

	public boolean checkInclusion(String s1, String s2) {
		if (s1.length() > s2.length())
			return false;
		int[] counter = new int[26], temp = new int[26];
		for (char c : s1.toCharArray())
			counter[c - 'a']++;
		copy(counter, temp);
		char[] arr = s2.toCharArray();
		int index = 0, s1Length = s1.length(), s2Length = s2.length(), back, length = 0, j;
		while (length != s1Length && (index + s1Length - length) <= s2Length) {
			length++;
			j = arr[index++] - 'a';
			temp[j]--;
			if (counter[j] == 0) {
				if (length != 0)
					copy(counter, temp);
				length = 0;
				continue;
			} else if (temp[j] == -1) {
				back = index - length;
				while (arr[back] - 'a' != j)
					temp[arr[back++] - 'a']++;
				back++;
				temp[j] = 0;
				length = index - back;
			}
		}
		if (length == s1Length)
			return true;
		return false;
	}

	private void copy(int[] source, int[] destination) {
		for (int i = 0; i < 26; i++)
			destination[i] = source[i];
	}
}
