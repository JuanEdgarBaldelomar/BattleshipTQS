package model;

public class User {
	
	private String nameUser;
	private int row;
	private int col;
	private int orientacion;
	private int typeBoat;

	
	
	public String getNameUser()
	{
		return nameUser;
	}
	
	public void setNameUser(String nameUser) {
		this.nameUser = nameUser;
	}
	
	public boolean setCoordinates(int row, int col, int orientacion, int typeBoat) {
		if(row >= 0 && row <= 9 && col >= 0 && col <= 9  && orientacion >0 && orientacion <= 2 && typeBoat >= 0 && typeBoat <= 3) {
			
			this.row=row;
			this.col=col;
			this.orientacion=orientacion;
			this.typeBoat=typeBoat;
			return true;
		}else {
			return false;
		}
		
		}
	public int getRow ()
	{
		return row;
	}
	public int getCol() {
		return col;
	}
	
	public int getOrientacion()
    {
        return orientacion; 
    }
    
	public int getTypeBoat() {
		
		return typeBoat;
	}
}
