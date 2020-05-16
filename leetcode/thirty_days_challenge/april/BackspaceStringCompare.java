package leetcode.thirty_days_challenge.april;

public class BackspaceStringCompare {
	public boolean backspaceCompare(String S, String T) {
		int l1 = S.length() - 1;
		int l2 = T.length() - 1;
		int backCount1 = 0;
		int backCount2 = 0;
		while (l1 >= 0 && l2 >= 0) {
			char c1 = S.charAt(l1);
			char c2 = T.charAt(l2);
			if (c1 == '#') {
				backCount1++;
				l1--;
			}
			if (c2 == '#') {
				backCount2++;
				l2--;
			}
			if (backCount1 == 0 && backCount2 == 0) {
				if (c1 != c2 && c1 != '#' && c2 != '#') {
					return false;
				} else {
					l1--;
					l2--;
				}
			}
			if (c1 != '#' && backCount1 > 0) {
				backCount1--;
				l1--;
			}
			if (c2 != '#' && backCount2 > 0) {
				backCount2--;
				l2--;
			}
		}

		while (l1 >= 0) {
			char c = S.charAt(l1);
			if (c == '#') {
				backCount1++;
			} else {
				if (backCount1 == 0) {
					return false;
				}
				backCount1--;
			}
			l1--;
		}
		while (l2 >= 0) {
			char c = T.charAt(l2);
			if (c == '#') {
				backCount2++;
			} else {
				if (backCount2 == 0) {
					return false;
				}
				backCount2--;
			}
			l2--;
		}
		if (l1 == l2 && l2 == -1) {
			return true;
		}
		return false;
	}
}
