package model;

public class LittleBoat{
	static final int AGUA = 0;
	static final int INITX_Y = 0;
	static final int FINALX_Y  = 9;
	static final int HORIZONTAL = 1;
	static final int VERTICAL = 2;
	private int mSize;
	
	public LittleBoat(int size) {
		// TODO Auto-generated constructor stub
		this.mSize = size;
	}
	
	public int getSize() {
		return this.mSize;
	}


	public boolean checkRule(int x, int y, int orientacion, int[][] board) {
		// TODO Auto-generated method stub
		
		if (board[x][y] == AGUA) {
			
			if (x ==INITX_Y && y==INITX_Y ) {
				if (board[x+1][y] ==AGUA && board[x][y+1]==AGUA && board[x+1][y+1]==AGUA) {
					return true;
				}else {
					return false;
				}
			}else if (x == FINALX_Y && y == INITX_Y ) {
				
				if(board[x-1][y] == AGUA && board[x][y+1] == AGUA && board[x-1][y+1] == AGUA) {
					return true;
				}else {
					return false;
				}
				
			}else if (x == INITX_Y && y == FINALX_Y) {
				
				if( board[x][y-1] == AGUA && board[x+1][y] ==  AGUA  &&  board[x+1][y-1]  == AGUA) {
					return true;
				}else {
					return false;
				}
				
			}else if (x== FINALX_Y && y ==  FINALX_Y) {
				
				if(board[x][y-1] == AGUA && board[x-1][y] == AGUA && board[x-1][y-1] == AGUA) {
					return true;
				}else {
					return false;
				}
				
			}else if( x == INITX_Y && y>INITX_Y && y<FINALX_Y) {
				if (board[x][y-1] == AGUA && board[x+1][y] == AGUA && board[x][y+1] == AGUA && board[x+1][y-1] == AGUA && board[x+1][y+1] == AGUA) {
					return true;
				}else {
					return false;
				}
			}else if(x == FINALX_Y &&y>INITX_Y && y<FINALX_Y ) {
				if(board[x][y-1] == AGUA && board[x][y+1] == AGUA  && board[x-1][y] == AGUA  && board[x-1][y-1] == AGUA && board[x-1][y+1] == AGUA  ) {
					return false;
				}else {
					return false;
				}
			}else if ( y == INITX_Y && x>INITX_Y && x<FINALX_Y) {
				
				if(board[x-1][y] == AGUA && board[x+1][y] == AGUA && board[x][y+1] == AGUA && board[x-1][y+1] == AGUA && board[x+1][y+1] == AGUA) {
					return true;
				}else {
					return false;
				}
				
			}else if (y == FINALX_Y && x>INITX_Y && x<FINALX_Y) {
				
				if(board[x-1][y] == AGUA && board[x+1][y] == AGUA && board[x][y-1] == AGUA && board[x-1][y-1] == AGUA && board[x+1][y-1] == AGUA) {
					return true;
				}else{
					return false;
				}
				
			}else {
				if(board[x][y-1] == AGUA && board[x][y+1] == AGUA && board[x-1][y] == AGUA && board[x+1][y] == AGUA && board[x-1][y-1] == AGUA && board[x+1][y-1] == AGUA
						&& board[x-1][y+1] == AGUA &&	board[x+1][y+1] == AGUA) {
					return true;
				}else{
					return false;
				}
			}
			
		}else {
			return false;
		}
		
		
	}

}
