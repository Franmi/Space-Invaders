package Logic.Objects;

import Logic.Game.Game;

public class Supermissile extends Weapon {
	
	//////////////////////////////////////		ATRIBUTOS		/////////////////////////////////////////////////////////////////

	private int contador;
	
	//////////////////////////////////////		CONSTRUCTOR		/////////////////////////////////////////////////////////////////
	
	public Supermissile(Game game, int fila, int columna) {
		super(game, fila, columna);
	
	}
	
	//////////////////////////////////////		M�TODOS	/////////////////////////////////////////////////////////////////

	
	public boolean move() {
		if(isAlive()) {
			this.fila--;
			if(isOut()) { game.enableSupermissile();}
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
			if(other.receiveMissileAttack(2)) game.enableSupermissile();
			return true;
		}
		return false;
	}
	
	public int getContador() {
		return contador;
	}

	public void incrementarContador() {
		this.contador++;
	}
	
	public void decrementarcontador() {
		this.contador--;
	}
	
	@Override
	public String toString() {
		return "**";
	}
	
	@Override
	public String getInformacion() {

		return "X;" + this.fila + "," + this.columna;
	}

	@Override
	public void computerAction() {
		// TODO Auto-generated method stub
		
	}

}
