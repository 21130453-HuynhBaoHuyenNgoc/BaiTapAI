package task1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

public class Node {
	public static final int N = 8;
	private Queen[] state;

	public Node() {
		state = new Queen[N];
		generateBoard();
	}

	public Node(Queen[] state) {
		this.state = new Queen[N];
		for (int i = 0; i < state.length; i++) {
			this.state[i] = new Queen(state[i].getRow(), state[i].getColumn());
		}
	}

	public Node(Node n) {
		this.state = new Queen[N];
		for (int i = 0; i < N; i++) {
			Queen qi = n.state[i];
			this.state[i] = new Queen(qi.getRow(), qi.getColumn());
		}
	}

	public void generateBoard() {
		Random random = new Random();
		for (int i = 0; i < N; i++) {
			state[i] = new Queen(random.nextInt(N), i);
		}
	}

	public int getH() {
		int heuristic = 0;
		for (int i = 0; i < N; i++) {
			for (int j = i+1; j < N; j++) {
				if(state[i].isConflict(state[j])) heuristic++;
			}
		}
		return heuristic;
	}

	public List<Node> generateAllCandidates() {
		List<Node> result = new ArrayList<Node>();
		for (int i = 0; i < N; i++) {
			Node tmp = new Node(state);
			tmp.state[i].move();
			result.add(tmp);
		}
		return result;
	}
	public Node getBestCandidate() {
		List<Node> list = generateAllCandidates();
		Node result = list.get(0);
		int maxH = list.get(0).getH();	
		for (int i = 1; i < N; i++) {
			Node current = list.get(i);
			int v = current.getH();
			if(maxH < v) {
				maxH = v;
				result = current;
			}
		}
		return result;
		
	}
	public Node selectNextRandomCandidate() {
		Node re = new Node(state);
		Random rd = new Random();
		int qi = rd.nextInt(N);
		int row = rd.nextInt(N);
		re.state[qi].setRow(row);
		return re;
	}
	public void displayBoard() {
		int[][] board = new int[N][N];
		// set queen position on the board
		for (int i = 0; i < N; i++) {
			board[state[i].getRow()][state[i].getColumn()] = 1;
		}
		// print board
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (board[i][j] == 1) {
					System.out.print("Q" + " ");
				} else {
					System.out.print("-" + " ");
				}
			}
			System.out.println();
		}
	}
	
}
