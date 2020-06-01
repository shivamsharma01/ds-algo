package prepbytes.marathon.logicbuilding;
import java.io.IOException;
import java.util.Scanner;

public class AreaOfTwoRectilinearRectangles {
	public static void main(String args[]) throws IOException {
		Scanner scan = new Scanner(System.in);
		byte t = scan.nextByte();
		while (t-- > 0) {
			int x1 = scan.nextInt(), y1 = scan.nextInt(), x2 = scan.nextInt(), y2 = scan.nextInt(), x3 = scan.nextInt(),
					y3 = scan.nextInt(), x4 = scan.nextInt(), y4 = scan.nextInt();
			int area = area(x1, y1, x2, y2);
			area += area(x3, y3, x4, y4);
			System.out.println(area - findCommonArea(x1, y1, x2, y2, x3, y3, x4, y4));
		}
	}

	private static int findCommonArea(int x1, int y1, int x2, int y2, int x3, int y3, int x4, int y4) {
		if (noOverlap(x1, y1, x2, y2, x3, y3, x4, y4))
			return 0;
		int maxLeft = Math.max(x1, x3);
		int minRight = Math.min(x2, x4);
		int maxBottom = Math.max(y1, y3);
		int minTop = Math.min(y2, y4);
		return (minRight - maxLeft) * (minTop - maxBottom);
	}

	private static boolean noOverlap(int x1, int y1, int x2, int y2, int x3, int y3, int x4, int y4) {
		if (x1 <= x3 && x2 <= x3 || x3 <= x1 && x4 <= x1)
			return true;
		if (y1 <= y3 && y2 <= y3 || y3 <= y1 && y4 <= y1)
			return true;
		return false;
	}

	private static int area(int x1, int y1, int x2, int y2) {
		return (x2 - x1) * (y2 - y1);
	}

}