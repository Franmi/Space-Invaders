package Logic.Objects;

import Logic.Game.Game;

public abstract class Ship extends GameObject {
	
	//////////////////////////////////////		CONSTRUCTOR		/////////////////////////////////////////////////////////////////
	
	public Ship(Game game, int fila, int columna, int live) {
		super(game, fila, columna, live);
	}


}
