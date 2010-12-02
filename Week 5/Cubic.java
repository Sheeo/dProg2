public class Cubic extends Function {
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
	public String toString() {
		StringBuilder sb = new StringBuilder("f(x) = ");
		int summands = 0;
		if (a != 0.0) {
			sb.append(a);
			++summands;
		}
		if (b != 0.0) {
			if (summands != 0) sb.append(" + ");
			sb.append(b);
			sb.append("*x");
			++summands;
		}
		if (c != 0.0) {
			if (summands != 0) sb.append(" + ");
			sb.append(c);
			sb.append("*x^2");
			++summands;
		}
		if (d != 0.0) {
			if (summands != 0) sb.append(" + ");
			sb.append(d);
			sb.append("*x^3");
			++summands;
		}
		if (summands == 0) {
			sb.append("0");
		}
		return sb.toString();
	}
}
