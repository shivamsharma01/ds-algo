package leetcode.thirty_days_challenge.may;

import java.util.HashMap;
import java.util.Map;

public class ContiguousArray {
	public int findMaxLength(int[] nums) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		map.put(0, -1);
		int count = 0, maxSubArray = 0;
		for (int i = 0; i < nums.length; i++) {
			count += (nums[i] == 0) ? 1 : -1;
			if (map.containsKey(count)) {
				maxSubArray = Math.max(maxSubArray, i - map.get(count));
			} else {
				map.put(count, i);
			}
		}
		return maxSubArray;
	}
}
