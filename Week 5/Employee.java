public class Employee {
	private String name;
	private double salary;

	public Employee(String aName, double aSalary) {
		name = aName;
		salary = aSalary;
	}

	public void setSalary(double aSalary) {
		salary = aSalary;
	}

	public String getName() {
		return name;
	}

	public double getSalary() {
		return salary;
	}

	public String thoughts() {
		return getName()+", Employee has been miserable lately. He couldn't "+
		       "support his family with his measly salary of "+salary+
		       " lately. He was bullied at work lately.";
	}

	public String toString() {
		return getName()+", Employee, "+getSalary()+"/yr";
	}

	public int hashCode() {
		return 13*super.hashCode()
		       +17*name.hashCode()
		       +23*new Double(salary).hashCode();
	}

	public boolean equals(Object other) {
		if (other.getClass() != Employee.class) return false;
		return employeeEquals((Employee) other);
	}

	private boolean employeeEquals(Employee other) {
		if (!getName().equals(other.getName())) return false;
		if (Math.abs(getSalary()-other.getSalary()) > 0.001*getSalary())
			return false;
		return true;
	}
}
