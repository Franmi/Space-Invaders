package Logic.Commands;

import Logic.Game.Game;

public class ExitCommand extends Command{

	///////////////////////////////////////////  CONSTRUCTOR   //////////////////////////////////////////////////////////////////////

	public ExitCommand() {
		super("exit", "e", "[E]xit\t     ", "Termina el juego\n");
	}

	///////////////////////////////////////////   METODOS   //////////////////////////////////////////////////////////////////////

	public boolean execute(Game game) {
		game.exit();
		return true;
	}

	public Command parse(String[] word) {
		if (word.length==1 && this.matchCommandName(word[0]))
			return new ExitCommand();

		else return null;
	}

	public String toString() {
		return "EXIT";
	}

}
