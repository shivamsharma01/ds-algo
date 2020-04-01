package bytebybyte;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Permutations {

	public static void main(String[] args) {
		List<String> stringPermutations = new ArrayList<String>();
		Scanner scan = new Scanner(System.in);
		permutations("", scan.next(), stringPermutations);
		printPermutations(stringPermutations);

		List<int[]> intPermutations = new ArrayList<int[]>();
		int[] a = new int[scan.nextInt()];
		for (int i = 0; i < a.length; i++) {
			a[i] = scan.nextInt();
		}
		permutations(0, a, intPermutations);
		printPermutations(intPermutations, intPermutations.size());
		scan.close();
	}

	public static void permutations(int start, int[] a, List<int[]> results) {
		if (start == a.length) {
			results.add(a.clone());
		}
		for (int i = start; i < a.length; i++) {
			swap(a, start, i);
			permutations(start + 1, a, results);
			swap(a, start, i);
		}
	}

	private static void swap(int[] a, int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}

	public static void permutations(String prefix, String suffix, List<String> results) {
		if (suffix.length() == 0) {
			results.add(prefix);
		}
		for (int i = 0; i < suffix.length(); i++) {
			permutations(prefix + suffix.charAt(i), suffix.substring(0, i) + suffix.substring(i + 1, suffix.length()),
					results);
		}
	}

	private static void printPermutations(List<String> list) {
		for (String result : list) {
			System.out.println(result);
		}
	}

	private static void printPermutations(List<int[]> list, int length) {
		for (int i = 0; i < length; i++) {
			System.out.print("{");
			for (int j = 0; j < list.get(i).length; j++) {
				System.out.print(j < list.get(i).length - 1 ? list.get(i)[j] + ",\t" : list.get(i)[j] + "}\n");
			}
		}

	}

}
