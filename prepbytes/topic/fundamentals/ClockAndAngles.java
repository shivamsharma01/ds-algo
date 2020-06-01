package prepbytes.topic.fundamentals;

import java.util.Scanner;

public class ClockAndAngles {

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		byte t = sc.nextByte();
		while (t-- > 0) {
			int hr = sc.nextInt(), min = sc.nextInt(), ans;
			hr = (int) (hr * 30 + min * 0.5);
			min = min * 6;
			ans = Math.abs(hr - min);
			if (ans <= 180)
				System.out.println(ans);
			else
				System.out.println(360 - ans);
		}
	}

}