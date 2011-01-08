package domain;

import java.util.Vector;

public class Mi6 {
	private static Mi6 uniqueInstance = null;
	
	private Vector<Agent> agentList;

	public static Mi6 getUniqueInstance(){
		if( uniqueInstance == null ) {
			uniqueInstance = new Mi6();
		}
		return uniqueInstance;
	}
	
	private Mi6(){
		agentList = new Vector<Agent>();
	}
	
	public boolean addAgent(Agent agent){
		return this.agentList.add(agent);
	}

	public int count() {
		return this.agentList.size();
	}
	
	public Agent getAgent(int idx) {
		if (idx < 0 || idx >= this.agentList.size()) return null;
		return this.agentList.get(idx);
	}

	@Override
	public String toString() {
		String agents = "Agents in Mi6:\n";
		for( int i = 0; i < this.count(); ++i ){
			agents = agents.concat( this.getAgent(i) + "\n");
		}
		return agents;
	}
}
