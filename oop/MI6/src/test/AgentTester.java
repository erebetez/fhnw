package test;

import domain.Agent;

public class AgentTester {

	public static void main(String[] args) {
		System.out.println("Anzahl Agenten " + Agent.getAgentCount());
		Agent a1 = new Agent();
		Agent a2 = new Agent("Meier", "Hans", "008", 40, false);
		Agent a3 = new Agent("Hallo", "Welt", "001", 25, false);
		
		System.out.println(a1.tellYourName());
		System.out.println(a2.tellYourName());
		System.out.println(a1);
		System.out.println(a2);
		System.out.println(a3);
		
		System.out.println("Anzahl Agenten " + Agent.getAgentCount());
	}

}
