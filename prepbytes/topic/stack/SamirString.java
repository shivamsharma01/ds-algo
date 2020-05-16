package prepbytes.topic.stack;

import java.util.Scanner;

public class SamirString {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		byte t = sc.nextByte();
		while (t-- > 0) {
			String input = sc.next();
			StringBuilder output = new StringBuilder("");
			int index = 0, counter = 0, MaxInt = 0, max = 0;
			while (index != input.length()) {
				if (input.charAt(index++) == 'I') {
					if (index != 1) {
						output.append(max);
					} else {
						output.append(++MaxInt);
					}
					counter = 1;
					while (index < input.length() && input.charAt(index) == 'I') {
						index++;
						counter++;
					}
					while (counter-- > 1) {
						output.append(++MaxInt);
					}
					if (index == input.length() && input.charAt(index - 1) == 'I')
						output.append(++MaxInt);
				} else {
					counter = 1;
					while (index < input.length() && input.charAt(index) == 'D') {
						index++;
						counter++;
					}
					if (output.toString().equals(""))
						MaxInt += counter;
					else
						MaxInt += counter + 1;
					max = MaxInt;
					output.append(max--);
					while (counter-- > 1) {
						output.append(max--);
					}
					if (index == input.length() && input.charAt(index - 1) == 'D')
						output.append(max);
				}
			}
			System.out.println(output);
		}
	}

}
