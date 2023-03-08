package Logic.Level;

public enum Level {
	 
	EASY(4, 2, 0.2, 3, 0.5, 1, 2, 4), 
	HARD(8, 2, 0.3, 2, 0.2, 2, 3, 4),
	INSANE(8, 4, 0.5, 1, 0.1, 2, 3, 3);

	private int numRegularAliens;
	private int numDestroyerAliens;
	private int numCyclesToMoveOneCell;
	private double ovniFrequency;
	private double shootFrequency;
	private int numRowsOfRegularAliens;
	private int filaIniDestroyer;
	private int columnaIniDestroyer;
	private double turnExplodeFrequency = 0.05;

	private Level(
			int numRegularAliens, 
			int numDestroyerAliens, 
			double shootFrequency, 
			int numCyclesToMoveOneCell, 
			double ovniFrequency, 
			int numRowsOfRegularAliens,
			int filaIniDestroyer,
			int columnaIniDestroyer)
	{
		this.numRegularAliens = numRegularAliens;
		this.numDestroyerAliens = numDestroyerAliens;
		this.shootFrequency = shootFrequency;
		this.numCyclesToMoveOneCell = numCyclesToMoveOneCell;
		this.ovniFrequency = ovniFrequency;
		this.numRowsOfRegularAliens = numRowsOfRegularAliens;
		this.filaIniDestroyer = filaIniDestroyer;
		this.columnaIniDestroyer = columnaIniDestroyer;
	}
	
	public int getFilaIniDestroyer() {
		return filaIniDestroyer;
	}

	public int getColumnaIniDestroyer() {
		return columnaIniDestroyer;
	}

	public int getNumRegularAliens() {
		return numRegularAliens;
	}
	
	public int getNumDestroyerAliens() {
		return numDestroyerAliens;
	}

	public double getShootFrequency() {
		return shootFrequency;
	}
	
	public int getNumCyclesToMoveOneCell() {
		return numCyclesToMoveOneCell;
	}

	public double getOvniFrequency() { 
		return ovniFrequency;
	}
	public int getNumRowsOfRegularAliens() {
		return numRowsOfRegularAliens;
	}
	
	public int getNumRegularAliensPerRow() {
		return numRegularAliens / numRowsOfRegularAliens;
	}
	
	public int  getNumDestroyerAliensPerRow() {
		return getNumDestroyerAliens();
	}
	
	public static Level parse(String cadenaEntrada) {
		for (Level level : Level.values())
			if (level.name().equalsIgnoreCase(cadenaEntrada))
				return level;
	    return EASY;
	}
	
	public double getTurnExplodeFrequency(){
		return turnExplodeFrequency;
	}
}
