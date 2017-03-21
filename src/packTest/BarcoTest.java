package packTest;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import packModelo.packBarcos.Barco;
import packModelo.packBarcos.Destructor;
import packModelo.packBarcos.Portaaviones;
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
		assertTrue(b.estaEnPos(new Coordenada(0,1)));
		assertTrue(b.estaEnPos(new Coordenada(0,2)));
		assertTrue(b.estaEnPos(new Coordenada(0,3)));
		assertFalse(b.estaEnPos(new Coordenada(0,4)));
		assertFalse(b.estaEnPos(new Coordenada(1,0)));
	}

	@Test
	public void testComprobarLimites() {
		Barco b = new Portaaviones(new Coordenada(0,0), true);
		assertTrue(b.fueraDeLimites());
		Barco b2 = new Portaaviones(new Coordenada(7,0), true);
		assertFalse(b2.fueraDeLimites());
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
