package Logic.Objects;

import Logic.Commands.CommandExecuteException;
import Logic.Game.Game;

public class UCMShip extends Ship {

	//////////////////////////////////////		ATRIBUTOS		/////////////////////////////////////////////////////////////////
	
	private UCMMissile missile;
	private Supermissile supermissile;
	private ShockWave shockwave;
	
	//////////////////////////////////////		CONSTRUCTOR		/////////////////////////////////////////////////////////////////

	public UCMShip(Game game, int fila, int columna) {
		super(game, fila, columna, 3);
		missile = new UCMMissile(game, -1, -1);
		shockwave = new ShockWave(game, -1, -1);
		supermissile = new Supermissile(game, -1, -1);
	}
	
	//////////////////////////////////////		M�TODOS		/////////////////////////////////////////////////////////////////
	
	public UCMMissile getMissile() {
		return missile;
	}
	
	public void enableMissil() {
		this.missile.live = 0;
	}
	
	public void enableSupermissil() {
		this.supermissile.live = 0;
	}
	
	public Supermissile getSupermissile() {
		return supermissile;
	}
	
	public boolean shoot(boolean supermisil) throws CommandExecuteException {
		if(!missile.isAlive() && !supermissile.isAlive()) {
			
			if(!supermisil) { posicionarDisparo(missile); return true;}
			
			else if(supermisil)
				if(supermissile.getContador() > 0) { 
					posicionarDisparo(supermissile); 
					supermissile.decrementarcontador(); 
					return true;
				}
				else throw new CommandExecuteException("\t ***No hay supermisiles disponibles.*** \n");
		}
		throw new CommandExecuteException("\t ***No se puede disparar, ya hay un misil.*** \n");
	}
	
	public void posicionarDisparo(GameObject object) {
		object.fila = this.fila;
		object.columna = this.columna;
		object.live = 1;
	}
	
	public ShockWave getShockwave() {
		return shockwave;
	}

	public void enableShockwave() {
		this.shockwave.live = 1;
	}
	
	public void disableShockwave() {
		this.shockwave.live = 0;
	}

	
	public boolean moveUCM (boolean derecha, int n) {
		if(derecha) this.columna += n;
		else this.columna -= n;
		return true;
		
	}

	public boolean receiveBombAttack(int damage) {
		if(isAlive()) {this.live -= damage; return true;}
		return false;
	}
	
	@Override
	public String toString() {
		if (this.live > 0)
			return "^__^";
		
		return "!XX!";
	}
	
	@Override
	public String getInformacion() {

		return "P;" + this.fila + "," + this.columna + "," + this.live + "," + game.getPuntos() + "," + this.shockwave.isAlive() + "," + this.supermissile.getContador();
	}

	@Override
	public boolean move() {
		return false;
	}

	@Override
	public void computerAction() {
		// TODO Auto-generated method stub
		
	}

}
