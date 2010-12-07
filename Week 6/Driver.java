import java.util.*;
import java.io.*;
import java.util.concurrent.*;

public abstract class Driver {
	public static void main(String[] args) {
		Driver d;
		if (args.length > 0 && args[0].equals("wordcount")) {
			d = new WordDriver();
		} else if (args.length > 0 && args[0].equals("multiset")) {
			d = new MultiDriver();
		} else {
			d = new UsageDriver();
		}
		d.drive(args);
	}
	public abstract void drive(String[] args);
}
class UsageDriver extends Driver {
	public void drive(String[] args) {
		System.out.println("Usage: java wordcount [file1 [file2 [...]]] (for the wordcount driver)");
		System.out.println("       java multiset                        (for the multiset driver)");
	}
}
class MultiDriver extends Driver {
	private static final Random rng = new Random();
	public void drive(String[] args) {
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

class WordDriver extends Driver {
	public void drive(String[] args) {
		LinkedBlockingQueue<WordCountingResult> q = new LinkedBlockingQueue<WordCountingResult>();
		for (String fileName : args) {
			File f = new File(fileName);
			WordCountRunner r = new WordCountRunner(f, q);
			r.run();
		}
		for (int read = 0; read < args.length; ++read) {
			try {
				System.out.println(q.take());
			} catch (InterruptedException e) {
				System.err.println("They're onto us!");
			}
		}
	}
}
