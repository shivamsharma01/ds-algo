package leetcode.thirty_days_challenge.may;

public class FloodFill {
	public static void main(String[] args) {
		FloodFill o = new FloodFill();
		int[][] input = new int[][] { { 1, 1, 1 }, { 1, 1, 0 }, { 1, 0, 1 } };
		input = o.floodFill(input, 1, 1, 2);
		for (int i = 0; i < input.length; i++) {
			for (int j = 0; j < input[i].length; j++)
				System.out.print(input[i][j] + " ");
			System.out.println();
		}
	}

	public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
		if (image[sr][sc] == newColor)
			return image;
		checkAndReplacePixel(image, sr, sc, newColor, image[sr][sc]);
		return image;
	}

	public void checkAndReplacePixel(int[][] image, int sr, int sc, int newColor, int oldColor) {
		if (sr == -1 || sr == image.length || sc == -1 || sc == image[sr].length)
			return;
		if (image[sr][sc] != oldColor)
			return;
		image[sr][sc] = newColor;
		checkAndReplacePixel(image, sr - 1, sc, newColor, oldColor);
		checkAndReplacePixel(image, sr + 1, sc, newColor, oldColor);
		checkAndReplacePixel(image, sr, sc - 1, newColor, oldColor);
		checkAndReplacePixel(image, sr, sc + 1, newColor, oldColor);
	}

}
