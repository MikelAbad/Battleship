package packModelo.packBarcos;

import java.util.ArrayList;

import packModelo.DatosJuego;
import packModelo.packCoordenada.Coordenada;
import packModelo.packCoordenada.ListaCoordenadas;

public abstract class Barco {
	private ListaCoordenadas posicion;
	private ListaCoordenadas tocadas;
	private String tipo;
	private int longitud = 0;
	private int escudo = 0;

	public Barco() {
		posicion = new ListaCoordenadas();
		tocadas = new ListaCoordenadas();
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
			escudo = DatosJuego.VALOR_ESCUDO;
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

	public ListaCoordenadas getPosicion() {
		return posicion;
	}

	public String getTipo() {
		return this.tipo;
	}

	public void setTipo(String pTipo) {
		this.tipo = pTipo;
	}
}