package prepbytes.marathon.primetime;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

// https://mycode.prepbytes.com/contest/PRIMETIME/problems/GOODNODE
public class GoodNodes {
	public static void main(String args[]) throws IOException {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(), Q = sc.nextInt(), U, V;
		Map<Integer, List<Integer>> r = new HashMap<>();
		int[] arr = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			arr[i] = sc.nextInt();
			r.put(i, new ArrayList<>());
		}
		for (int i = 1; i < N; i++)
			r.get(sc.nextInt()).add(sc.nextInt());
		List<Integer> children;
		for (int i = N; i >= 1; i--) {
			children = r.get(i);
			if (children.size() == 2)
				arr[i] = arr[i] | arr[children.get(0)] | arr[children.get(1)];
			else if (children.size() == 1)
				arr[i] = arr[i] | arr[children.get(0)];
		}
		for (int i = 1; i <= Q; i++) {
			int k = sc.nextInt(), count = 0;
			for (int j = 1; j <= N; j++) {
				if ((arr[j] & k) == arr[j])
					count++;
			}
			System.out.println(count);
		}
	}
}
