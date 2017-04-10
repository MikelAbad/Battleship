package packModelo;

import java.util.ArrayList;

import packModelo.packCoordenada.Coordenada;

public class Radar {
	private Coordenada posicion;
	private int usos;

	public Radar() {
		this.posicion = new Coordenada(0,0);
		usos = DatosJuego.INI_USOS_RADAR;
	}

	public void mover(Coordenada pC) {
		this.posicion = pC;
		// TODO: Notificar al observer y eso.
	}

	public ArrayList<Coordenada> escanear() {
		usos--;
		return posicion.getAdyacentes();
	}

	public Coordenada getPosicion() {
		return posicion;
	}

	public boolean usarRadar() {
		boolean usado = false;
		if (usos >= 1 && posicion != null) {
			usado = true;
		}
		return usado;
	}
}
