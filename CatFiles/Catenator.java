public interface Catenator {
	public void setOpts(ProgramOptions opts);
	public void setOutput(String output);
	public void catenate(String input);
	public void close();
}
