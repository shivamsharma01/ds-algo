package leetcode.problems.easy;

// https://leetcode.com/problems/construct-the-rectangle/
public class ConstructTheRectangle {
	public static void main(String[] args) {
		int[] arr = constructRectangle(4);
		System.out.print("[");
		for (int i : arr)
			System.out.print(i + " ");
		System.out.print("]\n");
	}

	public static int[] constructRectangle(int area) {
		int dif = Integer.MAX_VALUE;
		int[] out = null;
		for (int l = 1, w; l * l <= area; l++) {
			w = area / l;
			if (w * l == area && w - l < dif) {
				dif = w - l;
				out = new int[] { w, l };
			}
		}
		return out;
	}

}
