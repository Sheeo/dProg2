import java.util.*;
import java.io.*;
import java.util.concurrent.*;

public abstract class Driver {
	public static void main(String[] args) {
		Driver d = new WordDriver();
		d.drive(args);
	}
	public abstract void drive(String[] args);
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
