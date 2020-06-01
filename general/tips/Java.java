package general.tips;

import java.util.List;

public class Java {
	public static void main(String[] args) {

	}

	// list to int[]
	public static int[] getAtIntArray(List<Integer> list) {
		return list.stream().mapToInt(e -> e.intValue()).toArray();
	}
}
