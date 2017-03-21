package packModelo.packJugador;

import java.util.Random;

import packModelo.Battleship;
import packModelo.DatosJuego;
import packModelo.packBarcos.Barco;
import packModelo.packBarcos.Destructor;
import packModelo.packBarcos.Fragata;
import packModelo.packBarcos.Portaaviones;
import packModelo.packBarcos.Submarino;
import packModelo.packCoordenada.Coordenada;

public class Usuario extends Jugador {

	public Usuario() {
		super();
	}

	public void colocarBarco(Barco pBarco) {
		getListaBarcos().addBarco(pBarco);
		Battleship.getBattleship().imprimirTableroUsuario();
	}

	public boolean puedePonerUs(Barco pBarco) {
		boolean puede = false;
		if (getListaBarcos().numBarcos() < DatosJuego.NUM_BARCOS) {
			switch (pBarco.getTipo()) {
			case "Fragata":
				if (getListaBarcos().getNumBarcosRestantes(pBarco.getTipo()) < DatosJuego.NUM_FRAGATA) {
					puede = true;
				}
				break;
			case "Destructor":
				if (getListaBarcos().getNumBarcosRestantes(pBarco.getTipo()) < DatosJuego.NUM_DESTRUCTOR) {
					puede = true;
				}
				break;
			case "Submarino":
				if (getListaBarcos().getNumBarcosRestantes(pBarco.getTipo()) < DatosJuego.NUM_SUBMARINO) {
					puede = true;
				}
				break;
			case "Portaaviones":
				if (getListaBarcos().getNumBarcosRestantes(pBarco.getTipo()) < DatosJuego.NUM_PORTAAVIONES) {
					puede = true;
				}
				break;
			}
		}
		return puede;
	}
	
	public void colocarBarcosOrd() {
		Random rdn = new Random();
		int barcosPuestos;
		Barco unBarco;

		// Portaaviones (1)
		unBarco = new Portaaviones(new Coordenada(rdn.nextInt(DatosJuego.COLUMNAS_TABLERO - 1),
				rdn.nextInt(DatosJuego.FILAS_TABLERO - 1)), rdn.nextBoolean());
		if (puedePonerUs(unBarco) && puedePoner(unBarco)) {
			anadirBarcoProp(unBarco);
		}

		// Submarinos (2)
		barcosPuestos = 0;
		while (barcosPuestos < DatosJuego.NUM_SUBMARINO) {
			unBarco = new Submarino(new Coordenada(rdn.nextInt(DatosJuego.COLUMNAS_TABLERO - 1),
					rdn.nextInt(DatosJuego.FILAS_TABLERO - 1)), rdn.nextBoolean());
			if (puedePonerUs(unBarco) && puedePoner(unBarco)) {
				anadirBarcoProp(unBarco);
				barcosPuestos++;
			}
		}

		// Destructores (3)
		barcosPuestos = 0;
		while (barcosPuestos < DatosJuego.NUM_DESTRUCTOR) {
			unBarco = new Destructor(new Coordenada(rdn.nextInt(DatosJuego.COLUMNAS_TABLERO - 1),
					rdn.nextInt(DatosJuego.FILAS_TABLERO - 1)), rdn.nextBoolean());
			if (puedePonerUs(unBarco) && puedePoner(unBarco)) {
				anadirBarcoProp(unBarco);
				barcosPuestos++;
			}
		}

		// Fragata (4)
		barcosPuestos = 0;
		while (barcosPuestos < DatosJuego.NUM_FRAGATA) {
			unBarco = new Fragata(new Coordenada(rdn.nextInt(DatosJuego.COLUMNAS_TABLERO - 1),
					rdn.nextInt(DatosJuego.FILAS_TABLERO - 1)));
			if (puedePonerUs(unBarco) && puedePoner(unBarco)) {
				anadirBarcoProp(unBarco);
				barcosPuestos++;
			}
		}
	}
	
	public void imprimirTablero() {
		System.out.println("\nBarcos del Jugador:");
		this.getListaBarcos().imprimirTablero();
	}
}