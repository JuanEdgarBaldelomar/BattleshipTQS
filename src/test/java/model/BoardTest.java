package model;

import static org.junit.Assert.*;

import org.junit.Test;

public class BoardTest {


	@Test
	public void testInitBoard() {
		
		Board gameBoard = new Board();
		Board gameBoard2 = new Board();
		assertTrue(gameBoard.getSizeX()==10);
		assertTrue(gameBoard.getSizeY()==10);
		assertTrue(gameBoard.equals(gameBoard2));
	}
	
	
	/**
	 * 
	 */
	@Test
	public void testSetBoats() {
		
		Board gameBoard = new Board();
		
		//valores frontera
		//valor frontera (0,0)
		assertTrue(gameBoard.setBoat(0, 0, 1, 1));
		
		//valor frontera (9,0)
		assertTrue(gameBoard.setBoat(9, 0, 1, 1));
		
		//valor frontera (0,9)
		assertTrue(gameBoard.setBoat(0, 9, 1, 1));
		
		//valor frontera(9,9)
		assertTrue(gameBoard.setBoat(9, 9, 1, 1));
				
		//valores limite
		//limites tablero
		assertFalse(gameBoard.setBoat(-1, 10, 1, 1));
		assertFalse(gameBoard.setBoat(10, -1, 1, 1));
		
		//limite orientacion
		assertFalse(gameBoard.setBoat(0, 5, -1, 4));
		assertFalse(gameBoard.setBoat(0, 5, 3, 4));
		
		//limite tipos de barco
		assertFalse(gameBoard.setBoat(0, 0, 1, 0));
		assertFalse(gameBoard.setBoat(0, 0, 1, 5));
		
		
		//particiones equivalentes
		//(0,5)
		assertTrue(gameBoard.setBoat(0, 5, 1, 2));
		assertTrue(gameBoard.setBoat(0, 2, 2, 2));
		
		
		//(5,0)
		assertTrue(gameBoard.setBoat(4, 0, 1, 4));
		assertTrue(gameBoard.setBoat(2, 0, 2, 4));
		
		//(9,5)
		assertTrue(gameBoard.setBoat(9, 3, 1, 1));
		assertFalse(gameBoard.setBoat(9, 5, 1, 2));
		assertTrue(gameBoard.setBoat(9, 5, 2, 3));
		
		
		//(5,9)
		assertTrue(gameBoard.setBoat(3, 9, 1, 1));
		assertFalse(gameBoard.setBoat(5, 9, 2, 4));
		assertTrue(gameBoard.setBoat(5, 9, 1, 2));
		
		//comprobar colisiones
		assertFalse(gameBoard.setBoat(1, 0, 2, 4));
		assertFalse(gameBoard.setBoat(0, 4, 1, 2));
		assertTrue(gameBoard.setBoat(0, 7, 1, 3));
		assertTrue(gameBoard.setBoat(6, 5, 1, 2));
		
		
		
		
	}
	

}
		
