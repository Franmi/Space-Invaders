package Logic.Commands;

import Logic.Game.Game;
import Logic.GamePrinter.GamePrinter;
import Logic.GamePrinter.Stringifier;

public class StringifyCommand extends Command {

	///////////////////////////////////////////   CONSTRUCTOR   //////////////////////////////////////////////////////////////////////

	public StringifyCommand() {
		super("Stringifier", "g", "Strin[G]ifier", "Muestra los datos del juego por consola.\n");
	}

	///////////////////////////////////////////   METODOS   //////////////////////////////////////////////////////////////////////

	@Override
	public boolean execute(Game game) {
		GamePrinter print = new Stringifier();
		System.out.println(print.toString(game));
		return false;
	}

	@Override
	public Command parse(String[] word) {
		if(word.length == 1 && matchCommandName(word[0]))
			return new StringifyCommand();
		else
			return null;
	}

}
