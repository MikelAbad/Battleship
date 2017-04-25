package packModelo.packJugador;

import java.util.ArrayList;

import packModelo.Battleship;
import packModelo.DatosJuego;
import packModelo.packBarcos.Barco;
import packModelo.packBarcos.BarcoNoEncException;
import packModelo.packBarcos.ListaBarcos;
import packModelo.packCoordenada.Coordenada;

public class Usuario extends Jugador {

	public Usuario() {
		super();
	}

	public void colocarBarco(Barco pBarco) {
		getListaBarcos().addBarco(pBarco);
		Battleship.getBattleship().imprimirTableroUsuario();
	}

	public boolean puedePonerUs(Barco pBarco) {
		boolean puede = false;
		if (getListaBarcos().numBarcos() < DatosJuego.NUM_BARCOS) {
			puede = pBarco.puedePonerse(getListaBarcos());
		}
		return puede;
	}

	public void imprimirTablero() {
		System.out.println("\nBarcos del Jugador:");
		this.getListaBarcos().imprimirTablero();
	}

	public ArrayList<Coordenada>[] recibirEscaRadar() {
		ArrayList<Coordenada> escaneadas = super.getRadar().escanear();
		@SuppressWarnings("unchecked")
		ArrayList<Coordenada> listas[] = new ArrayList[2];
		ArrayList<Coordenada> objetivos = new ArrayList<Coordenada>();
		ArrayList<Coordenada> noDisparables = new ArrayList<Coordenada>();
		for (Coordenada co : escaneadas) {
			if (hayBarco(co)) {
				objetivos.add(co);
			} else
				noDisparables.add(co);
		}
		listas[0] = objetivos;
		listas[1] = noDisparables;
		return listas;
	}

	public int tocarBarco(Coordenada pCoordenada) {
		int resultado = 0;
		try {
			resultado = super.getListaBarcos().buscarBarco(pCoordenada).tocar(pCoordenada);
			if (resultado == 1) {
				String cambios = "tocada;" + pCoordenada.getX() + "," + pCoordenada.getY();
				setChanged();
				notifyObservers(cambios);
			} else if (resultado == 3) {
				Barco barco = super.getListaBarcos().buscarBarco(pCoordenada);
				String cambios = "destruido";
				for (Coordenada co : barco.getPosicion().getCoordenadas()) {
					cambios += ";" + co.getX() + "," + co.getY();
				}
				setChanged();
				notifyObservers(cambios);
			}
		} catch (BarcoNoEncException e) {
			String cambios = "agua;" + pCoordenada.getX() + "," + pCoordenada.getY();
			setChanged();
			notifyObservers(cambios);
		}
		return resultado;
	}

	public int destruirBarco(Coordenada pCoordenada) {
		int destruido;
		try{
			if (super.getListaBarcos().buscarBarco(pCoordenada).destruir()) {
				destruido = 1;// destruido
				Barco barco = super.getListaBarcos().buscarBarco(pCoordenada);
				String cambios = "destruido";
				for (Coordenada co : barco.getPosicion().getCoordenadas()) {
					cambios = cambios + ";" + co.getX() + "," + co.getY();
				}
				setChanged();
				notifyObservers(cambios);
			} else
				destruido = 2;// tenia escudo
		}catch (BarcoNoEncException e){destruido = 0;}// no hay barco
		return destruido;
	}

	public void usarBomba(Coordenada pCoordenada) {
		Battleship.getBattleship().getOrdenador().tocarBarco(pCoordenada);
	}

	public void usarMisil(Coordenada pCoordenada) {
		Battleship.getBattleship().getOrdenador().destruirBarco(pCoordenada);
		super.getArmamento().rmvMisil();
	}

	public void usarMisilNS(Coordenada pCoordenada) {
		ListaBarcos listaBa = new ListaBarcos();
		ArrayList<Coordenada> listaCo = new ArrayList<Coordenada>();
		Coordenada c;
		for (int y = 0; y < DatosJuego.FILAS_TABLERO; y++) {
			c = new Coordenada(pCoordenada.getX(), y);
			try{
				listaBa.buscarBarco(c);
			}catch (BarcoNoEncException e){
				try{
					listaBa.addBarco(Battleship.getBattleship().getOrdenador().getListaBarcos().buscarBarco(c));
					listaCo.add(c);
				}catch (BarcoNoEncException e2){}
			}
		}
		for (Coordenada co : listaCo)
			Battleship.getBattleship().getOrdenador().destruirBarco(co);
		super.getArmamento().rmvMisilNS();
	}

	public void usarMisilEO(Coordenada pCoordenada) {
		ListaBarcos listaBa = new ListaBarcos();
		ArrayList<Coordenada> listaCo = new ArrayList<Coordenada>();
		Coordenada c;
		for (int x = 0; x < DatosJuego.COLUMNAS_TABLERO; x++) {
			c = new Coordenada(x, pCoordenada.getY());
			try{
				listaBa.buscarBarco(c);
			}catch (BarcoNoEncException e){
				try{
					listaBa.addBarco(Battleship.getBattleship().getOrdenador().getListaBarcos().buscarBarco(c));
					listaCo.add(c);
				}catch (BarcoNoEncException e2){}
			}
		}
		for (Coordenada co : listaCo)
			Battleship.getBattleship().getOrdenador().destruirBarco(co);
		super.getArmamento().rmvMisilEO();
	}

	public void usarMisilBOOM(Coordenada pCoordenada) {
		super.getArmamento().addMisilNS();
		usarMisilNS(pCoordenada);
		ListaBarcos listaBa = new ListaBarcos();
		ArrayList<Coordenada> listaCo = new ArrayList<Coordenada>();
		Coordenada c;
		for (int x = 0; x < DatosJuego.COLUMNAS_TABLERO; x++) {
			c = new Coordenada(x, pCoordenada.getY());
			try{
				listaBa.buscarBarco(c);
			}catch (BarcoNoEncException e){
				try{
					if(!pCoordenada.isEqual(c)){
						listaBa.addBarco(Battleship.getBattleship().getOrdenador().getListaBarcos().buscarBarco(c));
						listaCo.add(c);
					}
				}catch (BarcoNoEncException e2){}
			}
		}
		for (Coordenada co : listaCo)
			Battleship.getBattleship().getOrdenador().destruirBarco(co);
		super.getArmamento().rmvMisilBOOM();
	}
}