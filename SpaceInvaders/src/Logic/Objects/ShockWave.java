package Logic.Objects;

import Logic.Game.Game;

public class ShockWave extends Weapon{

	//////////////////////////////////////		CONSTRUCTOR		/////////////////////////////////////////////////////////////////

	public ShockWave(Game game, int fila, int columna) {
		super(game, fila, columna);
	}

	//////////////////////////////////////		M�TODOS		/////////////////////////////////////////////////////////////////

	public boolean performAttack(GameObject other) {
		if(other.isAlive()) {
			other.receiveShockWaveAttack(1);
			return true;
		}

		return false;
	}

	@Override
	public String toString() { return null;	}

	@Override
	public boolean move() {
		return true;
	}

	@Override
	public String getInformacion() { return null; }

	@Override
	public void computerAction() {
		// TODO Auto-generated method stub
		
	}

}
