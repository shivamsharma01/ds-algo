package general.string;

// Knuth–Morris–Pratt (KMP)
public class KMPSubstringSearch {
	public static void main(String[] args) {
		System.out.println(KMP("abcxabcdabxabcdabcdabcy".toCharArray(), "abcdabcy".toCharArray()));
	}

	private static boolean KMP(char[] text, char[] pattern) {
		int[] temp = new int[pattern.length];
		computeTemporaryArray(pattern, temp);
		for (int i = 0; i < pattern.length; i++) {
			System.out.print("|  " + pattern[i] + "  ");
		}
		System.out.println("|");
		for (int i = 0; i < pattern.length; i++) {
			System.out.print("|  " + temp[i] + "  ");
		}
		System.out.println("|");
		int index = 0, i = 0;
		while (i < text.length && index < pattern.length) {
			if (text[i] == pattern[index]) {
				i++;
				index++;
			} else if (index != 0)
				index = temp[index - 1];
			else
				i++;
		}
		return index == pattern.length;
	}

	private static void computeTemporaryArray(char[] pattern, int[] temp) {
		int i = 1, index = 0;
		while (i < pattern.length) {
			if (pattern[i] == pattern[index])
				temp[i++] = ++index;
			else if (index != 0)
				index = temp[index - 1];
			else
				temp[i++] = 0;
		}
	}

}
