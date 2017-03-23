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
		
		//TODO Provoca error en alguna JUnit, comentar esta linea al ejecutarlas
		Battleship.getBattleship().imprimirTableroUsuario();
	}

	public boolean puedePonerUs(Barco pBarco) {
		boolean puede = false;
		if (getListaBarcos().numBarcos() < DatosJuego.NUM_BARCOS) {
			puede = pBarco.puedePonerse(getListaBarcos());			
		}		
		/*if (getListaBarcos().numBarcos() < DatosJuego.NUM_BARCOS) {
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
		}*/
		return puede;
	}
	
	public void imprimirTablero() {
		System.out.println("\nBarcos del Jugador:");
		this.getListaBarcos().imprimirTablero();
	}
}