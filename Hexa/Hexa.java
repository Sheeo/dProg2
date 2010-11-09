public class Hexa {

	//IMPLEMENTATION INVARIANT 
	//"hexa" is the hexadecimal representation of integer "num"

	private int num;
	private String hexa;

	public Hexa(int n) {
		num = n;
		hexa = Integer.toHexString(n).toUpperCase();
		assert sanityCheck();
	}

	public static String toHexString(int num) {
		StringBuilder b = new StringBuilder();
		for (int i = 8; i-- != 0;) {
			// Get nibble i
			int nibble = ((num & (0xF << (i*4))) >> (i*4)) & (0xF);

			if (nibble == 0) {
				if (b.length() == 0) continue;
			}

			if (nibble < 10) b.append((char) ('0' + nibble));

			else b.append((char) ('A' + (nibble-10)));
		}
		return b.toString();
	}

	private boolean sanityCheck() {
		return hexa.toUpperCase().equals(Integer.toHexString(num).toUpperCase());
	}

	public void increment() {
		num++;
		hexa = toHexString(num);
		assert sanityCheck();
	}
		
	public String toString() {
		return num + " equals "
		       + hexa + " in hexadecimal notation";
	}
}
