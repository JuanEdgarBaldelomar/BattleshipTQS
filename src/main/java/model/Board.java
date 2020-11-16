package model;

import java.util.ArrayList;
import java.util.Arrays;



public class Board {
	
	private static final int msizeX  = 10;
	private static final int msizeY = 10;
	private static final int OK = 1;
	private static final int LIMITELITTLEBOATS = 2;
	private static final int LIMITEMEDIUMBBOATS  = 3;
	private static final int LIMITEBIGBOATS = 4;
	private static final int LIMITESUBMARINO = 5;
	private static final int NODISTANCE = 6;
	private static final int ESPACIOOCUPADO = 7;
	private static final int LITTLEBOAT = 1;
	private static final int MEDIUMBOAT = 2;
	private static final int BIGBOAT = 3;
	private static final int SUBMARINE  = 4;
	private static final int VERTICAL = 2;
	private static final int AGUA = 0;
	private static final int FAIL  = 6;
	private static final int HIT = 5;
	
	
	private int[][] mBoard;
	ArrayList<String> mIdBoats;
	public Board() {
		
		mBoard = new int[msizeX][msizeY];
		for (int i = 0;i<msizeX;i++) {
			for (int j = 0;j<msizeY;j++) {
				
				mBoard[i][j] = 0;
				
			}
		}
		
		mIdBoats  = new  ArrayList<String>();
		mIdBoats.add("LITTLE");
		mIdBoats.add("LITTLE");
		mIdBoats.add("LITTLE");
		mIdBoats.add("LITTLE");
		mIdBoats.add("MEDIUM");
		mIdBoats.add("MEDIUM");
		mIdBoats.add("MEDIUM");
		mIdBoats.add("BIG");
		mIdBoats.add("BIG");
		mIdBoats.add("SUBMARINE");
		
	}
	
	public void setMockBoard(int[][] board) {
		mBoard  = board;
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
	
	public int setBoat(int initX, int initY, int orientacion, int boatType) {
		
		switch (boatType) {
		case LITTLEBOAT: {
			
			LittleBoat littleBoat =  new LittleBoat(LITTLEBOAT);
			if(littleBoat.checkRule(initX, initY, orientacion, mBoard)) {
				if(mIdBoats.contains("LITTLE")) {
					mBoard[initX][initY] =  LITTLEBOAT;
					mIdBoats.remove("LITTLE");
					return OK;
				}else {
					return LIMITELITTLEBOATS;
				}
				
			}else {
				return NODISTANCE;
			}
			
		}
		
		case MEDIUMBOAT:{
			
			MediumBoat mediumBoat  = new MediumBoat(MEDIUMBOAT);
			if(mediumBoat.checkRule(initX, initY, orientacion, mBoard)) {
				if(mediumBoat.freeSpace(initX, initY, orientacion, mBoard)) {
					if(mIdBoats.contains("MEDIUM")) {
						mIdBoats.remove("MEDIUM");
						if (orientacion == VERTICAL) {
							for (int j = 0;j<mediumBoat.getSize();j++) {
								mBoard[initX][initY+j] = MEDIUMBOAT;
								
							}
							return OK;
						}else {
							for (int i = 0;i<mediumBoat.getSize();i++) {
								mBoard[initX+i][initY]  = MEDIUMBOAT;
							}
							return OK;
						}
					}else {
						return LIMITEMEDIUMBBOATS;
					}
					
					
				}else {
					return ESPACIOOCUPADO;
				}
				
			}else {
				return NODISTANCE;
			}
			
			
		}
		
		case BIGBOAT:{
			BigBoat bigBoat = new BigBoat(BIGBOAT);
			if(bigBoat.checkRule(initX, initY, orientacion, mBoard)) {
				if(bigBoat.freeSpace(initX, initY, orientacion, mBoard)) {
					if(mIdBoats.contains("BIG")) {
						mIdBoats.remove("BIG");
						if (orientacion == VERTICAL) {
							for (int j = 0;j<bigBoat.getSize();j++) {
								mBoard[initX][initY+j] = BIGBOAT;
							}
							return OK;
						}else {
							for (int i = 0;i<bigBoat.getSize();i++) {
								mBoard[initX+i][initY]  = BIGBOAT;
							}
							return OK;
						}
					}else {
						return LIMITEBIGBOATS;
					}
					
					
				}else {
					return ESPACIOOCUPADO;
				}
				
			}else {
				return NODISTANCE;
			}
			
			
		}
		case SUBMARINE:{
			Submarine submarine = new Submarine(SUBMARINE);
			if(submarine.checkRule(initX, initY, orientacion, mBoard)) {
				if(submarine.freeSpace(initX, initY, orientacion, mBoard)) {
					if(mIdBoats.contains("SUBMARINE")) {
						mIdBoats.remove("SUBMARINE");
						if (orientacion == VERTICAL) {
							for (int j = 0;j<submarine.getSize();j++) {
								mBoard[initX][initY+j] = SUBMARINE;
							}
							return OK;
						}else {
							for (int i = 0;i<submarine.getSize();i++) {
								mBoard[initX+i][initY]  = SUBMARINE;
							}
							return OK;
						}
					}else {
						return LIMITESUBMARINO;
					}
					
					
				}else {
					return ESPACIOOCUPADO;
				}
				
			}else {
				return NODISTANCE;
			}
		
		}
		
		default:
			throw new IllegalArgumentException("Unexpected value: " + boatType);
		}
		
		
	}
	
	public boolean shotBoat(int x, int y) {
		if (mBoard[x][y] ==  AGUA) {
			mBoard[x][y] = FAIL;
			return false;
		}else if(mBoard[x][y] == FAIL) {
			return false;
		}else if (mBoard[x][y] == LITTLEBOAT || mBoard[x][y]  == MEDIUMBOAT || mBoard[x][y] == BIGBOAT  || mBoard[x][y] == SUBMARINE) {
			mBoard[x][y] = HIT;
			return true;
		}else {
			return false;
		}
	}
	
	
	public boolean checkWinner() {
		
		
		for (int  i =0;i<msizeX;i++) {
			for (int j = 0 ;j<msizeY;j++) {
				
				if(mBoard[i][j] ==  LITTLEBOAT || mBoard[i][j] ==MEDIUMBOAT || mBoard[i][j] ==BIGBOAT || mBoard[i][j] ==SUBMARINE ) {
					return false;
				}
				
			}
		}
		return true;
		
	}
	
}
