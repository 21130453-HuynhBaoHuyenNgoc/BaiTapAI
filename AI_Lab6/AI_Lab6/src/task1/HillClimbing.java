package task1;

import java.util.Arrays;

public class HillClimbing {
	public Node execute(Node initialState) {
		Node current = initialState;
		Node neightBor = null;
		while (true) {
			neightBor = current.getBestCandidate();
			if (current.getH() > neightBor.getH()) {
				current = neightBor;
			} else {
				return current;
			}
		}
	}

	public Node executeHillClimbingWithRandomRestart(Node initialState) {
		// Enter your code here.
		return null;
	}

	public static void main(String[] args) {
		new HillClimbing().execute(new Node()).displayBoard();
	}
}
