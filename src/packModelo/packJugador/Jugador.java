package packModelo.packJugador;

import java.util.ArrayList;

import packModelo.Almacen;
import packModelo.packBarcos.Barco;
import packModelo.packBarcos.ListaBarcos;
import packModelo.packCoordenada.Coordenada;
import packModelo.packCoordenada.ListaCoordenadas;

public abstract class Jugador {

	private ListaCoordenadas listNoDisparable;
	// private Radar radar;
	private ListaBarcos listaBarcos;
	private int dinero;
	private ListaBarcos barcosEneDest;
	private ListaCoordenadas listaTocadasEnem;

	public Jugador() {
		listNoDisparable = new ListaCoordenadas();
		listaBarcos = new ListaBarcos();
		dinero = 100;
		barcosEneDest = new ListaBarcos();
		listaTocadasEnem = new ListaCoordenadas();
	}

	public int getDinero() {
		return dinero;
	}

	public boolean tocarBarco(Coordenada pCoordenada) {
		// TODO - implement Jugador.tocarBarco
		throw new UnsupportedOperationException();
	}

	public void destruirBarco(Coordenada pCoordenada) {
		// TODO - implement Jugador.destruirBarco
		throw new UnsupportedOperationException();
	}

	public boolean ponerEscudo(Coordenada pCoordenada) {
		boolean exito = false;
		// exito = Almacen.getAlmacen().venderEscudo();
		if (exito) {
			exito = listaBarcos.buscarBarco(pCoordenada).ponerEscudo();
		}
		return exito;
	}

	public void addDispARival(Coordenada pCoodenada) {
		// TODO - implement Jugador.addDispARival
		throw new UnsupportedOperationException();
	}

	public void delDispARival(Coordenada pCoodenada) {
		// TODO - implement Jugador.delDispARival
		throw new UnsupportedOperationException();
	}

	public void anadirBarcDest(Barco pBarco) {
		// TODO - implement Jugador.anadirBarcDest
		throw new UnsupportedOperationException();
	}

	public void usarBomba(Coordenada pCoordenada) {
		// TODO - implement Jugador.usarBomba
		throw new UnsupportedOperationException();
	}

	public boolean usarMisil(Coordenada pCoordenada) {
		// TODO - implement Jugador.usarMisil
		throw new UnsupportedOperationException();
	}

	public boolean usarMisilNS(Coordenada pCoordenada) {
		// TODO - implement Jugador.usarMisilNS
		throw new UnsupportedOperationException();
	}

	public boolean usarMisilEO(Coordenada pCoordenada) {
		// TODO - implement Jugador.usarMisilEO
		throw new UnsupportedOperationException();
	}

	public boolean usarMisilBOOM(Coordenada pCoordenada) {
		// TODO - implement Jugador.usarMisilBOOM
		throw new UnsupportedOperationException();
	}

	public boolean usarEscudo(Coordenada pCoordenada) {
		// TODO - implement Jugador.usarEscudo
		throw new UnsupportedOperationException();
	}

	public void pagarArma(int pPrecio) {
		dinero = dinero - pPrecio;
	}

	public void anadirBarcoProp(Barco pBarco) {
		listaBarcos.addBarco(pBarco);
	}

	protected boolean puedePoner(Barco pBarco) {
		boolean puede = true;
		for (Coordenada co : pBarco.calcularAdyacentes()) {
			if (listaBarcos.buscarBarco(co) != null) {
				puede = false;
			}
		}
		return puede;
	}
}