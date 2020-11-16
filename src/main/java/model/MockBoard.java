package model;

public class MockBoard extends Board {

	public MockBoard() {
		super();
	}
	
	
	
	public int[][] getTestBoardLittleBoats(){
		
		int[][] board = super.getBoard();
		
		board[0][1] = 1;
		board[0][8] = 1;
		board[1][4] = 1;
		board[2][4] = 1;
		board[4][6] = 1;
		board[4][9] = 1;
		board[7][6] = 1;
		board[7][9] = 1;
		
		return board;
	}
	
	public int[][] getTestMediumBoats() {
		int[][] board =  super.getBoard();
		
		board[0][2] = 1;
		board[0][7] = 1;
		board[2][2] = 1;
		board[6][2] = 1;
		board[6][0] = 1;
		board[6][7] = 1;
		board[7][4] = 1;
		
		return board;
	}
	
	
	public int[][] getTestMediumBoatsDiagonal(){
		int[][] board =  super.getBoard();
		
		board[0][0] = 1;
		board[0][9] = 1;
		board[4][0] = 1;
		board[4][9] = 1;
		board[9][3] = 1;
		board[9][7] = 1;
		
		return board;
	
	}
	
	public int[][] getTestBigBoats(){
		int[][] board =  super.getBoard();
		
		board[0][3] = 1;
		board[0][6] = 1;
		board[2][7] = 1;
		board[3][3] = 1;
		board[6][8] = 1;
		board[7][1] = 1;
		board[9][7] = 1;
		
		return board;
	}
	
	public int[][] getTestBigBoatsDiagonal(){
		int[][] board =  super.getBoard();
		
		board[1][0] = 1;
		board[1][9] = 1;
		board[6][7] = 1;
		
		return board;
	}
	
	public int[][] getTestSubmarine(){
		
		int[][] board =  super.getBoard();
		
		board[0][4] = 1;
		board[3][4] = 1;
		board[5][1] = 1;
		board[6][8] = 1;
		board[9][4] = 1;
		
		return board;
		
	}
	
	public int[][] getTestSubmarineDiagonal(){
		
		int[][] board =  super.getBoard();
		
		board[1][4] = 1;
		board[1][5] = 1;
		board[5][5] = 1;
		board[5][9] = 1;
		board[2][9] = 1;
		
		return board;
		
		
	}
	
	public int[][] getBoardTestFreeSpace(){
		
		int[][] board = super.getBoard();
		
		board[0][5]  = 1;
		board[2][4]  = 1;
		board[6][3]  = 1;
		board[7][5]  = 1;
		
		return board;
		
	}
	
	public int[][] getB1(){
		
		int[][] board = super.getBoard();
		board[0][1] = 1;
		board[0][3] = 1;
		board[0][5] = 1;
		board[0][7] = 1;
		
		board[2][0] = 2;
		board[3][0] = 2;
		board[2][2] = 2;
		board[3][2] = 2;
		board[2][4] = 2;
		board[3][4] = 2;
		board[5][7]  = 1;
		
		
		return board;
		
	}
	
	public int[][] getShootBoard(){
		
		int board[][] =  super.getBoard();
		
		board[1][3] =  1;
		board[4][7] =  1;
		board[1][3] =  5;
		board[7][1] =  5;
		board[7][3] =  6;
		
		return board;
		
		
	}
	
	
}

