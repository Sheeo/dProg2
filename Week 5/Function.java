/*
 * Klasser der implementerer Function repræsenterer en differentiabel
 * funktion f.
 */
public interface Function {

    /**
     * Udregner værdien af funktionen f.
     * @param x
     * @return f(x)
     */
    public double getValue(double x);

    /**
     * Udregner den afledede værdi af funktionen f.
     * @param x
     * @return f'(x)
     */
    public double getDerivativeValue(double x);
}