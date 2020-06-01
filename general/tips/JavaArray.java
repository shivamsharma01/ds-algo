package general.tips;

import java.util.Arrays;

public class JavaArray {
	public static void main(String[] args) {

	}

	private static int[][] copySub(int[][] points, int K) {
		return Arrays.copyOfRange(points, 0, K);
	}
}
