package packModelo;

import packModelo.packBarcos.Barco;
import packModelo.packBarcos.BarcosFactory;
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
		ordenador.imprimirTablero();
		// TODO mas cosas, supongo
	}

	public boolean colocarBarcoUs(String pTipo, Coordenada pC, boolean pVertical) {
		Barco unBarco = BarcosFactory.getBarcoFactory().crearBarco(pTipo, pC, pVertical);
		if (usuario.puedePonerUs(unBarco) && usuario.puedePoner(unBarco)) {
			usuario.colocarBarco(unBarco);
			return true;
		} else {
			return false;
		}
	}
	
	public boolean puedeColocar(String pTipo, Coordenada pC, boolean pVertical) {
		Barco unBarco = BarcosFactory.getBarcoFactory().crearBarco(pTipo, pC, pVertical);
		if (usuario.puedePonerUs(unBarco) && usuario.puedeColocar(unBarco)) {
			return true;
		} else {
			return false;
		}
	}

	public int barcosXPonRestantes(String pTipo) {
		int i = 0;
		if (pTipo.equals("Fragata")) {
			i = DatosJuego.NUM_FRAGATA - usuario.getListaBarcos().getNumBarcosRestantes(pTipo);
		} else if (pTipo.equals("Destructor")) {
			i = DatosJuego.NUM_DESTRUCTOR - usuario.getListaBarcos().getNumBarcosRestantes(pTipo);
		} else if (pTipo.equals("Submarino")) {
			i = DatosJuego.NUM_SUBMARINO - usuario.getListaBarcos().getNumBarcosRestantes(pTipo);
		} else if (pTipo.equals("Portaaviones")) {
			i = DatosJuego.NUM_PORTAAVIONES - usuario.getListaBarcos().getNumBarcosRestantes(pTipo);
		}
		return i;
	}

	private void colocarBarcosOrd() {
		ordenador.colocarBarcosOrd();
	}

	public void imprimirTableroUsuario() {
		usuario.imprimirTablero();
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
		if (turno) {
			elJugador = usuario;
		} else {
			elJugador = ordenador;
		}
		boolean exito;
		if (pArma == -1) {
			elJugador.usarBomba(pCoordenada);
			exito = true;
		} else {
			exito = Almacen.getAlmacen().puedeVender(pArma, elJugador);
			if (exito) {
				switch (pArma) {
				case DatosJuego.NUM_ESCUDO: // escudo
					exito = elJugador.ponerEscudo(pCoordenada);
					break;
				case DatosJuego.NUM_MISIL:
					exito = elJugador.usarMisil(pCoordenada);
					break;
				case DatosJuego.NUM_MISIL_NS:
					exito = elJugador.usarMisilNS(pCoordenada);
					break;
				case DatosJuego.NUM_MISIL_EO:
					exito = elJugador.usarMisilEO(pCoordenada);
					break;
				case DatosJuego.NUM_MISIL_BOOM:
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
	public boolean hayBarcoUsu(Coordenada pC){
		return usuario.hayBarco(pC);
	}
	
	public boolean todosBarcosUsPuestos(){
		return usuario.getListaBarcos().numBarcos()>=DatosJuego.NUM_BARCOS;
	}
}