package packModelo.packJugador;

import packModelo.packBarcos.Barco;
import packModelo.packBarcos.ListaBarcos;
import packModelo.packCoordenada.Coordenada;
import packModelo.packCoordenada.ListaCoordenadas;

public abstract class Jugador {

	private ListaCoordenadas listNoDisparable;
	//private Radar radar;
	private ListaBarcos listaBarcos;
	private int dinero;
	private ListaBarcos barcosEneDest;
	private ListaCoordenadas listaTocadasEnem;

	public Jugador() {
		listNoDisparable = new ListaCoordenadas();
		listaBarcos = new ListaBarcos();
		dinero = 10000; //TODO decidir cantidad
		barcosEneDest = new ListaBarcos();
		listaTocadasEnem = new ListaCoordenadas();
	}

	/**
	 * 
	 * @param pCoordenada
	 */
	public boolean tocarBarco(Coordenada pCoordenada) {
		// TODO - implement Jugador.tocarBarco
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param pCoordenada
	 */
	public void destruirBarco(Coordenada pCoordenada) {
		// TODO - implement Jugador.destruirBarco
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param pCoordenada
	 */
	public boolean ponerEscudo(Coordenada pCoordenada) {
		return listaBarcos.buscarBarco(pCoordenada).ponerEscudo();
	}

	/**
	 * 
	 * @param pCoodenada
	 */
	public void addDispARival(Coordenada pCoodenada) {
		// TODO - implement Jugador.addDispARival
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param pCoodenada
	 */
	public void delDispARival(Coordenada pCoodenada) {
		// TODO - implement Jugador.delDispARival
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param pBarco
	 */
	public void anadirBarcDest(Barco pBarco) {
		// TODO - implement Jugador.anadirBarcDest
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param pCoordenada
	 */
	public void usarBomba(Coordenada pCoordenada) {
		// TODO - implement Jugador.usarBomba
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param pCoordenada
	 */
	public boolean usarMisil(Coordenada pCoordenada) {
		// TODO - implement Jugador.usarMisil
				throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param pCoordenada
	 */
	public boolean usarMisilNS(Coordenada pCoordenada) {
		// TODO - implement Jugador.usarMisilNS
				throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param pCoordenada
	 */
	public boolean usarMisilEO(Coordenada pCoordenada) {
		// TODO - implement Jugador.usarMisilEO
				throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param pCoordenada
	 */
	public boolean usarMisilBOOM(Coordenada pCoordenada) {
		// TODO - implement Jugador.usarMisilBOOM
				throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param pCoordenada
	 */
	public boolean usarEscudo(Coordenada pCoordenada) {
		// TODO - implement Jugador.usarEscudo
				throw new UnsupportedOperationException();
	}

}