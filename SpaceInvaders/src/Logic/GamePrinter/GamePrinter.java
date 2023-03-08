package Logic.GamePrinter;

import Logic.Game.Game;
import Logic.MyStringUtils.MyStringUtils;

public abstract class GamePrinter {
	
	Game game;
	
	public void setGame(Game game) {
		this.game = game;
	}
	
	public abstract String toString(Game game);
	public abstract String helpText();
	//public abstract GamePrinter parse(String name);
}


