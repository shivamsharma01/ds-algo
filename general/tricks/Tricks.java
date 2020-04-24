package general.tricks;

public class Tricks {

	public static void main(String[] args) {
		for (int i = 1; i <= 100; i++) {
			//
			String s = String.format("%16s", Integer.toBinaryString(i)).replace(' ', '0');
			System.out.println(s);
		}
	}
}
