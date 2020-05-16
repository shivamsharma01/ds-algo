package leetcode.thirty_days_challenge.april;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class FirstUnique {
	public static void main(String[] args) {
		FirstUnique o = new FirstUnique(new int[] { 2, 3, 5 });
		System.out.println(o.showFirstUnique() + "\n\n");
		o.add(5);
		System.out.println(o.showFirstUnique() + "\n\n");
		o.add(2);
		System.out.println(o.showFirstUnique() + "\n\n");
		o.add(3);
		System.out.println(o.showFirstUnique());
	}

	LinkedHashSet<Integer> unique = new LinkedHashSet<>();
	Set<Integer> dup = new HashSet<>();

	public FirstUnique(int[] nums) {
		for (int i : nums)
			add(i);
		System.out.println(unique);
	}

	public int showFirstUnique() {
		return unique.size() != 0 ? unique.stream().sequential().findFirst().get() : -1;
	}

	public void add(int value) {
		if (dup.contains(value))
			return;
		if (unique.contains(value)) {
			unique.remove(value);
			dup.add(value);
		} else
			unique.add(value);
	}

}