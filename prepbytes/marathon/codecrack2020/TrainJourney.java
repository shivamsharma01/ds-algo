package prepbytes.marathon.codecrack2020;

import java.util.Scanner;

public class TrainJourney {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t-- > 0) {
			int seat = sc.nextInt(), opposite;
			String seatType;
			if (((seat - 1) / 6) % 2 == 0)
				opposite = seat + 1 + 2 * (5 - ((seat - 1) % 6));
			else
				opposite = seat - 1 - 2 * ((seat - 1) % 6);
			seatType = seat % 6 == 0 || seat % 6 == 1 ? "WS" : seat % 6 == 2 || seat % 6 == 5 ? "MS" : "AS";
			System.out.println(opposite + " " + seatType);
		}
	}

}
