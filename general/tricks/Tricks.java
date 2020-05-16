package general.tricks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Tricks {

	public static void main(String[] args) {
		formatStringAndFillSpace();
		checkIfDoubleHasDecimal();
	}

	private static void formatStringAndFillSpace() {
		for (int i = 1; i <= 100; i++) {
			//
			String s = String.format("%16s", Integer.toBinaryString(i)).replace(' ', '0');
			System.out.println(s);
		}
	}

	private static void checkIfDoubleHasDecimal() {
		double a = 5;
		System.out.println(a); // 5.0
		if (a % 1 == 0)
			System.out.println((int) a); // 5

	}

	private static void takeinput(int n) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int a[] = new int[n];
		String line = br.readLine(); // to read multiple integers line
		String[] strs = line.trim().split("\\s+");
		for (int i = 0; i < n; i++) {
			a[i] = Integer.parseInt(strs[i]);
		}
	}
	
}
