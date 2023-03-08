package Logic.Objects;

import Logic.Game.Game;

public class UCMMissile extends Weapon{

	//////////////////////////////////////		CONSTRUCTOR		/////////////////////////////////////////////////////////////////

	public UCMMissile(Game game, int fila, int columna) {
		super(game, fila, columna);
	}

	//////////////////////////////////////		M�TODOS		/////////////////////////////////////////////////////////////////

	public boolean move() {
		if(isAlive()) {
			this.fila--;
			if(isOut()) { game.enableMissile();}
			return true;
		}
		return false;
	}

	public boolean receiveBombAttack(int damage) {
		if(isAlive()) { this.live = 0;this.fila =-1; return true;}
		return false;
	}

	public boolean performAttack(GameObject other) {
		if(other.isAlive() && this.fila == other.fila && this.columna == other.columna) {
			this.live = 0;
			this.fila =-1;
			if(other.receiveMissileAttack(1)) game.enableMissile();
			return true;
		}
		return false;
	}

	@Override
	public String getInformacion() {

		return "M;" + this.fila + "," + this.columna;
	}


	@Override
	public String toString() {
		return "oo";
	}

	@Override
	public void computerAction() {
		// TODO Auto-generated method stub
		
	}

}
