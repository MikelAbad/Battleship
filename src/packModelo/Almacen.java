package packModelo;

import packModelo.packJugador.Jugador;

public class Almacen {

	private static Almacen miAlmacen;
	private int misilNS;
	private int misilEO;
	private int misil;
	private int misilBOOM;
	private int escudo;

	private Almacen() {
		misilNS = DatosJuego.CANT_MISIL_NS;
		misilEO = DatosJuego.CANT_MISIL_EO;
		misilBOOM = DatosJuego.CANT_MISIL_BOOM;
		misil = DatosJuego.CANT_MISIL;
		escudo = DatosJuego.CANT_ESCUDO;
	}

	public static Almacen getAlmacen() {
		if (miAlmacen == null)
			miAlmacen = new Almacen();
		return miAlmacen;
	}

	public boolean puedeVender(int pArma, Jugador pJugador) {
		boolean puede = false;
		switch (pArma) {
		case DatosJuego.NUM_ESCUDO:
			if (escudo > 0)
				if (pJugador.getDinero() >= DatosJuego.PRECIO_ESCUDO) {
					puede = true;
				}
			break;
		case DatosJuego.NUM_MISIL:
			if (misil > 0)
				if (pJugador.getDinero() >= DatosJuego.PRECIO_MISIL) {
					puede = true;
				}
			break;
		case DatosJuego.NUM_MISIL_NS:
			if (misilNS > 0)
				if (pJugador.getDinero() >= DatosJuego.PRECIO_MISIL_NS) {
					puede = true;
				}
			break;
		case DatosJuego.NUM_MISIL_EO:
			if (misilEO > 0)
				if (pJugador.getDinero() >= DatosJuego.PRECIO_MISIL_EO) {
					puede = true;
				}
			break;
		case DatosJuego.NUM_MISIL_BOOM:
			if (misilBOOM > 0)
				if (pJugador.getDinero() >= DatosJuego.PRECIO_MISIL_BOOM) {
					puede = true;
				}
			break;
		}
		return puede;
	}

	
	public void venderEscudo(Jugador pJugador) {
		pJugador.pagarArma(DatosJuego.PRECIO_ESCUDO);
		escudo--;
	}
	
	public void venderMisil(Jugador pJugador) {
		pJugador.pagarArma(DatosJuego.PRECIO_MISIL);
		misil--;
	}


	public void venderMisilNS(Jugador pJugador) {
		pJugador.pagarArma(DatosJuego.PRECIO_MISIL_NS);
		misilNS--;
	}

	public void venderMisilEO(Jugador pJugador) {
		pJugador.pagarArma(DatosJuego.PRECIO_MISIL_EO);
		misilEO--;
	}
	
	public void venderMisilBOOM(Jugador pJugador) {
		pJugador.pagarArma(DatosJuego.PRECIO_MISIL_BOOM);
		misilBOOM--;
	}
}