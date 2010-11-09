public class HexaTester {
  public static void main(String[] args) {
    Hexa n = new Hexa(446);
    System.out.println(n);
    n.increment();
    System.out.println(n);
    n = new Hexa(33);
    System.out.println(n);
    n.increment();
    System.out.println(n);
  }
}
