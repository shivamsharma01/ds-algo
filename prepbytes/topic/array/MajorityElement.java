package prepbytes.topic.array;

/*
 * Moore's Voting Algorithm
 */
public class MajorityElement {
	public static void main(String[] args) {
		majorityElem(new int[] { 7, 2, 7, 3, 7, 2, 7, 7 });
	}

	private static void majorityElem(int[] arr) {
		int count = 0;
		Integer val = arr[0];
		for (int a : arr) {
			if (a != val) {
				count--;
				if (count == 0) {
					val = a;
					count = 1;
				}
			} else {
				count++;
			}
		}
		if (count < 1)
			System.out.println("No Majority Element");
		else {
			count = 0;
			for (int a : arr) {
				if (a == val) {
					count++;
				}
			}
			if (count > arr.length / 2) {
				System.out.println(val);
			} else {
				System.out.println("No Majority Element");
			}
		}
	}
}
