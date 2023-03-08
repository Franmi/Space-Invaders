package Logic.Game;

import Logic.Commands.CommandExecuteException;

public interface IPlayerController {
	
	// PLAYER ACTIONS	
	public boolean move (boolean derecha, int numCells);
	public boolean shootMissile(boolean supermissil) throws CommandExecuteException;
	public boolean shockWave();
	
	// CALLBACKS
	public void receivePoints(int points);
	public void enableShockWave();
	public void enableMissile();
	
}