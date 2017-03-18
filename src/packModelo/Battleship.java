package packModelo;

import packModelo.packBarcos.Barco;
import packModelo.packCoordenada.Coordenada;
import packModelo.packJugador.Jugador;
import packModelo.packJugador.Ordenador;
import packModelo.packJugador.Usuario;

public class Battleship {

	private static Battleship theBattleship;
	private Usuario usuario;
	private Ordenador ordenador;
	private boolean turno; // true = Usuario, false = Ordenador
	private boolean juegoAcabado = false;

	private Battleship() {}

	public static Battleship getBattleship() {
		if (theBattleship == null) {
			theBattleship = new Battleship();
		}
		return theBattleship;
	}

	public void jugar() {
		// TODO SegundoSprint
	}

	public void inicializar() {
		usuario = new Usuario();
		ordenador = new Ordenador();
		colocarBarcosOrd();

		// TODO mas cosas, supongo
	}

	public boolean colocarBarcoUs(Coordenada pC, int pLong, boolean pVertical) {
		Barco unBarco = new Barco(pC, pLong, pVertical);
		if (usuario.puedePonerUs(unBarco) && usuario.puedePoner(unBarco)) {
			usuario.colocarBarco(unBarco);
			return true;
		} else {
			return false;
		}
	}

	public int barcosXPonRestantes(int pLong) {
		int i = 0;
		switch (pLong) {
		case 1:
			i = 4 - usuario.getListaBarcos().getNumBarcosLong(pLong);
			break;
		case 2:
			i = 3 - usuario.getListaBarcos().getNumBarcosLong(pLong);
			break;
		case 3:
			i = 2 - usuario.getListaBarcos().getNumBarcosLong(pLong);
			break;
		case 4:
			i = 1 - usuario.getListaBarcos().getNumBarcosLong(pLong);
			break;
		}
		return i;
	}

	private void colocarBarcosOrd() {
		ordenador.colocarBarcosOrd();
	}

	public void juegoAcabado() {
		juegoAcabado = true;
	}

	public boolean hasGanado() {
		// TODO SegundoSprint
		throw new UnsupportedOperationException();
	}

	public boolean usarArmamento(int pArma, Coordenada pCoordenada) {
		Jugador elJugador;
		if (turno)
			elJugador = usuario;
		else
			elJugador = ordenador;
		boolean exito;
		if (pArma == -1) {
			elJugador.usarBomba(pCoordenada);
			exito = true;
		} else {
			exito = Almacen.getAlmacen().puedeVender(pArma, elJugador);
			if (exito) {
				switch (pArma) {
				case 0: // escudo
					exito = elJugador.ponerEscudo(pCoordenada);
					break;
				case 1: // misil
					exito = elJugador.usarMisil(pCoordenada);
					break;
				case 2: // misilNS
					exito = elJugador.usarMisilNS(pCoordenada);
					break;
				case 3: // misilEO
					exito = elJugador.usarMisilEO(pCoordenada);
					break;
				case 4: // misilBOOM
					exito = elJugador.usarMisilBOOM(pCoordenada);
					break;
				default:
					exito = false;
					break;
				}
			}
		}
		return exito;
	}
}