package Logic.Game;


import Logic.Objects.GameObject;


public class GameObjectBoard {

	//////////////////////////////////////		ATRIBUTOS		/////////////////////////////////////////////////////////////////

	private int width, height;
	private GameObject[] objects;
	private int currentObjects;
	

	
	//////////////////////////////////////		CONSTRUCTOR		/////////////////////////////////////////////////////////////////

	public GameObjectBoard (int width, int height) {
		this.width = width;
		this.height = height;
		this.currentObjects = 0;
		objects = new GameObject[100];
	}

	//////////////////////////////////////		M�TODOS		/////////////////////////////////////////////////////////////////

	public void add (GameObject object) {
		objects[currentObjects] = object;
		currentObjects++;
	}

	private GameObject getObjectInPosition (int fila, int columna) {
		int i = 0;
		while(i < currentObjects) {
			if(objects[i].getFila() == fila && objects[i].getColumna() == columna && objects[i].isAlive())
				return objects[i];
			else i++;
		}
		return null;
	}

	
	
	
	public void computerAction() {
		for(int i = 0; i < currentObjects; i++) {
			objects[i].computerAction();
		}
	}
	public void update() {
		for(int i = 0; i < currentObjects; i++) {
			objects[i].move();
			checkAttacks(objects[i]);
		}
		comprobar();
	}
	
	
	private void checkAttacks(GameObject object) {
		for(int i = 0; i < currentObjects; i++) {
			if(!object.equals(objects[i]) && object.getFila() == objects[i].getFila() &&  object.getColumna() == objects[i].getColumna()) {
				object.performAttack(objects[i]);
			}
		}
	}

	
	public void generarExplosive(GameObject object1, GameObject object2) {
		for(int i = 0; i < currentObjects; i++) {
			
			if(objects[i] == object1)
				objects[i] = object2;
		}
			
	}

	public void comprobar() {
		for(int i = 0; i < currentObjects; i++) {
			objects[i].comprobar();
		}
	}
	
	
	
	public void shockwaveAttack(GameObject shockwave) {
		for(int i = 0; i < currentObjects; i++) {
			shockwave.performAttack(objects[i]);
		}
	}

	public boolean shipExplote(GameObject object) {
		for(int i = 0; i < currentObjects; i++) {
			if(comprobarAdyacentes(objects[i], object)) objects[i].receiveShockWaveAttack(1);
		}
		return true;
	}  

	public boolean comprobarAdyacentes(GameObject obj1, GameObject obj2) {
		if((obj1.getFila() == obj2.getFila() -1 || obj1.getFila() == obj2.getFila() || obj1.getFila() == obj2.getFila() + 1 )
				&& (obj1.getColumna() == obj2.getColumna() - 1 || obj1.getColumna() == obj2.getColumna() ||	obj1.getColumna() == obj2.getColumna() + 1)) {
			return true;
		}
		return false;
	}
	
	public String getInformacion() {
		String aux = "";
		for(int i = 0; i < currentObjects; i++ )
			if(objects[i].isAlive())
				aux += objects[i].getInformacion() + "\n" ;
		return aux;
	}

	public String toString(int fila, int columna) {
		if(this.getObjectInPosition(fila, columna) == null) return " ";

		return this.getObjectInPosition(fila, columna).toString();
	}
	

}
