package leetcode.thirty_days_challenge.may;

import java.util.ArrayList;
import java.util.List;

public class FindTheTownJudge {
	public static void main(String[] args) {
		FindTheTownJudge o = new FindTheTownJudge();
		System.out.println(o.findJudge(3, new int[][] { { 1, 3 }, { 2, 3 } }));
	}

	public int findJudge(int N, int[][] trust) {
		if (trust.length == 0)
			return 1;
		int memberOfTown = trust[0][0], index = 1;
		List<Integer> eligibleTownJudge = new ArrayList<Integer>();
		eligibleTownJudge.add(trust[0][1]);
		while (index < trust.length) {
			if (trust[index][0] == memberOfTown)
				eligibleTownJudge.add(trust[index][1]);
			index++;
		}
		int judge = -1;
		for (int e : eligibleTownJudge) {
			if (isJudge(N, trust, e, 0)) {
				judge = e;
				break;
			}
		}
		return judge;
	}

	private boolean isJudge(int N, int[][] trust, int judgeNum, int index) {
		if (index == trust.length) {
			if (N == 1)
				return true;
			return false;
		}
		if (trust[index][0] == judgeNum)
			return false;
		if (trust[index++][1] == judgeNum)
			N--;
		return isJudge(N, trust, judgeNum, index);
	}
}
