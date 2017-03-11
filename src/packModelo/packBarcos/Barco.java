package packModelo.packBarcos;

import packModelo.packCoordenada.Coordenada;
import packModelo.packCoordenada.ListaCoordenadas;

public class Barco {
	private ListaCoordenadas posicion;
	private ListaCoordenadas tocadas;
	private int escudo = 0;

	public Barco(Coordenada pC, int pLong, boolean pVertical) {
		tocadas = new ListaCoordenadas();
		posicion = new ListaCoordenadas();
		posicion.addCoordenada(pC);
		if (pVertical = true) {
			while (posicion.numCoordenadas() < pLong) {
				posicion.addCoordenada(new Coordenada(pC.getX(),pC.getY()+1));
			}
		} else {
			while (posicion.numCoordenadas() < pLong) {
				posicion.addCoordenada(new Coordenada(pC.getX()+1,pC.getY()));
			}
		}
	}

	public void tocar(Coordenada pCoordenada) {
		if (posicion.contains(pCoordenada) && !tocadas.contains(pCoordenada)) {
			tocadas.addCoordenada(pCoordenada);
		}
	}

	public void reparar(Coordenada pCoordenada) {
		tocadas.vaciar();
	}

	public boolean estaDestruido() {
		return posicion.numCoordenadas() == tocadas.numCoordenadas();
	}

	public boolean ponerEscudo() {
		if (escudo == 0) {
			escudo = 2;
			return true;
		} else {
			return false;
		}
	}

	public void destruir() {
		tocadas = posicion;
	}

	public boolean estaEnPos(Coordenada pCoordenada) {
		return this.posicion.contains(pCoordenada);
	}
}