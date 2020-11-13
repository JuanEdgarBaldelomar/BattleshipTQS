package model;

public class BigBoat implements Boat {

	private int mSize;
	
	public BigBoat(int size) {
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
