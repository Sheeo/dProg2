public class Manager extends Employee {
	private double bonus;

	public Manager(String aName, double aSalary, double aBonus) {
		super(aName, aSalary);
		bonus = aBonus;
	}

	public Manager clone() {
		return new Manager(getName(), getSalary()-bonus, bonus);
	}

	public Manager setBonus(double bonus) {
		Manager m = clone();
		m.bonus = bonus;
		return m;
	}

	public double getSalary() {
		return super.getSalary() + bonus;
	}

	public double getBonus() {
		return bonus;
	}

	public String thoughts() {
		return getName()+" has been ecstatic lately. His bonus was increased to "+
			bonus+". He has earned a yearly salary of "+
			getSalary()+" recently.";
	}

	public String toString() {
		return getName()+", Manager, "+getSalary()+"/yr inc. "+bonus+"/yr bonus";
	}

	public int hashCode() {
		return 7*super.hashCode()+29*new Double(bonus).hashCode();
	}

	public boolean equals(Object other) {
		if (other.getClass() != Manager.class) return false;
		//if (other.hashCode() != hashCode()) return false;
		return managerEquals((Manager) other);
	}

	private boolean managerEquals(Manager other) {
		if (!getName().equals(other.getName())) return false;
		if (Math.abs(bonus-other.getBonus()) > 0.001*bonus) return false;
		if (Math.abs(getSalary()-other.getSalary()) > 0.001*getSalary()) return false;
		return true;
	}
}
