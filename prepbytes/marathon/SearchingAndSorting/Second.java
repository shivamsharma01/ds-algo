package prepbytes.marathon.SearchingAndSorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Second {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int[] arr = new int[n];
		int[] sorted = new int[n];
		List<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < n; i++) {
			sorted[i] = scan.nextInt();
			arr[i] = sorted[i];
			list.add(sorted[i]);
		}
//		for (int i : sorted) {
//			System.out.print(i + " ");
//		}
		Arrays.sort(sorted);
		for (int i : sorted) {
			System.out.print(i + " ");
		}
		System.out.println("usingQueue " + usingQueue(list, sorted));
		// System.out.println(linkedList(root, node, sorted));
	}

	private static int usingQueue(List<Integer> list, int[] sorted) {
		Integer[] arr = new Integer[sorted.length];
		arr = list.toArray(arr);
		Queue<Integer> q = new LinkedList<>();
		int operations = 0, index = 0;
		for (int i = 0; i < arr.length; i++)
			q.add(arr[i]);
		while (!q.isEmpty()) {
			operations++;
			if (q.peek() == sorted[index]) {
				index++;
				System.out.println(q + " " + operations + " index=" + index);
			} else
				q.add(q.peek());
			q.remove();
		}
		return operations;
	}

	private static int countOccurances(int[] arr, int start, int elm) {
		int count = 1;
		while (++start != arr.length) {
			if (arr[start] == elm)
				count++;
			else
				break;
		}
		return count;
	}

}
