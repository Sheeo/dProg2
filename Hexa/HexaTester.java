public class HexaTester {
	public static void main(String[] args) {
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
		}
	}
}
