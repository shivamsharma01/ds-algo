package leetcode.problems.easy;

import java.util.HashMap;
import java.util.List;

// https://leetcode.com/problems/destination-city
public class DestinationCity {

	public static void main(String[] args) {
		// System.out.println(new DestinationCity().destCity([["London","New
		// York"],["New York","Lima"],["Lima","Sao Paulo"]])); // "Sao Paulo"
	}

	public String destCity(List<List<String>> paths) {
		HashMap<String, String> map = new HashMap<>();
		for (List<String> l : paths)
			map.put(l.get(0), l.get(1));
		for (String value : map.values()) {
			if (!map.containsKey(value))
				return value;
		}
		return "";
	}

}
