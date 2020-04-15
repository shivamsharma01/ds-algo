package prepbytes.questions.string;

import java.io.IOException;
import java.util.Scanner;

public class PlayingCards {
	public static void main(String args[]) throws IOException {

		// write your code here
		Scanner scan = new Scanner(System.in);
		byte testCases = scan.nextByte();
		for (byte test = 0; test < testCases; test++) {
			String tableCard = scan.next();
			char rank = tableCard.charAt(0);
			char suit = tableCard.charAt(1);
			String[] cards = new String[5];
			for (byte i = 0; i < 5; i++) {
				cards[i] = scan.next();
			}
			boolean isFound = false;
			for (String card : cards) {
				if (card.charAt(0) == rank || card.charAt(1) == suit) {
					isFound = true;
					break;
				}
			}
			if (isFound) {
				System.out.println("YES");
			} else {
				System.out.println("NO");
			}
		}
	}
}
