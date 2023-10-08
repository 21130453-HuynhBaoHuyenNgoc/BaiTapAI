package task1;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BreadthFirstSearchAlgo implements ISearchAlgo {

	@Override
	public Node execute(Node root, String goal) {
		Queue<Node> frontier = new LinkedList<Node>();
		List<Node> exp = new ArrayList<Node>();
		frontier.add(root);
		while(!frontier.isEmpty()) {
			Node current = frontier.poll();
			exp.add(current);
			if(current.getLabel().equals(goal)) {
				return current;
			}
			List<Node> list = current.getChildrenNodes();
			for (int i = 0; i < list.size(); i++) {
				Node node = list.get(i);
				if(!exp.contains(node) && !frontier.contains(node)) {
				node.setParent(current);
				frontier.add(node);
				}
			}
		}
		return null;
	}

	@Override
	public Node execute(Node root, String start, String goal) {
		
		return null;

	}

}
