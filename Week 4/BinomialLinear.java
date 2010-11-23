/**
 * Class for calculating BinomialCoefficient
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
		// Base case
		if(k == 0 || n == k)
			return 1;
		// Recursive case
		return func(n, k-1) * (n-k+1)/k;
	}
}
