package codechef.challenge.year2020.june;

import codechef.common.InputReader;
import codechef.common.OutputWriter;

public class OperationsOnATuple {
	static InputReader in = new InputReader(System.in);
	static OutputWriter out = new OutputWriter(System.out);

	public static void main(String[] args) throws java.lang.Exception {
		try {
			int t = Integer.parseInt(in.next());
			while (t-- > 0) {
				int p = Integer.parseInt(in.next());
				int q = Integer.parseInt(in.next());
				int r = Integer.parseInt(in.next());
				int a = Integer.parseInt(in.next());
				int b = Integer.parseInt(in.next());
				int c = Integer.parseInt(in.next());
				out.printLine(Operations(p, q, r, a, b, c));
				out.flush();
			}
		} catch (Exception e) {
		}
	}

	private static int Operations(int p, int q, int r, int a, int b, int c) {
		if (p == a && q == b && r == c)
			return 0;
		else if (p != a && (q == b && r == c) || q != b && (p == a && r == c) || r != c && (q == b && p == a))
			return 1;
		else if (p != a && q != b && r != c)
			return allUnequal(p, q, r, a, b, c);
		else
			return twoUnequal(p, q, r, a, b, c);
	}

	private static int twoUnequal(int p, int q, int r, int a, int b, int c) {
		if (p != a) {
			if (q != b) {
				if (a - p == b - q || p != 0 && a % p == 0 && (a / p) * q == b)
					return 1;
				return 2;
			} else {
				if (a - p == c - r || p != 0 && a % p == 0 && (a / p) * r == c)
					return 1;
				return 2;
			}
		} else {
			if (b - q == c - r || q != 0 && b % q == 0 && (b / q) * r == c)
				return 1;
			return 2;
		}
	}

	// assumption is that it is called from 'operations function' only when we
	// already know that all are unequal
	private static int allUnequal(int p, int q, int r, int a, int b, int c) {
		if (a == 0 && b == 0 && c == 0 || a - p == b - q && a - p == c - r)
			return 1;
		if ((p != 0 && (a / p) * p == a && (a / p) * q == b && (a / p) * r == c)
				|| (q != 0 && (b / q) * p == a && (b / q) * q == b && (b / q) * r == c)
				|| (r != 0 && (c / r) * p == a && (c / r) * q == b && (c / r) * r == c))
			return 1;
		for (byte i = 1; i <= 3; i++) {
			int dif;
			switch (i) {
			case 1:
				dif = a - p;
				if (in1StepAddAfterAdd(q, r, b, c, dif))
					return 2;
				if (in1StepMultiplyAfterAdd(q, r, b, c, dif))
					return 2;
				break;
			case 2:
				dif = b - q;
				if (in1StepAddAfterAdd(p, r, a, c, dif))
					return 2;
				if (in1StepMultiplyAfterAdd(p, r, a, c, dif))
					return 2;
				break;
			case 3:
				dif = c - r;
				if (in1StepAddAfterAdd(q, p, b, a, dif))
					return 2;
				if (in1StepMultiplyAfterAdd(q, p, b, a, dif))
					return 2;
				break;
			}
		}
		if (checkAddThenMultiply(p, q, r, a, b, c))
			return 2;
		for (byte i = 1; i <= 3; i++) {
			int factor;
			switch (i) {
			case 1:
				if (p != 0) {
					factor = a / p;
					if (factor * p == a && in1StepAddAfterMultiply(q, r, b, c, factor))
						return 2;
					if (factor * p == a && in1StepMultiplyAfterMultiply(q, r, b, c, factor))
						return 2;
				}
				break;
			case 2:
				if (q != 0) {
					factor = b / q;
					if (factor * q == b && in1StepAddAfterMultiply(p, r, a, c, factor))
						return 2;
					if (factor * q == b && in1StepMultiplyAfterMultiply(p, r, a, c, factor))
						return 2;
				}
				break;
			case 3:
				if (r != 0) {
					factor = c / r;
					if (factor * r == c && in1StepAddAfterMultiply(q, p, b, a, factor))
						return 2;
					if (factor * r == c && in1StepMultiplyAfterMultiply(q, p, b, a, factor))
						return 2;
				}
				break;
			}
		}
		if (checkMultiplyThenAdd(p, q, r, a, b, c))
			return 2;
		return 3;
	}

	private static boolean in1StepAddAfterAdd(int a1, int b1, int a2, int b2, int added) {
		if (a2 - a1 == b2 - b1)
			return true;
		a1 = a1 + added;
		if (a2 - a1 == b2 - b1)
			return true;
		b1 = b1 + added;
		if (a2 - a1 == b2 - b1)
			return true;
		a1 = a1 - added;
		if (a2 - a1 == b2 - b1)
			return true;
		return false;
	}

	private static boolean in1StepMultiplyAfterAdd(int a1, int b1, int a2, int b2, int added) {
		if (a2 == 0 && b2 == 0)
			return true;
		if (a1 != 0) {
			int factor = a2 / a1;
			if (factor * a1 == a2 && factor * b1 == b2)
				return true;
		}
		a1 = a1 + added;
		if (a1 != 0) {
			int factor = a2 / a1;
			if (factor * a1 == a2 && factor * b1 == b2)
				return true;
		}
		b1 = b1 + added;
		if (a1 != 0) {
			int factor = a2 / a1;
			if (factor * a1 == a2 && factor * b1 == b2)
				return true;
		}
		a1 = a1 - added;
		if (a1 != 0) {
			int factor = a2 / a1;
			if (factor * a1 == a2 && factor * b1 == b2)
				return true;
		}
		return false;
	}

	private static boolean in1StepAddAfterMultiply(int a1, int b1, int a2, int b2, int factor) {
		if (a2 - a1 == b2 - b1)
			return true;
		a1 = a1 * factor;
		if (a2 - a1 == b2 - b1)
			return true;
		b1 = b1 * factor;
		if (a2 - a1 == b2 - b1)
			return true;
		a1 = a1 / factor;
		if (a2 - a1 == b2 - b1)
			return true;
		return false;
	}

	private static boolean in1StepMultiplyAfterMultiply(int a1, int b1, int a2, int b2, int factor) {
		if (a1 != 0) {
			int factor2 = a2 / a1;
			if (factor2 * a1 == a2 && factor2 * b1 == b2)
				return true;
		}
		a1 = a1 * factor;
		if (a1 != 0) {
			int factor2 = a2 / a1;
			if (factor2 * a1 == a2 && factor2 * b1 == b2)
				return true;
		}
		b1 = b1 * factor;
		if (a1 != 0) {
			int factor2 = a2 / a1;
			if (factor2 * a1 == a2 && factor2 * b1 == b2)
				return true;
		}
		a1 = a1 / factor;
		if (a1 != 0) {
			int factor2 = a2 / a1;
			if (factor2 * a1 == a2 && factor2 * b1 == b2)
				return true;
		}
		return false;
	}

	private static boolean checkAddThenMultiply(int p, int q, int r, int a, int b, int c) {
		int y, x;
		if (q - p != 0) {
			y = (b - a) / (q - p);
			if (y != 0) {
				x = (a - p * y) / y;
				if ((p + x) * y == a && (q + x) * y == b) {
					if (r * y == c || r + x == c || (r + x) * y == c)
						return true;
				}
			}
		}
		if (r - p != 0) {
			y = (c - a) / (r - p);
			if (y != 0) {
				x = (a - p * y) / y;
				if ((p + x) * y == a && (r + x) * y == c) {
					if (q * y == b || q + x == b || (q + x) * y == b)
						return true;
				}
			}
		}
		if (q - r != 0) {
			y = (b - c) / (q - r);
			if (y != 0) {
				x = (c - r * y) / y;
				if ((r + x) * y == c && (q + x) * y == b) {
					if (p * y == a || p + x == a || (p + x) * y == a)
						return true;
				}
			}
		}
		return false;
	}

	private static boolean checkMultiplyThenAdd(int p, int q, int r, int a, int b, int c) {
		int y, x;
		if (q - p != 0) {
			x = (b - a) / (q - p);
			y = a - p * x;
			if ((p * x) + y == a && (q * x) + y == b) {
				if (r + y == c || r * x == c || (r * x) + y == c)
					return true;
			}
		}
		if (r - p != 0) {
			x = (c - a) / (r - p);
			y = a - p * x;
			if ((p * x) + y == a && (r * x) + y == c) {
				if (q + y == b || q * x == b || (q * x) + y == b)
					return true;
			}
		}
		if (r - q != 0) {
			x = (c - b) / (r - q);
			y = b - q * x;
			if ((q * x) + y == b && (r * x) + y == c) {
				if (p + y == a || p * x == a || (p * x) + y == a)
					return true;
			}
		}
		return false;
	}

}