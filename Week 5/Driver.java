public class Driver {
	private final static Employee happyDilbert = new Employee("Dilbert");
	static {
		happyDilbert.setSalary(55000);
	}

	public static void main(String[] args) {
		Driver d = new Driver();
		d.drive(args);
	}

	private Manager manager;
	private Employee employee;

	public Driver() {
		createMananger();
		createDilbert();
	}

	public void drive(String[] args) {
		meetTheManager();
		meetDilbert();
		dilbertGetsARaise();
		checkHappiness();
	}

	private void createMananger() {
		manager = new Manager("P.H.B.");
		manager.setSalary(80000);
		manager.setBonus(10000);
	}

	private void meetTheManager() {
		System.out.println("Meet the manager.");
		System.out.println(manager.thoughts());
		System.out.println();
	}

	private void createDilbert() {
		employee = new Employee("Dilbert");
		employee.setSalary(44000);
	}

	private void meetDilbert() {
		System.out.println("And his employee.");
		System.out.println(employee.thoughts());
		System.out.println();
	}

	private void dilbertGetsARaise() {
		System.out.println("But then, he got a raise!");
		employee.setSalary(employee.getSalary()*1.25);
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
	}
}
