package codechef.easy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

// https://www.codechef.com/problems/CLEANUP
public class CleaningUp {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) {
		try {
			byte t = Byte.parseByte(br.readLine());
			while (t-- > 0) {
				String[] input = br.readLine().split(" ");
				int n = Integer.parseInt(input[0]);
				int[] finishedJobs = new int[Integer.parseInt(input[1])];
				input = br.readLine().split(" ");
				for (int i = 0; i < finishedJobs.length; i++)
					finishedJobs[i] = Integer.parseInt(input[i]);
				Arrays.sort(finishedJobs);
				int count = 1, index = 0;
				StringBuilder chef = new StringBuilder(""), assistant = new StringBuilder("");
				while (count <= n && index < finishedJobs.length) {
					if (count < finishedJobs[index]) {
						if (chef.length() <= assistant.length())
							chef.append(count + " ");
						else
							assistant.append(count + " ");
					} else
						index++;
					count++;
				}
				while (count <= n) {
					if (chef.length() <= assistant.length())
						chef.append(count + " ");
					else
						assistant.append(count + " ");
					count++;
				}
				System.out.println(chef);
				System.out.println(assistant);
			}
		} catch (Exception e) {
		}
	}
}
