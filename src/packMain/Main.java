package packMain;

import packModelo.Battleship;
import packVista.Inicio;
import packVista.TableroJuego;

public class Main {

	public static void main(String[] args) {
		Battleship.getBattleship().inicializar();
		Inicio.getInicio().empezar();
	}

}
