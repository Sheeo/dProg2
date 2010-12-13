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

		assert !a.equals(b) : "Inequal sets claim to be equal";
		assert b.remove("Bar") : "remove failed";
		assert a.equals(b) : "Equal sets claim to be inequal";
		Iterator<String> i = a.iterator();
		try {
			i.remove();
			assert false : "MultiIterator.remove() succeeded before calling next()";
		} catch (IllegalStateException e) {
		}
		while (i.hasNext()) { // test iterator
			String s = i.next();
			assert b.remove(s) : "remove failed";
		}
		try {
			i.next();
			assert false : "i.next() succeeded past end of list";
		} catch (NoSuchElementException e) {
		}
		assert b.size() == 0 : "MultiSet.size() nonzero after removing all elements";

		Set<String> baseSet = new HashSet<String>(a);
		assert baseSet.size()==2 : "keyset created from MultiSet has wrong size";

		b = new MultiSet<String>(a);
		assert a.equals(b) : "Constructor from collections fail";

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

