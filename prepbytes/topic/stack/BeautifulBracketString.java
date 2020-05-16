package prepbytes.topic.stack;

import java.util.Scanner;

public class BeautifulBracketString {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int count = 0;
		while (true) {
			char[] input = sc.next().toCharArray();
			if (input[0] == '-')
				break;
			int left = 0, operations = 0, closing = 0;
			for (char c : input) {
				if (c == '{')
					left++;
				else
					left--;
				if (left == -1) {
					closing++;
					left = 0;
					if (closing == 2) {
						operations += 1;
						closing = 0;
					}
				}
			}
			operations += left / 2;
			operations += left % 2 + closing;
			System.out.println(++count + ". " + operations);
		}
	}

}
