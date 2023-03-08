package Logic.Game;

public class Informacion {

	//////////////////////////////////////		MÉTODOS			/////////////////////////////////////////////////////////////////

	public void informacion_list_controller() {
		System.out.println("\t\t----- LIST -----\n");
		System.out.println("[E]xplosive ship: Puntos:  5 "+"- Daño: 1 /nave adyacente "+ " - Proteccion: 2"+"\n"
				+"[R]egular ship:   Puntos:  5 "+"- Daño: 0 "+ "			- Proteccion: 2"+"\n" 
				+ "[D]estroyer ship: Puntos: 10 "+"- Daño: 1 "+"			- Proteccion: 1"+"\n"
				+ "[O]vni:           Puntos: 25 "+"- Daño: 0 "+"			- Proteccion: 1"+"\n"
				+ " ^__^: "+"                      - Daño: 1 "+"			- Proteccion: 3\n");

	}

	public void mensajeGana() {
		System.out.println("\n");
		System.out.println(" \t\t           ><><><>< ENOHORABUENA ><><><><\n\n");
		System.out.println("\t\t           ####                       ####          ");
		System.out.println("\t\t        ####  ####                 ####  ####       ");
		System.out.println("\t\t      ####      ####             ####      ####     ");
		System.out.println("\t\t    ####          ####         ####          ####   \n");
		System.out.println("\n  ");
		System.out.println("\t\t    #############################################   ");
		System.out.println("\t\t    #############################################  \n\n ");
		System.out.println(" \t\t><><><>< HAS DERROTADO A TODOS LOS ALLIENS ><><><><\n");
		System.out.println(" \t\t                     HAS GANADO");
	}

	public void mensajePierde() {

		System.out.println("\n");
		System.out.println(" \t\t           ><><><>< LO SIENTO ><><><><\n\n");
		System.out.println("\t\t        #######                    #######                 ");
		System.out.println("\t\t        #######                    #######                 ");
		System.out.println("\t\t               #######      #######                 ");
		System.out.println("\t\t               #######      #######                 ");
		System.out.println("\t\t        ##################################                  ");
		System.out.println("\t\t      ######################################                  ");
		System.out.println("\t\t      #########       ######       #########                  ");
		System.out.println("\t\t      #########       ######       #########                  ");
		System.out.println("\t\t     ##########       ######       ##########                  ");
		System.out.println("\t\t   ############################################                  ");
		System.out.println("\t\t   ############################################                  ");
		System.out.println("\t\t   ####    ####                    ####    ####                  ");
		System.out.println("\t\t   ####    ####                    ####    ####              ");
		System.out.println("\t\t   ####    ############################    ####                                  ");
		System.out.println("\t\t   ####    ####                    ####    ####              ");
		System.out.println("\t\t   ####    ####                    ####    ####              ");
		System.out.println("\t\t               ########    ########                       ");
		System.out.println("\t\t               ########    ########                  \n\n    ");
		System.out.println(" \t\t><><><>< LOS ALIENS HAN PODIDO CONTIGO ><><><><\n");
		System.out.println(" \t\t                    HAS PERDIDO");
	}

	public void mensajeExit() {
		System.out.println("\n\n");
		System.out.println("    #####       #####      ##     ##   ########           ######     ##              ## ########  #########        ");
		System.out.println("  ##     ##    #######    ## ## ## ##  ########         ##      ##    ##            ##  ########  ##     ###     ");
		System.out.println(" ##           ##     ##  ##   ##    ## ##              ##        ##    ##          ##   ##        ##       ##           ");
		System.out.println(" ##           ##     ##  ##         ## ######         ##          ##    ##        ##    ######    ##      ##     ");
		System.out.println(" ##     ####  ## ### ##  ##         ## ######         ##          ##     ##      ##     ######    ##    ##        ");
		System.out.println(" ##       ##  ##     ##  ##         ## ##              ##        ##       ##    ##      ##        ##     ##      "); 
		System.out.println("  ##     ##   ##     ##  ##         ## ########         ##      ##         ##  ##       ########  ##      ##  ");
		System.out.println("    ####      ##     ##  ##         ## ########           ######            ####        ########  ##       ##   "  );
	}
}