package bytebybyte;

public class NoOfOneInBinary {
	public static void main(String[] args) {
		int num = 127;
		int result = noOfOnes(num);
		System.out.println("number of 1s in " + num + " is " + result);
	}

	public static int noOfOnes(int num) {
		int sum = 0;
			while(num != 0) {
				sum += num & 1;
				num >>= 1;
			}
		return sum;
	}
}
