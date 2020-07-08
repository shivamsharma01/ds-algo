package prepbytes.topic.segment_tree;

import java.io.IOException;
import java.util.Scanner;

public class GoodElements {
	static int n;
	static int[] arr;
	static int[][] segment;
	static int MOD = 1000000007;

	public static void main(String args[]) throws IOException {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		arr = createInputArray(sc);
		createSegment(arr);
		int q = sc.nextInt();
		while (q-- > 0) {
			byte type = sc.nextByte();
			int qLow = sc.nextInt(), qHigh = sc.nextInt();
			switch (type) {
			case 1:
				replaceElement(qLow - 1, qHigh);
				break;
			case 2: 
				System.out.println(rangeQuery(0, n - 1, qLow - 1, qHigh - 1, 0)[0]);
			}
		}
	}

	private static int[] createInputArray(Scanner sc) {
		int[] arr = new int[n];
		for (int i = 0; i < n; i++)
			arr[i] = sc.nextInt();
		return arr;
	}

	private static void createSegment(int[] arr) {
		segment = new int[getSegmentSize()][];
		createSegment(arr, 0, n - 1, 0);
	}

	private static int getSegmentSize() {
		int x = (int) (Math.ceil(Math.log(n) / Math.log(2)));
		return 2 * (int) Math.pow(2, x) - 1;
	}

	private static void createSegment(int[] arr, int low, int high, int pos) {
		if (low == high) {
			segment[pos] = new int[] { arr[low] };
			return;
		}
		int mid = low + (high - low) / 2;
		createSegment(arr, low, mid, pos * 2 + 1);
		createSegment(arr, mid + 1, high, pos * 2 + 2);
		setParent2DSegmentSize(pos);
		fill2DSegment(pos);
	}

	private static void fill2DSegment(int pos) {
		int cp1 = pos * 2 + 1, cp2 = cp1 + 1;
		int l1 = segment[cp1].length, l2 = segment[cp2].length;
		if (l1 == 1) {
			segment[pos][1] = segment[cp1][0];
			if (l2 == 1)
				segment[pos][2] = segment[cp2][0];
			else {
				segment[pos][0] = (segment[pos][0] + segment[cp2][0]) % MOD;
				for (int i = 1; i < l2; i++)
					segment[pos][i + 1] = segment[cp2][i];
			}
		} else {
			segment[pos][0] = (segment[pos][0] + segment[cp1][0]) % MOD;
			for (int i = 1; i < l1; i++)
				segment[pos][i] = segment[cp1][i];
			if (l2 == 1)
				segment[pos][l1] = segment[cp2][0];
			else {
				segment[pos][0] = (segment[pos][0] + segment[cp2][0]) % MOD;
				for (int i = 1; i < l2; i++)
					segment[pos][i + l1 - 1] = segment[cp2][i];
			}
		}
		calculateSum(pos, cp1, cp2);
	}

	private static void calculateSum(int pos, int cp1, int cp2) {
		int l1 = segment[cp1].length, l2 = segment[cp2].length, sum = 0, num1, num2;
		if (l1 == 1 && l2 == 1) {
			num1 = segment[cp1][0];
			num2 = segment[cp2][0];
			if (isNonZeroPair(num1, num2))
				segment[pos][0] = (num1 * num2) % MOD;
		} else if (l1 == 1) {
			num1 = segment[cp1][0];
			for (int i = 1; i < l2; i++) {
				num2 = segment[cp2][i];
				if (isNonZeroPair(num2, num1))
					sum = (sum + num2) % MOD;
			}
			sum = (sum * num1) % MOD;
			segment[pos][0] = (segment[pos][0] + sum) % MOD;
		} else if (l2 == 1) {
			num1 = segment[cp2][0];
			for (int i = 1; i < l1; i++) {
				num2 = segment[cp1][i];
				if (isNonZeroPair(num2, num1))
					sum = (sum + num2) % MOD;
			}
			sum = (sum * num1) % MOD;
			segment[pos][0] = (segment[pos][0] + sum) % MOD;
		} else {
			for (int i = 1; i < l2; i++) {
				num1 = segment[cp2][i];
				for (int j = 1; j < l1; j++) {
					num2 = segment[cp1][j];
					if (isNonZeroPair(num2, num1))
						sum = (sum + num2) % MOD;
				}
				sum = (sum * num1) % MOD;
				segment[pos][0] = (segment[pos][0] + sum) % MOD;
				sum = 0;
			}
		}
	}

	private static boolean isNonZeroPair(int num1, int num2) {
		while (num1 != 0 && num2 != 0) {
			if (num1 % 10 != 0 && num2 % 10 != 0)
				return false;
			num1 /= 10;
			num2 /= 10;
		}
		return true;
	}

	private static void setParent2DSegmentSize(int pos) {
		int left = segment[pos * 2 + 1].length == 1 ? 1 : segment[pos * 2 + 1].length - 1,
				right = segment[pos * 2 + 2].length == 1 ? 1 : segment[pos * 2 + 2].length - 1;
		segment[pos] = new int[1 + left + right];
	}

	private static void replaceElement(int index, int value) {
		replaceElement(0, n - 1, index, value, 0);
	}

	private static void replaceElement(int low, int high, int index, int newValue, int pos) {
		if (high < index || low > index)
			return;
		if (low == high) {
			segment[pos][0] = newValue;
			return;
		}
		int mid = low + (high - low) / 2, oldValue = segment[pos][index - low + 1];
		segment[pos][index - low + 1] = newValue;
		if (index <= mid) {
			int child = pos * 2 + 1, l1 = segment[child].length;
			if (l1 > 1)
				segment[pos][0] = (segment[pos][0] - segment[child][0] + MOD) % MOD;
			replaceElement(low, mid, index, newValue, child);
			if (l1 > 1)
				segment[pos][0] = (segment[pos][0] + segment[child][0]) % MOD;
			updateSegment(segment[child + 1], pos, oldValue, newValue);
		} else {
			int child = pos * 2 + 2, l2 = segment[child].length;
			if (l2 > 1)
				segment[pos][0] = (segment[pos][0] - segment[child][0] + MOD) % MOD;
			replaceElement(mid + 1, high, index, newValue, child);
			if (l2 > 1)
				segment[pos][0] = (segment[pos][0] + segment[child][0]) % MOD;
			updateSegment(segment[child - 1], pos, oldValue, newValue);
		}
	}

	private static void updateSegment(int[] otherSegment, int pos, int oldValue, int newValue) {
		int sum1 = 0, sum2 = 0, num;
		if (otherSegment.length == 1) {
			if (isNonZeroPair(otherSegment[0], oldValue))
				sum1 = (otherSegment[0] * oldValue) % MOD;
			segment[pos][0] = (segment[pos][0] - (sum1 % MOD) + MOD) % MOD;
			if (isNonZeroPair(otherSegment[0], newValue))
				sum2 = (otherSegment[0] * newValue) % MOD;
			segment[pos][0] = (segment[pos][0] + (sum2 % MOD) + MOD) % MOD;
		} else {
			for (int i = 1; i < otherSegment.length; i++) {
				num = otherSegment[i];
				if (isNonZeroPair(num, oldValue))
					sum1 += num;
				if (isNonZeroPair(num, newValue))
					sum2 += num;
			}
			segment[pos][0] = (segment[pos][0] - (sum1 % MOD) + MOD) % MOD;
			segment[pos][0] = (segment[pos][0] + (sum2 % MOD) + MOD) % MOD;
		}
	}

	private static int[] rangeQuery(int low, int high, int qLow, int qHigh, int pos) {
		if (qLow > high || qHigh < low)
			return null;
		if (qLow <= low && qHigh >= high)
			return segment[pos];
		int mid = low + (high - low) / 2;
		int[] seg1 = rangeQuery(low, mid, qLow, qHigh, pos * 2 + 1),
				seg2 = rangeQuery(mid + 1, high, qLow, qHigh, pos * 2 + 2);
		if (seg1 == null)
			return seg2;
		else if (seg2 == null)
			return seg1;
		else {
			int len = 1 + (seg1.length == 1 ? 1 : seg1.length - 1) + (seg2.length == 1 ? 1 : seg2.length - 1);
			int[] seg = new int[len];
			calculateSum(seg, seg1, seg2);
			return seg;
		}
	}

	private static void calculateSum(int[] seg, int[] seg1, int[] seg2) {
		int l1 = seg1.length, l2 = seg2.length, sum = 0, num1, num2, index = 1;
		if (l1 == 1 && l2 == 1) {
			if (isNonZeroPair(seg1[0], seg2[0]))
				seg[0] = (seg1[0] * seg2[0]) % MOD;
			seg[1] = seg1[0];
			seg[2] = seg2[0];
		} else if (l1 == 1) {
			num1 = seg1[0];
			seg[0] = (seg[0] + seg2[0]) % MOD;
			seg[index++] = num1;
			for (int i = 1; i < l2; i++) {
				num2 = seg2[i];
				seg[index++] = num2;
				if (isNonZeroPair(num2, num1))
					sum = (sum + num2) % MOD;
			}
			sum = (sum * num1) % MOD;
			seg[0] = (seg[0] + sum) % MOD;
		} else if (l2 == 1) {
			num1 = seg2[0];
			seg[0] = (seg[0] + seg1[0]) % MOD;
			for (int i = 1; i < l1; i++) {
				num2 = seg1[i];
				seg[index++] = num2;
				if (isNonZeroPair(num2, num1))
					sum = (sum + num2) % MOD;
			}
			seg[index++] = num1;
			sum = (sum * num1) % MOD;
			seg[0] = (seg[0] + sum) % MOD;
		} else {
			seg[0] = (seg[0] + seg1[0]) % MOD;
			for (int i = 1; i < l1; i++)
				seg[index++] = seg1[i];
			seg[0] = (seg[0] + seg2[0]) % MOD;
			for (int i = 1; i < l2; i++)
				seg[index++] = seg2[i];
			for (int i = 1; i < l2; i++) {
				num1 = seg2[i];
				for (int j = 1; j < l1; j++) {
					num2 = seg1[j];
					if (isNonZeroPair(num2, num1))
						sum = (sum + num2) % MOD;
				}
				sum = (sum * num1) % MOD;
				seg[0] = (seg[0] + sum) % MOD;
				sum = 0;
			}
		}
	}

}