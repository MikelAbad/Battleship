package packModelo.packJugador;

import packModelo.packBarcos.Barco;

public class Usuario extends Jugador {

	public Usuario() {
		super();
	}

	public void colocarBarco(Barco pBarco) {
		getListaBarcos().addBarco(pBarco);
	}

	public boolean puedePonerUs(Barco pBarco) {
		boolean puede = false;
		if (getListaBarcos().numBarcos() < 10) {
			switch (pBarco.getLongitud()) {
			case 1:
				if (getListaBarcos().getNumBarcosLong(pBarco.getLongitud()) < 4) {
					puede = true;
				}
				break;
			case 2:
				if (getListaBarcos().getNumBarcosLong(pBarco.getLongitud()) < 3) {
					puede = true;
				}
				break;
			case 3:
				if (getListaBarcos().getNumBarcosLong(pBarco.getLongitud()) < 2) {
					puede = true;
				}
				break;
			case 4:
				if (getListaBarcos().getNumBarcosLong(pBarco.getLongitud()) < 1) {
					puede = true;
				}
				break;
			}
		}
		return puede;
	}
}