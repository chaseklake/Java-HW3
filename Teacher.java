public class Teacher extends Person implements Employee{
	private static int teacherCount = 0;
	private int teacherID;
	private int gradeLevel;
	private String certification;

	public Teacher() {
		super();
		this.setFName("Prof. " + this.getFName());
		this.setLName(this.getLName() + " " + this.getCount());
		gradeLevel = 1;
		certification = "Elementary";
		teacherCount++;
		teacherID = teacherCount + 1000;
	}

	public Teacher(String f, String l, String num, int a, int g, String c) {
		super(f, l, num, a);
		gradeLevel = g;
		certification = c;

		this.setFName("Prof. " + this.getFName());
		this.setLName(this.getLName() + " " + this.getCount());

		teacherCount++;
		teacherID = teacherCount + 1000;
	}
	public int getGL() { return gradeLevel; }
	public String getCert() { return certification; }
	public void setGL(int g) { gradeLevel = g; }
	public void setCert(String c) { certification = c; }

	public void getPaid() {
		System.out.printf("%s %s (teacher #%d) got paid!\n", this.getFName(), this.getLName(), teacherID);
	}

	public int getEmployeeID() { return teacherID; }
}