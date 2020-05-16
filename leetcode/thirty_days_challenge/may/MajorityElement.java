package leetcode.thirty_days_challenge.may;

public class MajorityElement {
	public int majorityElement(int[] nums) {
        int count = 0, num=nums[0];
        for(int e:nums) {
            if(e == num)
                count++;
            else {
                count--;
                if(count == 0) {
                    count = 1;
                    num = e;
                }
            }
        }
        return num;
    }
}
