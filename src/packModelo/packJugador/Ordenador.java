package packModelo.packJugador;

import java.util.ArrayList;
import java.util.Random;

import com.sun.java.accessibility.util.java.awt.ListTranslator;

import packModelo.Battleship;
import packModelo.DatosJuego;
import packModelo.packBarcos.Barco;
import packModelo.packBarcos.Destructor;
import packModelo.packBarcos.Fragata;
import packModelo.packBarcos.ListaBarcos;
import packModelo.packBarcos.Portaaviones;
import packModelo.packBarcos.Submarino;
import packModelo.packCoordenada.Coordenada;
import packModelo.packCoordenada.ListaCoordenadas;

public class Ordenador extends Jugador {

	private ListaCoordenadas listNoDisparar;
	private ListaCoordenadas listDisparar;
	private ListaCoordenadas listTocadas;

	public Ordenador() {
		super();
		listNoDisparar = new ListaCoordenadas();
		listDisparar = new ListaCoordenadas();
		listTocadas = new ListaCoordenadas();
	}

	public void Jugar() {
		// TODO SegundoSprint
	}

	public void colocarBarcosOrd() {
		Random rdn = new Random();
		int barcosPuestos;
		Barco unBarco;

		// Portaaviones (1)
		boolean puesto = false;
		while (!puesto) {
			unBarco = new Portaaviones(new Coordenada(rdn.nextInt(DatosJuego.COLUMNAS_TABLERO - 1),
					rdn.nextInt(DatosJuego.FILAS_TABLERO - 1)), rdn.nextBoolean());
			if (puedeColocar(unBarco)) {
				anadirAdyacentesBarco(unBarco);
				anadirBarcoProp(unBarco);
				puesto = true;
			}
		}

		// Submarinos (2)
		barcosPuestos = 0;
		while (barcosPuestos < DatosJuego.NUM_SUBMARINO) {
			unBarco = new Submarino(new Coordenada(rdn.nextInt(DatosJuego.COLUMNAS_TABLERO - 1),
					rdn.nextInt(DatosJuego.FILAS_TABLERO - 1)), rdn.nextBoolean());
			if (puedeColocar(unBarco)) {
				anadirAdyacentesBarco(unBarco);
				anadirBarcoProp(unBarco);
				barcosPuestos++;
			}
		}

		// Destructores (3)
		barcosPuestos = 0;
		while (barcosPuestos < DatosJuego.NUM_DESTRUCTOR) {
			unBarco = new Destructor(new Coordenada(rdn.nextInt(DatosJuego.COLUMNAS_TABLERO - 1),
					rdn.nextInt(DatosJuego.FILAS_TABLERO - 1)), rdn.nextBoolean());
			if (puedeColocar(unBarco)) {
				anadirAdyacentesBarco(unBarco);
				anadirBarcoProp(unBarco);
				barcosPuestos++;
			}
		}

		// Fragata (4)
		barcosPuestos = 0;
		while (barcosPuestos < DatosJuego.NUM_FRAGATA) {
			unBarco = new Fragata(new Coordenada(rdn.nextInt(DatosJuego.COLUMNAS_TABLERO - 1),
					rdn.nextInt(DatosJuego.FILAS_TABLERO - 1)));
			if (puedeColocar(unBarco)) {
				anadirAdyacentesBarco(unBarco);
				anadirBarcoProp(unBarco);
				barcosPuestos++;
			}
		}
	}

	public void imprimirTablero() {
		System.out.println("Barcos del ordenador:");
		getListaBarcos().imprimirTablero();
	}

	public void recibirEscaRadar() {
		String infoRadar;
		boolean detectado = false;;
		infoRadar = "scan";
		ArrayList<Coordenada> escaneadas = super.getRadar().escanear();
		for (Coordenada co : escaneadas) {
			if (hayBarco(co)) {
				infoRadar = infoRadar + ";" + co.getX() + "," + co.getY(); // Barcos
				detectado = true;
			}
		}
		if (detectado) notificarRadar(infoRadar);
	}

	private void usarRadar() {
		ArrayList<Coordenada> listas[] = Battleship.getBattleship().getUsuario().recibirEscaRadar();
		listNoDisparar.addCoordenadas(listas[0]);
		listDisparar.addCoordenadas(listas[1]);
	}

	public void tocarBarco(Coordenada pCoordenada) {
		if (hayBarco(pCoordenada)) {
			switch (super.getListaBarcos().buscarBarco(pCoordenada).tocar(pCoordenada)) {
			case 1:
				String cambios = "tocada;" + pCoordenada.getX() + "," + pCoordenada.getY();
				setChanged();
				notifyObservers(cambios);
				break;
			case 2:
				String cambios1 = "escudo;" + pCoordenada.getX() + "," + pCoordenada.getY();
				setChanged();
				notifyObservers(cambios1);
				break;
			case 3:
				Barco barco1 = super.getListaBarcos().buscarBarco(pCoordenada);
				String cambios11 = "destruido";
				for (Coordenada co : barco1.getPosicion().getCoordenadas()) {
					cambios11 = cambios11 + ";" + co.getX() + "," + co.getY();
				}
				setChanged();
				notifyObservers(cambios11);
				break;
			case 4:
				String cambios111 = "detectado;" + pCoordenada.getX() + "," + pCoordenada.getY();
				setChanged();
				notifyObservers(cambios111);
				break;
			}
		}
	}

	public void destruirBarco(Coordenada pCoordenada) {
		if (hayBarco(pCoordenada)) {
			if (super.getListaBarcos().buscarBarco(pCoordenada).destruir()) {
				Barco barco = super.getListaBarcos().buscarBarco(pCoordenada);
				String cambios = "destruido";
				for (Coordenada co : barco.getPosicion().getCoordenadas()) {
					cambios = cambios + ";" + co.getX() + "," + co.getY();
				}
				setChanged();
				notifyObservers(cambios);
			} else {
				String cambios = "escudo;" + pCoordenada.getX() + "," + pCoordenada.getY();
				setChanged();
				notifyObservers(cambios);
			}
		}
	}

	private void usarBomba(Coordenada pCoordenada) {
		switch (Battleship.getBattleship().getUsuario().tocarBarco(pCoordenada)) {
		case 0:
			listNoDisparar.addCoordenada(pCoordenada);
			break;
		case 1:
			listNoDisparar.addCoordenada(pCoordenada);
			listTocadas.addCoordenada(pCoordenada);
			break;
		case 2:
		case 4:
			listDisparar.addCoordenada(pCoordenada);
			break;
		case 3:
			Barco barco = Battleship.getBattleship().getUsuario().getListaBarcos().buscarBarco(pCoordenada);
			getBarcosEneDest().addBarco(barco);
			listNoDisparar.addCoordenadas(barco.calcularAdyacentes());
			break;
		}
	}

	private void usarMisil(Coordenada pCoordenada) {
		switch (Battleship.getBattleship().getUsuario().destruirBarco(pCoordenada)) {
		case 0:
			listNoDisparar.addCoordenada(pCoordenada);
			break;
		case 1:
			Barco barco = Battleship.getBattleship().getUsuario().getListaBarcos().buscarBarco(pCoordenada);
			getBarcosEneDest().addBarco(barco);
			listNoDisparar.addCoordenadas(barco.calcularAdyacentes());
			break;
		case 2:
			listDisparar.addCoordenada(pCoordenada);
			break;
		}
		super.getArmamento().rmvMisil();
	}

	private void usarMisilNS(Coordenada pCoordenada) {
		ListaBarcos listaBa = new ListaBarcos();
		ArrayList<Coordenada> listaCo = new ArrayList<Coordenada>();
		Coordenada c;
		for (int y = 0; y < DatosJuego.FILAS_TABLERO; y++) {
			c = new Coordenada(pCoordenada.getX(), y);
			if (listaBa.buscarBarco(c) == null) {
				listaBa.addBarco(Battleship.getBattleship().getUsuario().getListaBarcos().buscarBarco(c));
				listaCo.add(c);
			}
		}
		for (Coordenada co : listaCo) {
			super.getArmamento().addMisil();
			usarMisil(co);
		}
		super.getArmamento().rmvMisilNS();
	}

	private void usarMisilEO(Coordenada pCoordenada) {
		ListaBarcos listaBa = new ListaBarcos();
		ArrayList<Coordenada> listaCo = new ArrayList<Coordenada>();
		Coordenada c;
		for (int x = 0; x < DatosJuego.COLUMNAS_TABLERO; x++) {
			c = new Coordenada(x, pCoordenada.getY());
			if (listaBa.buscarBarco(c) == null) {
				listaBa.addBarco(Battleship.getBattleship().getUsuario().getListaBarcos().buscarBarco(c));
				listaCo.add(c);
			}
		}
		for (Coordenada co : listaCo) {
			super.getArmamento().addMisil();
			usarMisil(co);
		}
		super.getArmamento().rmvMisilEO();
	}

	private void usarMisilBOOM(Coordenada pCoordenada) {
		super.getArmamento().addMisilNS();
		usarMisilNS(pCoordenada);
		ListaBarcos listaBa = new ListaBarcos();
		ArrayList<Coordenada> listaCo = new ArrayList<Coordenada>();
		Coordenada c;
		for (int x = 0; x < DatosJuego.COLUMNAS_TABLERO; x++) {
			c = new Coordenada(x, pCoordenada.getY());
			if (listaBa.buscarBarco(c) == null && !pCoordenada.isEqual(c)) {
				listaBa.addBarco(Battleship.getBattleship().getUsuario().getListaBarcos().buscarBarco(c));
				listaCo.add(c);
			}
		}
		for (Coordenada co : listaCo) {
			super.getArmamento().addMisil();
			usarMisil(co);
		}
		super.getArmamento().rmvMisilBOOM();
	}

}