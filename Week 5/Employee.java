/**
  A class for modeling Employees
*/
public class Employee
{
	/**
		Constructs an Employee object
		@param aName the employee's name
	*/
	public Employee(String aName)
	{
		name = aName;
	}

	/**
		Sets the salary
		@param the new salary
	*/
	public void setSalary(double aSalary)
	{
		salary = aSalary;
	}

	/**
		Returns the employee's name
		@return the name
	*/
	public String getName()
	{
		return name;
	}

	/**
		Returns the employee's salary
		@return the salary
	*/
	public double getSalary()
	{
		return salary;
	}

	public String thoughts() {
		return getName()+", Employee has been miserable lately. He couldn't support his family with his measly salary of "+
			salary+" lately. He was bullied at work lately.";
	}

	public String toString() {
		return getName()+", Employee, "+getSalary()+"/yr";
	}

	public int hashCode() {
		return 13*super.hashCode()+17*name.hashCode()+23*new Double(salary).hashCode();
	}

	public boolean equals(Object other) {
		if (other.getClass() != Employee.class) return false;
		//if (other.hashCode() != hashCode()) return false;
		return employeeEquals((Employee) other);
	}

	private boolean employeeEquals(Employee other) {
		if (!getName().equals(other.getName())) return false;
		if (Math.abs(getSalary()-other.getSalary()) > 0.001*getSalary()) return false;
		return true;
	}

	private String name;
	private double salary;
}
