package packModelo.packJugador;

import packModelo.packBarcos.Barco;

public class Usuario extends Jugador {

	public Usuario() {}

	public void colocarBarco(Barco pBarco) {
		getListaBarcos().addBarco(pBarco);
	}
	
	public boolean puedePonerUs(Barco pBarco) {
		boolean puede = true;
		if (getListaBarcos().numBarcos() < 10) {
			switch(pBarco.getLongitud()) {
			case 1:
				if (getListaBarcos().getNumBarcosLong(pBarco.getLongitud()) >= 4) {
					puede = false;
				}
				break;
			case 2:
				if (getListaBarcos().getNumBarcosLong(pBarco.getLongitud()) >= 3) {
					puede = false;
				}	
				break;
			case 3:
				if (getListaBarcos().getNumBarcosLong(pBarco.getLongitud()) >= 2) {
					puede = false;
				}
				break;
			case 4:
				if (getListaBarcos().getNumBarcosLong(pBarco.getLongitud()) >= 1) {
					puede = false;
				}
				break;
			}
		}	
		return puede;
	}
}