import java.util.*;

public class Committee implements Iterable<Employee> {
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

	public boolean equals(Object other) {
		if (other.getClass() != Committee.class) return false;
		return equalsCommittee((Committee) other);
	}

	private boolean equalsCommittee(Committee other) {
		if (!other.name.equals(name)) return false;
		if (other.purpose != purpose) return false; // enum type
		if (!other.chairperson.equals(chairperson)) return false;
		if (!other.members.equals(members) || !other.members.containsAll(members) || !members.containsAll(other.members)) return false;
		return true;
	}

	public int hashCode() {
		return 37*name.hashCode()+
		       (chairperson == null ? 0 : 41*chairperson.hashCode())+
		       (purpose == null ? 0 : 47*purpose.hashCode())+
		       7*membersHashCode();
	}

	private int membersHashCode() {
		int h = 0;
		for (Employee e : members) {
			h += e.hashCode();
		}
		return h;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder(name);
		sb.append("\n* Chairperson: ");
		sb.append(chairperson.toString());

		ArrayList<Employee> memberlist = new ArrayList<Employee>();
		for (Employee e : members) {
			memberlist.add(e);
		}
		Collections.sort(memberlist, new Comparator<Employee>() {
			public int compare(Employee a, Employee b) {
				return a.getName().compareTo(b.getName());
			}
		});
		for (Employee e : memberlist) {
			sb.append("\n* ");
			sb.append(e.toString());
		}
		return sb.toString();
	}

	public Iterator<Employee> iterator() {
		return members.iterator();
	}
}
