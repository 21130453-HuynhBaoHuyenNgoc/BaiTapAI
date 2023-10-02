package chapter2.agent_AB_2;

public class AgentProgram {

	public Action execute(Percept p) {// location, status
		if(p.getLocationState()== Environment.LocationState.DIRTY) {
			return Environment.SUCK_DIRT;
		}else if(p.getAgentLocation().equals(Environment.LOCATION_A)) {
			return Environment.MOVE_RIGHT;
		}else if(p.getAgentLocation().equals(Environment.LOCATION_B)) {
			return Environment.MOVE_DOWN;
		}else if(p.getAgentLocation().equals(Environment.LOCATION_C)) {
			return Environment.MOVE_LEFT;
		}else if(p.getAgentLocation().equals(Environment.LOCATION_B)) {
			return Environment.MOVE_UP;
		}
		return NoOpAction.NO_OP;
		
	}
}