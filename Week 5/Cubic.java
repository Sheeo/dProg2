public class Cubic implements Function {
	private final double a;
	private final double b;
	private final double c;
	public Cubic(double a, double b, double c) {
		this.a = a;
		this.b = b;
		this.c = c;
	}
	public double getValue(double x) {
		return a+x*b+x*x*c;
	}
	public double getDerivativeValue(double x) {
		return b+2.0*x*c;
	}
}
