package view;

public class ViewBoard {

	
	private static int AGUA = 0;
	private static int LITTLEBOAT = 1;
	private static int MEDIUMBOAT = 2;
	private static int BIGBOAT = 3;
	private static int SUBMARINE = 4;
	private static int HIT = 5;
	private static int FAIL = 6;
	
	public void printBoard(int[][] board) {
		
		System.out.println("BARCOS COLOCADOS");
		
		for(int x  =0;x<board.length;x++) {
			System.out.print("\t"+x);
		}
		System.out.println();
		for (int i  = 0;i<board.length;i++) {
			System.out.print(i+"");
			for (int  j =  0; j<board.length; j++) {
				
				if(board[j][i]  == AGUA) {
					System.out.print("\t" + "~");
				}else if (board[j][i] == HIT) {
					System.out.print("\t" + "X");
				}else if(board[j][i] == FAIL) {
					System.out.print("\t" + "F");
				}else if( board[j][i] == LITTLEBOAT || board[j][i]  == MEDIUMBOAT || board[j][i]  == BIGBOAT || board[j][i]  ==SUBMARINE) {
					System.out.print("\t" + "*");
				}
				 	
				
			}
			System.out.println();
		}
		
	} 
	
	public void printShootBoard(int [][]board) {
		for(int x  =0;x<board.length;x++) {
			System.out.print("\t"+x);
		}
		System.out.println();
		for (int i  = 0;i<board.length;i++) {
			System.out.print(i+"");
			for (int  j =  0; j<board.length; j++) {
				
				if(board[j][i]  == AGUA) {
					System.out.print("\t" + "~");
				}else if (board[j][i] == HIT) {
					System.out.print("\t" + "X");
				}else if(board[j][i] == FAIL) {
					System.out.print("\t" + "F");
				}else if( board[j][i] == LITTLEBOAT || board[j][i]  == MEDIUMBOAT || board[j][i]  == BIGBOAT || board[j][i]  ==SUBMARINE) {
					System.out.print("\t" + "~");
				}
				 	
				
			}
			System.out.println();
		}
	}
	
	
}
