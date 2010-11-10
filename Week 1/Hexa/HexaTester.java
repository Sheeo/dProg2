public class HexaTester {
	public static void main(String[] args) {
		if (asserts()) {
			tests();
		} else {
			demos();
		}
	}

	/**
	 * Return true if asserts are enabled, false otherwise.
	 */
	private static boolean asserts() {
		try {
			assert false;
		} catch (AssertionError e) {
			return true;
		}
		return false;
	}

	/**
	 * Run when asserts are enabled.
	 */
	private static void tests() {
		System.out.println("Running HexaWrong. Expecting AssertionError.");
		try {
			HexaWrong n = new HexaWrong(447);
			System.out.println(n);
			n.increment();
			System.out.println(n);
			n = new HexaWrong(0x7FFFFFFF);
			System.out.println(n);
			n.increment();
			System.out.println(n);
			System.err.println("Holy lack of assertion error, Batman!");
		} catch (AssertionError e) {
			System.out.println("AssertionError, just as planned...");
		}
		System.out.println();
		System.out.println("Running Hexa. Expecting no AssertionErrors.");
		try {
			Hexa nn = new Hexa(447);
			System.out.println(nn);
			nn.increment();
			System.out.println(nn);
			nn = new Hexa(0x7FFFFFFF);
			System.out.println(nn);
			nn.increment();
			System.out.println(nn);
		} catch (AssertionError e) {
			System.err.println("Holy assertion error, Batman!");
			e.printStackTrace();
		}
	}

	/**
	 * Run when asserts are disabled.
	 */
	private static void demos() {
		System.out.println("Assertions not enabled. Please run again with -ea.");
		System.out.println("Instead, let's demo hexadecimals.");
		Hexa n = new Hexa(0x2F9);
		for (int i = 0x2F9; i <= 0x310; ++i, n.increment()) {
			System.out.println(n);
		}
		System.out.println("Cool, don't you	think?");
	}
}
