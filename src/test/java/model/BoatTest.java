package model;

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
	
	
	

}
