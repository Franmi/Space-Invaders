/*package Logic.Objects;

import Logic.Game.Game;

public class GameObjectGenerator {

	private static GameObject[] availableGameObjects = {
			new UCMShip(null, 0, 0, 0),
			new Ovni(null),
			new RegularAlien(null, 0, 0, 0),
			new DestroyerAlien(null, 0, 0, 0),
			new ExplosiveAlien(),
			new ShockWave(null, 0, 0),
			new Bomb(null, 0, 0, 0),
			new UCMMissile(null, 0, 0),
			new Supermissile()
		};

	public static GameObject parse(String stringFromFile, Game game, FileContentsVerifier verifier)
					throws FileContentsException {		
		GameObject gameObject = null;
		for (GameObject go: availableGameObjects) {
			gameObject = go.parse(stringFromFile, game, verifier);
			if (gameObject != null) break;
		}
		return gameObject;
	}

}*/
