package prepbytes.topic.maths;

import java.util.Scanner;

public class CarsAndSpeed {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		byte t = scan.nextByte();
		while (t-- > 0) {
			System.out.println(sameSpeedCars(scan.nextShort(), scan.nextShort(), scan.nextInt()));
		}
	}

	private static int sameSpeedCars(short bmw, short audi, int k) {
		int maxBMWSpeed = (k / bmw) * bmw;
		int maxAudiSpeed = (k / audi) * audi;
		return Math.min(maxBMWSpeed, maxAudiSpeed) / lcm(Math.max(bmw, audi), Math.min(bmw, audi));
	}

	private static int lcm(int a, int b) {
		return a * b / gcd(a, b);
	}

	private static int gcd(int a, int b) {
		if (b == 0)
			return a;
		return gcd(b, a % b);
	}

}
