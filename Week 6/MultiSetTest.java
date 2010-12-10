import java.util.*;

public class MultiSetTest {

	public static void main(String[] args) {
		MultiSet<String> a = new MultiSet<String>();
		MultiSet<String> b = new MultiSet<String>();

		a.add("Foo");
		a.add("Bar");
		a.add("Foo");
		System.out.println("a:" + a); // test toString

		b.add("Bar");
		b.add("Foo");
		b.add("Bar");
		b.add("Foo");
		System.out.println("b:" + b);

		assert !a.equals(b) : "Failed test 1!"; // test equals
		assert b.remove("Bar") : "Failed test 2!"; // test remove
		assert a.equals(b) : "Failed test 3!";
		Iterator<String> i = a.iterator();
		try {
			i.remove();
			assert false : "MultiIterator.remove() succeeded before calling next()";
		} catch (IllegalStateException e) {
		}
		while (i.hasNext()) { // test iterator
			String s = i.next();
			assert b.remove(s) : "Failed test 4!";
		}
		try {
			i.next();
			assert false : "i.next() succeeded past end of list";
		} catch (NoSuchElementException e) {
		}
		assert b.size() == 0 : "Failed test 5!";

		Set<String> baseSet = new HashSet<String>(a);
		assert baseSet.size()==2 : "Failed test 6!";	

		b = new MultiSet<String>(a);
		assert a.equals(b) : "Failed test 7!";

		i = b.iterator();
		i.next();
		i.remove();
		assert !a.equals(b) : "MultiIterator.remove() failed";
		try {
			i.remove();
			assert false : "MultiIterator.remove() succeeded twice in a row";
		} catch (IllegalStateException e) {
		}
		while (i.hasNext()) {
			i.next();
		}

		try {
			assert false;
			System.out.println("Please enable assertions!");
		}
		catch(AssertionError e) {
			System.out.println("Success!");
		}
	}
}

