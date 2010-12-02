/*
 * Klassen FindRoot implementerer to metoder til at finde nulpunktet 
 * af en given funktion. OBS: BEGGE METODER ER NUMERISK USTABILE!
 */
public class FindRoot {

	/**
	 * Metode der finder et nulpunkt for en kontinuert funktion f i 
	 * intervallet [lower,higher]. For at sikre at der findes en løsning
	 * kræves det at f(lower)*f(higher) < 0.
	 * @param f funktion for hvilken der vil findes et nulpunkt.
	 * @param lower nedre grænse for intervallet.
	 * @param higher øvre grænse for intervallet.
	 * @return et tal x så f(x) ~= 0.
	 */
	public static double bisection(Function f, double lower, double higher) {
		int iterations = 0;
		double average = lower+(higher-lower)/2.0;
		while(f.getValue(average) != 0 && iterations < 1000) {
			iterations++;
			if(f.getValue(average)*f.getValue(higher) < 0)
				lower = average;
			else
				higher = average;
			average = lower+(higher-lower)/2.0;
		}
		System.out.println("Bisection required " + iterations + 
		                   " iterations to find a root.");
		return average;
	}

	/**
	 * Metode der finder et nulpunkt for en differentiabel funktion f 
	 * ved Newton iteration startende fra en værdi x. Det forventes at
	 * f'(x) != 0 i omegnen nulpunktet, og at startværdien x er nær
	 * nulpunktet.
	 * @param f funktion for hvilken der vil findes et nulpunkt.
	 * @param x startværdi til Newton iteration.
	 * @return et tal x så f(x) ~= 0.
	 */
	public static double newtonIteration(Function f, double x) {
		return newtonIteration(f, x, 1e-7);
	}
	public static double newtonIteration(Function f, double x, double precision) {
		double previousX;
		int iterations = 0;
		double dx;
		do {
			iterations++;
			previousX = x;
			dx = f.getValue(x)/f.getDerivativeValue(x);
			x = x - dx;
		} while(Math.abs(dx*x) > precision);
		System.out.println("Newton iteration required " + iterations + 
		                   " iterations to find a root.");
		return x;
	}
}
