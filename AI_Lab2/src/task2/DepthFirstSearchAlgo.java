package task2;

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
			System.out.println(frontier);
		}
		return null;
	}

	@Override
	public Node execute(Node root, String start, String goal) {
		Stack<Node> frontier = new Stack<Node>();
		List<Node> exp = new ArrayList<Node>();
		frontier.add(root);
		boolean flag = false;
		while(!frontier.isEmpty()) {
			Node current = frontier.pop();
			exp.add(current);
			for (Node node : exp) {
				if(node.getLabel().equals(start)) {
					flag = true;
				}
			}
			if(current.getLabel().equals(goal) && flag) {
				return current;
			}
			List<Node> list = current.getChildrenNodes();
			for (int i = list.size()-1; i >= 0; i--) {
				Node node = list.get(i);
				if(node.getLabel().equals(start)) {
					frontier.clear();
					frontier.add(node);
					break;
				}
				if(!exp.contains(node) && !frontier.contains(node)) {
				node.setParent(current);
				frontier.add(node);
				}
			}
			System.out.println(frontier);
		}
		return null;

	}

}
