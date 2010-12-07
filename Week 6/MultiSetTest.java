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
	for(String s : a) { // test iterator
	    assert b.remove(s) : "Failed test 4!";
	}
	assert b.size() == 0 : "Failed test 5!";

	Set<String> baseSet = new HashSet<String>(a);
	assert baseSet.size()==2 : "Failed test 6!";  

	b = new MultiSet<String>(a);
	assert a.equals(b) : "Failed test 7!";

	try {
	    assert false;
	    System.out.println("Please enable assertions!");
	}
	catch(AssertionError e) {
	    System.out.println("Success!");
	}
    }
}

