package Logic.GamePrinter;

import Logic.Game.Game;

public class Stringifier extends GamePrinter {

	//////////////////////////////////////		MÉTODOS		/////////////////////////////////////////////////////////////////

	@Override
	public String toString(Game game) {
		String aux;
		aux = "— Space Invaders v2.0 —\n";
		aux += "\n";
		aux += "G;"+game.getCurrentCycle() + "\n";
		aux += "L;"+game.getLevel() + "\n"; 
		aux += game.getInformacion() + "\n";
		return aux;
	}

	@Override
	public String helpText() {
		return "Stringifier: imprime el juego en lista (texto).";
	}

	/*@Override
	public GamePrinter parse(String name) {
		// TODO Auto-generated method stub
		return null;
	}*/

}