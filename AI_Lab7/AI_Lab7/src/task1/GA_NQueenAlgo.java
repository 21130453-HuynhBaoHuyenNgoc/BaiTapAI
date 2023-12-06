package task1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

public class GA_NQueenAlgo {
	public static final int POP_SIZE = 100;// Population size
	public static final double MUTATION_RATE = 0.03;
	public static final int MAX_ITERATIONS = 1000;
	List<Node> population = new ArrayList<Node>();
	Random rd = new Random();

// initialize the individuals of the population
	public void initPopulation() {
		for (int i = 0; i < POP_SIZE; i++) {
			Node ni = new Node();
			ni.generateBoard();
			population.add(ni);
		}
	}	
// Select K individuals from the population at random and 
//select the best out of these to become a parent.
//	public Node getParentByTournamentSelection() {
//	
//	}

//Select a random parent from the population
	public Node getParentByRandomSelection() {
		Random rd = new Random();
		int index = rd.nextInt(POP_SIZE);
		return population.get(index);
	}

	public Node execute() {
		Node child = null;
		int k = 0;
		while (k++ < MAX_ITERATIONS) {
			List<Node> newPop = new ArrayList<Node>();
			for (int i = 0; i < this.population.size(); i++) {

				Node x = getParentByRandomSelection();
				Node y = getParentByRandomSelection();
				child = reproduce(x, y);

				if (rd.nextDouble() < MUTATION_RATE) {
					mutate(child);
				}
				if (child.getH() == 0)
					return child;
				newPop.add(child);
			}
			this.population = newPop;
		}
		Collections.sort(this.population);
		
		return this.population.get(0);
	}
	

// Mutate an individual by selecting a random Queen and 
//move it to a random row.
	public void mutate(Node node) {
		node.setRow(rd.nextInt(Node.N), rd.nextInt(Node.N));
	}

//Crossover x and y to reproduce a child
	public Node reproduce(Node x, Node y) {
		Node child = new Node();
		int c = rd.nextInt(Node.N);
		for(int i = 0; i < c; i++) {
			child.setRow(i, x.getRow(i));
		}
		for(int i = c+1; i < Node.N; i++) {
			child.setRow(i, y.getRow(i));
		}
		return child;
}
}
