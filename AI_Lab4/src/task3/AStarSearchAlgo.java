package task3;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;


public class AStarSearchAlgo implements IInformedSearchAlgo {
	@Override
	public Node execute(Node root, String goal) {
		Queue<Node> frontier = new PriorityQueue<>(new NodeComparatorByF());
		ArrayList<Node> exp = new ArrayList<>();
		frontier.add(root);
		while(!frontier.isEmpty()) {
			Node current = frontier.poll();
			exp.add(current);
		//		System.out.println("label " +current.getLabel() + "-" + "g " + current.getG() );

			if(current.getLabel().equals(goal)) {
			//	System.out.println(current.getG() + current.getH());
				return current;
			}
			List<Node> childs = current.getChildrenNodes();
			for (int i = 0; i < childs.size(); i++) {
				Node node = childs.get(i);
				Node nodeNew = new Node(node);
				nodeNew.setParent(current);
				nodeNew.setG(nodeNew.getG() + current.getG());
		//	System.out.println("label " +nodeNew.getLabel() + "-" + "g " + nodeNew.getG() );
				for (Node nodeInFrontier : frontier) {
					if((nodeNew.getLabel().equals(nodeInFrontier.getLabel())) &&(nodeNew.getH() + nodeNew.getG()) < (nodeInFrontier.getH()+nodeInFrontier.getG())) {
						frontier.remove(nodeInFrontier);
						frontier.add(nodeNew);
						//.out.println("label " +nodeInFrontier.getLabel() + "-" + "g " + nodeInFrontier.getG() );
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
		Queue<Node> frontier = new PriorityQueue<>(new NodeComparatorByF());
		frontier.add(root);
		return null;
	}
	public boolean admissable(Node root, String goal) {	
		Node nodeGoal = execute(root, goal);
	   return (nodeGoal.getG() + nodeGoal.getH()) >= root.getH();
		
	}
}
