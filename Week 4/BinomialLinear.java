/**
 * Class for calculating the binomial coefficient
 */
class BinomialLinear implements Binomial
{
	/**
	 * Recursive method
	 * f(n,k)=(n,k-1)*(n-k+1)/k for n > k > 0
	 * f(n,k)=1					for k = 0 or n = k
	 *
	 */
	public long binomial(long n, long k)
	{
		if (0 > k || k > n || n > 60)
			throw new IllegalArgumentException();

		// Base case
		if(k == 0 || n == k)
			return 1;

		// Recursive case
		return binomial(n, k-1) * (n-k+1)/k;
	}
}
