import java.util.ArrayList;
import java.util.Random;

public class City {
	private ArrayList<Person> citizens = new ArrayList<Person>();
	private Random rand = new Random();
	private School school = new School();
	private CityHall cityHall = new CityHall();
	private int maxTeachers;
	private int maxOfficers;
	private int maxKids;
	
	public City() {
		Init();
	}
	
	// Initializes the city with random people in random places
	private void Init() {
		maxTeachers = (rand.nextInt(30) + 1);
		maxOfficers = (rand.nextInt(100) + 1);
		maxKids = (rand.nextInt(500) + 1);
		
		for (int i = 0; i < maxTeachers; i++) {
			Teacher teach = new Teacher();
			citizens.add(teach);
			//if (rand.nextInt()%10 < 9) // ~90% chance of teachers being in school
			school.addTeacher(teach);
		}

		for (int i = 0; i < maxOfficers; i++) {
			Police officer = new Police();
			citizens.add(officer);
			//if (rand.nextInt()%3 == 1) // ~33% chance officers are in City Hall (most should be "out on patrol")
			cityHall.addOfficer(officer);
		}

		for (int i = 0; i < maxKids; i++) {
			Kid kid = new Kid();
			citizens.add(kid);
			//if (rand.nextInt()%10 < 7) // ~70% chance of students being in school
			school.addStudent(kid);
		}
	}

	// Get basic info from our program
	public String getInfo() {
		String a = String.format("Number of teachers: %d  ", maxTeachers);
		//String b = String.format("In school: %d ", school.getNumTeachers());
		String c = String.format("Number of kids: %d  ", maxKids);
		//String d = String.format("In school: %d ", school.getNumStudents());
		String e = String.format("Number of officers: %d", maxOfficers);
		//String f = String.format("In City Hall: %d", cityHall.getNumOfficers());
		return a+c+e;
	}

	// Pays all of the employees
	public String payDay() {
		return "Everyone got paid!";
		/*
		for (Person p : citizens) {
			if (p instanceof Employee) {
				((Employee)p).getPaid(); 
			}
		}
		*/
	}
	
	public void addPerson(Person p) {
		citizens.add(p);
		
		if (p instanceof Police){
			maxOfficers++;
		} else if (p instanceof Teacher) {
			maxTeachers++;
		} else {
			maxKids++;
		}
	}
	
	// Accessing functions
	public int getTeachers() { return maxTeachers; }
	public int getOfficers() { return maxOfficers; }
	public int getStudents() { return maxKids; }
	public School getSchool() { return school; }
	public CityHall getCityHall() { return cityHall; }
}