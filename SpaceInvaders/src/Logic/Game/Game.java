package Logic.Game;

import java.util.Random;

import Logic.Commands.CommandExecuteException;
import Logic.Level.Level;
import Logic.Objects.AlienShip;
import Logic.Objects.GameObject;
import Logic.Objects.UCMShip;

public class Game implements IPlayerController{
	
	//////////////////////////////////////		ATRIBUTOS		/////////////////////////////////////////////////////////////////
	
	public final static int DIM_X = 9;
	public final static int DIM_Y = 8;

	private int currentCycle;
	private Random rand;
	private Level level;
	private int puntos;
	private GameObjectBoard board;
	private UCMShip player;
	private boolean doExit;
	private BoardInitializer initializer;
	private Informacion info;

	//////////////////////////////////////		CONSTRUCTOR		/////////////////////////////////////////////////////////////////
	
	public Game (Level level, Random random){
		this.rand = random;
		this.level = level;
		initializer = new BoardInitializer();
		info = new Informacion();
		initGame();
	}

	//////////////////////////////////////		M�TODOS		/////////////////////////////////////////////////////////////////
	
	public void initGame () {
		doExit = false;
		currentCycle = 0;
		puntos = 0;
		AlienShip.setNumNaves();
		board = initializer.initialize(this, level);
		player = new UCMShip(this, DIM_Y - 1, DIM_X / 2);
		board.add(player);
		board.add(player.getMissile());
		board.add(player.getShockwave());
		board.add(player.getSupermissile());
	
	}

	public Random getRandom() {
		return rand;
	}

	public Level getLevel() {
		return level;
	}

	public void reset() {
		initGame();
	}

	public void addObject(GameObject object) {
		board.add(object);
	}

	public String positionToString( int fila, int columna ) {
		return board.toString(fila, columna);
	}

	public boolean isFinished() {
		boolean aux = true;
		if(playerWin()) info.mensajeGana();
		else if(aliensWin()) info.mensajePierde();
		else if(doExit) info.mensajeExit();
		else aux = false;

		return aux;
	}

	public boolean aliensWin() {
		return !player.isAlive() || AlienShip.haveLanded();
	}

	private boolean playerWin () {
		return AlienShip.allDead();
	}

	public void update() {
		currentCycle ++;
		board.computerAction();
		board.update();
		//Fboard.mostrarLista();
	}

	public boolean isOnBoard(int fila, int columna) {
		return fila < DIM_Y && fila > -1 && columna < DIM_X && columna > -1;
	}

	public void exit() {
		doExit = true;
	}

	public void infoToString() {
		String aux = "NO";
		if(player.getShockwave().isAlive()) aux = "SI";

		System.out.println("Life: " + player.getLive());
		System.out.println("Number of cycles: " + this.currentCycle);
		System.out.println("Points: " + this.puntos);
		System.out.println("Remaining aliens: " + AlienShip.getNumNaves());
		System.out.println("ShockWave: " + aux);
		System.out.println("Supermissiles: " + player.getSupermissile().getContador());

	}

	@Override
	public boolean move(boolean derecha, int numCells) {

		if((derecha && isOnBoard(player.getFila(), player.getColumna() + numCells)) || 
				(!derecha && isOnBoard( player.getFila(),player.getColumna()-numCells))) {
			player.moveUCM(derecha, numCells);	this.update(); return true; }
		else { System.out.println("\t ***No se puede, te saldr�as del tablero.*** \n"); 	return false;	}	
	}

	@Override
	public boolean shootMissile(boolean supermisil) throws CommandExecuteException {
		if(player.shoot(supermisil)) { 
			this.update();
			return true;
		}
		return false;
	}

	@Override
	public boolean shockWave() {
		if(player.getShockwave().isAlive()) {
			board.shockwaveAttack(player.getShockwave());
			player.disableShockwave();
			this.update();
			return true;
		}
		return false;
	}

	public void shipExplote(GameObject object) {
		board.shipExplote(object);
	}

	public boolean comprarSupermisil() {
		if(puntos >= 20) {
			puntos-=20;
			player.getSupermissile().incrementarContador();
			return true;
		}
		return false;
	}

	@Override
	public void receivePoints(int points) {
		this.puntos += points;
	}

	@Override
	public void enableShockWave() {
		player.enableShockwave();
	}

	@Override
	public void enableMissile() {
		player.enableMissil();
	}

	public void enableSupermissile() {
		player.enableSupermissil();
	}

	public int getCurrentCycle() {
		return currentCycle;
	}

	public void executeList() {
		info.informacion_list_controller();
	}

	public int getPuntos() {
		return puntos;
	}

	public String getInformacion() {
		return board.getInformacion();
	}

	public void generarExplosive(GameObject object1, GameObject object2) {

		 board.generarExplosive(object1, object2);;
	}

	public void comprobar() {
		board.comprobar();
	}
	public int getciclos() {
		return this.currentCycle;
	}
	
}