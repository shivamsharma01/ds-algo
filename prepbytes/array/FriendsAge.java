package prepbytes.array;

import java.util.Scanner;

public class FriendsAge {
	public static void main(String[] args) throws InterruptedException {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int[] ageCounts = new int[121];
		for (int i = 0; i < n; i++) {
			ageCounts[scan.nextInt()]++;
		}
		int num = numFriendRequests(ageCounts);
		System.out.println("Number of friend requests sent " + num);
	}

	public static int numFriendRequests(int[] ages) {
		int friendReqCount = 0;
		// for a < 14, b>a therefore can't send friend requests.
		for (int a = 14; a <= 120; a++) {
			for (int b = (int) ((0.5 * a) + 7) + 1; b <= a; b++) {
				friendReqCount += ages[a] * ages[b];
				if (a == b) {
					friendReqCount -= ages[a];
				}
			}
		}
		return friendReqCount;
	}

}
