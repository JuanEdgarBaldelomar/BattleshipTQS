package model;


public interface Boat {
	
	static final int AGUA = 0;
	static final int INITX_Y = 0;
	static final int FINALX_Y  = 9;

	abstract boolean checkRule(int x, int y, int orientacion, int[][] board);
}
