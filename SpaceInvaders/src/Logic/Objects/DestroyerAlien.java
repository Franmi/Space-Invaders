package Logic.Objects;

import Logic.Game.Game;
import Logic.Game.IExecuteRandomActions;

public class DestroyerAlien extends AlienShip {

	//////////////////////////////////////		ATRIBUTOS		/////////////////////////////////////////////////////////////////

	private Bomb bomb;


	//////////////////////////////////////		CONSTRUCTOR		/////////////////////////////////////////////////////////////////

	public DestroyerAlien(Game game, int fila, int columna) {
		super(game, fila, columna, 1);
		bomb = new Bomb(game, -1, -1);
		this.setPuntos(10);
	}

	//////////////////////////////////////		M�TODOS		/////////////////////////////////////////////////////////////////

	public void computerAction() {
		shoot();
	}


	public void shoot() {
		if(IExecuteRandomActions.canGenerateRandomBomb(game) && !bomb.isAlive()) {
			bomb.fila = this.fila;
			bomb.columna = this.columna;
			bomb.live = this.live;
		}
	}

	
	public Bomb getBomb() {
		return bomb;
	}

	@Override
	public String toString() {
		return "D["+this.getLive()+"]";
	}

	@Override
	public String getInformacion() {
		String dir;
		if(this.derecha) dir = "derecha";
		else dir = "izquierda";
		return "D;"+ this.fila + "," + this.columna + "," + this.live + "," + this.getCiclos() + "," + dir;
	}


}
