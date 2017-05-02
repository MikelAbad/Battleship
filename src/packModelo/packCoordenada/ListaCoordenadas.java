package packModelo.packCoordenada;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

import packModelo.DatosJuego;

public class ListaCoordenadas {
	private ArrayList<Coordenada> listaCoordenadas;

	public ListaCoordenadas() {
		listaCoordenadas = new ArrayList<Coordenada>();
	}

	public void addCoordenada(Coordenada pCoordenada) {
		if (!listaCoordenadas.contains(pCoordenada)) {
			listaCoordenadas.add(pCoordenada);
		}
	}

	public void delCoordenada(Coordenada pCoordenada) {
		if (listaCoordenadas.contains(pCoordenada)) {
			listaCoordenadas.remove(pCoordenada);
		}
	}

	public boolean vacia() {
		return listaCoordenadas.isEmpty();
	}

	public Coordenada getRandomCo() {
		if (listaCoordenadas.size() > 1) {
			Random rdn = new Random();
			return listaCoordenadas.get(rdn.nextInt(listaCoordenadas.size() - 1));
		} else {
			return listaCoordenadas.get(0);
		}
	}

	public boolean estaEnLista(Coordenada pCoordenada) {
		return esta(listaCoordenadas, pCoordenada);
	}

	public int numCoordenadas() {
		return listaCoordenadas.size();
	}

	public ArrayList<Coordenada> calcularAdyacentes() {
		ArrayList<Coordenada> adyacentes = new ArrayList<Coordenada>();
		for (Coordenada co : listaCoordenadas) {
			for (Coordenada co2 : co.getAdyacentes()) {
				if (!esta(adyacentes, co2) && !co.fueraDeLimites()) {
					adyacentes.add(co2);
				}
			}
		}
		return adyacentes;
	}

	public boolean fueraDeLimites() {
		boolean fueraDeLimites = false;
		for (Coordenada co : listaCoordenadas) {
			if (co.getX() < 0 || co.getX() > DatosJuego.COLUMNAS_TABLERO - 1 || co.getY() < 0
					|| co.getY() > DatosJuego.FILAS_TABLERO - 1) {
				fueraDeLimites = true;
			}
		}
		return fueraDeLimites;
	}

	private boolean esta(ArrayList<Coordenada> pLista, Coordenada pC) {
		Iterator<Coordenada> itr = pLista.iterator();
		Coordenada co;
		boolean esta = false;
		while (itr.hasNext() && !esta) {
			co = itr.next();
			if (co.getX() == pC.getX() && co.getY() == pC.getY()) {
				esta = true;
			}
		}
		return esta;
	}

	public void addCoordenadas(ArrayList<Coordenada> pLista) {
		for (Coordenada co : pLista) {
			if (!esta(listaCoordenadas, co)) {
				listaCoordenadas.add(co);
			}
		}
	}

	public void delCoordenadas(ArrayList<Coordenada> pLista) {
		for (Coordenada co : pLista) {
			if (esta(listaCoordenadas, co)) {
				listaCoordenadas.remove(co);
			}
		}
	}

	public ArrayList<Coordenada> getCoordenadas() {
		return listaCoordenadas;
	}

	public boolean comprobarListas(ListaCoordenadas listaNoPonerB) {
		boolean coincide = false;
		Iterator<Coordenada> itr = getIterator();
		Coordenada co;

		while (itr.hasNext() && !coincide) {
			co = itr.next();
			if (esta(listaNoPonerB.getCoordenadas(), co)) {
				coincide = true;
			}
		}
		return coincide;
	}

	private Iterator<Coordenada> getIterator() {
		return listaCoordenadas.iterator();
	}
}