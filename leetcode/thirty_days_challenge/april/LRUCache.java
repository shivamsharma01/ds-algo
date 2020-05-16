package leetcode.thirty_days_challenge.april;

import java.util.LinkedHashMap;

/*
 * ["LRUCache","put","put","put","get","get","get"]
 * [[2],[1,1],[2,2],[3,3],[1],[2],[3]]
 * 
 * Expected Answer
 * [null,null,null,null,-1,2,3]
 */
class LRUCache {
	final int capacity;
	final LinkedHashMap<Integer, Integer> cache;

	public LRUCache(int capacity) {
		this.capacity = capacity;
		cache = new LinkedHashMap<>(capacity);
	}

	public int get(int key) {
		Integer val = cache.get(key);
		if (val == null)
			return -1;
		else {
			cache.remove(key);
			cache.put(key, val);
		}
		return val;
	}

	public void put(int key, int value) {
		Integer val = cache.get(key);
		if (val != null) {
			cache.remove(key);
			cache.put(key, value);
		} else {
			if (cache.size() == capacity)
				cache.remove(cache.entrySet().iterator().next().getKey());
			cache.put(key, value);
		}
	}

}