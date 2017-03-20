package packModelo.packBarcos;

import java.util.ArrayList;

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
		int i = 0;
		if (!pVertical) {
			i = pC.getY() + 1;
			while (posicion.numCoordenadas() < pLong) {
				posicion.addCoordenada(new Coordenada(pC.getX(), i++));
			}
		} else {
			i = pC.getX() + 1;
			while (posicion.numCoordenadas() < pLong) {
				posicion.addCoordenada(new Coordenada(i++, pC.getY()));
			}
		}
	}

	public void tocar(Coordenada pCoordenada) {
		if (posicion.estaEnLista(pCoordenada) && !tocadas.estaEnLista(pCoordenada)) {
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
		return this.posicion.estaEnLista(pCoordenada);
	}

	public boolean fueraDeLimites() {
		return posicion.fueraDeLimites();
	}

	public ArrayList<Coordenada> calcularAdyacentes() {
		return posicion.calcularAdyacentes();
	}

	public int getLongitud() {
		return posicion.numCoordenadas();
	}

	public ListaCoordenadas getPosicion() {
		return posicion;
	}
}