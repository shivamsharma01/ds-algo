package leetcode.thirty_days_challenge.may;

public class ValidPerfectSquare {

	public boolean isPerfectSquare(int num) {
        int low = 1, high = num,mid;
        long square;
        while(low<=high) {
            mid = low + (high-low)/2;
            square = ((long)mid)*mid;
            if(square == num)
                return true;
            else if(square > num)
                high = mid-1;
            else
                low = mid + 1;
        }
        return false;
    }
    
}