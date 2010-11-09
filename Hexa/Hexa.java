// WARNING: some method is not implemented correctly.
public class Hexa {

  //IMPLEMENTATION INVARIANT 
  //"hexa" is the hexadecimal representation of integer "num"

  private int num;
  private String hexa;

  public Hexa(int n) {
    num = n;
    hexa = Integer.toHexString(n).toUpperCase();
  }

  public void increment() {
    num++;
    hexa = hexa.substring(0,hexa.length()-1)
           +(char)(hexa.charAt(hexa.length()-1)+1);
  }
    
  public String toString() {
    return  num + " equals "
            + hexa + " in hexadecimal notation";
  }
}
