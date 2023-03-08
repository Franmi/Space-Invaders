package Logic.Commands;

import Logic.Game.Game;

public class ComprarSupermisilCommand extends Command {

	///////////////////////////////////////////   CONSTRUCTOR   //////////////////////////////////////////////////////////////////////

	public ComprarSupermisilCommand() {
		super("supermisil", "m", "Super[M]isil ", "Comprar un supermisil por 20 puntos.  --> [S]upermisil/ [S S]  para utilizarlo\n" );
	}


	///////////////////////////////////////////   METODOS  //////////////////////////////////////////////////////////////////////

	@Override
	public boolean execute(Game game) throws CommandExecuteException {
		if(game.comprarSupermisil())
			return true;
		else throw new CommandExecuteException("\t***No dispones de suficientes puntos (20 ptos.).***\n");
	}

	@Override
	public Command parse(String[] word) {

		if (word.length == 1 && this.matchCommandName(word[0]))
			return new ComprarSupermisilCommand(); 

		else return null;
	}

}
