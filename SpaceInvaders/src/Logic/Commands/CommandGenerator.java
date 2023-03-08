package Logic.Commands;

public class CommandGenerator {

	///////////////////////////////////////////   ATRIBUTOS   //////////////////////////////////////////////////////////////////////

	private static Command[] availableCommands = {
			new MoveCommand(true, 0),
			new ShootCommand(false),
			new ShockwaveCommand(),
			new ListCommand(),
			new ResetCommand(),
			new HelpCommand(), 
			new ExitCommand(),
			new UpdateCommand(),
			new ComprarSupermisilCommand(),
			new StringifyCommand(),
			new ListPrinterCommand(),
			new SaveCommand(null)
	};

	///////////////////////////////////////////   METODOS   //////////////////////////////////////////////////////////////////////


	public static Command parseCommand(String commandWords) throws CommandParseException{
		Command command = null;

		String word[] = commandWords.trim().split(" +");

		if(word.length ==0 || word.length >3) {
			throw new CommandParseException("\t*** El comando excede el tamanio limite. ***\n");
		}
		else {
			for(int i =0; i < availableCommands.length;i++) {
				command = availableCommands[i].parse(word);
				if(command!=null)
					return command;
			}
		}
		throw new CommandParseException("\t*** Comando no valido. ***\n");
	}


	public static String commandHelp() {
		String mensaje_Help="";

		for(int i =0; i < availableCommands.length;i++){
			mensaje_Help = mensaje_Help + availableCommands[i].helpText();	
		}
		return mensaje_Help;
	}
}