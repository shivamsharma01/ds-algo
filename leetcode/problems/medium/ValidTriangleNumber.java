package leetcode.problems.medium;

class ValidTriangleNumber {

	public static void main(String[] args) {
		ValidTriangleNumber o = new ValidTriangleNumber();
		System.out.println(o.triangleNumber(new int[] { 82, 15, 23, 82, 67, 0, 3, 92, 11 }));
	}

	public int triangleNumber(int[] nums) {
		int[] store = new int[1000 + 1], inc = new int[1000 + 1];
		for (int i : nums)
			store[i]++;
		for (int i = 1; i < inc.length; i++)
			inc[i] = store[i] + inc[i - 1];
		int totalTriangles = 0;
		for (int i = 1; i < store.length; i++) {
			if (store[i] == 0)
				continue;
			if (store[i] > 2)
				totalTriangles += getPairs(store[i], 3);
			if (store[i] > 1)
				totalTriangles += getPairs(store[i], 2) * ((inc[2 * i - 1] - inc[i]) + (inc[i - 1]));
			for (int j = i + 1; i + j <= store.length; j++) {
				if (store[j] == 0)
					continue;
				totalTriangles += store[i] * store[j] * (inc[i + j - 1] - inc[j]);
			}
		}
		return totalTriangles;
	}

	private int getPairs(int n, int r) {
		if (r == 3 && n == 3 || r == 2 && n == 2)
			return 1;
		int sum = n;
		for (int i = n - 1; i > Math.max(r, n - r); i--)
			sum *= i;
		for (int i = 2; i <= Math.min(r, n - r); i++)
			sum /= i;
		return sum;
	}

}