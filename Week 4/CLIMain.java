public class CLIMain
{
	public static void main(String[] args)
	{
		BinomialContext c = new BinomialContext(args[0]);

		System.out.println(c.binomial(Long.parseLong(args[1]), Long.parseLong(args[2])));
	}
}
