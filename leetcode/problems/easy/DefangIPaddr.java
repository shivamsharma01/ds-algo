package leetcode.problems.easy;

// https://leetcode.com/problems/defanging-an-ip-address/
public class DefangIPaddr {
	public static void main(String[] args) {
		System.out.println(new DefangIPaddr().defangIPaddr("192.168.1.1"));
	}

	public String defangIPaddr(String address) {
		return address.replaceAll("\\.", "[.]");
	}
}
