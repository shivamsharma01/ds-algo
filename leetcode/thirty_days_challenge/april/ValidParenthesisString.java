package leetcode.thirty_days_challenge.april;

public class ValidParenthesisString {
	public static void main(String[] args) {
		System.out.println(checkValidString("*("));
	}

	public static boolean checkValidString(String s) {
		return checkString(s.toCharArray(), 0, 0);
	}

	private static boolean checkString(char[] cArr, int index, int count) {
		if (count == -1) {
			return false;
		}
		if (index == cArr.length) {
			if (count == 0) {
				return true;
			}
			return false;
		}
		char c = cArr[index];
		if (c == '(') {
			count++;
		} else if (c == ')') {
			count--;
		} else {
			if (checkString(cArr, ++index, count))
				return true;
			else if (checkString(cArr, index, count + 1))
				return true;
			else if (checkString(cArr, index, count - 1))
				return true;
			else
				return false;
		}
		return checkString(cArr, ++index, count);
	}
}
