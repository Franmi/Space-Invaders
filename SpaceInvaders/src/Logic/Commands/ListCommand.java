package Logic.Commands;

import Logic.Game.Game;

public class ListCommand extends Command{

	///////////////////////////////////////////   CONSTRUCTOR   //////////////////////////////////////////////////////////////////////

	public ListCommand() {
		super("list", "l", "[L]ist\t     ", "Imprime las listas de las naves disponibles\n");
	}

	///////////////////////////////////////////    METODOS    //////////////////////////////////////////////////////////////////////

	@Override
	public boolean execute(Game game) {
		game.executeList();
		return false;
	}


	@Override
	public Command parse(String[] word) {
		if (word.length==1 && this.matchCommandName(word[0]))
			return new ListCommand(); 
		else return null;
	}


	public String toString() {
		return "LIST";
	}
}
