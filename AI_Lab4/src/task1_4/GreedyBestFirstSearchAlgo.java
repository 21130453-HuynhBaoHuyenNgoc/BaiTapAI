package task1_4;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class GreedyBestFirstSearchAlgo implements IInformedSearchAlgo {

	@Override
	public Node execute(Node root, String goal) {
	Queue<Node> frontier = new PriorityQueue<>(new NodeComparator());
	ArrayList<Node> exp = new ArrayList<>();
	frontier.add(root);
	while(!frontier.isEmpty()) {
		Node current = frontier.poll();
		exp.add(current);
		if(current.getLabel().equals(goal)) {
			return current;
		}
		List<Node> childs = current.getChildrenNodes();
		for (Node node : childs) {
			Node nodeNew = new Node(node);
			nodeNew.setParent(current);
			for (Node nodeInFrontier : frontier) {
				if(nodeNew.getH() < nodeInFrontier.getH()) {
					nodeInFrontier = nodeNew;
					break;
				}
			}
			if(!frontier.contains(nodeNew) && !exp.contains(nodeNew)) {
				frontier.add(nodeNew);
			}
		
		}
	}
		return null;
	}

	@Override
	public Node execute(Node root, String start, String goal) {
		Queue<Node> frontier = new PriorityQueue<>(new NodeComparator());
		ArrayList<Node> exp = new ArrayList<>();
		boolean flag = true;
		frontier.add(root);
		while(!frontier.isEmpty()) {
			Node current = frontier.poll();
			exp.add(current);
			for (Node node : exp) {
				if(node.getLabel().equals(start)) flag = true; break;
			}
			if(current.getLabel().equals(goal) && flag) {
				return current;
			}
			List<Node> childs = current.getChildrenNodes();
			for (Node node : childs) {
				if(node.getLabel().equals(start)) {
					frontier.clear();
					frontier.add(node);
					break;
				}
				Node nodeNew = new Node(node);
				nodeNew.setParent(current);
				for (Node nodeInFrontier : frontier) {
					if(nodeNew.getH() < nodeInFrontier.getH()) {
						nodeInFrontier = nodeNew;
						break;
					}
				}
				if(!frontier.contains(nodeNew) && !exp.contains(nodeNew)) {
					frontier.add(nodeNew);
				}
			
			}
		}
			return null;
	}

}
