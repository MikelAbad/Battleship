package packTest;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import packModelo.packBarcos.Barco;
import packModelo.packCoordenada.Coordenada;
import packModelo.packJugador.Usuario;

public class TestJugador {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Test
	public void testTocarBarco() {
		fail("Not yet implemented");
	}

	@Test
	public void testDestruirBarco() {
		fail("Not yet implemented");
	}

	@Test
	public void testPonerEscudo() {
		fail("Not yet implemented");
	}

	@Test
	public void testUsarBomba() {
		fail("Not yet implemented");
	}

	@Test
	public void testUsarMisil() {
		fail("Not yet implemented");
	}

	@Test
	public void testUsarMisilNS() {
		fail("Not yet implemented");
	}

	@Test
	public void testUsarMisilEO() {
		fail("Not yet implemented");
	}

	@Test
	public void testUsarMisilBOOM() {
		fail("Not yet implemented");
	}

	@Test
	public void testUsarEscudo() {
		fail("Not yet implemented");
	}

	@Test
	public void testPuedePoner() {
		Usuario u = new Usuario();
		Barco b = new Barco(new Coordenada(0,0), 4, false);
		u.colocarBarco(b);
		Barco b2 = new Barco(new Coordenada(0,0), 3, true);
		assertFalse(u.puedePoner(b2));
	}

}
