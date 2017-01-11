//Didn't make this abstract because it should be "any" building not just City Hall or School
public class Building {
	// Variables
	private String name, address;

	// Constructors
	public Building(String n, String a) {
		name = n;
		address = a;
	}

	public Building() {
		name = "Default Bldg.";
		address = "1111 W. Hamilton Ave.";
	}

	// Accessor Functions
	public String getName() { return name; }
	public String getAddress() { return address; }

	public void setName(String n) { name = n; }
	public void setAddress(String a) { address = a; }
}