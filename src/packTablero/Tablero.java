package packTablero;

public class Tablero {
	private final int filas = 10;
	private final int columnas = 10;
	private Coordenada[][] tablero;

	public Tablero() {
		this.tablero = new Coordenada[filas][columnas];
		inicializarTablero();
	}

	private void inicializarTablero() {
		for (int i = 0; i < filas; i++) {
			for (int j = 0; j < columnas; j++) {
				tablero[i][j] = new Coordenada(i, j);
			}
		}
	}
}
