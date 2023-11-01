package task2_4;

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
				System.out.println("label " +current.getLabel() + "-" + "g " + current.getG() );

			if(current.getLabel().equals(goal)) {
				return current;
			}
			List<Node> childs = current.getChildrenNodes();
			for (int i = 0; i < childs.size(); i++) {
				Node node = childs.get(i);
				Node nodeNew = new Node(node);
				nodeNew.setParent(current);
				nodeNew.setG(nodeNew.getG() + current.getG());
		//		System.out.println("label " +nodeNew.getLabel() + "-" + "g " + nodeNew.getG() );
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
		// TODO Auto-generated method stub
		PriorityQueue<Node> frontier = new PriorityQueue<Node>(new NodeComparatorByF());
		List<Node> nodeTravelleds = new ArrayList<Node>();
		frontier.add(root);
		
		Loop:
		while(!frontier.isEmpty()) {
			System.out.println(frontier);
			Node current = frontier.poll();
			nodeTravelleds.add(current);
		
			if(current.getLabel().equals(goal)) {
				return current;
			}
			else {
				List<Edge> children = current.getChildren();
				for(int i = 0 ; i < children.size() ; i++) {
					
					Node currentChild = new Node(children.get(i).getEnd());
					if(currentChild.getLabel().equals(start)) {
						frontier.clear();
						frontier.add(currentChild);
						continue Loop;
					}
					
					currentChild.setG(currentChild.getG() + currentChild.getH() + current.getG() - current.getH() );
					currentChild.setParent(current);
					if(!frontier.contains(currentChild) && !nodeTravelleds.contains(currentChild)) {
						frontier.add(currentChild);
					}
					
					else if(frontier.contains(currentChild)) {
						for (Node node : frontier) {
							if(  currentChild.getLabel().equals(node.getLabel()) && currentChild.getG() < node.getG()) {
								frontier.remove(node);
								frontier.add(currentChild);
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
