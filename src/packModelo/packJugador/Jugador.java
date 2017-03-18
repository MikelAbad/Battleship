package packModelo.packJugador;

import java.util.ArrayList;

import packModelo.Almacen;
import packModelo.packBarcos.Barco;
import packModelo.packBarcos.ListaBarcos;
import packModelo.packCoordenada.Coordenada;
import packModelo.packCoordenada.ListaCoordenadas;

public abstract class Jugador {

	private ListaCoordenadas listNoDisparable;
	// private Radar radar;
	private ListaBarcos listaBarcos;
	private int dinero;
	private ListaBarcos barcosEneDest;
	private ListaCoordenadas listaTocadasEnem;

	public Jugador() {
		listNoDisparable = new ListaCoordenadas();
		listaBarcos = new ListaBarcos();
		dinero = 100;
		barcosEneDest = new ListaBarcos();
		listaTocadasEnem = new ListaCoordenadas();
	}

	public int getDinero() {
		return dinero;
	}

	public boolean tocarBarco(Coordenada pCoordenada) {
		// TODO SegundoSprint
		throw new UnsupportedOperationException();
	}

	public void destruirBarco(Coordenada pCoordenada) {
		// TODO SegundoSprint
		throw new UnsupportedOperationException();
	}

	public boolean ponerEscudo(Coordenada pCoordenada) {
		boolean exito = false;
		Barco unBarco = this.listaBarcos.buscarBarco(pCoordenada);
		if (unBarco!=null) {
			exito = listaBarcos.buscarBarco(pCoordenada).ponerEscudo();	
		}
		if (exito) {
			Almacen.getAlmacen().venderEscudo(this);
		}
		return exito;
	}

	public void addDispARival(Coordenada pCoodenada) {
		// TODO SegundoSprint
		throw new UnsupportedOperationException();
	}

	public void delDispARival(Coordenada pCoodenada) {
		// TODO SegundoSprint
		throw new UnsupportedOperationException();
	}

	public void anadirBarcDest(Barco pBarco) {
		// TODO SegundoSprint
		throw new UnsupportedOperationException();
	}

	public void usarBomba(Coordenada pCoordenada) {
		// TODO SegundoSprint
		throw new UnsupportedOperationException();
	}

	public boolean usarMisil(Coordenada pCoordenada) {
		// TODO SegundoSprint
		throw new UnsupportedOperationException();
	}

	public boolean usarMisilNS(Coordenada pCoordenada) {
		// TODO SegundoSprint
		throw new UnsupportedOperationException();
	}

	public boolean usarMisilEO(Coordenada pCoordenada) {
		// TODO SegundoSprint
		throw new UnsupportedOperationException();
	}

	public boolean usarMisilBOOM(Coordenada pCoordenada) {
		// TODO SegundoSprint
		throw new UnsupportedOperationException();
	}

	public boolean usarEscudo(Coordenada pCoordenada) {
		// TODO SegundoSprint
		throw new UnsupportedOperationException();
	}

	public void pagarArma(int pPrecio) {
		dinero = dinero - pPrecio;
	}

	public void anadirBarcoProp(Barco pBarco) {
		listaBarcos.addBarco(pBarco);
	}
	
	public ListaBarcos getListaBarcos() {
		return this.listaBarcos;
	}

	public boolean puedePoner(Barco pBarco) {
		boolean puede = true;
		if (pBarco.comprobarLimites()) {
			for (Coordenada co : pBarco.calcularAdyacentes()) {
				if (listaBarcos.buscarBarco(co) != null) {
					puede = false;
				}
			}
		}
		return puede;
	}
}