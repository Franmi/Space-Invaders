  package Logic.Objects;

import Logic.Game.Game;

public class Bomb extends Weapon {

	//////////////////////////////////////		CONSTRUCTOR		/////////////////////////////////////////////////////////////////

	public Bomb(Game game, int fila, int columna) {
		super(game, fila, columna);
	}

	//////////////////////////////////////		M�TODOS		/////////////////////////////////////////////////////////////////

	@Override
	public boolean move() {
		if(isAlive()) this.fila++;
		if(isOut()) this.live = 0;
		return true;
	}


	public boolean performAttack(GameObject other) {
		if(other.isAlive() && this.fila == other.fila && this.columna == other.columna) {
			this.live = 0;
			this.fila =-1;
			other.receiveBombAttack(1);
			return true;
		}
		return false;
	}

	
	public boolean receiveMissileAttack(int damage) {
		if(isAlive()) { this.live -= damage;this.fila =-1; return true;}
		return false;
	}

	
	@Override
	public String getInformacion() {

		return "B;" + this.fila + "," + this.columna;
	}


	@Override
	public String toString() {
		return ".";
	}
	
	@Override
	public void computerAction() {
		// TODO Auto-generated method stub
		
	}

}
