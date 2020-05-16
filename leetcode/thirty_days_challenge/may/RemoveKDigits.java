package leetcode.thirty_days_challenge.may;

import java.util.Stack;

public class RemoveKDigits {
	public static void main(String[] args) {
		System.out.println(removeKDigits("1432219", 3));
		System.out.println(removeKDigits("1004003002219", 3));
		System.out.println(removeKDigits("200", 1));
		System.out.println(removeKDigits("10200", 1));
		System.out.println(removeKDigits("10", 2));
	}

	public static String removeKDigits(String num, int k) {
		int n = num.length();
		if (k == 0)
			return num;
		if (k == n)
			return "0";
		int i = 0;
		Stack<Character> s = new Stack<>();
		while (i < num.length()) {
			while (k > 0 && !s.isEmpty() && s.peek() > num.charAt(i)) {
				s.pop();
				k--;
			}
			s.push(num.charAt(i++));
		}
		while (k-- > 0)
			s.pop();
		StringBuilder sb = new StringBuilder("");
		s.forEach(c -> {
			sb.append(c);
		});
		while (sb.length() > 0 && sb.charAt(0) == '0')
			sb.deleteCharAt(0);
		if (sb.toString().equals(""))
			return "0";
		return sb.toString();
	}

}
