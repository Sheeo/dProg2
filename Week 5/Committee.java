import java.util.*;

public class Committee {
	private String name;
	private Manager chairperson;
	private Purpose purpose;
	private HashSet<Employee> members;

	public Committee(String n) {
		name = n;
		purpose = Purpose.NONE;
		members = new HashSet<Employee>();
	}

	public String getName() {
		return name;
	}

	public Purpose getPurpose() {
		return purpose;
	}

	public void setPurpose(Purpose p) {
		purpose = p;
	}

	public void appointChairperson(Manager m) {
		chairperson = m;
	}

	public Manager getChairperson() {
		return chairperson;
	}
	
	public void addMember(Employee e) {
		members.add(e);
	}

	public HashSet<Committee> getMembers() {
		return (HashSet<Committee>) members.clone();
	}
	
	public boolean equals(Object other) {
		if (other.getClass() != Committee.class) return false;
		return equalsCommittee((Committee) other);
	}

	private boolean equalsCommittee(Committee other) {
		if (!other.getName().equals(name)) return false;
		if (other.getPurpose() != purpose) return false; // enum type
		if (!other.getChairperson().equals(chairperson)) return false;
		if (!other.getMembers().equals(members)) return false;
		return true;
	}
}
