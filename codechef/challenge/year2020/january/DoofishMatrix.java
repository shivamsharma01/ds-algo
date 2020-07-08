package codechef.challenge.year2020.january;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.InputMismatchException;

public class DoofishMatrix {
	static InputReader in = new InputReader(System.in);
	static OutputWriter out = new OutputWriter(System.out);

	public static void main(String[] args) throws java.lang.Exception {
		short t = Short.parseShort(in.next());
		while (t-- > 0) {
			long time = System.nanoTime();
			short n = Short.parseShort(in.next());
			if (n == 1) {
				out.printLine("Hooray\n1\n");
			} else if (n % 2 == 1) {
				out.printLine("Boo");
			} else {
				out.printLine("Hooray");
				printDoofishMatrix(n);
			}
			out.flush();
			System.out.println((System.nanoTime() - time) / 1000000000);
		}
	}

	private static void printDoofishMatrix(short n) {
		short[][] arr = new short[n][n];
		short max = (short) (2 * n - 1);
		arr[0][0] = max;
		for (short i = 1; i < n; i++) {
			arr[0][i] = i;
			arr[i][i] = max;
		}
		short next = 2;
		for (short i = 1; i < n - 1; i++) {
			arr[i][n - 1] = next;
			next += 2;
			if (next >= n)
				next = 1;
		}
		for (short i = 1, cur; i < n; i++) {
			cur = (short) (arr[i][n - 1] + 1);
			if (cur == n)
				cur = 1;
			for (short j = (short) (i + 1); j < n - 1; j++) {
				arr[i][j] = cur++;
				if (cur == n)
					cur = 1;
			}
		}
		for (short i = 0; i < n; i++) {
			for (short j = 0; j < n; j++) {
				if (i > j)
					out.print(max - arr[j][i] + " ");
				else
					out.print(arr[i][j] + " ");
			}
			out.printLine();
		}
	}

}

class InputReader {

	private InputStream stream;
	private byte[] buf = new byte[1024];
	private int curChar;
	private int numChars;
	private SpaceCharFilter filter;

	public InputReader(InputStream stream) {
		this.stream = stream;
	}

	private int read() {
		if (numChars == -1)
			throw new InputMismatchException();
		if (curChar >= numChars) {
			curChar = 0;
			try {
				numChars = stream.read(buf);
			} catch (IOException e) {
				throw new InputMismatchException();
			}
			if (numChars <= 0)
				return -1;
		}
		return buf[curChar++];
	}

	public int readInt() {
		int c = read();
		while (isSpaceChar(c))
			c = read();
		int sgn = 1;
		if (c == '-') {
			sgn = -1;
			c = read();
		}
		int res = 0;
		do {
			if (c < '0' || c > '9')
				throw new InputMismatchException();
			res *= 10;
			res += c - '0';
			c = read();
		} while (!isSpaceChar(c));
		return res * sgn;
	}

	public String readString() {
		int c = read();
		while (isSpaceChar(c))
			c = read();
		StringBuilder res = new StringBuilder();
		do {
			res.appendCodePoint(c);
			c = read();
		} while (!isSpaceChar(c));
		return res.toString();
	}

	public boolean isSpaceChar(int c) {
		if (filter != null)
			return filter.isSpaceChar(c);
		return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
	}

	public String next() {
		return readString();
	}

	public interface SpaceCharFilter {
		public boolean isSpaceChar(int ch);
	}
}

class OutputWriter {
	private final PrintWriter writer;

	public OutputWriter(OutputStream outputStream) {
		writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(outputStream)));
	}

	public OutputWriter(Writer writer) {
		this.writer = new PrintWriter(writer);
	}

	public void print(Object... objects) {
		for (int i = 0; i < objects.length; i++) {
			if (i != 0)
				writer.print(' ');
			writer.print(objects[i]);
		}
	}

	public void printLine(Object... objects) {
		print(objects);
		writer.println();
	}

	public void close() {
		writer.close();
	}

	public void flush() {
		writer.flush();
	}

}