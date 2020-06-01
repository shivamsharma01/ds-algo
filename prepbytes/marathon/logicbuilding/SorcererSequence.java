package prepbytes.marathon.logicbuilding;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SorcererSequence {

	public static void main(String args[]) throws IOException {
		Scanner sc = new Scanner(System.in);
		byte t = sc.nextByte();
		Map<Long, String> map = new HashMap<Long, String>();
		while (t-- > 0)
			System.out.println(getResult(map, sc.nextInt()));
	}

	private static String getResult(Map<Long, String> map, long n) {
		if (n == 1)
			return "1";
		if (map.containsKey(n))
			return map.get(n);
		double temp = Math.sqrt(n);
		String output = n + " ";
		if (n % 2 == 1)
			output += getResult(map, (long) (temp * temp * temp));
		else
			output += getResult(map, (long) temp);
		map.put(n, output);
		return output;
	}

}
