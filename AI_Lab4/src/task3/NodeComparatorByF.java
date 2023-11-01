package task3;

import java.util.Comparator;

public class NodeComparatorByF implements Comparator<Node> {

	@Override 
	public int compare(Node o1, Node o2) { 
	Double h1 = o1.getH(); 	Double h2 = o2.getH(); 
	Double g1 = o1.getG(); 	Double g2 = o2.getG(); 
	Double f1 = h1+g1;  	Double f2 = h2+g2;
	
	int result = f1.compareTo(f2); 
	if (result == 0) 
	return o1.getLabel().compareTo(o2.getLabel()); 
	else 
	return result; 
	}

}
