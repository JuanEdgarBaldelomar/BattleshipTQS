package model;

import java.util.Arrays;



public class Board {
	
	private static final int msizeX  = 10;
	private static final int msizeY = 10;
	private int[][] mBoard;
	
	public Board() {
		
		mBoard = new int[msizeX][msizeY];
		for (int i = 0;i<msizeX;i++) {
			for (int j = 0;j<msizeY;j++) {
				
				mBoard[i][j] = 0;
				
			}
		}
		
	}
	
	
	public int[][] getBoard(){
		return mBoard;
	}
	
	public int getSizeX() {
		return msizeX;
	}
	
	public int getSizeY() {
		return msizeY;
	}
	
	public boolean equals(Board b2) {
		
		if(Arrays.deepEquals(this.mBoard, b2.getBoard())) {
			return true;
		}else {
			return false;
		}
		
	}
}
