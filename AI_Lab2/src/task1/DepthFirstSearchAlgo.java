package task1;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class DepthFirstSearchAlgo implements ISearchAlgo {

	@Override
	public Node execute(Node root, String goal) {
		Stack<Node> frontier = new Stack<Node>();
		List<Node> exp = new ArrayList<Node>();
		frontier.add(root);
		while(!frontier.isEmpty()) {
			Node current = frontier.pop();
			exp.add(current);
			if(current.getLabel().equals(goal)) {
				return current;
			}
			List<Node> list = current.getChildrenNodes();
			for (int i = list.size()-1; i >= 0; i--) {
				Node node = list.get(i);
				if(!exp.contains(node) && !frontier.contains(node)) {
				node.setParent(current);
				
//				if(node.getLabel().equals(goal)) {
//					return node;
//				}
				frontier.add(node);
				}
			}
		}
		return null;
	}

	@Override
	public Node execute(Node root, String start, String goal) {
		// TODO Auto-generated method stub
		return null;
	}

}
