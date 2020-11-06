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
		assertTrue(gameBoard.setBoat(0, 0, 2, 1));
		
		//valor frontera (9,0)
		assertTrue(gameBoard.setBoat(9, 0, 2, 1));
		assertTrue(gameBoard.setBoat(9, 0, 1, 1));
		
		//valor frontera (0,9)
		assertTrue(gameBoard.setBoat(0, 9, 1, 1));
		assertTrue(gameBoard.setBoat(0, 9, 2, 1));
		
		
		//valor frontera(9,9)
		assertTrue(gameBoard.setBoat(9, 9, 1, 1));
		assertTrue(gameBoard.setBoat(9, 9, 2, 1));
		
		//valores limite
		assertFalse(gameBoard.setBoat(-1, 10, 1, 1));
		assertFalse(gameBoard.setBoat(10, -1, 1, 1));
		
		
		//particiones equivalentes
		//(0,5)
		assertTrue(gameBoard.setBoat(0, 5, 1, 1));
		assertTrue(gameBoard.setBoat(0, 5, 2, 1));
		assertTrue(gameBoard.setBoat(0, 5, 1, 4));
		assertTrue(gameBoard.setBoat(0, 5, 2, 4));
		
		
		//(5,0)
		assertTrue(gameBoard.setBoat(5, 0, 1, 1));
		assertTrue(gameBoard.setBoat(5, 0, 2, 1));
		assertTrue(gameBoard.setBoat(5, 0, 1, 4));
		assertTrue(gameBoard.setBoat(5, 0, 2, 4));
		
		//(9,5)
		assertTrue(gameBoard.setBoat(9, 5, 1, 1));
		assertTrue(gameBoard.setBoat(9, 5, 2, 1));
		assertFalse(gameBoard.setBoat(9, 5, 1, 2));
		assertTrue(gameBoard.setBoat(9, 5, 2, 4));
		
		
		//(5,9)
		assertTrue(gameBoard.setBoat(5, 9, 1, 1));
		assertTrue(gameBoard.setBoat(5, 9, 2, 1));
		assertTrue(gameBoard.setBoat(5, 9, 1, 2));
		assertFalse(gameBoard.setBoat(5, 9, 2, 4));
		
		
		
	}
	

}
		