package task3;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class AStar implements IPuzzleAlgo {

	@Override
	public Node execute(Puzzle model) {
		// TODO Auto-generated method stub
		PriorityQueue<Node> frontier = new PriorityQueue<Node>(PuzzleUtils.HeuristicComparatorByF);
		List<Node> explored = new ArrayList<Node>();
		
		Node start = new Node(model.getInitialState());
		start.setH(model.computeH1(start));
		System.out.println(start.getG());
		frontier.add(start);
		
		while(!frontier.isEmpty()) {
			Node current = frontier.poll();
			explored.add(current);
			if(current.getH() == 0) return current;
			else {
				List<Node> listChild = model.getSuccessors(current);
				for(Node childNode :listChild ) {
					if(!frontier.contains(childNode) && !explored.contains(childNode)) {
						childNode.setG(current.getG() +1);
						System.out.println(childNode.getG());
						frontier.add(childNode);
					}
					else if(frontier.contains(childNode) && !explored.contains(childNode)) {
						for(Node node : frontier) {
							if(	current.equals(node) &&	current.getF() < node.getF()) {
								frontier.remove(node);
								frontier.add(childNode);
								break;
							}
						}
					}
				}
				
				
			}
			
		}
		return null;
	}

}
