package google.kickstart;

import java.util.Arrays;
import java.util.Scanner;

public class FootBallCoach {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		byte t = scan.nextByte(), x = 0;
		while (++x <= t) {
			int n = scan.nextInt(), p = scan.nextInt();
			int[] arr = new int[n];
			for (int i = 0; i < n; i++)
				arr[i] = scan.nextInt();
			Arrays.sort(arr);
			System.out.println("Case #" + x + ": " + getHoursToTrain(arr, n, p));
		}
	}

	public static int getHoursToTrain(int[] arr, int n, int p) {
		int minHours, index = 0, hours = 0;
		while (++index <= p - 1) {
			hours += arr[n - 1] - arr[n - (index + 1)];
		}
		if (hours == 0)
			return hours;
		minHours = hours;
		for (int i = n - 2; i >= p - 1; i--) {
			hours = hours - (p - 1) * (arr[i + 1] - arr[i]) + (arr[i] - arr[i - p + 1]);
			minHours = Math.min(minHours, hours);
			if (minHours == 0)
				return minHours;
		}
		return minHours;
	}

}
