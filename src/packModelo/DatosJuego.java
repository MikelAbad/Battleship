package packModelo;

public class DatosJuego {

	public static final int FILAS_TABLERO = 10;
	public static final int COLUMNAS_TABLERO = 10;
	public static final int DINERO_INICIAL = 100;
	public static final int VALOR_ESCUDO = 2;
	
	// Numero id arma
	public static final int NUM_MISIL = 1;
	public static final int NUM_MISIL_NS = 2;
	public static final int NUM_MISIL_EO = 3;
	public static final int NUM_MISIL_BOOM = 4;
	public static final int NUM_ESCUDO = 0;
	public static final int NUM_BOMBA = -1;
	
	// Cantidades inciales stock Almacen
	public static final int CANT_MISIL = 10;
	public static final int CANT_MISIL_NS = 1;
	public static final int CANT_MISIL_EO = 1;
	public static final int CANT_MISIL_BOOM = 1;
	public static final int CANT_ESCUDO = 5;
	
	// Precio armas almacen
	public static final int PRECIO_MISIL = 10;
	public static final int PRECIO_MISIL_NS = 45;
	public static final int PRECIO_MISIL_EO = 45;
	public static final int PRECIO_MISIL_BOOM = 90;
	public static final int PRECIO_ESCUDO = 25;

	// Longitud tipos barco
	public static final int LONG_FRAGATA = 1;
	public static final int LONG_DESTRUCTOR = 2;
	public static final int LONG_SUBMARINO = 3;
	public static final int LONG_PORTAAVIONES = 4;

	// Numero maximo barcos
	public static final int NUM_BARCOS = 10;
	public static final int NUM_FRAGATA = 4;
	public static final int NUM_DESTRUCTOR = 3;
	public static final int NUM_SUBMARINO = 2;
	public static final int NUM_PORTAAVIONES = 1;
	
	// Devuelve la longitud del tipo de barco
	public static int getLongDeTipo(String pTipo) {
		if (pTipo.equals("Fragata")) {
			return LONG_FRAGATA;
		} else if (pTipo.equals("Destructor")) {
			return LONG_DESTRUCTOR;
		} else if (pTipo.equals("Submarino")) {
			return LONG_SUBMARINO;
		} else if (pTipo.equals("Portaaviones")) {
			return LONG_PORTAAVIONES;
		} else {
			System.out.println("*PANIC*");
			return -1;
		}
	}
}