import java.io.*;

/**
 * CLI wrapper around BinomialContext context, that always chooses the linear strategy.
 */
public class CLIMain
{
	public static void main(String[] args)
	{
		try
		{
			long n = Long.parseLong(args[0]);
			long k = Long.parseLong(args[1]);
			BinomialContext c = new BinomialContext("linear", n , k);
			System.out.println(c.binomial());
		}
		catch(IndexOutOfBoundsException e)
		{
			System.out.println("Illegal argument(s)");
		}
	}
}
