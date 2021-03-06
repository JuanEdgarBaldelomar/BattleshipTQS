package model;


public abstract class Boat{
	static final int AGUA = 0;
	static final int INITX_Y = 0;
	static final int FINALX_Y  = 9;
	static final int HORIZONTAL = 1;
	static final int VERTICAL = 2;
	
	private int mSize;
	
	public Boat(int size) {
		this.mSize = size;
	}
	
	public int getSize() {
		return this.mSize;
	}


	public boolean checkRule(int x, int y, int orientacion, int[][] board) {
		// TODO Auto-generated method stub
		
		if (board[x][y] == AGUA) {
			
			if (orientacion == VERTICAL) {
				
				if (x == INITX_Y && y == INITX_Y) {
					for (int j =0;j<mSize;j++) { // Miramos si hay barcos en la derecha
						if (board[x+1][y+j] != AGUA) {
							return false;
						}
					}
					if(board[x+1][y+mSize] == AGUA && board[x][y+mSize] == AGUA) { //Diagonal y abajo
						return true;
					}else {
						return false;
					}
				}else if (x == FINALX_Y && y == INITX_Y) {
					
					for (int j= 0;j<mSize;j++) {//Miramos si hay barcos en la izquierda
						if (board[x-1][y+j] != AGUA) {
							return false;
						}
					}
					if(board[x-1][y+mSize] == AGUA && board[x][y+mSize] == AGUA) {//Diagonal y abajo
						return true;
					}else {
						return false;
					}
					
				}else if(x == INITX_Y && (y+mSize-1) ==FINALX_Y) {// parte inferior
					
					
					for (int j = 0; j<mSize;j++ ) {
						if (board[x+1][y+j] != AGUA) {
							return false;
						}
						
					}
					if(board[x][y-1] == AGUA && board[x+1][y-1] == AGUA) {//Arriba y diaonal superior derecha
						return true;
					}else {
						return false;
					}
					
				}else if(y == INITX_Y && x > INITX_Y && x<FINALX_Y){//fila superior
					
					for (int j = 0;j<mSize;j++) {
						
						if (board[x-1][j+j] != AGUA || board[x+1][y+j] != AGUA)  {
							return false;
						}
					}
					if (board[x][mSize+1] == AGUA) {//ABAJO
						
						if(board[x-1][mSize+1] != AGUA || board[x+1][mSize+1] != AGUA){//Diagonal izquierda y derecha
							return false;
						}else {
							return true;
						}
						
					}else {
						return false;
					}
					
					
				}else if (x > INITX_Y && x<FINALX_Y && y > INITX_Y && (y+mSize-1)<FINALX_Y){//barco no se encuentra en los bordes
					
					//miramos derecha e izquierda
					for (int j = 0;j<mSize;j++) {
						
						if (board[x-1][y+j] != AGUA || board[x+1][y+j] != AGUA) {
							return false;
						}	
					}
					//miramos arriba y abajo
					if(board[x][y-1]!= AGUA || board[x+1][mSize+1] != AGUA){
						return false;
					}else if(board[x-1][y-1]!= AGUA || board[x+1][y-1] != AGUA) {//diagonales superiores
						return false;
					}else if(board[x-1][y+mSize] != AGUA || board[x+1][y+mSize] != AGUA) {//diagones inferiores
						return false;
					}else {
						return true;
					}
					
				}else if ( x > INITX_Y && x < FINALX_Y && (mSize+y-1) == FINALX_Y) { // estamos en las dos ultimas filas del trablero
					//miramos barcos derecha e izquierda
					for (int j =0;j<mSize;j++) {
						if (board[x-1][y+j] != AGUA || board[x+1][y+j] != AGUA) {
							return false;
						}
					}
					if (board[x][y-1] ==  AGUA){//arriba
						if(board[x-1][y-1] != AGUA || board[x+1][y-1] != AGUA ){//diagonales superiores
							return false;
						}else {
							return true;
						}
						
					}else{
						return false;
					}
					
				}else if (x == FINALX_Y && (y+mSize-1) == FINALX_Y) {
					for (int j = 0;j<mSize;j++) {
						if (board[x-1][y+j] != AGUA) {
							return false;
						}
					}
					
					//diagonal izquierda superior i superior
					
					if(board[x][y-1]==AGUA && board[x-1][y-1] == AGUA) {
						return true;
					}else{
						return false;
					}
					
				}else if(x == INITX_Y &&  (y+mSize-1)<FINALX_Y) {
					
					for (int j = 0;j<mSize;j++) {
						if(board[x][y+j]!= AGUA) {
							return  false;
						}
					}
					
					//miramos  arribba y abajo
					if (board[x][y-1] !=  AGUA  || board[x][y+mSize] !=  AGUA) {
						return false;
					}else if(board[x+1][y-1]  == AGUA && board[x+1][y+mSize] == AGUA) {
						return true;
						
					}else {
						return false;
					}
					
				}
			}else {//horizontal
				
				if (x == INITX_Y && y == INITX_Y) {//esquina 0,0
					
					//miramos parte inferior
					for(int i =0;i<mSize;i++) {
						if(board[x+i][y+1] != AGUA) {
							 return false;
						}
					}
					//diagonal inferior derecha y derecha
					if(board[x+mSize][y+1] == AGUA && board[x+mSize][y] == AGUA ) {
						return true;
					}else {
						return false;
					}
					
				
				}else if ( (x+mSize-1) == FINALX_Y && y == INITX_Y) {//esquina superior derecha
					
					for (int i = 0;i<mSize;i++) {//parte inferior
						if (board[x+i][y+1] != AGUA) {
							return false;
						}
					}
					//miramos diagonal inferior izquierda e izquierda
					if(board[x-1][y+1] == AGUA && board[x-1][y] == AGUA) {
						return true;
					}else {
						return false;
					}
					
				}else if ((x+mSize-1) == FINALX_Y && y == FINALX_Y) {//esquina parte inferior derecha
					
					for (int i = 0;i<mSize;i++) {//parte inferior
						if (board[x+i][y-1] != AGUA) {
							return false;
						}
					}
					//miramos diagonal superior izquierda e izquierda
					if(board[x-1][y-1] == AGUA && board[x-1][y] == AGUA) {
						return true;
					}else {
						return false;
					}
					
				}else if (x == INITX_Y && y > INITX_Y && y<FINALX_Y) {//miramos linea izquierda
					
					//miramos arriba y abajo
					for (int i = 0;i<mSize;i++) {
						
						if(board[x+i][y-1] != AGUA || board[x+i][y+1] != AGUA){
							return false;
						}
						
					}
					//miramos diagonal derecha inferior i superior i derecha
					if (board[x+mSize+1][y-1] == AGUA && board[x+mSize+1][y+1] == AGUA && board[x+1+mSize][y] == AGUA) {
						return true;
					}else {
						return false;
					}
					
				}else if (y == INITX_Y && x > INITX_Y && (x+mSize-1) < FINALX_Y) {//limite superior
					
					//miramos parte inferior
					for (int i = 0;i<mSize;i++) {
						
						if(board[x+i][y] != AGUA) {
							return false;
						}
						
					}
					//derecha e izquieda, diagiones inferior izquierda y derecha
					if (board[x+1][y] == AGUA && board[x-1][y] == AGUA && board[x-1][y+1] == AGUA && board[x+mSize][y+1] == AGUA) {
						return true;
					}else {
						return false;
					}
					
				}else if ((x+mSize-1) == FINALX_Y && y>INITX_Y && y<FINALX_Y) {//limite derecha
					
					//miramos parte superior e inferior
					for (int i = 0;i<mSize; i++) {
						
						if(board[x+i][y-1] != AGUA || board[x+i][y+1] != AGUA) {
							return false;
						}
						
					}
					//miramos izquierda, diagonal izquierda superio e inferior
					if (board[x-1][y] == AGUA && board[x-1][y-1] == AGUA && board[x-1][y+1] == AGUA) {
						return true;
					}else {
						return false;
					}
				}else if (y == FINALX_Y && x>INITX_Y && (x+mSize-1)<FINALX_Y) {//linea inferior
					
					for (int i =0;i<mSize;i++) {
						if(board[x+i][y] != AGUA) {
							return false;
						}
					}
					//miramos costado y diagonales
					if(board[x-1][y] == AGUA && board[x+mSize][y] == AGUA && board[x-1][y-1] == AGUA && board[x+mSize][y-1] == AGUA) {
						return true;
					}else {
						return false;
					}
					
					
				}else if (y > INITX_Y && y<FINALX_Y &&  x > INITX_Y && (x+mSize-1)<FINALX_Y) {//con un espacio hacia los bordes
					
					//miramos parte superior e inferior
					for (int i = 0;i<mSize;i++) {
						
						if(board[x+i][y-1] != AGUA || board[x+i][y+1] != AGUA) {
							return false;
						}
						
					}
					
					//miramos laterales 
					if (board[x-1][y] == AGUA && board[x+mSize][y] == AGUA) {
						
						//comprobamos diagonles
						if( board[x-1][y-1] == AGUA && board[x-1][y+1] == AGUA && board[x+mSize][y-1] == AGUA && board[x+mSize][y+1] == AGUA ) {
							return true;
						}else {
							return false;
						}
						
					}else {
						return false;
					}	
				}
			}
			
		}
		return false;
	}

	public boolean freeSpace(int x, int y,  int orientacion, int[][] board) {
		
		
		
		if (orientacion == VERTICAL) {
			
			for  (int  j = 0;j<mSize+1;j++) {
				if(board[x][y+j] != AGUA) {
					return false;
				}
			}
			return true;
			
		}else {
			
			for (int i = 0;i<mSize ;i++) {
				if(board[x+i][y]  != AGUA) {
					return false;
				}
				
			}
			return true;
			
		}
		
		
	}
	
}