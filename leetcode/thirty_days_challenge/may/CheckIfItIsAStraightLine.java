package leetcode.thirty_days_challenge.may;

public class CheckIfItIsAStraightLine {

	public boolean checkStraightLine(int[][] coordinates) {
        double m = coordinates[1][0] != coordinates[0][0] ? (coordinates[1][1] - coordinates[0][1])/(double)(coordinates[1][0] - coordinates[0][0]) : Integer.MAX_VALUE;
        double cur;
        for(int i=2; i<coordinates.length; i++) {
            cur = coordinates[i][0] != coordinates[i-1][0] ? (coordinates[i][1] - coordinates[i-1][1])/(double)(coordinates[i][0] - coordinates[i-1][0]) : Integer.MAX_VALUE;
            if(cur != m)
                return false;
        }   
        return true;
    }
    
}