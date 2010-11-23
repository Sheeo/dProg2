public class BinomialContext
{
	private Binomial b;
	
	public BinomialContext(String strategy)
	{
		if(strategy.equals("linear"))
			b = new BinomialLinear();
		else if(strategy.equals("slow"))
			b = new BinomialSlow();
	}

	public long binomial(long n, long k)
	{
		return b.binomial(n, k);
	}
}
