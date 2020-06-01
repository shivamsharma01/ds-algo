package leetcode.problems.easy;

public class ReplaceElementsWithGreatestElementOnRightSide {

	public static void main(String[] args) {
		int[] arr = new ReplaceElementsWithGreatestElementOnRightSide()
				.replaceElements(new int[] { 17, 18, 5, 4, 6, 1 });
		for (int i : arr)
			System.out.print(i + " ");
	}

	public int[] replaceElements(int[] arr) {
		int index = arr.length - 1;
		int max = arr[index], tMax;
		arr[index] = -1;
		while (index-- > 0) {
			tMax = arr[index];
			arr[index] = max;
			max = Math.max(max, tMax);
		}
		return arr;
	}

}
