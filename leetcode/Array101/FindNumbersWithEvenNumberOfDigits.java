package leetcode.Array101;

public class FindNumbersWithEvenNumberOfDigits {

	public int findNumbers(int[] nums) {
        int ans = 0;
        
        for(int num: nums) {
            if(num == 100000){
                ans++;
            } else if(num >= 10000){
                
            } else if(num >= 1000) {
                ans++;
            } else if(num >=100){
                
            } else if(num >= 10){
                ans++;
            }
        }
        return ans;
    }

}