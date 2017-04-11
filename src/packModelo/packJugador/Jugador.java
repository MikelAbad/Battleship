package packModelo.packJugador;

import java.util.ArrayList;
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

	private Radar radar;
	private ListaBarcos listaBarcos;
	private Cantidades armamento;
	private int dinero;
	private ListaBarcos barcosEneDest;
	private ListaCoordenadas listaTocadasEnem;
	private ListaCoordenadas listaNoPonerB;

	public Jugador() {
		armamento = new Cantidades();
		armamento.iniciarJugador();
		listaBarcos = new ListaBarcos();
		barcosEneDest = new ListaBarcos();
		listaTocadasEnem = new ListaCoordenadas();
		listaNoPonerB = new ListaCoordenadas();
		dinero = DatosJuego.DINERO_INICIAL;
		radar = new Radar();
	}

	public int getDinero() {
		return dinero;
	}
	
	protected ListaBarcos getBarcosEneDest() {
		return barcosEneDest;
	}

	protected ListaCoordenadas getListaTocadasEnem() {
		return listaTocadasEnem;
	}
	
	protected Cantidades getArmamento() {
		return armamento;
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
		int[] info = new int[2]; // Para la vista
		boolean exito = false;
		if (Almacen.getAlmacen().puedeVender(pArma)) {
			if (meLlega(pArma)) {
				exito = true;
				switch (pArma) {
				case DatosJuego.NUM_ESCUDO:
					Almacen.getAlmacen().venderEscudo();
					dinero = dinero - DatosJuego.PRECIO_ESCUDO;
					armamento.addEscudo();
					info[0] = DatosJuego.NUM_ESCUDO;
					info[1] = armamento.getEscudo();
					notificarCompra(info);
					break;
				case DatosJuego.NUM_MISIL:
					Almacen.getAlmacen().venderMisil();
					dinero = dinero - DatosJuego.PRECIO_MISIL;
					armamento.addMisil();
					info[0] = DatosJuego.NUM_MISIL;
					info[1] = armamento.getMisil();
					notificarCompra(info);
					break;
				case DatosJuego.NUM_MISIL_NS:
					Almacen.getAlmacen().venderMisilNS();
					dinero = dinero - DatosJuego.PRECIO_MISIL_NS;
					armamento.addMisilNS();
					info[0] = DatosJuego.NUM_MISIL_NS;
					info[1] = armamento.getMisilNS();
					notificarCompra(info);
					break;
				case DatosJuego.NUM_MISIL_EO:
					Almacen.getAlmacen().venderMisilEO();
					dinero = dinero - DatosJuego.PRECIO_MISIL_EO;
					armamento.addMisilEO();
					info[0] = DatosJuego.NUM_MISIL_EO;
					info[1] = armamento.getMisilEO();
					notificarCompra(info);
					break;
				case DatosJuego.NUM_MISIL_BOOM:
					Almacen.getAlmacen().venderMisilBOOM();
					dinero = dinero - DatosJuego.PRECIO_MISIL_BOOM;
					armamento.addMisilBOOM();
					info[0] = DatosJuego.NUM_MISIL_BOOM;
					info[1] = armamento.getMisilBOOM();
					notificarCompra(info);
					break;
				}
			}
		}
		return exito;
	}
	
	private boolean meLlega(int pArma) {
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
	protected Radar getRadar(){return radar;}
	
	public void moverRadar(Coordenada pCoordenada) {
		String[] infoRadar = new String[5];
		infoRadar[0] = "move";
		Coordenada c = radar.getPosicion();
		if (c == null) {
			infoRadar[1] = null;
			infoRadar[2] = null;
		} else {
			infoRadar[1] = "" + c.getX();
			infoRadar[2] = "" + c.getY();
		}

		radar.mover(pCoordenada);
		infoRadar[3] = "" + pCoordenada.getX();
		infoRadar[4] = "" + pCoordenada.getY();
		setChanged();
		notifyObservers(infoRadar);
	}
	
	public boolean puedeUsar(int pArma) {
		boolean puede = false;
		switch (pArma) {
		case DatosJuego.NUM_ESCUDO:
			if (armamento.getEscudo() > 0) {
				puede = true;
			}
			break;
		case DatosJuego.NUM_BOMBA:
			puede = true;
			break;
		case DatosJuego.NUM_MISIL:
			if (armamento.getMisil() > 0) {
				puede = true;
			}
			break;
		case DatosJuego.NUM_MISIL_NS:
			if (armamento.getMisilNS() > 0) {
				puede = true;
			}
			break;
		case DatosJuego.NUM_MISIL_EO:
			if (armamento.getMisilEO() > 0) {
				puede = true;
			}
			break;
		case DatosJuego.NUM_MISIL_BOOM:
			if (armamento.getMisilBOOM() > 0) {
				puede = true;
			}
			break;
		}
		return puede;
	}

	public void notificarRadar(String[] pInfoRadar){
		setChanged();
		notifyObservers(pInfoRadar);
	}
	
	private void notificarCompra(int[] info) {
		setChanged();
		notifyObservers(info);
	}
}