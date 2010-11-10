import java.util.*;
import java.io.*;

public class CatFiles {
	private Catenator cat;

	private List<String> inputArgs;
	private String outputArg;

	private ProgramOptions opts;

	public static void main(String[] args) {
		try {
			CatFiles cat = new CatFiles(args);
			cat.execute();
		} catch (InvalidUsageException e) {
			System.err.println(e.getMessage());
			usage();
			System.exit(1);
		} catch (IOException e) {
			System.err.println("I/O error");
			e.printStackTrace();
			System.exit(1);
		}
	}

	public CatFiles(String[] argv) throws InvalidUsageException {
		class Args {
			public ArrayList<String> inputArgs;
			public String outputArg;
			public Args() {
				inputArgs = new ArrayList<String>();
				outputArg = null;
			}
			public void add(String arg) {
				if (outputArg != null) {
					inputArgs.add(outputArg);
				}
				outputArg = arg;
			}
		}
		Args args = new Args();
		boolean append = false;
		boolean noclobber = false;
		boolean verbose = false;
		boolean onlyfiles = false;
		for (int i = 0; i < argv.length; ++i) {
			String arg = argv[i];
			if (onlyfiles) {
				args.add(arg);
				continue;
			}
			if (arg.equals("--")) {
				onlyfiles = true;
				continue;
			}
			if (arg.length() > 1 && arg.charAt(0) == '-') {
				if (arg.equals("-a")) {
					append = true;
				} else if (arg.equals("-nc")) {
					noclobber = true;
				} else if (arg.equals("-v")) {
					verbose = true;
				} else {
					throw new InvalidUsageException("Unrecognised option: "+arg);
				}
				continue;
			}
			args.add(arg);
		}
		inputArgs = args.inputArgs;
		outputArg = args.outputArg;

		opts = new ProgramOptions(append, noclobber, verbose);
		cat = new BinaryCatenator();
		cat.setOpts(opts);
	}

	public void execute() throws IOException, InvalidUsageException {
		cat.setOutput(outputArg);
		if (opts.verbose) System.err.println("Opened output file "+outputArg);
		for (String input : inputArgs) {
			cat.catenate(input);
		}
		cat.close();
	}

	private static void usage() {
		System.err.println("usage: java CatFiles [-a|-nc] [--] input [input [...]] output");
		System.err.println("If input is -, read from standard input. If output is -, write to standard output.");
	}
}
