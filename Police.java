public class Police extends Person implements Employee{
	private enum Role {
		PATROL, SARGENT, CAPTAIN, CHIEF
	}
	private	Role role;
	private static int policeCount = 0;	
	private int policeID;

	public Police() {
		super();
		role = Role.PATROL;

		this.setFName("Mr. " + this.getFName());
		this.setLName(this.getLName() + " " + this.getCount());

		policeCount++;
		policeID = policeCount + 100;
	}

	public Police(String f, String l, String num, int a, Role r) {
		super(f,l,num,a);
		this.role = r;

		this.setFName("Mr. " + this.getFName());
		this.setLName(this.getLName() + " " + this.getCount());

		policeCount++;
		policeID = policeCount + 100;
	}


	public Role getRole() { return this.role; }
	public void setRole(Role r) { this.role = r; }

	public void getPaid() {
		System.out.printf("%s %s %s (officer #%d) got paid!\n", role, this.getFName(), this.getLName(), policeID);
	}

	public int getEmployeeID() { return policeID; }

}