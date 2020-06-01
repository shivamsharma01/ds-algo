package leetcode.thirty_days_challenge.may;

public class CountingBits {
	public static void main(String args[]) {
		CountingBits o = new CountingBits();
		int num = 10;
		int[] arr = o.countBits(num);
		for (int i = 0; i <= num; i++)
			System.out.print(arr[i] + " ");

	}

	public int[] countBits(int num) {
		int[] arr = new int[num + 1];
		for (int i = 1; i <= num; i++)
			arr[i] = arr[i / 2] + i % 2;
		return arr;
	}

}
