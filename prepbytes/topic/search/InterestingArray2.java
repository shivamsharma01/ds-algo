package prepbytes.topic.search;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public class InterestingArray2 {

	public static void main(String args[]) throws IOException {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt(), k = scan.nextInt(), val, pairs = 0;
		Map<Integer, Integer> store = new HashMap<>();
		Integer storeVal;

		for (int i = 0; i < n; i++) {
			val = scan.nextInt();
			storeVal = store.get(val);
			if (storeVal != null)
				store.put(val, ++storeVal);
			else
				store.put(val, 1);
		}

		Iterator<Map.Entry<Integer, Integer>> itr = store.entrySet().iterator();
		Map.Entry<Integer, Integer> entry;
		while (itr.hasNext()) {
			entry = itr.next();
			storeVal = store.get(entry.getKey() - k);
			if (storeVal != null)
				pairs += storeVal * entry.getValue();
			storeVal = store.get(entry.getKey() + k);
			if (storeVal != null)
				pairs += storeVal * entry.getValue();
			itr.remove();
		}
		System.out.println(pairs);
	}

}