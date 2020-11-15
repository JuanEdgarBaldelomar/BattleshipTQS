package model;

public class MockUser extends User {
	
	public MockUser() {
		
		User testMock = new User();
		testMock.getNameUser();
		testMock.setCoordinates(5, 2, 1, 1);
		
		User testMock1 = new User();
		testMock1.getNameUser();
		testMock1.setCoordinates(-5, 0, 1, 1);
		
		User testMock2 = new User();
		testMock2.getNameUser();
		testMock2.setCoordinates(0, 0, 2, 1);
		
	}

	
	
}
