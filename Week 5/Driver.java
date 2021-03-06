import java.util.*;

public abstract class Driver {
	public static void main(String[] args) {
		Driver d;
		if (args.length > 0 && args[0].equals("root")) {
			d = new RootDriver();
		} else if (args.length > 0 && args[0].equals("committee")) {
			d = new CommitteeDriver();
		} else {
			d = new UsageDriver();
		}
		d.drive(args);
	}
	public void drive(String[] args) {
	}
}

class UsageDriver extends Driver {
	public void drive(String[] args) {
		System.out.println("Usage: java Driver {committee|root}");
	}
}

class RootDriver extends Driver {
	private final static Random rng = new Random();
	public void drive(String[] args) {
		double y;
		if (args.length > 1) {
			y = Double.parseDouble(args[1]);
		} else {
			y = (1+Math.abs(rng.nextGaussian())*100);
			y = y*y*y;
		}
		int lower = 0;
		int higher = 1;
		while (higher*higher*higher < y) {
			++lower;
			++higher;
		}
		System.out.println("Finding the cube root of "+y+" (between "+lower+" and "+higher+")");
		Function fn = new Cubic(-y,0.0,0.0,1.0);
		System.out.println("Root by bisection:");
		System.out.println(FindRoot.bisection(fn, lower, higher+0.1));
		System.out.println("Root by Newton:");
		System.out.println(FindRoot.newtonIteration(fn, lower+(higher-lower)/2.0));
	}
}

class CommitteeDriver extends Driver {
	private final static Employee happyDilbert = new Employee("Dilbert", 55000);
	private final static Random rng = new Random();

	private Manager manager;
	private Employee employee;
	private ArrayList<Employee> colleagues;
	private List<Committee> committees;

	/* Mutable members are no good as members in a HashSet. Therefore, Employee
	 * is immutable.
	 * http://javaadventure.blogspot.com/2007/02/hashcode-pitfalls-with-hashset-and.html
	 */

	public CommitteeDriver() {
		createMananger();
		createDilbert();
		createColleagues();
		createCommittee();
	}

	public void drive(String[] args) {
		meetTheManager();
		meetDilbert();
		dilbertGetsARaise();
		checkHappiness();
		meetTheCommittee();
	}

	private void createMananger() {
		manager = new Manager("P.H.B.", 80000, 10000);
	}

	private void meetTheManager() {
		System.out.println("Meet the manager.");
		System.out.println(manager.thoughts());
		System.out.println();
	}

	private void createDilbert() {
		employee = new Employee("Dilbert", 44000);
	}

	private void meetDilbert() {
		System.out.println("And his employee.");
		System.out.println(employee.thoughts());
		System.out.println();
	}

	private void dilbertGetsARaise() {
		System.out.println("But then, he got a raise!");
		employee = employee.setSalary(employee.getSalary()*1.25);
	}

	private void checkHappiness() {
		if (employee.equals(happyDilbert)) {
			System.out.println("Now he is SO happy. Just look at him!");
			System.out.println(employee.thoughts());
		} else {
			System.out.println("That did no good!");
			System.out.println("Got:");
			System.out.println(employee);
			System.out.println("Expected:");
			System.out.println(happyDilbert);
		}
		System.out.println();
	}

	private void createColleagues() {
		colleagues = new ArrayList<Employee>();
		colleagues.add(new Employee("Phil", 45000));
		colleagues.add(new Employee("Will", 43000));
		colleagues.add(new Employee("Eve", 25000));
		colleagues.add(new Employee("Adam", 38000));
	}

	private void createCommittee() {
		ArrayList<Committee> list = new ArrayList<Committee>();
		committees = list;
		Committee programmers = new Committee("Java Implementations Committee");
		programmers.appointChairperson(manager);
		programmers.addMember(employee);
		for (Employee e : colleagues) {
			/* Select employees for the committee based on some criteria.  We
			 * use a random number generator to make this decision, since that
			 * seems to closely model the situation in real life.
			 */
			if (rng.nextDouble() >= 0.5) {
				programmers.addMember(e);
			}
		}
		list.add(programmers);

		Committee coffeefans = new Committee("Java Implementations Committee");
		coffeefans.appointChairperson(manager);
		for (Employee e : programmers) {
			coffeefans.addMember(e);
		}
		list.add(coffeefans);
	}

	private void meetTheCommittee() {
		System.out.println("The pre-raise Dilbert was in a programming committee of some sort.");
		System.out.println(committees.get(0));
		System.out.println();
		System.out.println("He also joined a coffee brewers committee.");
		System.out.println(committees.get(1));
		System.out.println();
		if (committees.get(0).equals(committees.get(1))) {
			System.out.println("My oh my if they weren't identical!");
		} else {
			System.out.println("Huh! I can't tell the difference, but they're !equals, somehow.");
		}
	}
}
