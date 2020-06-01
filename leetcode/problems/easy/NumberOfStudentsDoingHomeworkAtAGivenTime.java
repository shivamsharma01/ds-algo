package leetcode.problems.easy;

// https://leetcode.com/problems/number-of-students-doing-homework-at-a-given-time/
public class NumberOfStudentsDoingHomeworkAtAGivenTime {

	public static void main(String[] args) {
		System.out.println(new NumberOfStudentsDoingHomeworkAtAGivenTime().busyStudent(new int[] {1,2,3},new int[] {3,2,7},4));// 1
	}

	public int busyStudent(int[] startTime, int[] endTime, int queryTime) {
        int study = 0;
        for(int i=0; i<startTime.length; i++)
            if(queryTime >= startTime[i] && queryTime <= endTime[i])
                study++;
        return study;
    }

}
