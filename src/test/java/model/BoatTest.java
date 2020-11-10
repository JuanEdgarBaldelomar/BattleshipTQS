package model;

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
	
	
	
	
	
	

}
