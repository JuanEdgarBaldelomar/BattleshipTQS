package model;

import static org.junit.Assert.*;

import org.junit.Test;

public class UserTest {

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
	
		User coordinates = new User();
		coordinates.setCoordinates(0, 0);
		int aux10 = coordinates.getRow();
		int aux11 = coordinates.getCol();
		assertEquals(0, aux10);
		assertEquals(0, aux11);
	
		User coordinates1 = new User();
		coordinates1.setCoordinates(10, 10);
		int aux100 = coordinates1.getRow();
		int aux111 = coordinates1.getCol();
		assertEquals(10, aux100);
		assertEquals(10, aux111);
	
		User coordinates2 = new User();
		coordinates2.setCoordinates(12, 0);
		int aux1000 = coordinates2.getRow();
		int aux1111 = coordinates2.getCol();
		assertEquals(12, aux1000);
		assertEquals(0, aux1111);
	
	
	}
	
}
