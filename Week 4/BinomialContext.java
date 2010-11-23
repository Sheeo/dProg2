public class BinomialContext
{
	private Binomial b;
	private long n;
	private long k;
	
	public BinomialContext(String strategy, long n, long k)
	{
		if (n > 60 || k > 60 || n < 0 || k < 0) {
			throw new IllegalArgumentException("Arguments ("+n+","+k+") out of bounds");
		}
		if(strategy.equals("linear"))
			b = new BinomialLinear();
		else if(strategy.equals("slow"))
			b = new BinomialSlow();
		this.n = n;
		this.k = k;
	}

	public long binomial()
	{
		return b.binomial(n, k);
	}
}
