package leetcode.thirty_days_challenge.may;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/implement-trie-prefix-tree/
public class Trie {
	public static void main(String args[]) throws IOException {
		Trie o = new Trie();
		System.out.println(o.search("s"));
		System.out.println(o.startsWith("s"));
		o.insert("shivam");
		System.out.println(o.search("shivam"));
		System.out.println(o.startsWith("shivam"));

	}

	/** Initialize your data structure here. */
	Map<String, Boolean> map = new HashMap<>();

	public Trie() {

	}

	/** Inserts a word into the trie. */
	public void insert(String word) {
		String s = "";
		for (char c : word.toCharArray()) {
			s += c;
			if (!map.containsKey(s))
				map.put(s, false);
		}
		map.put(word, true);
	}

	/** Returns if the word is in the trie. */
	public boolean search(String word) {
		return map.containsKey(word) && map.get(word) == true;
	}

	/**
	 * Returns if there is any word in the trie that starts with the given prefix.
	 */
	public boolean startsWith(String prefix) {
		return map.containsKey(prefix);
	}
}
