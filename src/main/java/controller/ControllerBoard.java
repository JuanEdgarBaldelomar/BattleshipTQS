package controller;

import model.Board;
import view.ViewBoard;

public class ControllerBoard {

	
	private Board mBoardGame;
	private ViewBoard mViewBoard;
	
	public ControllerBoard(Board model, ViewBoard view) {
		
		this.mBoardGame = model;
		this.mViewBoard = view;
	}
	
	
	public void getViewBoard() {
		mViewBoard.printBoard(mBoardGame.getBoard());
	}
	
	
	public int setBoatsBoard(int initX, int initY, int orientacion, int boatType) {
		return mBoardGame.setBoat(initX, initY, orientacion, boatType);
	}
	
	
	public int canSetBoats() {
		return mBoardGame.getSizeIdBoats();
	}
	
	public boolean getWinner() {
		
		return mBoardGame.checkWinner();
		
	}
	
	public boolean shootBoat(int x, int y) {
		return mBoardGame.shotBoat(x, y);
	}
	
	public void getViewShootBoard() {
		mViewBoard.printShootBoard(mBoardGame.getShootBoard());
	}
	
	public void copyBoard(int[][] board) {
		mBoardGame.copyBoardToShoot(board);
	}
	
	public int[][] getBoard(){
		return mBoardGame.getBoard();
	}
}
