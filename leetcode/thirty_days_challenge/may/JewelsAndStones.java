package leetcode.thirty_days_challenge.may;

public class JewelsAndStones {
	public static void main(String[] args) {
		JewelsAndStones o = new JewelsAndStones();
		System.out.println(o.numJewelsInStones("aA", "aAAbbbb"));
	}

	public int numJewelsInStones(String J, String S) {
		int count = 0;
		boolean[] store = new boolean['z' - 'A' + 1];
		for (char c : J.toCharArray())
			store[c - 'A'] = true;
		for (char c : S.toCharArray())
			if (store[c - 'A'])
				count++;
		return count;
	}
}
