package task1;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class GraphSearch implements IPuzzleAlgo {

	@Override
	public Node execute(Puzzle model) {
		Queue<Node> frontier = new LinkedList<Node>();
		ArrayList<Node> exp = new ArrayList<>();
		frontier.add(model.getInitialState());
		while(!frontier.isEmpty()) {
			Node current = frontier.poll();
			exp.add(current);
			if(current.equals(model.getGoalState())) {
				return current;
			}
			List<Node> childs = model.getSuccessors(current);
			for (Node node : childs) {
				if(!frontier.contains(node) && !exp.contains(node)) {
					frontier.add(node);
				}
			}
		}
		return null;
	}

}
