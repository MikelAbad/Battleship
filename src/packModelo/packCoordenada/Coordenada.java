package packModelo.packCoordenada;

import java.util.ArrayList;

public class Coordenada {
	private int x;
	private int y;

	public Coordenada(int pX, int pY) {
		this.x = pX;
		this.y = pY;
	}

	public int getX() {return this.x;}
	public int getY() {return this.y;}

	public ArrayList<Coordenada> getAdyacentes() {
		ArrayList<Coordenada> adyacentes = new ArrayList<Coordenada>();
		// La propia coordenada
		adyacentes.add(new Coordenada(x,y));
		// A los lados de la coordenada
		adyacentes.add(new Coordenada(x-1,y));
		adyacentes.add(new Coordenada(x+1,y));
		// Encima de la coordenada (de izq a der)
		adyacentes.add(new Coordenada(x-1,y-1));
		adyacentes.add(new Coordenada(x,y-1));
		adyacentes.add(new Coordenada(x+1,y-1));
		// Debajo de la coordenada (de izq a der)
		adyacentes.add(new Coordenada(x-1,y+1));
		adyacentes.add(new Coordenada(x,y+1));
		adyacentes.add(new Coordenada(x+1,y+1));
		return adyacentes;
	}
}