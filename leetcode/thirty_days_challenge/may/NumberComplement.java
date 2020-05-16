package leetcode.thirty_days_challenge.may;

public class NumberComplement {
	public int findComplement(int num) {
        return compliment(Integer.toBinaryString(num));
    }
    
    private int compliment(String arg) {
		char[] cArr = arg.toCharArray();
		for (int i = 0; i < arg.length(); i++) {
			if (cArr[i] - '0' == 0)
				cArr[i] = '1';
			else
				cArr[i] = '0';
		}
		return Integer.parseUnsignedInt(String.copyValueOf(cArr), 2);
	}
}