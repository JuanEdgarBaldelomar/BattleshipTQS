package view;

public class ViewUser {
	
	
	public void viewSetName1() {
		
		System.out.println("INTRODUZCA SU NOMBRE");
		
	}
	public void viewSetName2() {
		
		System.out.println("INTRODUZCA SU NOMBRE");
		
	}
	
	public void viewSetCord() {
		System.out.println("INTRODUZCA LAS COORDENADAS(X-Y) entre 0-9");
	}
	
	public void viewSetOrientacion() {
		System.out.println("INTRODUZCA LA ORIENTACION 1: HORIZONTAL, 2 VERTICAL, SI EL BARCO ES PEQUEÑO CUALQUIER ORIENTACION");
	}
	
	public void viewSetTypeBoat() {
		
		System.out.println("TIPO DE BARCO, 1: PEQUEÑO, 2:MEDIANO, 3:GRANDE, 4:SUBMARINO");
		
	}
	
	public void viewWin(String userName) {
		
		System.out.println("FELICIDADES GANASTE "+userName);
		
	}
	
	
	public void viewErrorData() {
		System.out.println("VUELVA A INTRODUCIR LOS DATOS");
	}
	
	
	public void getViewErrorSetData() {
		System.out.println("ERROR! VUELA A INTRODUCIR LOS DATOS SEGUN LAS CONDICIONES DESCRITAS");
	}
	
	
	public void getSetBoatOK() {
		System.out.println("BARCO COLOCADO");
	}
	
	public void msgLimiteBarcosPequeños() {
		System.out.println("NO PUEDE COLOCAR MAS BARCOS PEQUEÑOS");
	}
	
	public void msgLimiteBarcosMedianos() {
		System.out.println("NO PUEDE COLOCAR MAS BARCOS MEDIANOS");
	}
	
	public void msgLimiteBarcosGrandes() {
		System.out.println("NO PUEDE COLOCAR MAS BARCOS GRANDES");
	}
	
	public void msgLimiteSubmarine() {
		System.out.println("NO PUEDE COLOCAR MAS SUBMARINO");
	}
	
	
	public void msgReglaEspacio() {
		System.out.println("LA DISTANCIA ENTRE BARCOS ES INCORRECTA");
	}
	
	public void msgEspacioOcupado() {
		System.out.println("EL ESPACIO ESTA OCUPADO POR OTRO BARCO");
	}
	
	public void shootMsg(String userName) {
		System.out.println("DISPARAR CORDX, CORD Y "+userName);
	}
	
}
