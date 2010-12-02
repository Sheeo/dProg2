/*
 * Klasser der implementerer Function repræsenterer en differentiabel
 * funktion f.
 */
public abstract class Function {

    /**
     * Udregner værdien af funktionen f.
     * @param x
     * @return f(x)
     */
    public abstract double getValue(double x);

    /**
     * Udregner den afledede værdi af funktionen f.
     * @param x
     * @return f'(x)
     */
    public abstract double getDerivativeValue(double x);

	public String toString() {
		return "f(x) = (machine code)";
	}
}
