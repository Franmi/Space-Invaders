package Controller;

import java.io.IOException;
import java.util.Scanner;

import Logic.Commands.*;
import Logic.GamePrinter.*;
import Logic.Game.*;

public class Controller {

	//////////////////////////////////////		ATRIBUTOS		 /////////////////////////////////////////////////////////////////

	private Game game;
	private Scanner in;
	private boolean exit;
	private GamePrinter dib_tab;

	//////////////////////////////////////     CONSTRUCTOR  	 ////////////////////////////////////////////////////////////////

	public Controller(Game game, Scanner sc, GamePrinter hola) {
		this.game = game;
		this.in = sc;
		this.dib_tab = hola;
		exit = false;
	}

	//////////////////////////////////////		M�TODOS 	 ///////////////////////////////////////////////////////////////////

	public void run() {

		game.infoToString();
		dib_tab.toString(game);

		while(!exit) {
			try {
				System.out.println("Command: ");
				String words = in.nextLine();

				Command command = CommandGenerator.parseCommand(words);

				try {
					if(command.execute(game)) {
						exit = game.isFinished();
						if(!exit) { game.infoToString(); dib_tab.toString(game);}
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			}catch (CommandParseException | CommandExecuteException ex) {
				System.out.format(ex.getMessage() + " %n %n");
			}

		}
	}
}