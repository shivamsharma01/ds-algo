package codechef.challenge.year2020.june;

import codechef.common.InputReader;
import codechef.common.OutputWriter;

public class prac {
	static InputReader in = new InputReader(System.in);
	static OutputWriter out = new OutputWriter(System.out);

	public static void main(String[] args) throws java.lang.Exception {
		try {
			int t = Integer.parseInt(in.next());
			while (t-- > 0) {
				int a = Integer.parseInt(in.next()), b = Integer.parseInt(in.next()), c = Integer.parseInt(in.next());
				while (true) {
					out.printLine(Operations(a, b, c, Integer.parseInt(in.next()), Integer.parseInt(in.next()),
							Integer.parseInt(in.next())));
					out.flush();
				}
			}
		} catch (Exception e) {
		}
	}

	private static int Operations(long a1, long b1, long c1, long a2, long b2, long c2) {
		if (a1 == a2 && b1 == b2 && c1 == c2) {
			return 0;
		} else if (a1 != a2 && (b1 == b2 && c1 == c2) || b1 != b2 && (a1 == a2 && c1 == c2)
				|| c1 != c2 && (b1 == b2 && a1 == a2)) {
			return 1;
		} else if (a1 != a2 && b1 != b2 && c1 != c2) {
			// common number added to 2 or all
			if (a2 - a1 == b2 - b1) {
				if (a2 - a1 == c2 - c1)
					return 1;
				else
					return 2;
			} else if (a2 - a1 == c2 - c1) {
				return 2;
			} else if (c2 - c1 == b2 - b1) {
				return 2;
			} else {
				// common number multiple of 2 or all
				long num;
				if (a1 != 0 && a2 % a1 == 0) {
					num = a2 / a1;
					if (num * b1 == b2) {
						if (num * c1 == c2)
							return 1;
						else
							return 2;
					} else if (num * c1 == c2)
						return 2;
				} else if (b1 != 0 && b2 % b1 == 0) {
					num = b2 / b1;
					if (num * a1 == a2) {
						if (num * c1 == c2)
							return 1;
						else
							return 2;
					} else if (num * c1 == c2)
						return 2;
				} else if (c1 != 0 && c2 % c1 == 0) {
					num = c2 / c1;
					if (num * a1 == a2) {
						if (num * b1 == b2)
							return 1;
						else
							return 2;
					} else if (num * b1 == b2)
						return 2;
				}
				long x, y;
				if (b2 - a2 != 0) {
					x = (a2 * b1 - a1 * b2) / (b2 - a2);
					if (a1 + x != 0 && a2 % (a1 + x) == 0) {
						y = a2 / (a1 + x);
						if ((a1 + x) * y == a2 && (b1 + x) * y == b2) {
							if (c1 + x == c2 || (c1 + x) * y == c2 || c1 * y == c2) {
								return 2;
							}
						}
					}
				}

				if (c2 - a2 != 0) {
					x = (a2 * c1 - a1 * c2) / (c2 - a2);
					if (a1 + x != 0 && a2 % (a1 + x) == 0) {
						y = a2 / (a1 + x);
						if ((a1 + x) * y == a2 && (c1 + x) * y == c2) {
							if (b1 + x == b2 || (b1 + x) * y == b2 || b1 * y == b2) {
								return 2;
							}
						}
					}
				}

				if (c2 - b2 != 0) {
					x = (b2 * c1 - b1 * c2) / (c2 - b2);
					if (b1 + x != 0 && b2 % (b1 + x) == 0) {
						y = b2 / (b1 + x);
						if ((b1 + x) * y == b2 && (c1 + x) * y == c2) {
							if (a1 + x == a2 || (a1 + x) * y == a2 || a1 * y == a2) {
								return 2;
							}
						}
					}
				}

				if (a2 - b2 != 0 && a1 - b1 != 0 && (a2 - b2) % (a1 - b1) == 0) {
					y = (a2 - b2) / (a1 - b1);
					x = a2 - a1 * y;
					if (a1 * y + x == a2 && b1 * y + x == b2) {
						if (c1 * y + x == c2 || c1 * y == c2 || c1 + x == c2)
							return 2;
					}
				}
				if (a2 - c2 != 0 && a1 - c1 != 0 && (a2 - c2) % (a1 - c1) == 0) {
					y = (a2 - c2) / (a1 - c1);
					x = a2 - a1 * y;
					if (a1 * y + x == a2 && c1 * y + x == c2) {
						if (b1 * y + x == b2 || b1 * y == b2 || b1 + x == b2)
							return 2;
					}
				}
				if (c2 - b2 != 0 && c1 - b1 != 0 && (c2 - b2) % (c1 - b1) == 0) {
					y = (c2 - c2) / (c1 - b1);
					x = c2 - c1 * y;
					if (c1 * y + x == c2 && b1 * y + x == b2) {
						if (a1 * y + x == a2 || a1 * y == a2 || a1 + x == a2)
							return 2;
					}
				}
				if (a2 == b2 && a2 == c2)
					return 2;
				return 3;
			}
		} else {
			if (a1 != a2) {
				if (b1 != b2) {
					if (a2 - a1 == b2 - b1 || a1 != 0 && a2 % a1 == 0 && (a2 / a1) * b1 == b2)
						return 1;
					return 2;
				} else {
					if (a2 - a1 == c2 - c1 || a1 != 0 && a2 % a1 == 0 && (a2 / a1) * c1 == c2)
						return 1;
					return 2;
				}
			} else {
				if (b2 - b1 == c2 - c1 || b1 != 0 && b2 % b1 == 0 && (b2 / b1) * c1 == c2)
					return 1;
				return 2;
			}
		}
	}
}
