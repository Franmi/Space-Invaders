package Logic.Objects;

import Logic.Game.Game;
import Logic.Game.IAttack;

public abstract class GameObject implements IAttack {
	
	//////////////////////////////////////		ATRIBUTOS		/////////////////////////////////////////////////////////////////
	
	protected int fila, columna;
	protected int live;
	protected Game game;
	
	//////////////////////////////////////		CONSTRUCTOR		/////////////////////////////////////////////////////////////////

	public GameObject( Game game, int fila, int columna, int live) {
		this.fila = fila;
		this.columna = columna;
		this.game = game;
		this.live = live;

	}
	
//////////////////////////////////////		M�TODOS		/////////////////////////////////////////////////////////////////

	public int getFila() { return this.fila;}
	
	public int getColumna() {return this.columna;}

	public boolean isAlive() {
		return this.live > 0;
	}

	public int getLive() {
		return this.live;
	}

	public boolean isOnPosition(int i, int j) {
		return this.fila == i && this.columna == j;
	}

	public void getDamage (int damage) {
		this.live = damage >= this.live ? 0 : this.live - damage;
	}

	public boolean isOut() {
		return !game.isOnBoard(this.fila, this.columna);
	}

	public GameObject generarExplosive() {return this;}
	public void comprobar() {}; /////////////
	
	public abstract boolean move();
	public abstract String toString();
	public abstract String getInformacion();
	public abstract void computerAction();
}