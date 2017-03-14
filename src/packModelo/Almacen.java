package packModelo;

import packModelo.packJugador.Jugador;

public class Almacen {

	private static Almacen miAlmacen;
	private int misilNS;
	private int misilEO;
	private int misil;
	private int misilBOOM;
	private int escudo;
	private final int precioMisilNS = 45;
	private final int precioMisilEO = 45;
	private final int precioMisil = 10;
	private final int precioMisilBOOM = 90;
	private final int PrecioEscudo = 25;

	private Almacen() {
		misilNS = 1;
		misilEO = 1;
		misilBOOM = 1;
		misil = 10;
		escudo = 5;
	}

	public static Almacen getAlmacen() {
		if (miAlmacen == null)
			miAlmacen = new Almacen();
		return miAlmacen;
	}

	public boolean puedeVender(int pArma, Jugador pJugador) {
		boolean puede = false;
		switch (pArma) {
		case 0: // escudo
			if (escudo > 0)
				if (pJugador.getDinero() > PrecioEscudo) {
					puede = true;
				}
			break;
		case 1: // misil
			if (misil > 0)
				if (pJugador.getDinero() > precioMisil) {
					puede = true;
				}
			break;
		case 2: // misilNS
			if (misilNS > 0)
				if (pJugador.getDinero() > precioMisilNS) {
					puede = true;
				}
			break;
		case 3: // misilEO
			if (misilEO > 0)
				if (pJugador.getDinero() > precioMisilEO) {
					puede = true;
				}
			break;
		case 4: // misilBOOM
			if (misilBOOM > 0)
				if (pJugador.getDinero() > precioMisilBOOM) {
					puede = true;
				}
			break;
		}
		return puede;
	}

	public void VenderMisilNS(Jugador pJugador) {
		pJugador.pagarArma(precioMisilNS);
		misilNS--;
	}

	public void venderMisil(Jugador pJugador) {
		pJugador.pagarArma(precioMisil);
		misil--;
	}

	public void venderMisilBOOM(Jugador pJugador) {
		pJugador.pagarArma(precioMisilBOOM);
		misilBOOM--;
	}

	public void venderEscudo(Jugador pJugador) {
		pJugador.pagarArma(PrecioEscudo);
		escudo--;
	}

	public void venderMisilEO(Jugador pJugador) {
		pJugador.pagarArma(precioMisilEO);
		misilEO--;
	}
}