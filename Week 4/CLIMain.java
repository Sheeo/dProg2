import java.io.*;

public class CLIMain
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter strategy (linear/slow)");
		String strategy = in.readLine();
		System.out.println("Enter n: ");
		long n = Long.parseLong(in.readLine());

		System.out.println("Enter k: ");
		long k = Long.parseLong(in.readLine());

		BinomialContext c = new BinomialContext(strategy, n, k);
		System.out.println("BinomialCoefficient: ");
		System.out.println(c.binomial());
	}
}
