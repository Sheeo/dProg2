import java.io.*;
public class BinaryCatenator implements Catenator {
	private String input;
	private String output;
	private OutputStream outputStream;
	private ProgramOptions opts;
	public BinaryCatenator() {
		outputStream = null;
		output = null;
	}
	public void setOpts(ProgramOptions opts) {
		this.opts = opts;
	}
	public void close() {
		if (outputStream != null) {
			try {
				outputStream.close();
			} catch (IOException e) {
				System.err.println("Couldn't close "+output);
			}
		}
	}
	public void setOutput(String outputArg) {
		try {
			outputStream = outputFactory(outputArg);
		} catch (IOException e) {
			throw new InvalidUsageException("Couldn't open "+outputArg+" for writing");
		}
	}
	public void catenate(String input) {
		if (outputStream == null) {
			throw new IllegalStateException("Can't catenate without an output specified");
		}
		InputStream r;
		try {
			r = inputFactory(input);
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

	private void copy(InputStream inputStream) throws IOException {
		byte[] buf = new byte[1024];
		int totes = 0;
		while (true) {
			int read = inputStream.read(buf);
			if (read == -1) break;
			totes += read;
			outputStream.write(buf, 0, read);
		}
		if (opts.verbose) System.err.println("Wrote "+totes+" bytes");
	}

	private OutputStream outputFactory(String outputfile) throws IOException, InvalidUsageException {
		if (outputfile == null) {
			throw new InvalidUsageException("Which file?");
		}
		if (outputfile.equals("-")) {
			return System.out;
		} else {
			File file = new File(outputfile);
			if (opts.noclobber && file.exists()) {
				throw new InvalidUsageException("Won't open "+outputfile+" for writing: File exists and -nc specified");
			}
			return new FileOutputStream(file, opts.append);
		}
	}

	private InputStream inputFactory(String inputfile) throws IOException {
		if (inputfile.equals("-")) {
			return System.in;
		} else {
			return new FileInputStream(inputfile);
		}
	}

}
