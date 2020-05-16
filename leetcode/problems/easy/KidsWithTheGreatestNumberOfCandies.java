package leetcode.problems.easy;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

// https://leetcode.com/problems/kids-with-the-greatest-number-of-candies/
public class KidsWithTheGreatestNumberOfCandies {
	public static void main(String[] args) {
		KidsWithTheGreatestNumberOfCandies o = new KidsWithTheGreatestNumberOfCandies();
		List<Boolean> l = o.kidsWithCandies(new int[] { 2, 3, 4, 5 }, 2);
		for (boolean b : l) {
			System.out.print(b + " ");
		}
	}

	public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
		final int max = Arrays.stream(candies).max().getAsInt();
		return Arrays.stream(candies).mapToObj(e -> this.isGTE(e + extraCandies, max)).collect(Collectors.toList());
	}

	private boolean isGTE(int e, int target) {
		return e >= target;
	}
}
