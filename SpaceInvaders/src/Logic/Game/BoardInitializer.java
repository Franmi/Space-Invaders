package Logic.Game;

import Logic.Level.Level;
import Logic.Objects.DestroyerAlien;
import Logic.Objects.Ovni;
import Logic.Objects.RegularAlien;

public class BoardInitializer {

	//////////////////////////////////////		ATRIBUTOS		/////////////////////////////////////////////////////////////////
	
	private Level level;
	private GameObjectBoard board;
	private Game game;

	//////////////////////////////////////		MÉTODOS		/////////////////////////////////////////////////////////////////
	
	public  GameObjectBoard initialize(Game game, Level level) {
		this.level = level;
		this.game = game;
		board = new GameObjectBoard(Game.DIM_X, Game.DIM_Y);
		initializeOvni();
		initializeRegularAliens();
		initializeDestroyerAliens();
		return board;
	}

	private void initializeOvni () {
		board.add(new Ovni(game));
	}

	private void initializeRegularAliens () {
		int fila = 1, columna = 3;

		for(int i = 0; i < level.getNumRowsOfRegularAliens();i++)
			for(int j = 0; j < level.getNumRegularAliensPerRow();j++)
				board.add(new RegularAlien(game, fila + i, columna + j));

	}

	private void initializeDestroyerAliens() {
		for(int i = 0; i < level.getNumDestroyerAliens(); i++) {
			DestroyerAlien destroyer = new DestroyerAlien(game, level.getFilaIniDestroyer(), level.getColumnaIniDestroyer()+i);
			board.add(destroyer);
			board.add(destroyer.getBomb());
		}

	}
}
