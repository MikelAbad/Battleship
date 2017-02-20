package packTablero;

import packCasillas.Casilla;
import packCasillas.CasillaAgua;
import packCasillas.Coordenada;

public class Tablero {
	private final int filas = 10;
	private final int columnas = 10;
	private Casilla[][] tablero;
	
	public Tablero(){
		this.tablero = new Casilla[filas][columnas];
		inicializarTablero();
	}
	
	private void inicializarTablero(){
		for (int i = 0; i < filas; i++) {
			for (int j = 0; j < columnas; j++) {
				tablero[i][j] = new CasillaAgua(new Coordenada(i,j));
			}
		}
	}
}
