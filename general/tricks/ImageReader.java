package general.tricks;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.filechooser.FileNameExtensionFilter;

public class ImageReader {
	private static FileNameExtensionFilter fFilter = new FileNameExtensionFilter("", "png");
	private static String rootDirectory = "F:\\study material\\Made easy tests - Copy (2)";

	public static void main(String[] args) {
		convertImages(rootDirectory);
	}

	private static void convertImages(String rootDirectory) {
		File directory = new File(rootDirectory);
		System.out.println("Inside Directory ->" + directory.getName());
		File[] fList = directory.listFiles();
		for (File file : fList) {
			if (file.isDirectory()) {
				convertImages(file.getAbsolutePath());
			} else {
				if (isPNGImage(file)) {
					convertImage(file);
				}
			}
		}
		System.out.println("Finished Converting Images inside ->" + directory.getName());
	}

	private static boolean isPNGImage(File file) {
		return file.isFile() && fFilter.accept(file);
	}

	private static void convertImage(File file) {
		BufferedImage bufferedImage = null;
		try {
			System.out.println("Converting image -> " + file.getName());
			bufferedImage = ImageIO.read(file);
			File pathFile = new File(file.getAbsolutePath());
			int left = getLeft(bufferedImage)+2;
			int right = getRight(bufferedImage);
			int height = getHeight(bufferedImage);
			ImageIO.write(bufferedImage.getSubimage(left, 101, right - left, height - 98), "png", pathFile);
		} catch (IOException e) {
			System.out.println(e);
		}
	}

	private static int getHeight(BufferedImage image) {
		Color c = new Color(213, 213, 213);
		for (int height = image.getHeight() - 1; height >= 0; height--) {
			if (image.getRGB(1000, height) == c.getRGB()) {
				return height;
			}
		}
		return image.getHeight();
	}

	private static int getLeft(BufferedImage image) {
		Color c = new Color(222, 222, 222);
		for (int width = 0; width <= image.getWidth() - 1; width++) {
			if (image.getRGB(width, 500) == c.getRGB()) {
				return width;
			}
		}
		return 0;
	}

	private static int getRight(BufferedImage image) {
		Color c = new Color(222, 222, 222);
		for (int width = image.getWidth() - 1; width >= 0; width--) {
			if (image.getRGB(width, 500) == c.getRGB()) {
				return width;
			}
		}
		return image.getWidth();
	}

}