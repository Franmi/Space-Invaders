package Logic.Commands;

import Logic.Game.Game;

public class UpdateCommand extends Command{

	///////////////////////////////////////////   CONSTRUCTOR   //////////////////////////////////////////////////////////////////////

	public UpdateCommand() {
		super("update", "u", "[]/[U]pdate  ", "No hace nada durante ese ciclo\n");
	}

	///////////////////////////////////////////   METODOS   //////////////////////////////////////////////////////////////////////

	@Override
	public boolean execute(Game game) {
		game.update();
		return true;
	}

	@Override
	public Command parse(String[] word) {
		if (word.length==1 && (this.matchCommandName(word[0]) || word[0].equalsIgnoreCase("")))
			return new UpdateCommand();
		else return null;
	}


	public String toString() {
		return "UPDATE";
	}

}
