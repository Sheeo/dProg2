public class Cubic implements Function {
	private final double a;
	private final double b;
	private final double c;
	private final double d;
	public Cubic(double a, double b, double c, double d) {
		this.a = a;
		this.b = b;
		this.c = c;
		this.d = d;
	}
	public double getValue(double x) {
		return a+x*b+x*x*c+x*x*x*d;
	}
	public double getDerivativeValue(double x) {
		return b+2.0*x*c+3.0*x*x*d;
	}
}
