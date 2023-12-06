package task1;

public class Queen {
	private int row;
	private int column;

	public Queen(int row, int column) {
		super();
		this.row = row;
		this.column = column;
	}

	public void move() {
		setRow(row++);
		if(row >= Node.N) {
			setRow(0);
		}
	}
	// check whether this Queen can attack the given Queen (q)
	public boolean isConflict(Queen q) {
		if(this.row == q.getRow()) return true;
		if(calRow(row, q.getRow()) == calCol(column,q.getColumn())) return true;
		return false;
	}
	public int calRow(int r1, int r2) {
		return Math.abs(r1-r2);
	}
	public int calCol(int c1, int c2) {
		return Math.abs(c1-c2);
	}
	public int getRow() {
		return row;
	}

	public int getColumn() {
		return column;
	}

	public void setRow(int row) {
		this.row = row;
	}
	
	

	@Override
	public String toString() {
		return "(" + row + ", " + column + ")";
	}
}
