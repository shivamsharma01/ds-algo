package leetcode.problems.easy;

// https://leetcode.com/problems/minimum-time-visiting-all-points/
public class MinimumTimeVisitingAllPoints {

	public static void main(String[] args) {
		System.out.println(new MinimumTimeVisitingAllPoints().minTimeToVisitAllPoints(new int[][] {{1,1},{3,4},{-1,0}})); // 7
	}

	public int minTimeToVisitAllPoints(int[][] points) {
        int time = 0;
        for(int i=1; i<points.length; i++)
            time += Math.max(Math.abs(points[i][0]-points[i-1][0]), Math.abs(points[i][1]-points[i-1][1]));
        return time;
    }

}
