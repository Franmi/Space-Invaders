package Logic.Commands;

import Logic.Game.Game;

public class HelpCommand extends Command{

	///////////////////////////////////////////   CONSTRUCTOR   //////////////////////////////////////////////////////////////////////

	public HelpCommand() {
		super("help", "h", "[H]elp\t     ", "Muestra este mensaje de ayuda\n");
	}

	///////////////////////////////////////////   METODOS   //////////////////////////////////////////////////////////////////////

	public boolean execute(Game game) {
		System.out.println(CommandGenerator.commandHelp());
		return false;
	}

	public Command parse(String[] word) {

		if (word.length==1 && this.matchCommandName(word[0]))
			return new HelpCommand(); 

		else return null;
	}

	public String toString() {
		return "HELP";
	}
}
