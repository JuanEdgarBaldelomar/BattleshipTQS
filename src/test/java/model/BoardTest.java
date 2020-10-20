package model;

import static org.junit.Assert.*;

import org.junit.Test;

public class BoardTest {


	@Test
	public void testTableSizes() {
		
		Board gameBoard = new Board();
		
		assertTrue(gameBoard.getSizeX()==10);
		assertTrue(gameBoard.getSizeY()==10);
	}

}
