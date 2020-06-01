package leetcode.problems.easy;

// https://leetcode.com/problems/reverse-integer/
public class ReverseInteger {

	public static void main(String[] args) {
		System.out.println(new ReverseInteger().reverse(123)); // 321
		System.out.println(new ReverseInteger().reverse(120)); // 21
		System.out.println(new ReverseInteger().reverse(1523123123)); // 0
	}

	public int reverse(int x) {
        long y = 0;
        while(x!= 0) {
            y =y*10 + x%10;
            x /=10;
        }
        if(y < Integer.MIN_VALUE || y > Integer.MAX_VALUE)
            return 0;
        return (int)y;
    }
}
