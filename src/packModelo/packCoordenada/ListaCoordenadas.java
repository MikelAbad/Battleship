package packModelo.packCoordenada;

import java.util.ArrayList;
import java.util.Iterator;

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

	public boolean contains(Coordenada pCoordenada) {
		return esta(listaCoordenadas, pCoordenada);
	}

	public int numCoordenadas() {
		return listaCoordenadas.size();
	}
	
	public void vaciar() {
		listaCoordenadas = new ArrayList<Coordenada>();
	}
	
	public ArrayList<Coordenada> calcularAdyacentes() {
		ArrayList<Coordenada> adyacentes = new ArrayList<Coordenada>();
		for (Coordenada co : listaCoordenadas) {
			for (Coordenada co2 : co.getAdyacentes()) {
				if (!esta(adyacentes, co2)) {
					adyacentes.add(co2);
				}
			}
		}
		return adyacentes;
	}

	// Devuelve false si está fuera de los limites
	public boolean comprobarLimites() {
		boolean fueraDeLimites = false;
		for (Coordenada co : listaCoordenadas) {
			if (co.getX() > 9 || co.getY() > 9) {
				fueraDeLimites = true;
			}
		}
		return !fueraDeLimites;
	}
	
	private boolean esta(ArrayList<Coordenada> pLista, Coordenada pC) {
		Iterator<Coordenada> itr = pLista.iterator();
		Coordenada co;
		boolean esta = false;
		while(itr.hasNext() && !esta) {
			co = itr.next();
			if (co.getX() == pC.getX() && co.getY() == pC.getY()) {
				esta = true;
			}
		}
		return esta;
	}
	
	public void addCoordenadas(ArrayList<Coordenada> pLista) {
		for (Coordenada co : pLista) {
			if (!esta(listaCoordenadas, co))
				listaCoordenadas.add(co);
		}
	}
	
	public ArrayList<Coordenada> getCoordenadas() {
		return listaCoordenadas;
	}

	// Devuelve true si hay alguna coincidencia
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