package codechef.Beginner;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://www.codechef.com/problems/AMR15A
public class Mahasena {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws java.lang.Exception {
		try {
			int count = 0, n = next();
			String[] input = br.readLine().split(" ");
			for (int i = 0; i < n; i++)
				count += Integer.parseInt(input[i]) % 2 == 0 ? 1 : 0;
			if (count > n / 2)
				System.out.println("READY FOR BATTLE");
			else
				System.out.println("NOT READY");
		} catch (Exception t) {
		}
	}

	private static int next() throws IOException {
		return Integer.parseInt(br.readLine());
	}

}
