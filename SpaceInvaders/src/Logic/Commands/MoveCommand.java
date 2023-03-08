package Logic.Commands;

import Logic.Game.Game;

public class MoveCommand extends Command {

	///////////////////////////////////////////   ATRIBUTOS   //////////////////////////////////////////////////////////////////////

	private boolean derecha;
	private int numCasillas;

	///////////////////////////////////////////   CONSTRUCTOR   //////////////////////////////////////////////////////////////////////

	public MoveCommand(boolean derecha, int numCasillas) {
		super("move", "m", "[M]ove\t     ", "Mueve UCM-Ship a la direccion inidicada\n");
		this.derecha = derecha;
		this.numCasillas = numCasillas;
	}

	///////////////////////////////////////////   METODOS   //////////////////////////////////////////////////////////////////////

	@Override
	public boolean execute(Game game) throws CommandExecuteException {

		if(game.move(derecha, numCasillas)) return true;
		else throw new CommandExecuteException("\t***El movimiento indicado no se ha podido realizar.***\n");
	}

	@Override
	public Command parse(String[] word) throws CommandParseException {

		if (word.length==3 && this.matchCommandName(word[0]) &&	(word[1].equalsIgnoreCase("LEFT") || word[1].equalsIgnoreCase("RIGHT") || word[1].equalsIgnoreCase("L") || 
				word[1].equalsIgnoreCase("R")) && (word[2].equalsIgnoreCase("1") || word[2].equalsIgnoreCase("2"))) {

			if(word[1].equalsIgnoreCase("left") || word[1].equalsIgnoreCase("l")) derecha = false;
			else derecha = true;

			return new MoveCommand(derecha, Integer.parseInt(word[2]));
		}

		else return null;
	}

	public String toString() {
		return "MOVE";
	}
}
