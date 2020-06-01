package codechef.cookoff.year2020.may;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// https://www.codechef.com/COOK118B/problems/CHEFRECP
public class ChefAndRecipe {

	public static void main(String[] args) throws java.lang.Exception {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			byte t = Byte.parseByte(br.readLine());
			while (t-- > 0) {
				short n = Short.parseShort(br.readLine());
				String[] input = br.readLine().split(" ");
				boolean[] usedIngredientArr = new boolean[1000 + 1];
				boolean[] quantityArr = new boolean[1000 + 1];
				int quantity = 1, prev = Integer.parseInt(input[0]), cur;
				usedIngredientArr[prev] = true;
				String output = "YES";
				for (short i = 1; i < n; i++) {
					cur = Integer.parseInt(input[i]);
					if (usedIngredientArr[cur] && prev != cur) {
						output = "NO";
						break;
					}
					usedIngredientArr[cur] = true;
					if (prev == cur)
						quantity++;
					else {
						if (quantityArr[quantity]) {
							output = "NO";
							break;
						}
						quantityArr[quantity] = true;
						quantity = 1;
					}
					prev = cur;
					if (i == n - 1 && quantityArr[quantity])
						output = "NO";
				}
				System.out.println(output);
			}
		} catch (Exception e) {

		}
	}

}
