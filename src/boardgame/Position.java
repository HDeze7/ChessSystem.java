package boardgame;

public class Position {
	
	private int Row;
	private int Column;
	
	public Position(int row, int column) {
		Row = row;
		Column = column;
	}

	public int getRow() {
		return Row;
	}
	public void setRow(int row) {
		Row = row;
	}
	public int getColumn() {
		return Column;
	}
	public void setColumn(int column) {
		Column = column;
	}

	@Override
	public String toString() {
		//return "Position [Row= " + Row + ", Column= " + Column + "]";
		return Row + ", " + Column;
	}	
}