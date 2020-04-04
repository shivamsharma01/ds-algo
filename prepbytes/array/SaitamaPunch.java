package prepbytes.array;

import java.io.IOException;
import java.util.Scanner;

public class SaitamaPunch {
	public static void main(String args[]) throws IOException {

		// write your code here
		Scanner scan = new Scanner(System.in);
		int testCases = scan.nextInt();
		for (int test = 0; test < testCases; test++) {
			int[] arr = new int[scan.nextInt()];
			int k = scan.nextInt();
			int runningParalysisEndTime = 0;
			int currentParalysisEndTime = 0;
			int totalParalysisTime = 0;
			for (int i = 0; i < arr.length; i++) {
				int punchAt = scan.nextInt();
				currentParalysisEndTime = punchAt + k;
				if (runningParalysisEndTime < punchAt) {
					totalParalysisTime += currentParalysisEndTime - punchAt;
					runningParalysisEndTime = currentParalysisEndTime;
				} else {
					totalParalysisTime += currentParalysisEndTime - runningParalysisEndTime;
					runningParalysisEndTime = currentParalysisEndTime;
				}
			}
			System.out.println(totalParalysisTime);
		}
	}

}