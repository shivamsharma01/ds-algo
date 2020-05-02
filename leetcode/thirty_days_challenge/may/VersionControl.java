package leetcode.thirty_days_challenge.may;

public class VersionControl {
	static int firstBadVersion = 0;

	public static void main(String[] args) {
		Solution s = new Solution();
		int n = (int) (Math.random() * 1000000000);
		System.out.println("n is " + n);
		firstBadVersion = (int) (Math.random() * n) + 1;
		System.out.println(firstBadVersion);
		System.out.println(s.firstBadVersion(n));

	}

	public boolean isBadVersion(int num) {
		return num >= firstBadVersion;
	}
}

class Solution extends VersionControl {

	public int firstBadVersion(int n) {
		int i = 1;
		int j = n;
		int mid = 0;
		while (i != j) {
			mid = i + (j - i) / 2;
			if (!(isBadVersion(mid)))
				i = mid + 1;
			else
				j = mid;
		}
		return i;
	}

}
