package packModelo.packBarcos;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import packModelo.packCoordenada.Coordenada;

public class ListaBarcos {
	private List<Barco> listaBarcos;

	public ListaBarcos() {
		listaBarcos = new ArrayList<Barco>();
	}
	
	public void addBarco(Barco pBarco) {
		if (!listaBarcos.contains(pBarco)) {
			listaBarcos.add(pBarco);
		}
	}

	public void delBarco(Barco pBarco) {
		if (listaBarcos.contains(pBarco)) {
			listaBarcos.remove(pBarco);
		}
	}

	public boolean contains(Barco pBarco) {
		return listaBarcos.contains(pBarco);
	}

	public int numBarcos() {
		return listaBarcos.size();
	}
	
	public int getNumBarcosLong(int pLong) {
		int cuantos = 0;
		for (Barco b : listaBarcos) {
			if (b.getLongitud() == pLong) {
				cuantos++;
			}
		}
		return cuantos;
	}
	
	public Barco buscarBarco(Coordenada pCoordenada) {
		Iterator<Barco> itr = getIterator();
		boolean encontrado = false;
		Barco barco = null;
		Barco b;
		while (itr.hasNext() && !encontrado) {
			b = itr.next();
			if (b.estaEnPos(pCoordenada)) {
				barco = b;
				encontrado = true;
			}
		}
		return barco;
	}
	
	private Iterator<Barco> getIterator() {
		return listaBarcos.iterator();
	}
}