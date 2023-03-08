package Logic.Objects;

import Logic.Game.Game;

public abstract class Weapon extends GameObject {
	
	//////////////////////////////////////		CONSTRUCTOR		/////////////////////////////////////////////////////////////////

	public Weapon(Game game, int fila, int columna) {
		super(game, fila, columna, -1);
	}
}
