/**
* This class makes an abstract Person. Police, Teacher, and Kid all inherit from Person
* @author Chase Lake
*/
public abstract class Person {
	private static int count = 0;
	private int age;
	private String fname, lname, phoneNum;

	public Person() {
		fname = "Joe";
		lname = "Schmoe";
		phoneNum = "111-1111";
		age = 30;
		count++;
	}

	public Person(String f, String l, String num, int a) {
		fname = f;
		lname = l;
		phoneNum = num;
		age = a;
	}

	public void setPhoneNum(String num) { phoneNum = num; }
	public void setFName(String f) { fname = f; }
	public void setLName(String l) { lname = l; }
	public void setAge(int a) { age = a; }

	public String getPhoneNum() { return phoneNum; }
	public String getFName() { return fname; }
	public String getLName() { return lname; }
	public int getAge() { return age; }
	public int getCount() { return count; }
}