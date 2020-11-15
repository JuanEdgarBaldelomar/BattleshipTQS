package model;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class BoatTest {
	 
	
	LittleBoat littleBoat;
	MediumBoat mediumBoat;
	BigBoat bigBoat;
	Submarine submarine;
	
	@Before
	public void setUp() {
		littleBoat = new LittleBoat(1);
		mediumBoat = new MediumBoat(2);
		bigBoat = new BigBoat(3);
		submarine = new Submarine(4);
	}
	
	
	@Test
	public void testInitBoats() {
		
		//Valor limite lancha
		assertTrue(littleBoat.getSize()==1);
		assertTrue(littleBoat.getSize()!=0);
		assertTrue(littleBoat.getSize()!=2);
		
		//Valor limite barco medio
		assertTrue(mediumBoat.getSize()==2);
		assertTrue(mediumBoat.getSize()!=1);
		assertTrue(mediumBoat.getSize()!=3);
		
		//Valor limite barco grande
		assertTrue(bigBoat.getSize()==3);
		assertTrue(bigBoat.getSize()!=2);
		assertTrue(bigBoat.getSize()!=4);
		
		//valor limite submarino
		assertTrue(submarine.getSize()==4);
		assertTrue(submarine.getSize()!=3);
		assertTrue(submarine.getSize()!=5);
		
		
	}
	
	@Test
	public void testCheckRule() {
		
		MockBoard mockBoard = new MockBoard();
		//lancha
		assertFalse(littleBoat.checkRule(0, 0, 1, mockBoard.getTestBoardLittleBoats()));//conflicto abajo
		assertFalse(littleBoat.checkRule(0, 4, 1, mockBoard.getTestBoardLittleBoats()));//conflicto derecha
		assertFalse(littleBoat.checkRule(0, 9, 1, mockBoard.getTestBoardLittleBoats()));//conflicto abajo
		assertFalse(littleBoat.checkRule(3, 4, 1, mockBoard.getTestBoardLittleBoats()));//conflicto izquierda
		assertFalse(littleBoat.checkRule(5, 7, 1, mockBoard.getTestBoardLittleBoats()));//superior izquierda
		assertFalse(littleBoat.checkRule(5, 8, 1, mockBoard.getTestBoardLittleBoats()));//infererior izquierda
		assertFalse(littleBoat.checkRule(6, 7, 1, mockBoard.getTestBoardLittleBoats()));//superior derecha
		assertFalse(littleBoat.checkRule(6, 8, 1, mockBoard.getTestBoardLittleBoats()));//inferior derecha
		assertTrue(littleBoat.checkRule(8, 2, 1,  mockBoard.getTestBoardLittleBoats()));
		assertTrue(littleBoat.checkRule(9, 9, 1,  mockBoard.getTestBoardLittleBoats()));//V.Fontera 9,9
		
		mockBoard = new MockBoard();
		//barco mediano
		assertFalse(mediumBoat.checkRule(0, 0, 2, mockBoard.getTestMediumBoats()));//conflicto abajo
		assertFalse(mediumBoat.checkRule(0, 8, 2, mockBoard.getTestMediumBoats()));//conflicto arriba
		assertFalse(mediumBoat.checkRule(3, 2, 2, mockBoard.getTestMediumBoats()));//conflicto izquierda
		assertFalse(mediumBoat.checkRule(5, 2, 2, mockBoard.getTestMediumBoats()));//conflicto derecha
		assertFalse(mediumBoat.checkRule(6, 9, 2, mockBoard.getTestMediumBoats()));//v. limite
		assertFalse(mediumBoat.checkRule(9, 4, 1, mockBoard.getTestMediumBoats()));//v. limite
		assertTrue(mediumBoat.checkRule(8, 0, 1, mockBoard.getTestMediumBoats()));//v. Frontera
		assertTrue(mediumBoat.checkRule(9, 0, 2, mockBoard.getTestMediumBoats()));//v. Frontera
		assertTrue(mediumBoat.checkRule(8, 6, 1, mockBoard.getTestMediumBoats()));//v. Frontera
		assertFalse(mediumBoat.checkRule(9, 8, 1, mockBoard.getTestMediumBoats()));//v. limite
		assertTrue(mediumBoat.checkRule(9, 8, 2, mockBoard.getTestMediumBoats()));//v. limite
		
		mockBoard = new MockBoard();
		//barco mediano conflicto diagonal
		assertFalse(mediumBoat.checkRule(1, 1, 2, mockBoard.getTestMediumBoatsDiagonal()));//superior izquierda
		assertFalse(mediumBoat.checkRule(1, 7, 2, mockBoard.getTestMediumBoatsDiagonal()));//inferior izquierda
		assertFalse(mediumBoat.checkRule(3, 1, 2, mockBoard.getTestMediumBoatsDiagonal()));//superior derecha
		assertFalse(mediumBoat.checkRule(3, 7, 2, mockBoard.getTestMediumBoatsDiagonal()));//inferior derecha
		assertFalse(mediumBoat.checkRule(5, 1, 1, mockBoard.getTestMediumBoatsDiagonal()));//horizontal superior izquierda
		assertFalse(mediumBoat.checkRule(5, 8, 1, mockBoard.getTestMediumBoatsDiagonal()));//horizontal inferior izquierda
		assertFalse(mediumBoat.checkRule(7, 4, 1, mockBoard.getTestMediumBoatsDiagonal()));//horizontal inferior derecha
		assertFalse(mediumBoat.checkRule(7, 6, 1, mockBoard.getTestMediumBoatsDiagonal()));//horizontal inferior derecha
		assertFalse(mediumBoat.checkRule(8, 2, 1, mockBoard.getTestMediumBoatsDiagonal()));//horizontal abajo VF
		assertFalse(mediumBoat.checkRule(8, 8, 1, mockBoard.getTestMediumBoatsDiagonal()));//horizontal arriba VF
		assertFalse(mediumBoat.checkRule(9, 9, 1, mockBoard.getTestMediumBoatsDiagonal()));//horizontal arriba VL
		assertTrue(mediumBoat.checkRule(2, 8, 2, mockBoard.getTestMediumBoatsDiagonal()));//v. Frontera
		
		
		//barco grande
		//vertical
		mockBoard = new MockBoard();
		assertFalse(bigBoat.checkRule(0, 0, 2, mockBoard.getTestBigBoats()));// conflicto  abajo
		assertFalse(bigBoat.checkRule(0, 7, 2, mockBoard.getTestBigBoats()));// conflicto  abajo
		assertFalse(bigBoat.checkRule(1, 2, 2, mockBoard.getTestBigBoats()));// conflicto  izquirda
		assertFalse(bigBoat.checkRule(2, 2, 2, mockBoard.getTestBigBoats()));// conflicto  derecha
		assertFalse(bigBoat.checkRule(9, 9, 2, mockBoard.getTestBigBoats()));// VL 9,9
		assertTrue(bigBoat.checkRule(5, 3, 2, mockBoard.getTestBigBoats()));// sin conflictos
		// horizontal
		assertFalse(bigBoat.checkRule(3, 7, 1, mockBoard.getTestBigBoats()));// conflicto izquierda
		assertFalse(bigBoat.checkRule(3, 8, 1, mockBoard.getTestBigBoats()));// conflicto derecha
		assertFalse(bigBoat.checkRule(3, 2, 1, mockBoard.getTestBigBoats()));// conflicto abajo
		assertFalse(bigBoat.checkRule(7, 2, 1, mockBoard.getTestBigBoats()));// conflicto arriba
		assertFalse(bigBoat.checkRule(9, 1, 1, mockBoard.getTestBigBoats()));// V. limite
		assertTrue(bigBoat.checkRule(7, 4, 1, mockBoard.getTestBigBoats()));// v.frontera
		//diagonal
		//vertical
		mockBoard = new MockBoard();
		assertFalse(bigBoat.checkRule(0, 1, 2, mockBoard.getTestBigBoatsDiagonal()));//esquina superior derecha
		assertFalse(bigBoat.checkRule(2, 1, 2, mockBoard.getTestBigBoatsDiagonal()));//esquina superior izquierda
		assertFalse(bigBoat.checkRule(0, 6, 2, mockBoard.getTestBigBoatsDiagonal()));//esquina inferior derecha
		assertFalse(bigBoat.checkRule(2, 6, 2, mockBoard.getTestBigBoatsDiagonal()));//esquina inferior izquierda
		//horizontal
		assertFalse(bigBoat.checkRule(3, 6, 1, mockBoard.getTestBigBoatsDiagonal()));//esquina inferior derecha
		assertFalse(bigBoat.checkRule(3, 8, 1, mockBoard.getTestBigBoatsDiagonal()));//esquina superior derecha
		assertFalse(bigBoat.checkRule(7, 6, 1, mockBoard.getTestBigBoatsDiagonal()));//esquina inferior izquierda
		assertFalse(bigBoat.checkRule(7, 8, 1, mockBoard.getTestBigBoatsDiagonal()));//esquina inferior izquierda
		assertTrue(bigBoat.checkRule(7, 9, 1, mockBoard.getTestBigBoatsDiagonal()));
		
		mockBoard = new MockBoard();
		//subamarino
		//vertical
		assertFalse(submarine.checkRule(0, 0, 2, mockBoard.getTestSubmarine()));//conflicto abajo
		assertFalse(submarine.checkRule(0, 5, 2, mockBoard.getTestSubmarine()));//conflictO arriba,
		assertFalse(submarine.checkRule(1, 3, 2, mockBoard.getTestSubmarine()));//conflictO izquierda
		assertFalse(submarine.checkRule(2, 3, 2, mockBoard.getTestSubmarine()));//conflictO derecha
		assertTrue(submarine.checkRule(9, 6, 2, mockBoard.getTestSubmarine()));//v. lIMITE
		//horizontal
		assertFalse(submarine.checkRule(3, 3, 1, mockBoard.getTestSubmarine()));//abajo
		assertFalse(submarine.checkRule(3, 5, 1, mockBoard.getTestSubmarine()));//arriba
		assertFalse(submarine.checkRule(4, 4, 1, mockBoard.getTestSubmarine()));//izquierda
		assertFalse(submarine.checkRule(2, 8, 1, mockBoard.getTestSubmarine()));//derecha
		assertFalse(submarine.checkRule(7, 1, 1, mockBoard.getTestSubmarine()));//v.limite
		assertTrue(submarine.checkRule(0, 0, 1, mockBoard.getTestSubmarine()));
		mockBoard = new MockBoard();
		//diagonal
		//orientacion vertical
		assertFalse(submarine.checkRule(0, 0, 2, mockBoard.getTestSubmarineDiagonal()));//esquina inferior derecha
		assertFalse(submarine.checkRule(0, 6, 2, mockBoard.getTestSubmarineDiagonal()));//esquina superior derecha
		assertFalse(submarine.checkRule(2, 0, 2, mockBoard.getTestSubmarineDiagonal()));//esquina inferior izquierda
		assertFalse(submarine.checkRule(2, 6, 2, mockBoard.getTestSubmarineDiagonal()));//esquina superior izquierda				
		
	}
	
	
	

}
