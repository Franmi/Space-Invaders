package Main;
import java.util.Random;
import java.util.Scanner;

import Controller.Controller;
import Logic.Commands.CommandParseException;
import Logic.Game.Game;
import Logic.GamePrinter.FormattedPrinter;
import Logic.GamePrinter.GamePrinter;
import Logic.Level.Level;


public class Main {

	public static void main(String args[]) throws Exception {

		Level nivel = null;
		int seed =123;
		Scanner sc = new Scanner(System.in);
			
		System.out.print("\n\t\t\t\t ****************\n");
		System.out.print("\t\t\t\t  SPACE INVADERS\n");
		System.out.print("\t\t\t\t ****************\n");
		
		try {
		if(args.length > 0 && args.length < 3)
		switch(args[0]){
		case "EASY":
			System.out.print("\t\t\t\t    MODO  EASY \n");
			nivel = Level.EASY;
			
			break;
		case "HARD":
			System.out.print("\t\t\t\t    MODO  HARD \n");
			nivel = Level.HARD;
		
			break;
		case "INSANE":
			System.out.print("\t\t\t\t   MODO  INSANE \n");
			nivel = Level.INSANE;
			break;		
			
		default:
			throw new NullPointerException("Main <EASY|HARD|INSANE>: level must be one of: EASY, HARD, INSANE");
		}
		else throw new NullPointerException("Main <EASY|HARD|INSANE>");
	
		System.out.print("\t\t\t\t ****************\n");
		Game jugar = new Game(nivel, new Random(seed)); //Level y Random
		//GamePrinter tablero = new GamePrinter(jugar, 8, 9);
		GamePrinter tablero = new FormattedPrinter();
		Controller controlador = new Controller(jugar,sc,tablero);
		
		controlador.run();
		
		} catch (NullPointerException ex) {
			System.out.println("\n\t\t\t Exception: " + ex.getMessage() + "\n");
		}

	}
}