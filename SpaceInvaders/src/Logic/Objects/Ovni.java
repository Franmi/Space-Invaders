package Logic.Objects;

import Logic.Game.Game;
import Logic.Game.IExecuteRandomActions;

public class Ovni extends EnemyShip implements IExecuteRandomActions {

	//////////////////////////////////////	CONSTRUCTOR		/////////////////////////////////////////////////////////////////
	
	public Ovni(Game game) {
		super(game, 0, 9, 0);
		this.setPuntos(25);
	}

	//////////////////////////////////////		M�TODOS		/////////////////////////////////////////////////////////////////
	
	@Override
	public boolean move() {
		if(this.isAlive()) {
			this.columna--;
			if(isOut()) this.live = 0;
		}
		else if(IExecuteRandomActions.canGenerateRandomOvni(game)) {
			this.columna = 9;
			this.live = 1;
		} 
		
		return true;
	}
	
	public boolean receiveMissileAttack(int damage) {
		if(isAlive()) { 
			this.live -= damage;
			if(!isAlive()) {
				 game.receivePoints(this.getPuntos());
				 game.enableShockWave();	
			}
			this.game.enableMissile();
			return true;
		}
		return false;
	}
	
	public boolean receiveShockWaveAttack(int damage) {
		if(isAlive()) { 
			this.live -= damage;
			if(!isAlive()) game.receivePoints(this.getPuntos());
			return true;
		}
		return false;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "O["+this.getLive()+"]";
	}
	
	@Override
	public String getInformacion() {

		return "O;" + this.fila + "," + this.columna + "," + this.live;
	}

	@Override
	public void computerAction() {
		// TODO Auto-generated method stub
		
	}


}
