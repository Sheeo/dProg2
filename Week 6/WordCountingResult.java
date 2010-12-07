import java.io.*;
public class WordCountingResult {
	public final File file;
	public final int count;
	public final Exception exception;

	public WordCountingResult(File f, int c) {
		file = f;
		count = c;
		exception = null;
	}
	public WordCountingResult(File f, Exception e) {
		file = f;
		count = -1;
		exception = e;
	}
	public String toString() {
		if (exception != null) {return file+": "+exception;}
		return file+": "+count;
	}
}
