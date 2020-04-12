package prepbytes.array;

public class RainWater {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(getMaxWaterTrapped(new int[] { 0, 1, 2, 0, 0, 3, 1, 0, 3 }));
	}

	private static int getMaxWaterTrapped(int[] a) {
		int[] left = new int[a.length];
		int[] right = new int[a.length];

		left[0] = a[0];
		for (int i = 1; i < a.length; i++) {
			if (a[i] > left[i - 1]) {
				left[i] = a[i];
			} else {
				left[i] = left[i - 1];
			}
		}

		right[a.length - 1] = a[a.length - 1];
		for (int i = a.length - 2; i >= 0; i--) {
			if (a[i] > right[i + 1]) {
				right[i] = a[i];
			} else {
				right[i] = right[i + 1];
			}
		}

		int waterTrapped = 0;
		for (int i = 1; i < a.length - 1; i++) {
			waterTrapped += Math.min(left[i], right[i]) - a[i];
		}

		return waterTrapped;
	}

}
