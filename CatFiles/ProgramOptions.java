public class ProgramOptions {
	public final boolean append;
	public final boolean noclobber;
	public final boolean verbose;
	public ProgramOptions(boolean a, boolean nc, boolean v) {
		append = a;
		noclobber = nc;
		verbose = v;
	}
}
