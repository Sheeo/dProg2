import java.io.*;
import java.util.concurrent.*;

public class WordCountRunner implements Runnable {
	private File file;
	private LinkedBlockingQueue<WordCountingResult> q;

	public WordCountRunner(File file, LinkedBlockingQueue<WordCountingResult> q) {
		this.file = file;
		this.q = q;
	}

	public void run() {
		WordCounter c = new WordCounter(file);
		try {
			this.q.put(new WordCountingResult(file, c.count()));
		} catch (InterruptedException e) {
			System.err.println("It's as if they don't want us to count these words");
		} catch (Exception e) {
			try {
				this.q.put(new WordCountingResult(file, e));
			} catch (InterruptedException f) {
				System.err.println("It's as if they don't want us to report these exceptions");
			}
		}
	}
}
