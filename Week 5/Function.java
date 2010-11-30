/*
 * Klasser der implementerer Function repr�senterer en differentiabel
 * funktion f.
 */
public interface Function {

    /**
     * Udregner v�rdien af funktionen f.
     * @param x
     * @return f(x)
     */
    public double getValue(double x);

    /**
     * Udregner den afledede v�rdi af funktionen f.
     * @param x
     * @return f'(x)
     */
    public double getDerivativeValue(double x);
}