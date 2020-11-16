package model;

public class MockUser extends User {
	
	public MockUser() {
		
		/*User testMock = new User();
		testMock.getNameUser();
		testMock.setCoordinates(5, 2, 1, 1);
		
		User testMock1 = new User();
		testMock1.getNameUser();
		testMock1.setCoordinates(-5, 0, 1, 1);
		
		User testMock2 = new User();
		testMock2.getNameUser();
		testMock2.setCoordinates(0, 0, 2, 1);*/
		
		
		
		
	}

	
	
	public int[] decisionTestTrue(){
		
		int[] parameters = new int[4];
		
		parameters[0] = 8;
		parameters[1] = 2;
		parameters[2] = 1;
		parameters[3] = 2;
		
		
		return parameters;
		
		
	}
	
	
	public int[] decisionTestFalse() {
		
		int[] parameters = new int[4];
		
		parameters[0] = 10;
		parameters[1] = 2;
		parameters[2] = 1;
		parameters[3] = 2;
		
		
		return parameters;
		
		
	}
	
	public int[] conditionTestFirstParamTrue() {
		
		int[] parameters = new int[4];
		
		parameters[0] = 8;
		parameters[1] = 2;
		parameters[2] = 1;
		parameters[3] = 2;
		
		return parameters;
		
		
	}
	public int[] conditionTestFirstParamFalse() {
		int[] parameters = new int[4];
		
		parameters[0] = 11;
		parameters[1] = 2;
		parameters[2] = 1;
		parameters[3] = 2;
		
		return parameters;
		
	}
	
	public int[] conditionTestSecondParamTrue() {
		
		int[] parameters = new int[4];
		
		parameters[0] = 8;
		parameters[1] = 2;
		parameters[2] = 1;
		parameters[3] = 2;
		
		return parameters;
		
		
	}
	
	public int[] conditionTestSecondParamFalse() {
		
		int[] parameters = new int[4];
		
		parameters[0] = 8;
		parameters[1] = 11;
		parameters[2] = 1;
		parameters[3] = 2;
		
		return parameters;
		
	}
	
	public int[] conditionTestThirdParamTrue() {
		int[] parameters = new int[4];
		parameters[0] = 8;
		parameters[1] = 2;
		parameters[2] = 1;
		parameters[3] = 2;
		
		return parameters;
		
	}
	
	public int[] conditionTestThirdParamFalse() {
		int[] parameters = new int[4];
		parameters[0] = 8;
		parameters[1] = 2;
		parameters[2] = 3;
		parameters[3] = 2;
		
		return parameters;
		
		
	}
	public int[] conditionTestFourParamTrue() {
		
		int[] parameters = new int[4];
		parameters[0] = 8;
		parameters[1] = 2;
		parameters[2] = 2;
		parameters[3] = 2;
		
		return parameters;
		
		
	}
	
	public int[] conditionTestFourParamFalse() {
		
		int[] parameters = new int[4];
		parameters[0] = 8;
		parameters[1] = 2;
		parameters[2] = 2;
		parameters[3] = 5;
		
		return parameters;
		
		
	}
	
	
}
