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
	/**
	 * 
	 * @param initX coordenada X del inicio del barco
	 * @param initY coordenada Y del inicio del barco
	 * @param orientacion del barco, 1 horizontal, 2 vertical 
	 * @param boatType tipo de barco lancha, destructores, portaaviones, submanrino
	 * @return
	 */
	
	public boolean setBoat(int initX, int initY, int orientacion, int boatType) {
		return true;
	}
}
