import java.io.*;
public class TextCatenator implements Catenator {
	private String output;
	private PrintWriter writer;
	private ProgramOptions opts;
	public TextCatenator() {
		output = null;
		writer = null;
	}
	public void setOpts(ProgramOptions opts) {
		this.opts = opts;
	}
	public void close() {
		if (writer != null) {
			writer.close();
		}
	}
	public void setOutput(String outputArg) {
		try {
			if (outputArg.equals("-")) {
				writer = new PrintWriter(System.out);
			} else {
				writer = new PrintWriter(new BufferedWriter(new FileWriter(outputArg, opts.append)));
			}
		} catch (IOException e) {
			throw new InvalidUsageException("Couldn't open "+outputArg+" for writing");
		}
	}
	public void catenate(String input) {
		if (writer == null) {
			throw new IllegalStateException("Can't catenate without an output specified");
		}
		BufferedReader r;
		try {
			if (input.equals("-")) {
				r = new BufferedReader(new InputStreamReader(System.in));
			} else {
				r = new BufferedReader(new FileReader(input));
			}
		} catch (IOException e) {
			System.err.println("Couldn't open "+input+" for reading");
			return;
		}
		if (opts.verbose) System.err.println("Opened input file "+input);
		try {
			try {
				copy(r);
			} finally {
				r.close();
			}
		} catch (IOException e) {
			System.err.println("Couldn't copy "+input+" to output");
		}
	}

	private void copy(BufferedReader r) throws IOException {
		String line = r.readLine();
		int lines = 0;
		while (line != null) {
			writer.println(line);
			++lines;
			line = r.readLine();
		}
		if (opts.verbose) System.err.println("Wrote "+lines+" lines");
	}
}
