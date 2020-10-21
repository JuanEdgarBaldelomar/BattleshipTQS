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
	
	

}
