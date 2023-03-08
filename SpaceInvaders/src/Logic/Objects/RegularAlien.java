package Logic.Objects;

import Logic.Game.Game;
import Logic.Game.IExecuteRandomActions;

public class RegularAlien extends AlienShip implements IExecuteRandomActions {
	
	//////////////////////////////////////		ATRIBUTOS		/////////////////////////////////////////////////////////////////
	
	
	//////////////////////////////////////		CONSTRUCTOR		/////////////////////////////////////////////////////////////////
	
	public RegularAlien(Game game, int fila, int columna) {
		super(game, fila, columna, 2);
		this.setPuntos(5);
	}

	//////////////////////////////////////		M�TODOS		/////////////////////////////////////////////////////////////////


	@Override
	public void computerAction() {
		
		if(IExecuteRandomActions.canGenerateExplosiveRegular(game)) {
			ExplosiveRegular explosive = new ExplosiveRegular(this.game, this.fila, this.columna);
			explosive.live = this.live;
			explosive.derecha = this.derecha;

			game.generarExplosive(this,explosive );
		}
		
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "R["+ this.getLive() +"]";
	}
	
	@Override
	public String getInformacion() {
		String dir;
		if(this.derecha) dir = "derecha";
		else dir = "izquierda";
		return "R;"+ this.fila + "," + this.columna + "," + this.live + "," + this.getCiclos() + "," + dir;
	}

}
