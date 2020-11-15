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
	private static final int HORIZONTAL = 1;
	
	
	
	private int[][] mBoard;
	ArrayList<Integer> mIdBoats;
	public Board() {
		
		mBoard = new int[msizeX][msizeY];
		for (int i = 0;i<msizeX;i++) {
			for (int j = 0;j<msizeY;j++) {
				
				mBoard[i][j] = 0;
				
			}
		}
		
		mIdBoats  = new  ArrayList<Integer>();
		mIdBoats.add(1);
		mIdBoats.add(1);
		mIdBoats.add(1);
		mIdBoats.add(1);
		mIdBoats.add(2);
		mIdBoats.add(2);
		mIdBoats.add(2);
		mIdBoats.add(3);
		mIdBoats.add(3);
		mIdBoats.add(4);
		
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
				if(mIdBoats.contains(LITTLEBOAT)) {
					mBoard[initX][initY] =  LITTLEBOAT;
					mIdBoats.remove(LITTLEBOAT);
				}else {
					return LIMITELITTLEBOATS;
				}
				
			}else {
				return NODISTANCE;
			}
			break;
		}
		
		case MEDIUMBOAT:{
			
			MediumBoat mediumBoat  = new MediumBoat(MEDIUMBOAT);
			if(mediumBoat.checkRule(initX, initY, orientacion, mBoard)) {
				if(mediumBoat.freeSpace(initX, initY, orientacion, mBoard)) {
					if(mIdBoats.contains(MEDIUMBOAT)) {
						mIdBoats.remove(MEDIUMBOAT);
						if (orientacion == VERTICAL) {
							for (int j = 0;j<mediumBoat.getSize();j++) {
								mBoard[initX][initY+j] = MEDIUMBOAT;
							}
						}else {
							for (int i = 0;i<mediumBoat.getSize();i++) {
								mBoard[initX+i][initY]  = MEDIUMBOAT;
							}
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
			
			break;
		}
		
		case BIGBOAT:{
			BigBoat bigBoat = new BigBoat(BIGBOAT);
			if(bigBoat.checkRule(initX, initY, orientacion, mBoard)) {
				if(bigBoat.freeSpace(initX, initY, orientacion, mBoard)) {
					if(mIdBoats.contains(BIGBOAT)) {
						mIdBoats.remove(BIGBOAT);
						if (orientacion == VERTICAL) {
							for (int j = 0;j<bigBoat.getSize();j++) {
								mBoard[initX][initY+j] = BIGBOAT;
							}
						}else {
							for (int i = 0;i<bigBoat.getSize();i++) {
								mBoard[initX+i][initY]  = BIGBOAT;
							}
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
			
			break;
		}
		case SUBMARINE:{
			Submarine submarine = new Submarine(SUBMARINE);
			if(submarine.checkRule(initX, initY, orientacion, mBoard)) {
				if(submarine.freeSpace(initX, initY, orientacion, mBoard)) {
					if(mIdBoats.contains(SUBMARINE)) {
						mIdBoats.remove(SUBMARINE);
						if (orientacion == VERTICAL) {
							for (int j = 0;j<submarine.getSize();j++) {
								mBoard[initX][initY+j] = SUBMARINE;
							}
						}else {
							for (int i = 0;i<submarine.getSize();i++) {
								mBoard[initX+i][initY]  = SUBMARINE;
							}
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
			break;
		}
		
		default:
			throw new IllegalArgumentException("Unexpected value: " + boatType);
		}
		
		
	}
}
