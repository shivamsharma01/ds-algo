package bytebybyte;

public class SmallestChange {
	public static void main(String[] args) {
		int[] coins = { 9, 6, 5, 1 };
		System.out.println(change(coins, 101));
	}

	public static int change(int[] coins, int val) {
		int[] table = new int[val+1];
		table[0] = 0;
		for(int i = 1; i<=val; i++) {
			table[i] = Integer.MAX_VALUE;
		}
		for(int i =1; i<= val; i++) {
			for(int coin: coins) {
				if(coin <= i) {
					int sub_res = table[i-coin];
					if(sub_res != Integer.MAX_VALUE && sub_res + 1 <= table[i]) {
						table[i] = sub_res +1;
					}
				}
			}
		}
		return table[val];
	}
}