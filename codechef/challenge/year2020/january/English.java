package codechef.challenge.year2020.january;

import java.util.Scanner;

public class English {

	static class Node {
		int ch;
		Node[] v;

		Node() {
			v = new Node[26 * 26];
		}
	}

	static Node root;

	static void add(String s) {
		int n = s.length();
		Node t = root;
		for (int i = 0; i < n; i++) {
			int x = 26 * (s.charAt(i) - 'a') + (s.charAt(n - (i + 1)) - 'a');
			if (t.v[x] == null)
				t.v[x] = new Node();
			t = t.v[x];
			t.ch++;
		}
	}

	static long solve(Node root, long h) {
		if (root == null)
			return 0;
		long ans = root.ch / 2 * ((h * h) - (h - 1) * (h - 1));
		for (Node n : root.v)
			ans += solve(n, h + 1);
		return ans;
	}

	public static void main(String[] args) {
		try {
			Scanner sc = new Scanner(System.in);
			int t = Integer.parseInt(sc.nextLine());
			while (t-- > 0) {
				root = new Node();
				int n = Integer.parseInt(sc.nextLine());
				while (n-- > 0)
					add(sc.nextLine());
				System.out.println(solve(root, 0));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}