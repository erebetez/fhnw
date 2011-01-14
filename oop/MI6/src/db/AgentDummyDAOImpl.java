package db;

import java.util.Vector;

import domain.Agent;

public class AgentDummyDAOImpl implements AgentDAO {
	private static AgentDummyDAOImpl uniqueInstance = null;
	private Vector<Agent> agents; 

	private AgentDummyDAOImpl(){
		agents = new Vector<Agent>();
		agents.add(new Agent("Bond", "James", "007", 28, true));
		agents.add(new Agent("Meier", "Urs", "008", 28, true));
		agents.add(new Agent("Fricker", "Fridolin", "009", 28, true));
		agents.add(new Agent("Haas", "Walter", "001", 28, false));
		agents.add(new Agent("Blunt", "Jonny", "002", 28, false));
		agents.add(new Agent("Dias", "Fernando", "003", 28, false));
		agents.add(new Agent("Caber", "Michel", "004", 28, false));
		agents.add(new Agent("Weber", "Werner", "005", 28, false));
		agents.add(new Agent("Gasser", "Sascha", "006", 28, false));
	}
	
	public static AgentDummyDAOImpl getUniqueInstance(){
		if (uniqueInstance == null){
			uniqueInstance = new AgentDummyDAOImpl();
		}
		return uniqueInstance;
	}


	@Override
	public Vector<Agent> getAllAgents() {
		return agents;
	}
}
