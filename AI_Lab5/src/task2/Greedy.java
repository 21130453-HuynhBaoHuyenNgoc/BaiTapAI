package task2;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class Greedy implements IPuzzleAlgo {

	@Override
	public Node execute(Puzzle model) {
		// TODO Auto-generated method stub
		PriorityQueue<Node> frontier = new PriorityQueue<Node>(PuzzleUtils.HeuristicComparatorByH);
		List<Node> explored = new ArrayList<Node>();
		
		Node start = new Node(model.getInitialState());
		start.setH(model.computeH2(start));
		frontier.add(start);
		
		while(!frontier.isEmpty()) {
			Node current = frontier.poll();
			explored.add(current);
			if(current.getH() == 0) return current;
			else {
				for(Node childNode : model.getSuccessors(current)) {
					if(!frontier.contains(childNode) && !explored.contains(childNode)) {
						frontier.add(childNode);
					}
					
					else if(frontier.contains(childNode) && !explored.contains(childNode)) {
						for(Node node : frontier) {
							if(	current.equals(node) &&	current.getH() < node.getH()) {
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
