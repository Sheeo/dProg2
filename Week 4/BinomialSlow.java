/**
 * Class for calculating the binomial coefficient, in a slow manner.
 */
public class BinomialSlow implements Binomial
{
	/**
	 * Recursion over
	 * f(n,k) = (n-1, k) + (n-1, k-1)	for n > k > 0
	 * f(n,k) = 1						for k == 0 or n == k
	 */
	public long binomial(long n, long k)
	{
		if (0 > k || k > n || n > 60)
			throw new IllegalArgumentException();

		// Base case
		if(k == 0 || n == k)
			return 1;

		// Recursive case
		return binomial(n-1, k) + binomial(n-1,k-1);
	}
}
