package model;

public class Submarine implements Boat{

	private int mSize;
	
	public Submarine(int size) {
		this.mSize = size;
	}
	
	public int getSize() {
		return this.mSize;
	}

	@Override
	public boolean checkRule(int x, int y, int orientacion, int[][] board) {
		// TODO Auto-generated method stub
		return false;
	}
	
}
