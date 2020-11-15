package model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class BoardTest {

	Board gameBoard;
	@Before
	public  void setUp() {
		gameBoard = new Board();
	}
	
	@Test
	public void testInitBoard() {
		
		Board gameBoard2 = new Board();
		assertTrue(gameBoard.getSizeX()==10);
		assertTrue(gameBoard.getSizeY()==10);
		assertTrue(gameBoard.equals(gameBoard2));
		assertTrue(gameBoard.mIdBoats.size()==10);
	}
	
	
	/**
	 * 
	 */
	@Test
	public void testSetBoats() {
		
		
		
		
		
		
	}
	

}
		
