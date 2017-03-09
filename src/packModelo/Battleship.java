package packModelo;

import packModelo.packCoordenada.Coordenada;
import packModelo.packJugador.Ordenador;
import packModelo.packJugador.Usuario;

public class Battleship {

	private static Battleship theBattleship;
	private Usuario usuario;
	private Ordenador ordenador;
	private boolean turno;
	private boolean juegoAcabado = false;

	private Battleship() {
		// TODO - implement Battleship.Battleship
		throw new UnsupportedOperationException();
	}

	public static Battleship getBattleship() {
		// TODO - implement Battleship.getBattleship
		throw new UnsupportedOperationException();
	}

	public void jugar() {
		// TODO - implement Battleship.jugar
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param pC
	 * @param pLong
	 * @param pVertical
	 */
	public boolean colocarBarcoUs(Coordenada pC, int pLong, boolean pVertical) {
		// TODO - implement Battleship.colocarBarcoUs
		throw new UnsupportedOperationException();
	}

	private void colocarBarcosOrd() {
		// TODO - implement Battleship.colocarBarcosOrd
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param pCoordenada
	 */
	public boolean ponerEscudo(Coordenada pCoordenada) {
		// TODO - implement Battleship.ponerEscudo
		throw new UnsupportedOperationException();
	}

	public void inicializar() {
		// TODO - implement Battleship.inicializar
		throw new UnsupportedOperationException();
	}

	public void juegoAcabado() {
		// TODO - implement Battleship.juegoAcabado
		throw new UnsupportedOperationException();
	}

	public boolean hasGanado() {
		// TODO - implement Battleship.hasGanado
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param pArma
	 * @param pCoordenada
	 */
	public boolean usarArmamentoUsu(int pArma, Coordenada pCoordenada) {
		// TODO - implement Battleship.usarArmamentoUsu
				throw new UnsupportedOperationException();
	}

}