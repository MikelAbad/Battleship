package packModelo.packBarcos;

import packModelo.packCoordenada.Coordenada;

public class Fragata extends Barco {

	public Fragata(Coordenada pC){
		super();
		setTipo("Fragata");
		getPosicion().addCoordenada(pC);
	}
}
