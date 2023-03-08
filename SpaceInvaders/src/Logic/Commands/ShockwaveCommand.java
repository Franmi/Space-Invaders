package Logic.Commands;

import Logic.Game.Game;

public class ShockwaveCommand extends Command{

	///////////////////////////////////////////   CONSTRUCTOR   //////////////////////////////////////////////////////////////////////

	public ShockwaveCommand() {
		super("shockwave", "w", "Shock[W]ave  ", "UCM-Ship realiza un 'shock wave\n");
		// TODO Auto-generated constructor stub
	}

	///////////////////////////////////////////   METODOS   //////////////////////////////////////////////////////////////////////

	@Override
	public boolean execute(Game game) throws CommandExecuteException {
		if(game.shockWave()) return true;
		else throw new CommandExecuteException("\t ***No se puede, superpoder no disponible.*** \n");
	}

	@Override
	public Command parse(String[] word) {
		if (word.length==1 && this.matchCommandName(word[0]))
			return new ShockwaveCommand();
		else return null;
	}


	public String toString() {
		return "SHOCKWAVE";
	}

}
