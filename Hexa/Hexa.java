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

	private boolean sanityCheck() {
		return hexa.toUpperCase().equals(Integer.toHexString(num).toUpperCase());
	}

	public void increment() {
		num++;
		hexa = Integer.toHexString(num).toUpperCase();
		assert sanityCheck();
	}
		
	public String toString() {
		return num + " equals "
		       + hexa + " in hexadecimal notation";
	}
}
