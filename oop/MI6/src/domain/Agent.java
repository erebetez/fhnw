package domain;

import test.AgentTester;

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
		String formatString = "%1$18s%2$1s\n";
//		String agent = String.format(formatString, "id: ", this.id);
//		agent = agent.concat(String.format(formatString, "name: ", this.name));
//		agent = agent.concat(String.format(formatString, "vorname: ", this.firstname));
//		agent = agent.concat(String.format(formatString, "code name: ", this.codeName));
//		agent = agent.concat(String.format(formatString, "age: ", this.age));
//		agent = agent.concat(String.format(formatString, "licence to kill: ", this.licenceToKill));
//		return agent;
		
		return this.id + ", " + this.name + ", " + this.firstname + ", " + this.codeName + ", " + this.age + ", " + this.licenceToKill;
	}
	
	public static int getAgentCount() {
		return agentCount;
	}
	 
	public boolean equals(Agent agent){
		if (agent.getId() != this.id) {
			return false;
		}
		if (!agent.getName().equals(this.name)) {
			return false;
		}
		if (!agent.getFirstname().equals(this.firstname)) {
			return false;
		}
		if (agent.getAge() != this.age) {
			return false;
		}
		if (!agent.codeName.equals(this.codeName)) {
			return false;
		}
		if (agent.isLicenceToKill() != this.licenceToKill) {
			return false;
		}
		return true;
	}
	
//	public Agent clone() {
//		return this.clone();
//	}
	
	public Agent myClone() {
		Agent a = new Agent();
		a.id = this.id;
		a.codeName = this.codeName;
		a.name = this.name;
		a.firstname = this.firstname;
		a.licenceToKill = this.licenceToKill;
		return a;
	}
	
}
