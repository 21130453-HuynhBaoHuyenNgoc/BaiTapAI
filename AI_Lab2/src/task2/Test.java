package task2;

public class Test {
	public static void main(String[] args) {
//		Node nodeS = new Node("S");
//		Node nodeA = new Node("A"); Node nodeB = new Node("B");
//		Node nodeC = new Node("C"); Node nodeD = new Node("D");
//		Node nodeE = new Node("E"); Node nodeF = new Node("F");
//		Node nodeG = new Node("G"); Node nodeH = new Node("H");
//		nodeS.addEdge(nodeA, 5); nodeS.addEdge(nodeB, 2);
//		nodeS.addEdge(nodeC, 4); nodeA.addEdge(nodeD, 9);
//		nodeA.addEdge(nodeE, 4); nodeB.addEdge(nodeG, 6);
//		nodeC.addEdge(nodeF, 2); nodeD.addEdge(nodeH, 7);
//		nodeE.addEdge(nodeG, 6); nodeF.addEdge(nodeG, 1);
//		ISearchAlgo algo1 = new BreadthFirstSearchAlgo();
//		ISearchAlgo algo2 = new DepthFirstSearchAlgo();
//	//	Node result = algo1.execute(nodeS, "G");
//		Node result = algo1.execute(nodeS, "D", "H");
//	//	Node result2 = algo2.execute(nodeS, "C" ,"G");
//		System.out.println(NodeUtils.printPath(result));
		Node nodeS = new Node("S");
		Node nodeA = new Node("A"); Node nodeB = new Node("B");
		Node nodeC = new Node("C"); Node nodeD = new Node("D");
		Node nodeE = new Node("E"); 
		Node nodeG = new Node("G"); 
		nodeS.addEdge(nodeA, 10); nodeS.addEdge(nodeD, 5);
		nodeS.addEdge(nodeE, 11);nodeA.addEdge(nodeC, 9);
		nodeA.addEdge(nodeB, 7); nodeB.addEdge(nodeG, 1);
		nodeC.addEdge(nodeG, 3); nodeD.addEdge(nodeA, 6);
		nodeC.addEdge(nodeE, 5); nodeC.addEdge(nodeD, 8);
		nodeE.addEdge(nodeG, 7);
		ISearchAlgo algo1 = new BreadthFirstSearchAlgo();
		//ISearchAlgo algo2 = new DepthFirstSearchAlgo();
		Node result = algo1.execute(nodeS, "G");
		System.out.println(NodeUtils.printPath(result));
	}

}
