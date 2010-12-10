package domain;

import java.util.Vector;

public class Mi6 {
	private Vector<Agent> agentList;

	public Mi6(){
		agentList = new Vector<Agent>();
	}
	
	public boolean addAgent(Agent agent){
		return this.agentList.add(agent);
	}

	public int getAgentCount() {
		return this.agentList.size();
	}
	
	public Agent getAgent(int idx) {
		if (idx < 0 || idx >= this.agentList.size()) return null;
		return this.agentList.get(idx);
	}
}
