package Logic.Objects;

import Logic.Game.Game;

public abstract class AlienShip extends EnemyShip {

	//////////////////////////////////////		ATRIBUTOS		/////////////////////////////////////////////////////////////////

	protected static boolean landed;
	protected static int numNaves;
	protected static boolean bajar;
	protected boolean derecha;

	private static int navesFrontera = 0;
	protected static int contador=0;
	//////////////////////////////////////		CONSTRUCTOR		/////////////////////////////////////////////////////////////////

	public AlienShip(Game game, int fila, int columna, int live) {
		super(game, fila, columna, live);
		numNaves++;
		landed = false;
		derecha = false;
		bajar = false;
	}

	//////////////////////////////////////		M…TODOS		/////////////////////////////////////////////////////////////////




	public boolean ciclo () {
		if(game.getCurrentCycle()%game.getLevel().getNumCyclesToMoveOneCell() == 0) return true;
		return false;
	}

	public boolean move() {

		if(this.isAlive()) {

			if(ciclo()) {

				if(navesFrontera > 0) {

					this.fila++;
					this.derecha = !this.derecha;
					navesFrontera -=1;

				}
				else if (navesFrontera == 0) {

					if(this.derecha) this.columna++;
					else this.columna--;
					contador++;

				}

				if(contador == numNaves) {
					game.comprobar();
					contador=0;
				}

				if(this.fila == game.DIM_Y-1)
					landed = true;
			}

		}
		return true;
	}

	public void comprobar() {
		if(this.columna == Game.DIM_X-1 && derecha || this.columna == 0 && !derecha) {
			navesFrontera = numNaves;
		}

	}





	public boolean receiveMissileAttack(int damage) {
		if(isAlive()) { 
			this.live -= damage;

			if(!isAlive()) {
				this.fila =-1;
				this.columna =-1;
				game.receivePoints(this.getPuntos());
				numNaves--;
			}
			this.game.enableMissile();
			return true;
		}
		return false;
	}

	public boolean receiveShockWaveAttack(int damage) {
		if(isAlive()) { 
			this.live -= damage;
			if(!isAlive()) {
				this.fila =-1;
				this.columna =-1;
				game.receivePoints(this.getPuntos());
				numNaves--;
			}
			return true;
		}
		return false;
	}








	public static boolean haveLanded() {
		return landed;
	}

	public static boolean allDead() {
		if(numNaves == 0) return true;
		return false;
	}

	public static void setNumNaves() {
		AlienShip.numNaves = 0;
	}

	public static boolean isBajar() {
		return bajar;
	}

	public static void setBajar(boolean bajar) {
		AlienShip.bajar = bajar;
	}

	public static int getNumNaves() {
		return numNaves;
	}

	public int getCiclos() {
		return game.getLevel().getNumCyclesToMoveOneCell() - (game.getCurrentCycle()%game.getLevel().getNumCyclesToMoveOneCell());
	}




}