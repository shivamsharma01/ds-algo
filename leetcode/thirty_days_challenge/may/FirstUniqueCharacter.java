package leetcode.thirty_days_challenge.may;

public class FirstUniqueCharacter {
	public static void main(String[] args) {
		System.out.println(firstUniqChar(""));
		System.out.println(firstUniqChar("ll"));
	}

	public static int firstUniqChar(String s) {
		String other = s;
		while (other.length() > 0) {
			char c = other.charAt(0);
			if (other.length() - other.replaceAll("" + c, "").length() == 1) {
				return s.indexOf(c);
			}
			other = other.replaceAll("" + c, "");
		}
		return -1;
	}

}
