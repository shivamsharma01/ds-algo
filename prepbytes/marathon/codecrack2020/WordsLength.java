package prepbytes.marathon.codecrack2020;

import java.util.Arrays;
import java.util.Scanner;

public class WordsLength {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] input = sc.nextLine().split(" ");
		Arrays.stream(input).map(e -> e.length()).sorted().forEach(e -> {
			System.out.print(e + " ");
		});
	}
}
