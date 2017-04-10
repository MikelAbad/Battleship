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

	private ListaCoordenadas listNoDisparable;
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
		listNoDisparable = new ListaCoordenadas();
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

	public boolean tocarBarco(Coordenada pCoordenada) {
		boolean tocado = false;
		if (hayBarco(pCoordenada)) {
			int resultado = this.listaBarcos.buscarBarco(pCoordenada).tocar(pCoordenada);
			if (resultado == 1) {
				tocado = true;
				String c = pCoordenada.getX() + "," + pCoordenada.getY();
				setChanged();
				notifyObservers(c);	
			} else if (resultado == 2 && !Battleship.getBattleship().getTurno()) {
				Barco barco = this.getListaBarcos().buscarBarco(pCoordenada);
				String cambios = DatosJuego.NUM_ESCUDO + "";
				for (Coordenada co : barco.getPosicion().getCoordenadas()) {
					cambios = cambios + ";" + co.getX() + "," + co.getY();
				}
				setChanged();
				notifyObservers(cambios);
			}
			
		}
		return tocado;
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
		int[] info = new int[2]; // Para la vista
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
						notificarCompra(info);
					}
					break;
				case DatosJuego.NUM_MISIL:
					Almacen.getAlmacen().venderMisil();
					armamento.addMisil();
					if (Battleship.getBattleship().getTurno()){
						info[0] = DatosJuego.NUM_MISIL;
						info[1] = armamento.getMisil();
						notificarCompra(info);
					}
					break;
				case DatosJuego.NUM_MISIL_NS:
					Almacen.getAlmacen().venderMisilNS();
					armamento.addMisilNS();
					if (Battleship.getBattleship().getTurno()) {
						info[0] = DatosJuego.NUM_MISIL_NS;
						info[1] = armamento.getMisilNS();
						notificarCompra(info);
					}
					break;
				case DatosJuego.NUM_MISIL_EO:
					Almacen.getAlmacen().venderMisilEO();
					armamento.addMisilEO();
					if (Battleship.getBattleship().getTurno()) {
						info[0] = DatosJuego.NUM_MISIL_EO;
						info[1] = armamento.getMisilEO();
						notificarCompra(info);
					}
					break;
				case DatosJuego.NUM_MISIL_BOOM:
					Almacen.getAlmacen().venderMisilBOOM();
					armamento.addMisilBOOM();
					if (Battleship.getBattleship().getTurno()) {
						info[0] = DatosJuego.NUM_MISIL_BOOM;
						info[1] = armamento.getMisilBOOM();
						notificarCompra(info);
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
		if (Battleship.getBattleship().getTurno()) { // Jugador
			Battleship.getBattleship().getOrdenador().tocarBarco(pCoordenada);
		} else { // Ordenador
			Battleship.getBattleship().getUsuario().tocarBarco(pCoordenada);
		}
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
	
	public void notificarRadar(String[] pInfoRadar){
		setChanged();
		notifyObservers(pInfoRadar);
	}
	
	private void notificarCompra(int[] info) {
		setChanged();
		notifyObservers(info);
	}
}