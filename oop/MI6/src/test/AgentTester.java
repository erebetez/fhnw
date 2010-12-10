package test;

import domain.Agent;

public class AgentTester {

	public static void main(String[] args) {
		System.out.println("Anzahl Agenten " + Agent.getAgentCount());
		Agent a1 = new Agent();
		Agent a2 = new Agent("Meier", "Hans", "008", 40, false);
		Agent a3 = new Agent("Meier", "Welt", "001", 25, false);
		Agent a4 = new Agent("Meier", "Welt", "001", 25, false);
		Agent a5 = a1.myClone();
//		a5 = a1.clone();
		
		System.out.println(a1);
		
		a1.setCodeName("Peter");
		
		System.out.println(a1);
//		System.out.println(a2.tellYourName());
//		System.out.println(a1);
//		System.out.println(a2);
//		System.out.println(a3);
//		
//		System.out.println("Anzahl Agenten " + Agent.getAgentCount());
//		
//		
//		
//		if (a3.equals(a4)) {
//			System.out.println("gleich");
//		} else {
//			System.out.println("nicht gleicht");
//		}
//
//		if (a5.equals(a1)) {
//			System.out.println("gleich");
//		} else {
//			System.out.println("nicht gleicht");
//		}
		
	}

}
