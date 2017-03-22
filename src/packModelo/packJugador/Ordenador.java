package packModelo.packJugador;

import java.util.Random;

import packModelo.DatosJuego;
import packModelo.packBarcos.Barco;
import packModelo.packBarcos.Destructor;
import packModelo.packBarcos.Fragata;
import packModelo.packBarcos.Portaaviones;
import packModelo.packBarcos.Submarino;
import packModelo.packCoordenada.Coordenada;

public class Ordenador extends Jugador {

	public Ordenador() {
		super();
	}

	public void Jugar() {
		// TODO SegundoSprint
	}

	public void colocarBarcosOrd() {
		Random rdn = new Random();
		int barcosPuestos;
		Barco unBarco;

		// Portaaviones (1)
		boolean puesto = false;
		while (!puesto) {
			unBarco = new Portaaviones(new Coordenada(rdn.nextInt(DatosJuego.COLUMNAS_TABLERO - 1),
					rdn.nextInt(DatosJuego.FILAS_TABLERO - 1)), rdn.nextBoolean());
			if (puedePoner(unBarco)) {
				anadirBarcoProp(unBarco);
				puesto = true;
			}	
		}

		// Submarinos (2)
		barcosPuestos = 0;
		while (barcosPuestos < DatosJuego.NUM_SUBMARINO) {
			unBarco = new Submarino(new Coordenada(rdn.nextInt(DatosJuego.COLUMNAS_TABLERO - 1),
					rdn.nextInt(DatosJuego.FILAS_TABLERO - 1)), rdn.nextBoolean());
			if (puedePoner(unBarco)) {
				anadirBarcoProp(unBarco);
				barcosPuestos++;
			}
		}

		// Destructores (3)
		barcosPuestos = 0;
		while (barcosPuestos < DatosJuego.NUM_DESTRUCTOR) {
			unBarco = new Destructor(new Coordenada(rdn.nextInt(DatosJuego.COLUMNAS_TABLERO - 1),
					rdn.nextInt(DatosJuego.FILAS_TABLERO - 1)), rdn.nextBoolean());
			if (puedePoner(unBarco)) {
				anadirBarcoProp(unBarco);
				barcosPuestos++;
			}
		}

		// Fragata (4)
		barcosPuestos = 0;
		while (barcosPuestos < DatosJuego.NUM_FRAGATA) {
			unBarco = new Fragata(new Coordenada(rdn.nextInt(DatosJuego.COLUMNAS_TABLERO - 1),
					rdn.nextInt(DatosJuego.FILAS_TABLERO - 1)));
			if (puedePoner(unBarco)) {
				anadirBarcoProp(unBarco);
				barcosPuestos++;
			}
		}
	}
	
	public void imprimirTablero() {
		System.out.println("Barcos del ordenador:");
		getListaBarcos().imprimirTablero();
	}
}