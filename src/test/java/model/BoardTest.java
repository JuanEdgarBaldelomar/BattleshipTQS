package model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class BoardTest {

	Board gameBoard;
	MockBoard  mockboard;
	@Before
	public  void setUp() {
		gameBoard = new Board();
		mockboard  = new MockBoard();
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
	 * Comprobamos si podemos colocar barcos en las coordendas
	 *
	 */
	@Test
	public void testSetBoats() {
		
		//colocacmos barcos  pequeños
		assertEquals(gameBoard.setBoat(0, 2, 1, 1), 1);
		assertEquals(gameBoard.setBoat(2, 0, 1, 1), 1);
		assertEquals(gameBoard.setBoat(9, 0, 1, 1), 1);
		assertEquals(gameBoard.setBoat(9, 9, 1, 1), 1);
		assertEquals(gameBoard.setBoat(5, 4, 2, 1), 2);//error al intentar poner un barco pequeño, ya hay 4
		//barcos medianos
		assertEquals(gameBoard.setBoat(0, 6, 2, 2), 1);
		assertEquals(gameBoard.setBoat(1, 4, 1, 2), 1);
		assertEquals(gameBoard.setBoat(3, 6, 2, 2), 1);
		assertEquals(gameBoard.setBoat(5, 4, 2, 2), 3);//intenar colocar un barco del mismo  tipo mas  de lo permitido
		//barcos grandes
		assertEquals(gameBoard.setBoat(5, 0, 2, 3), 1);
		assertEquals(gameBoard.setBoat(7, 4, 1, 3), 1);
		assertEquals(gameBoard.setBoat(7, 2, 1, 3), 4);//intenar colocar un barco del mismo  tipo mas  de lo permitido
		//submarinos
		assertEquals(gameBoard.setBoat(5, 7, 1, 4), 1);
		assertEquals(gameBoard.setBoat(3, 9, 1, 4), 5);//intenar colocar un barco del mismo  tipo mas  de lo permitido
		
		gameBoard.setMockBoard(mockboard.getB1());
		assertEquals(gameBoard.setBoat(2, 9, 1, 1), 2);
		assertEquals(gameBoard.setBoat(5, 1, 2, 2), 3);
		assertEquals(gameBoard.setBoat(9, 0, 1, 4), 6);//el barco no cabbe en el tablero
		assertEquals(gameBoard.setBoat(9, 7, 1, 4), 6);
		assertEquals(gameBoard.setBoat(5, 6, 2, 3), 7);//en el espacio que va  a ocupar el barco ya hay otro
		
	}
	
	@Test
	public void testShootBoat() {
		
		gameBoard.setMockBoardShot(mockboard.getShootBoard());
		assertTrue(gameBoard.shotBoat(1,3));
		assertTrue(gameBoard.shotBoat(4,7));
		assertFalse(gameBoard.shotBoat(4, 7));//volvemos a dispar  en un punto  ya dispardo
		assertFalse(gameBoard.shotBoat(5, 3));
		assertFalse(gameBoard.shotBoat(7, 3));
		assertFalse(gameBoard.shotBoat(7, 1));
		
		
	}
	
	@Test
	public  void  testCheckWinner() {
		assertTrue(gameBoard.checkWinner());
		gameBoard.setMockBoard(mockboard.getBoardOneAlive());
		assertFalse(gameBoard.checkWinner());
	}
	@Test
	public void testCopyBoard() {
		
		Board gameShootBoard = new Board();
		gameShootBoard.copyBoardToShoot(gameBoard.getBoard());
		assertTrue(gameBoard.equals(gameShootBoard));
		
	}

}
		
