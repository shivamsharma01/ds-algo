package prepbytes.topic.search;

import java.util.Scanner;

public class StockMarket {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		byte t = scan.nextByte();
		while (t-- > 0) {
			int[] stocks = new int[scan.nextInt()];
			int stockPurchasePrice = 0;
			long profit = 0;
			boolean isCarryingAStock = false;
			stocks[0] = scan.nextInt();

			for (int i = 1; i < stocks.length; i++) {
				stocks[i] = scan.nextInt();
				if (!isCarryingAStock && stocks[i - 1] < stocks[i]) {
					isCarryingAStock = true;
					stockPurchasePrice = stocks[i - 1];
				}
				if (isCarryingAStock && stocks[i - 1] >= stocks[i]) {
					isCarryingAStock = false;
					profit += stocks[i - 1] - stockPurchasePrice;
				}
			}
			if (isCarryingAStock) {
				profit += stocks[stocks.length - 1] - stockPurchasePrice;
			}
			System.out.println(profit);
		}
	}
}
