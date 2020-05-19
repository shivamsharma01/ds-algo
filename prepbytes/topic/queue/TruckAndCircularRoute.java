package prepbytes.topic.queue;

import java.util.Scanner;

public class TruckAndCircularRoute {

	public static void main(String[] args) throws InterruptedException {
		Scanner sc = new Scanner(System.in);
		int size = sc.nextInt();
		int[] gas = new int[size];
		int[] cost = new int[size];
		for (int i = 0; i < size; i++)
			gas[i] = sc.nextInt();
		for (int i = 0; i < size; i++)
			cost[i] = sc.nextInt();
		System.out.println(checkRoute(gas, cost, size));

	}

	static int checkRoute(int[] gas, int[] cost, int n) {
		int start = 0;
		int end = 1;
		int curr_petrol = gas[start] - cost[start];
		while (end != start || curr_petrol < 0) {
			while (curr_petrol < 0 && start != end) {
				curr_petrol -= gas[start] - cost[start];
				start = (start + 1) % n;
				if (start == 0)
					return -1;
			}
			curr_petrol += gas[end] - cost[end];
			end = (end + 1) % n;
		}
		return start;
	}

}
