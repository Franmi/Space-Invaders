package Logic.Commands;

import Logic.Game.Game;
import Logic.GamePrinter.FormattedPrinter;
import Logic.GamePrinter.GamePrinter;
import Logic.GamePrinter.Stringifier;

public class ListPrinterCommand extends Command {

	///////////////////////////////////////////   CONSTRUCTOR   //////////////////////////////////////////////////////////////////////

	public ListPrinterCommand() {
		super("ListPrinter", "p", "List[P]rinter", "Muestra una lista de los tipos printer.\n");
	}

	///////////////////////////////////////////   METODOS   //////////////////////////////////////////////////////////////////////

	@Override
	public boolean execute(Game game) {
		GamePrinter print = new FormattedPrinter();
		System.out.println(print.helpText());
		GamePrinter print1 = new Stringifier();
		System.out.println(print1.helpText());
		return false;
	}

	@Override
	public Command parse(String[] word) {
		if(word.length == 1 && matchCommandName(word[0])) 
			return new ListPrinterCommand();
		return null;
	}

}
