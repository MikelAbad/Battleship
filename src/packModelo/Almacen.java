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
		case 0: // escudo
			if (escudo > 0)
				if (pJugador.getDinero() > DatosJuego.PRECIO_ESCUDO) {
					puede = true;
				}
			break;
		case 1: // misil
			if (misil > 0)
				if (pJugador.getDinero() > DatosJuego.PRECIO_MISIL) {
					puede = true;
				}
			break;
		case 2: // misilNS
			if (misilNS > 0)
				if (pJugador.getDinero() > DatosJuego.PRECIO_MISIL_NS) {
					puede = true;
				}
			break;
		case 3: // misilEO
			if (misilEO > 0)
				if (pJugador.getDinero() > DatosJuego.PRECIO_MISIL_EO) {
					puede = true;
				}
			break;
		case 4: // misilBOOM
			if (misilBOOM > 0)
				if (pJugador.getDinero() > DatosJuego.PRECIO_MISIL_BOOM) {
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


	public void VenderMisilNS(Jugador pJugador) {
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