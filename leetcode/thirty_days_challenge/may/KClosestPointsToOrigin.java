package leetcode.thirty_days_challenge.may;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class KClosestPointsToOrigin {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int[][] kClosest(int[][] points, int K) {
		if (K == points.length)
			return points;
		else if (K == 0)
			return new int[][] {};
		Map<Integer, List<Integer>> map = new TreeMap<>();
		List<Integer> list;
		for (int i = 0; i < points.length; i++) {
			int sq = points[i][0] * points[i][0] + points[i][1] * points[i][1];
			list = map.get(sq);
			if (list == null)
				list = new ArrayList<>();
			list.add(i);
			map.put(sq, list);
		}
		int[][] out = new int[K][2];
		int index = 0;
		Iterator<Map.Entry<Integer, List<Integer>>> e = map.entrySet().iterator();
		while (index < K) {
			for (int i : e.next().getValue())
				out[index++] = points[i];
		}
		return out;
	}
}
