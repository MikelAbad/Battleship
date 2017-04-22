package packModelo;

import java.util.Observable;

import packModelo.packBarcos.Barco;
import packModelo.packBarcos.BarcosFactory;
import packModelo.packCoordenada.Coordenada;
import packModelo.packJugador.Jugador;
import packModelo.packJugador.Ordenador;
import packModelo.packJugador.Usuario;

public class Battleship extends Observable{

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

	public void inicializar() {
		usuario = new Usuario();
		ordenador = new Ordenador();
		colocarBarcosOrd();
		ordenador.imprimirTablero();
		turno = true;
	}

	public void colocarBarcoUs(String pTipo, Coordenada pC, boolean pVertical) {
		Barco unBarco = BarcosFactory.getBarcoFactory().crearBarco(pTipo, pC, pVertical);
		usuario.anadirAdyacentesBarco(unBarco);
		usuario.colocarBarco(unBarco);
	}
	
	// Para la vista, no colocar nada, solo comprueba
	public boolean puedeColocar(String pTipo, Coordenada pC, boolean pVertical) {
		Barco unBarco = BarcosFactory.getBarcoFactory().crearBarco(pTipo, pC, pVertical);
		if (usuario.puedePonerUs(unBarco) && usuario.puedeColocar(unBarco)) {
			return true;
		} else {
			return false;
		}
	}

	public boolean getTurno() {
		return this.turno;
	}
	
	public void setTurno(boolean pTurno) {
		turno = pTurno;
		if(!turno) ordenador.jugar();
	}
	
	public Usuario getUsuario() {
		return this.usuario;
	}
	
	public Ordenador getOrdenador() {
		return this.ordenador;
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
		// TODO TercerSprint
		throw new UnsupportedOperationException();
	}
	public boolean usarEscudo(Coordenada pCoordenada) {
		if(usuario.ponerEscudo(pCoordenada)) {
			notificarEscudo(pCoordenada);
			return true;
		}else return false;
	}
	
	public void usarBomba(Coordenada pCoordenada) {
		usuario.usarBomba(pCoordenada);
	}
	
	public void usarMisil(Coordenada pCoordenada) {
		usuario.usarMisil(pCoordenada);
	}
	
	public void usarMisilNS(Coordenada pCoordenada) {
		usuario.usarMisilNS(pCoordenada);
	}
	
	public void usarMisilEO(Coordenada pCoordenada) {
		usuario.usarMisilEO(pCoordenada);
	}
	
	public void usarMisilBOOM(Coordenada pCoordenada) {
		usuario.usarMisilBOOM(pCoordenada);
	}
	
	public boolean puedeUsar(int pArma){
		return usuario.puedeUsar(pArma);
	}
	public void moverRadar(Coordenada pCoordenada) {
		ordenador.moverRadar(pCoordenada);
	}

	public boolean usarRadar() {
		if (usuario.getRadar().puedeUsarRadar()){
			ordenador.recibirEscaRadar();
			usuario.getRadar().restarUsoRadar();
			System.out.println("uso de reaadar");
			return true;
		}
		else return false;
	}

	private void notificarEscudo(Coordenada pCoordenada) {
		// Solo pinta los escudos que pone el usuario
		// Si llegamos aquí es porque ya sabemos que hay un barco, nunca null
		Barco barco = usuario.getListaBarcos().buscarBarco(pCoordenada);
		String cambios = "escudo";
		for (Coordenada co : barco.getPosicion().getCoordenadas()) {
			cambios += ";" + co.getX() + "," + co.getY();
		}
		setChanged();
		notifyObservers(cambios);
	}

	public boolean hayBarcoUsu(Coordenada pC){
		return usuario.hayBarco(pC);
	}
	
	public boolean todosBarcosUsPuestos(){
		return usuario.getListaBarcos().numBarcos() >= DatosJuego.NUM_BARCOS;
	}
	
	public int getDineroUsuario() {
		return usuario.getDinero();
	}
	
	public boolean comprarArma(int pArma){
		return usuario.comprarArma(pArma);
		
	}
}