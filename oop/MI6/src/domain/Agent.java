package domain;

public class Agent {
	// class Attributes (static)
	private static int agentCount = 0;
	
	// Attributes	
	private int id;
    private String name;
    private String firstname;
	private String codeName;
	private int age;
	private boolean licenceToKill;
	
	// constructor
	public Agent(){
		id = ++agentCount;
		name = "Bond";
		firstname = "James";
		codeName = "007";
		this.age = 25;
		this.licenceToKill = true;		
	}

	public Agent(String name, String firstname, String codeName, 
			     int age, boolean licenceToKill) {
		this.id = ++agentCount;
		this.name = name;
		this.firstname = firstname;
		this.codeName = codeName;
		this.age = age;
		this.licenceToKill = licenceToKill;
	}

	// getters and setters
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getCodeName() {
		return codeName;
	}

	public void setCodeName(String codeName) {
		this.codeName = codeName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public boolean isLicenceToKill() {
		return licenceToKill;
	}

	public void setLicenceToKill(boolean licenceToKill) {
		this.licenceToKill = licenceToKill;
	}

	public int getId() {
		return id;
	}
	
	public String tellYourName(){
		return "Mein Name ist " + this.name + ", " + 
		       this.firstname + " " + this.name + " ;)"; 
	}
	
	public String toString(){
		return this.id + ", " + this.name + ", " + this.firstname  + ", " +
		       this.codeName + ", " + this.age + ", " + this.licenceToKill;
	}
	
	public static int getAgentCount() {
		return agentCount;
	}
}
