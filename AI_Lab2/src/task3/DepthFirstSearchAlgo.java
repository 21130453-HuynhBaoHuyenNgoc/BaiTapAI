package task3;

import java.util.ArrayList;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

import task3.Node;

public class DepthFirstSearchAlgo implements ISearchAlgo {

	@Override
	public Node execute(Node root, String goal) {
		Stack<Node> frontier = new Stack<Node>();
		frontier.add(root);
		while (!frontier.isEmpty()) {
			Node current = frontier.pop();
			if (current.getLabel().equals(goal)) {
				return current;
			}
			List<Node> list = current.getChildrenNodes();
			for (int i = list.size() - 1; i >= 0; i--) {
				Node node = list.get(i);
				node.setParent(current);
				if (node.getLabel().equals(goal)) {
					return node;
				}
				frontier.add(node);
			}

		}
		return null;
	}

	@Override
	public Node execute(Node root, String start, String goal) {
		Stack<Node> frontier = new Stack<Node>();
		List<Node> exp = new ArrayList<Node>();
		frontier.add(root);
		boolean flag = false;
		while (!frontier.isEmpty()) {
			Node current = frontier.pop();
			exp.add(current);
			for (Node node : exp) {
				if (node.getLabel().equals(start)) {
					flag = true;
				}
			}

			List<Node> list = current.getChildrenNodes();
			for (int i = list.size() - 1; i >= 0; i--) {
				Node node = list.get(i);
				if (node.getLabel().equals(start)) {
					frontier.clear();
					frontier.add(node);
					break;
				}
				if (current.getLabel().equals(goal) && flag) {
					return current;
				}
				frontier.add(node);

			}
			System.out.println(frontier);
		}
		return null;

	}

}
