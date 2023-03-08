package Logic.Commands;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import Logic.Game.Game;
import Logic.GamePrinter.GamePrinter;
import Logic.GamePrinter.Stringifier;

public class SaveCommand extends Command {

	///////////////////////////////////////////   ATRIBUTOS   //////////////////////////////////////////////////////////////////////

	private String fileName;
	private FileWriter fileWriter;
	private BufferedWriter bufferedWriter; 

	///////////////////////////////////////////   CONSTRUCTOR   //////////////////////////////////////////////////////////////////////

	public SaveCommand(String fileName) {
		super("save", "v", "Sa[V]e + Nombre del fichero", "Guarda el estado actual de la partida\n");
		this.fileName = fileName ;
	}

	///////////////////////////////////////////   METODOS   //////////////////////////////////////////////////////////////////////

	@Override
	public boolean execute(Game game) throws IOException {
		try{
			this.fileName += ".dat";
			System.out.println(fileName);
			fileWriter = new FileWriter(fileName);
			bufferedWriter = new BufferedWriter(fileWriter);
			GamePrinter print = new Stringifier();
			bufferedWriter.write(print.toString(game));
			bufferedWriter.close();
			System.out.println("Juego guardado correctamente en el archivo " + fileName + ".");
			return false;
		}catch (IOException ex) { throw ex; }
	}

	@Override
	public Command parse(String[] word) throws CommandParseException {
		if(word.length == 2 && matchCommandName(word[0])) {
			fileName = word[1];
			return new SaveCommand(word[1]);
		}
		else return null;
	}
	
}
