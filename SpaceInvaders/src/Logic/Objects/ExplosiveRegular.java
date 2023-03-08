package Logic.Objects;

import Logic.Game.Game;

public class ExplosiveRegular extends RegularAlien {

	//////////////////////////////////////		CONSTRUCTOR		/////////////////////////////////////////////////////////////////

	public ExplosiveRegular(Game game, int fila, int columna) {
		super(game, fila, columna);
		numNaves--;
	}

	//////////////////////////////////////		M�TODOS		/////////////////////////////////////////////////////////////////



	public boolean receiveMissileAttack(int damage) {
		if(isAlive()) { 
			this.live -= damage;
			if(!isAlive()) {
				game.receivePoints(this.getPuntos());
				game.shipExplote(this);
				numNaves--;
				this.fila =-1;
				this.columna =-1;
			}
			this.game.enableMissile();
			return true;
		}
		return false;
	}	


	public boolean receiveShockWaveAttack(int damage) {     // Para que exploten en cadena
		if(isAlive()) { 
			this.live -= damage;
			if(!isAlive()) {
				game.receivePoints(this.getPuntos());
				game.shipExplote(this);
				this.fila =-1;
				this.columna =-1;
				numNaves--;
			}
			return true;
		}
		return false;
	}


	public String toString() {
		return "E[" + this.live + "]";
	}

	@Override
	public String getInformacion() {

		String dir;
		if(this.derecha) dir = "derecha";
		else dir = "izquierda";
		return "E;"+ this.fila + "," + this.columna + "," + this.live + "," + this.getCiclos() + "," + dir;
	}

}
