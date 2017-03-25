package packModelo;

import packModelo.packCoordenada.Coordenada;

public class Radar {
	private Coordenada posicion;
	private int usos;

	public Radar(Coordenada pC) {
		this.posicion = pC;
		usos = 2;
	}
	
	public void mover(Coordenada pC) {
		this.posicion = pC;
	}

	public void escanear() {
		//TODO OtroSprint
	}
}
