package packModelo;

import packModelo.packCoordenada.Coordenada;
import packModelo.packJugador.Jugador;
import packModelo.packJugador.Ordenador;
import packModelo.packJugador.Usuario;

public class Battleship {

	private static Battleship theBattleship;
	private Usuario usuario;
	private Ordenador ordenador;
	private boolean turno; //true es el usuario, false el ordenador
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

	public boolean colocarBarcoUs(Coordenada pC, int pLong, boolean pVertical) {
		// TODO - implement Battleship.colocarBarcoUs
		throw new UnsupportedOperationException();
	}

	private void colocarBarcosOrd() {
		// TODO - implement Battleship.colocarBarcosOrd
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

	public boolean usarArmamento(int pArma, Coordenada pCoordenada) {
		Jugador elJugador;
		if (turno)elJugador=usuario;
		else elJugador=ordenador;
		boolean exito;
			if(pArma==-1){
				elJugador.usarBomba(pCoordenada);
				exito=true;
			}
			else{
				exito = Almacen.getAlmacen().puedeVender(pArma, elJugador);
				if (exito){
					switch(pArma){
					case 0://escudo
						exito = elJugador.ponerEscudo(pCoordenada);
						break;
					case 1://misil
						exito = elJugador.usarMisil(pCoordenada);
						break;
					case 2://misilNS
						exito = elJugador.usarMisilNS(pCoordenada);
						break;
					case 3://misilEO
						exito = elJugador.usarMisilEO(pCoordenada);
						break;
					case 4://misilBOOM
						exito = elJugador.usarMisilBOOM(pCoordenada);
						break;
					default:
						exito=false;
						break;
					}
				}	
			}
		return exito;
	}
}