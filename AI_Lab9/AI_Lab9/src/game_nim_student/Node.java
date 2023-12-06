package game_nim_student;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Node {
	private List<Integer> data = new ArrayList<Integer>();
	
	public void add(Integer val) {
		this.data.add(val);
	}

	public void addAll(List<Integer> data) {
		this.data.addAll(data);
	}

	// Get children of the current nodes
	public List<Node> getSuccessors() {
		List<Node> re = new ArrayList<>();
		Collections.sort(data, DESCOMPARATOR);
		for (int i = 0; i < data.size(); i++) {
			int n = data.get(i);
				int c = n / 2;
				for (int j = 1; j <= c; j++) {
					if(n - j != j) {
					Node newNode = new Node();
					newNode.add(n - j);
					newNode.add(j);
					for (int k = 0; k < data.size(); k++) {
						if(k!= i) newNode.add(data.get(k));
					}
					re.add(newNode);
				}
				}
		}
		System.out.println(re);
		return re;
	}

	// Check whether a node is terminal or not
	public boolean isTerminal() {
		Collections.sort(data, DESCOMPARATOR);
		return data.get(0) < 3;
	}

	public static final Comparator<Integer> DESCOMPARATOR = new Comparator<Integer>() {

		@Override
		public int compare(Integer o1, Integer o2) {
			return o2.compareTo(o1);
		}
	};

	@Override
	public String toString() {
		Collections.sort(this.data, DESCOMPARATOR);
		return this.data.toString();
	}

}
