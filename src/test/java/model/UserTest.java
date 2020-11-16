package model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class UserTest {

	
	
	MockUser mockUser;
	int[] data;
	User userTest;
	@Before
	public  void setUp() {
		mockUser = new MockUser();
		data = new int[4];
		userTest = new User();
	}
	
	
	@Test
	public void testGetSetNameUser() {
		
		//valor null
		User nameUser1 = new User();
		assertEquals(null, nameUser1.getNameUser());
	
		//comprobar valor player
		User nameUser2 = new User();
		nameUser2.setNameUser("player");
		String aux = nameUser2.getNameUser();
		assertEquals("player", aux);
		
		//comprobar dos valores diferentes
		User nameUser3 = new User();
		nameUser3.setNameUser("player");
		String aux1 = nameUser3.getNameUser();
		assertNotEquals("play", aux1);
		
		//comprobar valor con letras y numeros
		User nameUser4 = new User();
		nameUser4.setNameUser("hat11");
		String aux2 = nameUser4.getNameUser();
		assertNotEquals("hat01", aux2);
		
		
	}
	@Test
	public void testGetSetcoordinates() {
	
	    //valores frontera
		//valor frontera (0,0,0,0)
		User coordinates = new User();
		coordinates.setCoordinates(0,0,0,0);
		int aux6 = coordinates.getRow();
		int aux5 = coordinates.getCol();
		int aux30 = coordinates.getOrientacion();
		int aux31 = coordinates.getTypeBoat();
		assertEquals(0, aux6);
		assertEquals(0, aux5);
		assertEquals(0, aux30);
		assertEquals(0, aux31);
		
		//valor frontera (0,9,1,3)
		User coordinates1 = new User();
		coordinates1.setCoordinates(0,9,1,3);
		int aux7 = coordinates1.getRow();
		int aux8 = coordinates1.getCol();
		int aux32 = coordinates1.getOrientacion();
		int aux33 = coordinates1.getTypeBoat();
		assertEquals(0, aux7);
		assertEquals(9, aux8);
		assertEquals(1, aux32);
		assertEquals(3, aux33);
	
		
		User coordinates10 = new User();
		coordinates10.setCoordinates(8,1,1,3);
		int aux9 = coordinates10.getRow();
		int aux78 = coordinates10.getCol();
		int aux82 = coordinates10.getOrientacion();
		int aux83 = coordinates10.getTypeBoat();
		assertEquals(8, aux9);
		assertEquals(1, aux78);
		assertEquals(1, aux82);
		assertEquals(3, aux83);
	

		//valor frontera (9,9)
		User coordinates3 = new User();
		coordinates3.setCoordinates(9, 9, 1, 2);
		int aux11 = coordinates3.getRow();
		int aux12 = coordinates3.getCol();
		int aux36 = coordinates3.getOrientacion();
		int aux37 = coordinates3.getTypeBoat();
		assertEquals(9, aux11);
		assertEquals(9, aux12);
		assertEquals(1, aux36);
		assertEquals(2, aux37);
		
		//valores limite
		//valores limite(-1,10)
		User coordinates4 = new User();
		coordinates4.setCoordinates(-1, 10, -1, 4);
		int aux13 = coordinates4.getRow();
		int aux14 = coordinates4.getCol();
		int aux38 = coordinates4.getOrientacion();
		int aux39 = coordinates4.getTypeBoat();
		assertNotEquals(-1, aux13);
		assertNotEquals(10, aux14);	
		assertNotEquals(-1, aux38);
		assertNotEquals(4, aux39);
		
		//valores limite(10,-1,3,-1)
		User coordinates5 = new User();
		coordinates5.setCoordinates(10, -1, 3, -1);
		int aux15 = coordinates5.getRow();
		int aux16 = coordinates5.getCol();
		int aux40 = coordinates5.getOrientacion();
		int aux41 = coordinates5.getTypeBoat();
		assertNotEquals(10, aux15);
		assertNotEquals(-1, aux16);
		assertNotEquals(3, aux40);
		assertNotEquals(-1, aux41);
		
		//particion equivalente
		////valores (3,2,3,2)
		User coordinates6 = new User();
		coordinates6.setCoordinates(3,2,2,2);
		int aux17 = coordinates6.getRow();
		int aux18 = coordinates6.getCol();
		int aux60 = coordinates6.getOrientacion();
		int aux61 = coordinates6.getTypeBoat();
		assertEquals(3, aux17);
		assertEquals(2, aux18);
		assertEquals(2, aux60);
		assertEquals(2, aux61);
		
		
		//valores (2, 3, 2, 3)
		User coordinates7 = new User();
		coordinates7.setCoordinates(2, 3, 2, 3);
		int aux19 = coordinates7.getRow();
		int aux20 = coordinates7.getCol();
		int aux70 = coordinates7.getOrientacion();
		int aux71 = coordinates7.getTypeBoat();
		assertEquals(2, aux19);
		assertEquals(3, aux20);
		assertEquals(2, aux70);
		assertEquals(3, aux71);
		
		/*
		//Decisi�n coverage
		// pasamos valores para que el primer if sea True
		
		User testCondC1 = new User();
		testCondC1.setCoordinates(5, 4, 2, 3);
		
		
		// pasamos valores para que el primer if sea False
		
		User testCondC2 = new User();
		testCondC2.setCoordinates(-5, -5, 7, 5);*/ 
		
		}
	
		/*
		coordinates8.setCoordinates(2, -1, -1, -1);
		int aux50 = coordinates8.getRow();
		int aux51 = coordinates8.getCol();
		int aux52 = coordinates8.getOrientacion();
		int aux53 = coordinates8.getTypeBoat();
		//assertTrue(2, aux50);
		
		*/
	@Test
	public void decisionTest() {
		
		data = mockUser.decisionTestTrue();
		assertTrue(userTest.setCoordinates(data[0], data[1], data[2], data[3]));
		data = mockUser.decisionTestFalse();
		assertFalse(userTest.setCoordinates(data[0], data[1], data[2], data[3]));
		
	}
		
		
	
	
}
