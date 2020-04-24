package prepbytes.topic.sorting;

import java.util.Scanner;

public class PokemonBattle {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int t = scan.nextInt();
		while (t-- > 0) {
			int[] teamGRevolution = new int[scan.nextInt()], opponents = new int[teamGRevolution.length];
			for (int i = 0; i < teamGRevolution.length; i++)
				teamGRevolution[i] = scan.nextInt();
			for (int i = 0; i < opponents.length; i++)
				opponents[i] = scan.nextInt();
			mergeSort(teamGRevolution, 0, teamGRevolution.length - 1);
			mergeSort(opponents, 0, opponents.length - 1);
			int opponentIndex = 0, wins = 0, count = 0;
			while (count < opponents.length) {
				if (teamGRevolution[count++] > opponents[opponentIndex]) {
					wins++;
					opponentIndex++;
				}
			}
			System.out.println(wins);
		}
	}

	private static void mergeSort(int[] arr, int left, int right) {
		if (left < right) {
			int middle = (left + right) / 2;
			mergeSort(arr, left, middle);
			mergeSort(arr, middle + 1, right);
			merge(arr, left, middle, right);
		}
	}

	private static void merge(int[] arr, int left, int middle, int right) {
		int[] t1 = new int[middle - left + 2];
		int[] t2 = new int[right - middle + 1];
		for (int i = 0; i <= middle - left; i++)
			t1[i] = arr[left + i];
		for (int i = 0; i < right - middle; i++)
			t2[i] = arr[middle + i + 1];
		t1[t1.length - 1] = Integer.MAX_VALUE;
		t2[t2.length - 1] = Integer.MAX_VALUE;
		int i1 = 0, i2 = 0;
		for (int i = left; i <= right; i++) {
			if (t1[i1] < t2[i2])
				arr[i] = t1[i1++];
			else
				arr[i] = t2[i2++];
		}
	}
}
