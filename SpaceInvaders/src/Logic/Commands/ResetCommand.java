package Logic.Commands;

import Logic.Game.Game;

public class ResetCommand extends Command{

	///////////////////////////////////////////   CONSTRUCTOR   //////////////////////////////////////////////////////////////////////

	public ResetCommand() {
		super("reset", "r", "[R]eset\t     ", "Empieza un juego nuevo\n");
	}

	///////////////////////////////////////////   METODOS   //////////////////////////////////////////////////////////////////////

	@Override
	public boolean execute(Game game) {
		game.reset();
		return true;
	}


	public Command parse(String[] word) {
		if (word.length==1 && this.matchCommandName(word[0]))
			return new ResetCommand(); 
		else return null;
	}


	public String toString() {
		return "RESET";
	}

}