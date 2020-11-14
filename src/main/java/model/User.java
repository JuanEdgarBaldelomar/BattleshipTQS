package model;

public class User {
	
	private String nameUser;
	private int row;
	private int col;

	
	
	public String getNameUser()
	{
		return nameUser;
	}
	
	public void setNameUser(String nameUser) {
		this.nameUser = nameUser;
	}
	
	public void setCoordinates(int row, int col) {
		this.row=row;
		this.col=col;
		}
	public int getRow ()
	{
		return row;
	}
	public int getCol() {
		return col;
	}
}
