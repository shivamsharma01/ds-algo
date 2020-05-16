package leetcode.thirty_days_challenge.may;

public class MaximumSumCircularSubarray {

	public static void main(String[] args) throws InterruptedException {
		MaximumSumCircularSubarray o = new MaximumSumCircularSubarray();
		// System.out.println(o.maxSubarraySumCircular(new int[] { 5, -3, 5 }));
//		System.out.println(o.maxSubarraySumCircular(new int[] { 1, -2, 3, -2 }));
//		System.out.println(o.maxSubarraySumCircular(new int[] { 3, -1, 2, -1 }));
//		System.out.println(o.maxSubarraySumCircular(new int[] { 3, -2, 2, -3 }));
		System.out.println(o.maxSubarraySumCircular(new int[] { -2, -3, -1 }));
	}

	public int maxSubarraySumCircular(int[] A) throws InterruptedException {
		int max = Integer.MIN_VALUE, sum = 0;
		long[] total = new long[A.length];
		for (int i = 0, index, j; i < A.length; i++) {
			index = i;
			sum = A[index];
			total[index] = index > 0 ? A[index] + total[index - 1] : A[0];
			max = Math.max(max, sum);
			if (index > 0 && A[index - 1] > 0)
				continue;
			j = i + A.length;
			while (++index < j && sum > 0) {
				sum += A[index % A.length];
				max = Math.max(max, sum);
			}
		}
		return max;
	}

}
