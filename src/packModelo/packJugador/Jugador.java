package packModelo.packJugador;


import java.util.Observable;

import packModelo.Almacen;
import packModelo.Battleship;
import packModelo.Cantidades;
import packModelo.DatosJuego;
import packModelo.Radar;
import packModelo.packBarcos.Barco;
import packModelo.packBarcos.BarcoNoEncException;
import packModelo.packBarcos.ListaBarcos;
import packModelo.packCoordenada.Coordenada;
import packModelo.packCoordenada.ListaCoordenadas;


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

	public int[] getCantidades() {
		int[] cantidades = new int[6];
		cantidades[0] = armamento.getMisil();
		cantidades[1] = armamento.getMisilNS();
		cantidades[2] = armamento.getMisilEO();
		cantidades[3] = armamento.getMisilBOOM();
		cantidades[4] = radar.getUsos();
		cantidades[5] = armamento.getEscudo();
		return cantidades;
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
		try{
			Barco unBarco = this.listaBarcos.buscarBarco(pCoordenada);
			if (armamento.getEscudo() >= 1) {
				if (unBarco.ponerEscudo()) {
					exito = true;
					armamento.rmvEscudo();
				}
			}
		}catch (BarcoNoEncException e){}
		return exito;
	}
	
	public boolean comprarArma(int pArma) {
		boolean exito = false;
		if (Almacen.getAlmacen().puedeVender(pArma)) {
			if (meLlega(pArma)) {
				exito = true;
				switch (pArma) {
				case DatosJuego.NUM_ESCUDO:
					Almacen.getAlmacen().venderEscudo();
					dinero = dinero - DatosJuego.PRECIO_ESCUDO;
					armamento.addEscudo();
					break;
				case DatosJuego.NUM_MISIL:
					Almacen.getAlmacen().venderMisil();
					dinero = dinero - DatosJuego.PRECIO_MISIL;
					armamento.addMisil();
					break;
				case DatosJuego.NUM_MISIL_NS:
					Almacen.getAlmacen().venderMisilNS();
					dinero = dinero - DatosJuego.PRECIO_MISIL_NS;
					armamento.addMisilNS();
					break;
				case DatosJuego.NUM_MISIL_EO:
					Almacen.getAlmacen().venderMisilEO();
					dinero = dinero - DatosJuego.PRECIO_MISIL_EO;
					armamento.addMisilEO();
					break;
				case DatosJuego.NUM_MISIL_BOOM:
					Almacen.getAlmacen().venderMisilBOOM();
					dinero = dinero - DatosJuego.PRECIO_MISIL_BOOM;
					armamento.addMisilBOOM();
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
		try{
			listaBarcos.buscarBarco(pC);
			return true;
		}catch (BarcoNoEncException e){
			return false;
		}
	}
	public Radar getRadar(){return radar;}
	
	public void moverRadar(Coordenada pCoordenada) {
		radar.mover(pCoordenada);
		// Solo notifica si es el jugador
		if (Battleship.getBattleship().getTurno()) {
			String infoRadar ="move;"+ pCoordenada.getX() + "," + pCoordenada.getY();
			setChanged();
			notifyObservers(infoRadar);
		}
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

	public void notificarRadar(String pInfoRadar){
		setChanged();
		notifyObservers(pInfoRadar);
	}
}