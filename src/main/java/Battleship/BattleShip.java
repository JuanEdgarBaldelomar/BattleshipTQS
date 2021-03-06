package Battleship;
import java.io.IOException;
import java.util.Scanner;

import controller.ControllerBoard;
import controller.ControllerUser;
import model.Board;
import model.User;
import view.ViewBoard;
import view.ViewUser;

public class BattleShip {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		User modelUser1 = new User();
		User modelUser2 = new User();
		Board modelBoard1 = new Board();
		Board modelBoard2 = new Board();
		
		ViewUser viewUser = new ViewUser();
		ViewBoard viewBoard = new ViewBoard();
		
		ControllerUser controllerUser1 = new ControllerUser(modelUser1, viewUser);
		ControllerUser controllerUser2 = new ControllerUser(modelUser2, viewUser);
		ControllerBoard controllerBoard1 = new ControllerBoard(modelBoard1, viewBoard);
		ControllerBoard controllerBoard2 = new ControllerBoard(modelBoard2, viewBoard);
		
		try (Scanner keyBoard = new Scanner(System.in)) {
			controllerUser1.getViewSetName1();
			String userName = keyBoard.nextLine();
			controllerUser1.setUserName(userName);
			
			while (controllerBoard1.canSetBoats() != 0) {
				controllerUser1.getViewSetCord();
				int x = keyBoard.nextInt();
				int y = keyBoard.nextInt();
				controllerUser1.getViewOrientacion();
				int orientacion = keyBoard.nextInt();
				controllerUser1.getViewTypeBoat();
				int tipo = keyBoard.nextInt();
				
				if(controllerUser1.setAllData(x, y, orientacion, tipo)) {
					
					int code = controllerBoard1.setBoatsBoard(x,y,orientacion,tipo);
					if(code == 1) {
						controllerUser1.getOKMsg();
					}else if(code == 2) {
						controllerUser1.getErrBoatType1();
					}else if (code == 3) {
						controllerUser1.getErrBoatType2();
					}else if(code == 4) {
						controllerUser1.getErrBoatType3();
					}else if (code == 5) {
						controllerUser1.getErrBoatType4();
					}else if(code == 6) {
						controllerUser1.getErrRule();
					}else if(code == 7) {
						controllerUser1.getErrEspacio();
					}
					
					
				}else {
					controllerUser1.getErrorMsg();
				}
				
			}
			
			controllerBoard1.getViewBoard();
			
		
			controllerUser2.getViewSetName2();
			String userName2 = keyBoard.next();
			controllerUser2.setUserName(userName2);
			
			while(controllerBoard2.canSetBoats() !=0) {
					
				controllerUser2.getViewSetCord();
				
				int x = keyBoard.nextInt();
				int y = keyBoard.nextInt();
				controllerUser2.getViewOrientacion();
				int orientacion = keyBoard.nextInt();
				controllerUser2.getViewTypeBoat();
				int tipo = keyBoard.nextInt();
					
				if(controllerUser2.setAllData(x, y, orientacion, tipo)) {
						
					int code = controllerBoard2.setBoatsBoard(x,y,orientacion,tipo);
					if(code == 1) {
						controllerUser2.getOKMsg();
					}else if(code == 2) {
						controllerUser2.getErrBoatType1();
					}else if (code == 3) {
						controllerUser2.getErrBoatType2();
					}else if(code == 4) {
						controllerUser2.getErrBoatType3();
					}else if (code == 5) {
						controllerUser2.getErrBoatType4();
					}else if(code == 6) {
						controllerUser2.getErrRule();
					}else if(code == 7) {
						controllerUser2.getErrEspacio();
					}					
						
				}else {
					controllerUser2.getErrorMsg();
				}
			}
			
			
			
			controllerBoard2.getViewBoard();
			
			boolean repeatShootUser1 = true;
			boolean repeatShootUser2 = true;
			controllerBoard1.copyBoard(controllerBoard2.getBoard());
			controllerBoard2.copyBoard(controllerBoard1.getBoard());
			
			
			while(!controllerBoard1.getWinner() && !controllerBoard2.getWinner()) {
		
				
				
				while(repeatShootUser1 && !controllerBoard1.getWinner() && !controllerBoard2.getWinner()){
					
					controllerUser1.getShootMsg();
					int x = keyBoard.nextInt();
					int y = keyBoard.nextInt();
					repeatShootUser1 = controllerBoard1.shootBoat(x, y);
					controllerBoard1.getViewShootBoard();
				} 
				
				repeatShootUser1 = true;
				
				//Runtime.getRuntime().exec("clear");

				
				while(repeatShootUser2 && !controllerBoard2.getWinner() && !controllerBoard1.getWinner()){
					controllerUser2.getShootMsg();
					int x2 = keyBoard.nextInt();
					int y2 =keyBoard.nextInt();
					repeatShootUser2 = controllerBoard2.shootBoat(x2, y2);
					controllerBoard2.getViewShootBoard();
				}
			
				//Runtime.getRuntime().exec("clear");
				repeatShootUser2 = true;
			}
			
			
			if(controllerBoard1.getWinner()) {
				controllerUser1.getViewWin();
			}else {
				controllerUser2.getViewWin();
			}
			
					
		}
		


	}

}
