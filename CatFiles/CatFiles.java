import java.io.*;
public class Concatenation {
	public static void main(String[] args) {
		String[] input = tryGetInput(args);
		String output = getOutput(args);
		FileWriter f = new FileWriter(output);
		System.out.println("Opened output file "+output);
		for (String inputfile : input) {
			FileReader r = new FileReader(inputfile);
			System.out.println("Opened input file "+inputfile);
			copy(r, f);
			r.close();
		}
		f.close();
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
