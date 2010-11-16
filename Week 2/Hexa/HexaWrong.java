// WARNING: some method is not implemented correctly.
public class HexaWrong {

  //IMPLEMENTATION INVARIANT 
  //"hexa" is the hexadecimal representation of integer "num"

  private int num;
  private String hexa;

  public HexaWrong(int n) {
    num = n;
    hexa = Integer.toHexString(n).toUpperCase();
		assert sanityCheck();
  }

	private boolean sanityCheck() {
		return hexa.toUpperCase().equals(Integer.toHexString(num).toUpperCase());
	}

  public void increment() {
    num++;
    hexa = hexa.substring(0,hexa.length()-1)
           +(char)(hexa.charAt(hexa.length()-1)+1);
		assert sanityCheck();
  }
    
  public String toString() {
    return  num + " equals "
            + hexa + " in hexadecimal notation";
  }
}
