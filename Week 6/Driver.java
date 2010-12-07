import java.util.*;

public class Driver {
	private static final Random rng = new Random();
	public static void main(String[] args) {
		MultiSet<Integer> s = new MultiSet<Integer>();
		for (int i = 1; i <= 5; ++i) {
			int num = rng.nextInt() % 100;
			System.out.println("Add "+num+" "+i+" times");
			for (int j = 1; j <= i; ++j) {
				s.add(num);
			}
		}
		System.out.println(s);
		ArrayList<Integer> ary = new ArrayList<Integer>(s);
		Collections.shuffle(ary);
		MultiSet<Integer> t = new MultiSet<Integer>();
		for (Integer i : ary) {
			t.add(i);
		}
		System.out.println(t);
		System.out.println(s.equals(t));
		System.out.println(t.equals(s));
	}
}
