package packModelo.packJugador;


import packModelo.Battleship;
import packModelo.DatosJuego;
import packModelo.packBarcos.Barco;


public class Usuario extends Jugador {

	public Usuario() {
		super();
	}

	public void colocarBarco(Barco pBarco) {
		getListaBarcos().addBarco(pBarco);
		Battleship.getBattleship().imprimirTableroUsuario();
	}

	public boolean puedePonerUs(Barco pBarco) {
		boolean puede = false;
		if (getListaBarcos().numBarcos() < DatosJuego.NUM_BARCOS) {
			puede = pBarco.puedePonerse(getListaBarcos());			
		}
		return puede;
	}
	
	public void imprimirTablero() {
		System.out.println("\nBarcos del Jugador:");
		this.getListaBarcos().imprimirTablero();
	}
}