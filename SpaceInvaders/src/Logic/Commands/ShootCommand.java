package Logic.Commands;

import Logic.Game.Game;

public class ShootCommand extends Command{

	///////////////////////////////////////////   ATRIBUTOS   //////////////////////////////////////////////////////////////////////

	private boolean supermisil;

	///////////////////////////////////////////   CONSTRUCTOR   //////////////////////////////////////////////////////////////////////

	public ShootCommand(boolean supermisil) {
		super("shoot", "s", "[S]hoot\t     ", "UCM-Ship laza un misil\n");
		this.supermisil = supermisil;
	}

	///////////////////////////////////////////   METODOS   //////////////////////////////////////////////////////////////////////

	public boolean execute(Game game) throws CommandExecuteException {
		return game.shootMissile(supermisil);
	}


	public Command parse(String[] word) {

		if (word.length==1 && this.matchCommandName(word[0]))
			return new ShootCommand(false);
		else if(word.length == 2 && this.matchCommandName(word[0]) && (word[1].equalsIgnoreCase("supermisil") || (word[1].equalsIgnoreCase("s"))))
			return new ShootCommand(true);
		else return null;
	}


	public String toString() {
		return "SHOOT";
	}

}

