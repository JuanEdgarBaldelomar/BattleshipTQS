package controller;


import model.User;
import view.ViewUser;

public class ControllerUser {

	
	private User mModel;
	private ViewUser mView;
	
	public ControllerUser(User model, ViewUser view) {
		
		
		this.mModel = model;
		this.mView = view;
		
	}
	
	public void getViewSetName1() {
		
		mView.viewSetName1();
	}
public void getViewSetName2() {
		
		mView.viewSetName2();
	}
	
	public void getViewSetCord() {
		mView.viewSetCord();
	}
	
	public void getViewOrientacion() {
		mView.viewSetOrientacion();
	}
	
	public void getViewTypeBoat() {
		mView.viewSetTypeBoat();
	}
	
	public void getViewWin() {
		mView.viewWin(mModel.getNameUser());
	}
	
	public void setUserName(String userName) {
		mModel.setNameUser(userName);
	}
	
	public boolean setAllData(int col, int row, int orientacion, int typeBoat) {
		return mModel.setCoordinates(row, col, orientacion, typeBoat);
	}
	
	public void getErrorMsg() {
		mView.getViewErrorSetData();
	}
	
	public void getOKMsg() {
		mView.getSetBoatOK();
	}
	
	public void getErrBoatType1() {
		mView.msgLimiteBarcosPequeños();
	}
	
	public void getErrBoatType2() {
		mView.msgLimiteBarcosMedianos();
	}
	
	public void getErrBoatType3() {
		mView.msgLimiteBarcosGrandes();
	}
	
	public void getErrBoatType4() {
		mView.msgLimiteSubmarine();
		
	}
	
	
	public void getErrRule() {
		mView.msgReglaEspacio();
	}
	
	public void getErrEspacio() {
		mView.msgEspacioOcupado();
	}
	
	public void getShootMsg() {
		mView.shootMsg(mModel.getNameUser());
	}
	
	
}
