import java.util.*;
import java.io.*;

public class WordCounter {
	private File file;

	public WordCounter(File file) {
		this.file = file;
	}

	public int count() throws IOException {
		FileInputStream r;
		r = new FileInputStream(file);
		int c = count(r);
		r.close();
		return c;
	}

	private int count(FileInputStream r) {
		Scanner sc = new Scanner(r);
		int count = 0;
		while (sc.hasNext()) {
			sc.next();
			++count;
		}
		return count;
	}
}
