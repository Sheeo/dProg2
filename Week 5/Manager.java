/**
  A class for modeling Employees who are Managers
*/
public class Manager extends Employee 
{
	/**
		Constructs a Manager object
		@param aName the employee's name
	*/
	public Manager(String aName)
	{
		super(aName);
		bonus = 0;
	}

	/**
		Sets the bonus
		@param the new bonus
	*/
	public void setBonus(double aBonus)
	{
		bonus = aBonus;
	}

	/**
		Returns the manager's salary
		@return the salary
	*/
	public double getSalary()
	{
		return super.getSalary() + bonus;
	}

	public double getBonus() {
		return bonus;
	}

	public String toString() {
		return getName()+" has been ecstatic lately. His bonus was increased to "+
			bonus+" lately. He has earned a yearly salary of "+
			getSalary()+" recently.";
	}

	public int hashCode() {
		return 7*super.hashCode()+29*new Double(bonus).hashCode();
	}

	public boolean equals(Object other) {
		if (other.getClass() != Manager.class) return false;
		if (other.hashCode() != hashCode()) return false;
		return managerEquals((Manager) other);
	}

	private boolean managerEquals(Manager other) {
		if (!getName().equals(other.getName())) return false;
		if (Math.abs(bonus-other.getBonus()) > 0.001*bonus) return false;
		if (Math.abs(getSalary()-other.getSalary()) > 0.001*getSalary()) return false;
		return true;
	}

	private double bonus;
}
