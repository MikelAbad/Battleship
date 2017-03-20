package packModelo.packJugador;

import java.util.Random;

import packModelo.packBarcos.Barco;
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
		
		// Portaaviones (1)
		Barco unBarco = new Barco(new Coordenada(rdn.nextInt(9), rdn.nextInt(9)), 4, rdn.nextBoolean());
		if (puedePoner(unBarco)) {
			anadirBarcoProp(unBarco);
		}

		// Submarinos (2)
		int puestos = 0;
		while (puestos < 2) {
			unBarco = new Barco(new Coordenada(rdn.nextInt(9), rdn.nextInt(9)), 3, rdn.nextBoolean());
			if (puedePoner(unBarco)) {
				anadirBarcoProp(unBarco);
				puestos++;
			}
		}

		// Destructores (3)
		puestos = 0;
		while (puestos < 3) {
			unBarco = new Barco(new Coordenada(rdn.nextInt(9), rdn.nextInt(9)), 2, rdn.nextBoolean());
			if (puedePoner(unBarco)) {
				anadirBarcoProp(unBarco);
				puestos++;
			}
		}

		// Fragata (1)
		puestos = 0;
		while (puestos < 4) {
			unBarco = new Barco(new Coordenada(rdn.nextInt(9), rdn.nextInt(9)), 1, rdn.nextBoolean());
			if (puedePoner(unBarco)) {
				anadirBarcoProp(unBarco);
				puestos++;
			}
		}
	}
}