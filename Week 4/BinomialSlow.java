public class BinomialSlow implements Binomial
{
	public long binomial(long n, long k)
	{
		// Base case
		if(k == 0 || n == k)
			return 1;
		// Recursive case
		return (binomial(n-1, k) + binomial(n-1, k-1));
	}
}
