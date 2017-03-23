package packTest;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import packModelo.packBarcos.Barco;
import packModelo.packBarcos.Destructor;
import packModelo.packBarcos.Fragata;
import packModelo.packBarcos.Portaaviones;
import packModelo.packBarcos.Submarino;
import packModelo.packCoordenada.Coordenada;

public class BarcoTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Test
	public void testTocar() {
		fail("Not yet implemented");
	}

	@Test
	public void testReparar() {
		fail("Not yet implemented");
	}

	@Test
	public void testEstaDestruido() {
		fail("Not yet implemented");
	}

	@Test
	public void testPonerEscudo() {
		fail("Not yet implemented");
	}

	@Test
	public void testDestruir() {
		fail("Not yet implemented");
	}

	@Test
	public void testEstaEnPos() {
		Barco b = new Portaaviones(new Coordenada(0,0), true);
		assertTrue(b.estaEnPos(new Coordenada(0,0)));
		assertTrue(b.estaEnPos(new Coordenada(1,0)));
		assertTrue(b.estaEnPos(new Coordenada(2,0)));
		assertTrue(b.estaEnPos(new Coordenada(3,0)));
		assertFalse(b.estaEnPos(new Coordenada(0,4)));
		assertFalse(b.estaEnPos(new Coordenada(0,1)));
	}

	@Test
	public void testFueraDeLimites() {
		Barco b = new Portaaviones(new Coordenada(0,0), true);
		assertFalse(b.fueraDeLimites());
		Barco b2 = new Portaaviones(new Coordenada(7,0), true);
		assertTrue(b2.fueraDeLimites());
		Barco b3 =  new Fragata(new Coordenada(10,0));
		assertTrue(b3.fueraDeLimites());
		Barco b4 =  new Submarino(new Coordenada(5,9),false);
		assertTrue(b4.fueraDeLimites());
		Barco b5 =  new Submarino(new Coordenada(5,5),false);
		assertFalse(b.fueraDeLimites());
	}

	@Test
	public void testCalcularAdyacentes() {
		Barco b = new Destructor(new Coordenada(0,0), true);
		ArrayList<Coordenada> adyacentes = b.calcularAdyacentes();
		
		ArrayList<Coordenada> misAdyacentes = new ArrayList<Coordenada>();
		// Barco
		misAdyacentes.add(new Coordenada(0,0));
		misAdyacentes.add(new Coordenada(0,1));
		// Arriba y abajo
		misAdyacentes.add(new Coordenada(0,-1));
		misAdyacentes.add(new Coordenada(0,2));
		// Derecha
		misAdyacentes.add(new Coordenada(-1,1));
		misAdyacentes.add(new Coordenada(0,1));
		misAdyacentes.add(new Coordenada(1,1));
		misAdyacentes.add(new Coordenada(2,1));
		// Izquierda
		misAdyacentes.add(new Coordenada(-1,-1));
		misAdyacentes.add(new Coordenada(-1,0));
		misAdyacentes.add(new Coordenada(-1,1));
		misAdyacentes.add(new Coordenada(-1,2));

		assertEquals(misAdyacentes.size(),adyacentes.size());
		
	}

}
