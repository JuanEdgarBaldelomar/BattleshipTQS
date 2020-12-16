package Battleship;


import static org.junit.Assert.assertEquals;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.IOException;

import org.junit.Test;

import controller.ControllerBoard;
import model.Board;
import model.User;
import view.ViewBoard;

/**
 * @author Ferran Bayona Castellà - 1390131
 * @author Marcos Alessandro Mena Pérez - 1460748
 * */

public class AutomatedTest {
	
	@Test
	public void main() {
		
		boolean hit = false;
		
		Board modelBoard1 = new Board();
		Board modelBoard2 = new Board();
		Board modelBoard3 = new Board();
		Board modelBoard4 = new Board();
		
		ViewBoard viewBoard = new ViewBoard();
		
		ControllerBoard controllerBoard1 = new ControllerBoard(modelBoard1, viewBoard);
		ControllerBoard controllerBoard2 = new ControllerBoard(modelBoard2, viewBoard);
		ControllerBoard controllerBoard3 = new ControllerBoard(modelBoard3, viewBoard);
		ControllerBoard controllerBoard4 = new ControllerBoard(modelBoard4, viewBoard);
		ControllerBoard controllerBoard5 = new ControllerBoard(modelBoard1, viewBoard);
		ControllerBoard controllerBoard6 = new ControllerBoard(modelBoard2, viewBoard);
		ControllerBoard controllerBoard7 = new ControllerBoard(modelBoard1, viewBoard);
		ControllerBoard controllerBoard8 = new ControllerBoard(modelBoard2, viewBoard);
		
		

		
		/**
		 * PARTIDA 1  Controlar posiciones barcos
		 * */
		
		//Colocar barco grande fuera del tablero por la orientacion horizontal
		assertEquals(controllerBoard1.setBoatsBoard(0, 9, 1, 3), 6);
		//Colocar submarino fuera del tablero por la orientacion vertical
		assertEquals(controllerBoard1.setBoatsBoard(8, 8, 2, 4), 6);
		
		//Colocar un barco que una de sus posiciones coincida con un barco ya colocado
		assertEquals(controllerBoard1.setBoatsBoard(3, 3, 1, 4), 1);
		assertEquals(controllerBoard1.setBoatsBoard(3, 3, 2, 3), 6);
		assertEquals(controllerBoard1.setBoatsBoard(4, 2, 2, 3), 6);
		
		//Colocar un barco que una de sus posiciones este tocando con otro barco ya colocado
		assertEquals(controllerBoard1.setBoatsBoard(7, 7, 1, 1), 1);
		assertEquals(controllerBoard1.setBoatsBoard(8, 7, 1, 1), 6);
		assertEquals(controllerBoard1.setBoatsBoard(7, 8, 1, 1), 6);
		
		//Colocar mas barcos de los permitidos para un tipo de barco
		//Barcos pequenos
		assertEquals(controllerBoard2.setBoatsBoard(0, 2, 1, 1), 1);
		assertEquals(controllerBoard2.setBoatsBoard(2, 0, 1, 1), 1);
		assertEquals(controllerBoard2.setBoatsBoard(9, 0, 1, 1), 1);
		assertEquals(controllerBoard2.setBoatsBoard(9, 9, 1, 1), 1);
		assertEquals(controllerBoard2.setBoatsBoard(5, 4, 2, 1), 2);
		//Barcos medianos
		assertEquals(controllerBoard2.setBoatsBoard(0, 6, 2, 2), 1);
		assertEquals(controllerBoard2.setBoatsBoard(1, 4, 1, 2), 1);
		assertEquals(controllerBoard2.setBoatsBoard(3, 6, 2, 2), 1);
		assertEquals(controllerBoard2.setBoatsBoard(5, 4, 2, 2), 3);
		//Barcos grandes
		assertEquals(controllerBoard2.setBoatsBoard(5, 0, 2, 3), 1);
		assertEquals(controllerBoard2.setBoatsBoard(7, 4, 1, 3), 1);
		assertEquals(controllerBoard2.setBoatsBoard(7, 2, 1, 3), 4);
		//Submarinos
		assertEquals(controllerBoard2.setBoatsBoard(5, 7, 1, 4), 1);
		assertEquals(controllerBoard2.setBoatsBoard(3, 9, 1, 4), 5);
		
		controllerBoard1.shootBoat(1, 1);
		controllerBoard2.shootBoat(0, 2);
		controllerBoard2.shootBoat(0, 0);
		controllerBoard1.shootBoat(3, 3);
		controllerBoard1.shootBoat(7, 7);
		
		if(controllerBoard1.getWinner()) {
			System.out.println("JUGADOR 1 HA GANADO LA PARTIDA 1");
		}else {
			System.out.println("JUGADOR 2 HA GANADO LA PARTIDA 1");
		}
		
		/**
		 * PARTIDA 2 Controlar disparos jugadores
		 * */
		
		controllerBoard3.copyBoard(controllerBoard4.getBoard());
		controllerBoard4.copyBoard(controllerBoard3.getBoard());
		
		//Colocamos barcos para comprobar disparos
		controllerBoard3.setBoatsBoard(0, 0, 1, 1);
		controllerBoard3.setBoatsBoard(2, 0, 1, 1);
		controllerBoard3.setBoatsBoard(3, 3, 2, 2);
		controllerBoard4.setBoatsBoard(4, 4, 1, 1);
		controllerBoard4.setBoatsBoard(0, 3, 1, 1);
		controllerBoard4.setBoatsBoard(7, 7, 2, 2);
		
		//Disparos fuera tablero
		assertFalse(controllerBoard3.shootBoat(-5, 0));
		assertFalse(controllerBoard4.shootBoat(0, -7));
		assertFalse(controllerBoard3.shootBoat(20, 0));
		assertFalse(controllerBoard4.shootBoat(0, 10));
		//Turno J3: toca,hunde,falla
		assertEquals(controllerBoard3.shootBoat(3, 3), hit);
		assertEquals(controllerBoard3.shootBoat(3, 4), hit);
		assertFalse(controllerBoard3.shootBoat(9, 8));
		//Turno J4: Hunde,hunde,toca,falla
		assertEquals(controllerBoard4.shootBoat(4,4), hit);
		assertEquals(controllerBoard4.shootBoat(0,3), hit);
		assertEquals(controllerBoard4.shootBoat(7,7), hit);
		assertFalse(controllerBoard4.shootBoat(1, 7));
		////Turno J3: hunde ultimo barco
		assertEquals(controllerBoard3.shootBoat(0,0), hit);
		
		if(controllerBoard3.getWinner()) {
			System.out.println("JUGADOR 3 HA GANADO LA PARTIDA 2");
		}else {
			System.out.println("JUGADOR 4 HA GANADO LA PARTIDA 2");
		}
		
		/**
		 * PARTIDA 3 Controlar ganador de partida
		 * */
		
		controllerBoard5.setBoatsBoard(9, 0, 1, 1);
		controllerBoard6.setBoatsBoard(0, 9, 1, 1);

		controllerBoard5.shootBoat(9, 0);
		controllerBoard6.shootBoat(0, 0);

		assertTrue(controllerBoard5.getWinner());

		if(controllerBoard5.getWinner()) {
			System.out.println("JUGADOR 5 HA GANADO LA PARTIDA 3");
		}else {
			System.out.println("JUGADOR 6 HA GANADO LA PARTIDA 3");
		}
		
		//Gana Jugador 6
		controllerBoard5.setBoatsBoard(8, 0, 1, 1);

		controllerBoard5.shootBoat(0, 0);
		controllerBoard6.shootBoat(0, 9);

		assertTrue(controllerBoard6.getWinner());

		if(controllerBoard6.getWinner()) {
			System.out.println("JUGADOR 6 HA GANADO LA PARTIDA 3");
		}else {
			System.out.println("JUGADOR 5 HA GANADO LA PARTIDA 3");
		}
		
		
		/**
		 * PARTIDA 4 Controlar entrar nombre
		 * */
		
		//SetNameUser correcto
		User Jugador1 = new User();
		assertEquals(null, Jugador1.getNameUser());
		Jugador1.setNameUser("Jugador1");
		assertEquals(Jugador1.getNameUser(), "Jugador1");
		

		//NO NUMERICO
		assertFalse(Jugador1.setCoordinates('a', 0, 1, 1));
		assertFalse(Jugador1.setCoordinates(0, '%', 1, 1));
		assertFalse(Jugador1.setCoordinates(0, 0, '-', 1));
		
		//FUERA RANGO TABLERO
		assertFalse(Jugador1.setCoordinates(50, 0, 1, 1));
		assertFalse(Jugador1.setCoordinates(0, 11, 1, 1));
		assertFalse(Jugador1.setCoordinates(-50, 0, 1, 1));
		assertFalse(Jugador1.setCoordinates(0, -11, 1, 1));
		assertFalse(Jugador1.setCoordinates(0, 0, 5, 1));
		assertFalse(Jugador1.setCoordinates(0, 0, 1, 0));
		
		//CORRECTO
		assertTrue(Jugador1.setCoordinates(5, 0, 1, 1));
		assertTrue(Jugador1.setCoordinates(0, 4, 1, 1));
		assertTrue(Jugador1.setCoordinates(9, 4, 1, 1));
		assertTrue(Jugador1.setCoordinates(8, 3, 1, 1));
		assertTrue(Jugador1.setCoordinates(0, 0, 2, 1));
		assertTrue(Jugador1.setCoordinates(0, 0, 1, 3));
		
		controllerBoard7.setBoatsBoard(3, 3, 1, 4);
		controllerBoard7.setBoatsBoard(7, 7, 1, 1);
		controllerBoard8.setBoatsBoard(0, 2, 1, 1);
		controllerBoard7.shootBoat(1, 1);
		controllerBoard8.shootBoat(0, 2);
		
		if(controllerBoard8.getWinner()) {
			System.out.println("JUGADOR 8 HA GANADO LA PARTIDA 4");
		}else {
			System.out.println("JUGADOR 7 HA GANADO LA PARTIDA 4");
		}
	}
}
