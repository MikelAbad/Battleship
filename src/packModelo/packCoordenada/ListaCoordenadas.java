package packModelo.packCoordenada;

import java.util.ArrayList;
import java.util.List;

public class ListaCoordenadas {
	private List<Coordenada> listaCoordenadas;

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
		return listaCoordenadas.contains(pCoordenada);
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
				if (!adyacentes.contains(co2)) {
					adyacentes.add(co2);
				}
			}
		}
		return adyacentes;
	}
}