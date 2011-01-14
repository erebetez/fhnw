package domain;

import java.util.*;

import db.*;

public class Mi6 extends Observable {
	private static Mi6 uniqueInstance = null;
	private AgentDAO agentDAO;
	
	private Vector<Agent> agentList;

	public static Mi6 getUniqueInstance(){
		if( uniqueInstance == null ) {
			uniqueInstance = new Mi6();
		}
		return uniqueInstance;
	}
	
	private Mi6(){
		agentList = new Vector<Agent>();
		agentDAO = AgentDummyDAOImpl.getUniqueInstance();
		//agentDAO = AgentDBDAOImpl.getUniqueInstance();
		agentList = agentDAO.getAllAgents();
	}
	
	public boolean addAgent(Agent agent){
		boolean ok = this.agentList.add(agent);
		this.setChanged();
		this.notifyObservers();
		return ok;
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
