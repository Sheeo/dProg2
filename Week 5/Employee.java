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

	public String toString() {
		return getName()+", Employee has been miserable lately. He couldn't support his family with his measly salary of "+
			salary+" lately. He was bullied at work lately.";
	}

	public int hashCode() {
		return 13*super.hashCode()+17*name.hashCode()+23*new Double(salary).hashCode();
	}

	private String name;
	private double salary;
}
