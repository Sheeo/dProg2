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

	public Purpose getPurpose() {
		return purpose;
	}

	public void setPurpose(Purpose p) {
		purpose = p;
	}

	public void appointChairperson(Manager m) {
		chairperson = m;
	}
	
	public void addMember(Employee e) {
		members.add(e);
	}
}
