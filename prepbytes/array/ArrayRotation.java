package prepbytes.array;

/**
 * Reversal Algo
 */
public class ArrayRotation {
	public static void main(String[] args) {
		int[] arr = new int[] { 1, 2, 3, 4, 5, 6, 7 };
		int rotationLeft = 4;
		int rotationRight = 4;
		System.out.println("After Rotating \n");
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + "\t");
		}
		System.out.println("\n left " + rotationLeft + " times");
		rotateLeft(arr, rotationLeft);
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + "\t");
		}

		System.out.println("\nAfter Rotating \n");
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + "\t");
		}
		System.out.println("\n right " + rotationRight + " times");
		rotateRight(arr, rotationRight);
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + "\t");
		}

	}

	private static void rotateLeft(int[] arr, int k) {
		int n = arr.length;
		int splitIndex = k % n;
		int temp = 0;
		for (int i = 0; i <= (splitIndex / 2) - 1; i++) {
			temp = arr[i];
			arr[i] = arr[splitIndex - i - 1];
			arr[splitIndex - i - 1] = temp;
		}
		for (int i = splitIndex; i <= (n + splitIndex) / 2 - 1; i++) {
			temp = arr[i];
			arr[i] = arr[n - i + splitIndex - 1];
			arr[n - i + splitIndex - 1] = temp;
		}
		for (int i = 0; i < n / 2; i++) {
			temp = arr[i];
			arr[i] = arr[n - i - 1];
			arr[n - i - 1] = temp;
		}
	}

	private static void rotateRight(int[] arr, int k) {
		int n = arr.length;
		int splitIndex = k % n;
		int temp = 0;
		for (int i = 0; i < n / 2; i++) {
			temp = arr[i];
			arr[i] = arr[n - i - 1];
			arr[n - i - 1] = temp;
		}
		for (int i = 0; i <= (splitIndex / 2) - 1; i++) {
			temp = arr[i];
			arr[i] = arr[splitIndex - i - 1];
			arr[splitIndex - i - 1] = temp;
		}
		for (int i = splitIndex; i <= (n + splitIndex) / 2 - 1; i++) {
			temp = arr[i];
			arr[i] = arr[n - i + splitIndex - 1];
			arr[n - i + splitIndex - 1] = temp;
		}
	}

}
