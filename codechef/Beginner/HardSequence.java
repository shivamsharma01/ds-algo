package codechef.Beginner;

public class HardSequence {
	public static void main(String[] args) {
		System.out.println(getNthHardSequenceCount(11));
	}

	private static int getNthHardSequenceCount(int n) {
		int[] arr = new int[n + 1]; // [4, 3 ]
		int[] last = new int[n + 1];// [0, 0 , 0, 1, 0, 2]
		for (int i = 2; i < n + 1; i++) {
			int x = arr[i - 1];
			if (last[x] == 0) {
				arr[i] = 0;
				last[x] = i - 1;
			} else {
				arr[i] = (i - 1) - last[x];
				last[x] = i - 1;
			}
		}
		int count = 0;
		for (int i = 1; i <= n; i++) {
			if (arr[i] == arr[n])
				++count;
		}
		for (int i = 1; i <= n; i++) {
			System.out.print(arr[i] + "  ");
		}
		System.out.println("\n" + arr[n]);
		return count;
	}
}
