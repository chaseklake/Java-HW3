public class Kid extends Person {
	private String faveCandy;

	public Kid(String f, String l, String num, int a, String c) {
		super(f, l, num, a);
		faveCandy = c;
	}

	public Kid() {
		super();
		this.setFName(this.getFName() + " Jr.");
		this.setLName(this.getLName() + " " + this.getCount());
		faveCandy = "Lollipops";
	}

	public String getFaveCandy() { return faveCandy; }
	public void setFaveCandy(String c) { faveCandy = c; }
}