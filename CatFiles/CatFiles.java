import java.io.*;
public class CatFiles {
	public static void main(String[] args) {
		String[] input = tryGetInput(args);
		String output = getOutput(args);
		FileWriter f;
		try {
			f = new FileWriter(output);
		} catch (IOException e) {
			System.err.println("Couldn't open "+output+" for writing");
			e.printStackTrace();
			System.exit(1);
			return;
		}
		System.out.println("Opened output file "+output);
		for (String inputfile : input) {
			FileReader r;
			try {
				r = new FileReader(inputfile);
			} catch (IOException e) {
				System.err.println("Couldn't open "+inputfile+" for reading");
				e.printStackTrace();
				continue;
			}
			System.out.println("Opened input file "+inputfile);
			try {
				copy(r, f);
				r.close();
			} catch (IOException e) {
				System.err.println("Couldn't copy "+inputfile+" to output");
				e.printStackTrace();
				continue;
			}
		}
		try {
			f.close();
		} catch (IOException e) {
			System.err.println("Couldn't close "+output);
			e.printStackTrace();
			System.exit(1);
			return;
		}
	}

	private static String[] getInput(String[] args) {
		String[] res = new String[args.length-1];
		for (int i = 0; i < res.length; ++i) {
			res[i] = args[i];
		}
		return res;
	}

	private static String getOutput(String[] args) {
		return args[args.length-1];
	}

	private static String[] tryGetInput(String[] args) {
		try {
			String[] res = getInput(args);
			return res;
		} catch (IndexOutOfBoundsException e) {
			usage();
			System.exit(1);
			return new String[0];
		}
	}

	private static void copy(Reader input, Writer output) throws IOException {
		char[] cbuf = new char[1024];
		int totes = 0;
		while (true) {
			int read = input.read(cbuf);
			if (read == -1) break;
			totes += read;
			output.write(cbuf, 0, read);
		}
		System.out.println("Wrote "+totes+" bytes");
	}

	private static void usage() {
	}
}
