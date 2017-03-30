package packModelo.packJugador;

import java.util.Observable;

import packModelo.Almacen;
import packModelo.Battleship;
import packModelo.Cantidades;
import packModelo.DatosJuego;
import packModelo.Radar;
import packModelo.packBarcos.Barco;
import packModelo.packBarcos.ListaBarcos;
import packModelo.packCoordenada.Coordenada;
import packModelo.packCoordenada.ListaCoordenadas;
import packVista.TableroJuego;

public abstract class Jugador extends Observable{

	private ListaCoordenadas listNoDisparable;
	private Radar radar;
	private ListaBarcos listaBarcos;
	private Cantidades armamento;
	private int dinero;
	private ListaBarcos barcosEneDest;
	private ListaCoordenadas listaTocadasEnem;
	private ListaCoordenadas listaNoPonerB;
	private int[] info; // Para la vista

	public Jugador() {
		armamento = new Cantidades();
		armamento.iniciarJugador();
		listNoDisparable = new ListaCoordenadas();
		listaBarcos = new ListaBarcos();
		barcosEneDest = new ListaBarcos();
		listaTocadasEnem = new ListaCoordenadas();
		listaNoPonerB = new ListaCoordenadas();
		dinero = DatosJuego.DINERO_INICIAL;
		info = new int[2];
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
		if (unBarco != null) {
			if (armamento.getEscudo() >= 1) {
				if (unBarco.ponerEscudo()) {
					exito = true;
					armamento.rmvEscudo();
				}
			}
		}
		return exito;
	}
	
	public boolean comprarArma(int pArma) {
		boolean exito = false;
		if (Almacen.getAlmacen().puedeVender(pArma)) {
			if (meLlega(pArma)) {
				exito = true;
				restarDinero(pArma);
				switch (pArma) {
				case DatosJuego.NUM_ESCUDO:
					Almacen.getAlmacen().venderEscudo();
					armamento.addEscudo();
					if (Battleship.getBattleship().getTurno()) {
						info[0] = DatosJuego.NUM_ESCUDO;
						info[1] = armamento.getEscudo();
						notificar();
					}
					break;
				case DatosJuego.NUM_MISIL:
					Almacen.getAlmacen().venderMisil();
					armamento.addMisil();
					if (Battleship.getBattleship().getTurno()){
						info[0] = DatosJuego.NUM_MISIL;
						info[1] = armamento.getMisil();
						notificar();
					}
					break;
				case DatosJuego.NUM_MISIL_NS:
					Almacen.getAlmacen().venderMisilNS();
					armamento.addMisilNS();
					if (Battleship.getBattleship().getTurno()) {
						info[0] = DatosJuego.NUM_MISIL_NS;
						info[1] = armamento.getMisilNS();
						notificar();
					}
					break;
				case DatosJuego.NUM_MISIL_EO:
					Almacen.getAlmacen().venderMisilEO();
					armamento.addMisilEO();
					if (Battleship.getBattleship().getTurno()) {
						info[0] = DatosJuego.NUM_MISIL_EO;
						info[1] = armamento.getMisilEO();
						notificar();
					}
					break;
				case DatosJuego.NUM_MISIL_BOOM:
					Almacen.getAlmacen().venderMisilBOOM();
					armamento.addMisilBOOM();
					if (Battleship.getBattleship().getTurno()) {
						info[0] = DatosJuego.NUM_MISIL_BOOM;
						info[1] = armamento.getMisilBOOM();
						notificar();
					}
					break;
				}
			}
		}
		return exito;
	}
	
	protected boolean meLlega(int pArma) {
		boolean suficiente = false;
		switch (pArma) {
		case DatosJuego.NUM_ESCUDO:
			if (dinero >= DatosJuego.PRECIO_ESCUDO) {
				suficiente = true;
			}
			break;
		case DatosJuego.NUM_MISIL:
			if (dinero >= DatosJuego.PRECIO_MISIL) {
				suficiente = true;
			}
			break;
		case DatosJuego.NUM_MISIL_NS:
			if (dinero >= DatosJuego.PRECIO_MISIL_NS) {
				suficiente = true;
			}
			break;
		case DatosJuego.NUM_MISIL_EO:
			if (dinero >= DatosJuego.PRECIO_MISIL_EO) {
				suficiente = true;
			}
			break;
		case DatosJuego.NUM_MISIL_BOOM:
			if (dinero >= DatosJuego.PRECIO_MISIL_BOOM) {
				suficiente = true;
			}
			break;
		}
		return suficiente;
	}
	
	protected void restarDinero(int pArma) {
		switch (pArma) {
		case DatosJuego.NUM_ESCUDO:
			dinero = dinero - DatosJuego.PRECIO_ESCUDO;
			break;
		case DatosJuego.NUM_MISIL:
			dinero = dinero - DatosJuego.PRECIO_MISIL;
			break;
		case DatosJuego.NUM_MISIL_NS:
			dinero = dinero - DatosJuego.PRECIO_MISIL_NS;
			break;
		case DatosJuego.NUM_MISIL_EO:
			dinero = dinero - DatosJuego.PRECIO_MISIL_EO;
			break;
		case DatosJuego.NUM_MISIL_BOOM:
			dinero = dinero - DatosJuego.PRECIO_MISIL_BOOM;
			break;
		}
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

	public void anadirBarcoProp(Barco pBarco) {
		listaBarcos.addBarco(pBarco);
	}

	public ListaBarcos getListaBarcos() {
		return this.listaBarcos;
	}

	public void anadirAdyacentesBarco(Barco pBarco) {
		listaNoPonerB.addCoordenadas(pBarco.calcularAdyacentes());
	}
	
	public boolean puedeColocar(Barco pBarco) {
		boolean puede = false;
		if (!pBarco.fueraDeLimites()) {
			if (!pBarco.getPosicion().comprobarListas(listaNoPonerB)) {
				puede = true;
			}
		}
		return puede;
	}
	public boolean hayBarco(Coordenada pC) {
		return listaBarcos.buscarBarco(pC) != null;
	}
	
	private void notificar() {
		setChanged();
		notifyObservers(info);
	}
}