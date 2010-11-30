public class Driver {
	private final static Employee happyDilbert = new Employee("Dilbert");
	static {
		happyDilbert.setSalary(55000);
	}
	public static void main(String[] args) {
		Manager m = new Manager("P.H.B.");
		m.setSalary(80000);
		m.setBonus(10000);
		System.out.println("Meet the manager.");
		System.out.println(m);
		Employee e = new Employee("Dilbert");
		e.setSalary(44000);
		System.out.println();
		System.out.println("And his employee.");
		System.out.println(e);
		System.out.println();
		System.out.println("But then, he got a raise!");
		e.setSalary(e.getSalary()*1.25);
		if (e.equals(happyDilbert)) {
			System.out.println("Now he is SO happy. Just look at him!");
			System.out.println(e);
		} else {
			System.out.println("That did no good!");
			System.out.println("Got:");
			System.out.println(e);
			System.out.println("Expected:");
			System.out.println(happyDilbert);
		}
	}
}
