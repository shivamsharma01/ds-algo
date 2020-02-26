package bytebybyte;

public class StringCompression {
	public static void main(String[] args) {
		String out = compress("aa");
		System.out.println(out);
	}

	private static String compress(String s) {
		if (s == null || s.length() == 0) {
			return null;
		}
		String out = "";
		int sum = 1;
		for (int i = 0; i < s.length() - 1; i++) {
			if (s.charAt(i) == s.charAt(i + 1)) {
				++sum;
				continue;
			} else {
				out = out + s.charAt(i) + sum;
				sum = 1;
			}
		}
		out += s.substring(s.length() - 1, s.length()) + sum;
		if(out.length() > s.length()) {
			return s;
		}
		return out;
	}
}
