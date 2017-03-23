package packModelo;

import java.util.Observable;

import packModelo.packJugador.Jugador;
import packVista.TableroJuego;

public class Almacen extends Observable{

	private static Almacen miAlmacen;
	private int misilNS;
	private int misilEO;
	private int misil;
	private int misilBOOM;
	private int escudo;
	private int[] stock;

	private Almacen() {
		misilNS = DatosJuego.CANT_MISIL_NS;
		misilEO = DatosJuego.CANT_MISIL_EO;
		misilBOOM = DatosJuego.CANT_MISIL_BOOM;
		misil = DatosJuego.CANT_MISIL;
		escudo = DatosJuego.CANT_ESCUDO;
		stock = new int[2]; // Para la vista
		addObserver(TableroJuego.getTableroJuego());
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
		stock[0] = DatosJuego.NUM_ESCUDO;
		stock[1] = escudo;
		notificar();
	}
	
	public void venderMisil(Jugador pJugador) {
		pJugador.pagarArma(DatosJuego.PRECIO_MISIL);
		misil--;
		stock[0] = DatosJuego.NUM_MISIL;
		stock[1] = misil;
		notificar();
	}


	public void venderMisilNS(Jugador pJugador) {
		pJugador.pagarArma(DatosJuego.PRECIO_MISIL_NS);
		misilNS--;
		stock[0] = DatosJuego.NUM_MISIL_NS;
		stock[1] = misilNS;
		notificar();
	}

	public void venderMisilEO(Jugador pJugador) {
		pJugador.pagarArma(DatosJuego.PRECIO_MISIL_EO);
		misilEO--;
		stock[0] = DatosJuego.NUM_MISIL_EO;
		stock[1] = misilEO;
		notificar();
	}
	
	public void venderMisilBOOM(Jugador pJugador) {
		pJugador.pagarArma(DatosJuego.PRECIO_MISIL_BOOM);
		misilBOOM--;
		stock[0] = DatosJuego.NUM_MISIL_BOOM;
		stock[1] = misilBOOM;
		notificar();
	}
	
	private void notificar() {
		setChanged();
		notifyObservers(stock);
	}
}