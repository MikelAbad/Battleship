package packTest;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import packModelo.Almacen;
import packModelo.packJugador.Usuario;

public class AlmacenTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testPuedeVender() {
		Almacen a = Almacen.getAlmacen();
		Usuario u = new Usuario();
		Usuario u2 = new Usuario();
		assertTrue(a.puedeVender(0, u));
		a.venderEscudo(u);
		assertTrue(a.puedeVender(0, u2));
		a.venderEscudo(u2);
		assertTrue(a.puedeVender(0, u));
		a.venderEscudo(u);
		assertTrue(a.puedeVender(0, u));
		a.venderEscudo(u);
		// Hasta aquí u deberia tener 25, u2 75, y 1 escudo en el almacen
		assertTrue(a.puedeVender(0, u));
		assertTrue(a.puedeVender(0, u2));
		a.venderEscudo(u);
		assertFalse(a.puedeVender(0, u));// Ni quedan escudos ni u tiene dinero
		assertFalse(a.puedeVender(0, u2));//No quedan escudos
		assertFalse(a.puedeVender(1, u));// u no tiene dinero
		assertTrue(a.puedeVender(1, u2));//quedan misiles y u2 tiene 75 de dinero
		assertEquals(u2.getDinero(),75);
		assertEquals(u.getDinero(),0);
	}

	@Test
	public void testVenderEscudo() {
		Almacen a = Almacen.getAlmacen();
		Usuario u = new Usuario();
		a.venderEscudo(u);
		assertEquals(u.getDinero(), 75);
	}

	@Test
	public void testVenderMisil() {
		Almacen a = Almacen.getAlmacen();
		Usuario u = new Usuario();
		a.venderMisil(u);
		assertEquals(u.getDinero(), 90);
		a.venderMisil(u);
		assertEquals(u.getDinero(), 80);
	}

	@Test
	public void testVenderMisilNS() {
		Almacen a = Almacen.getAlmacen();
		Usuario u = new Usuario();
		assertEquals(u.getDinero(), 100);
		assertTrue(a.puedeVender(2, u));

		a.venderMisilNS(u);

		assertEquals(u.getDinero(), 55);
		assertFalse(a.puedeVender(2, u));
	}

	@Test
	public void testVenderMisilEO() {
		Almacen a = Almacen.getAlmacen();
		Usuario u = new Usuario();
		assertEquals(u.getDinero(), 100);
		assertTrue(a.puedeVender(3, u));

		a.venderMisilEO(u);

		assertEquals(u.getDinero(), 55);
		assertFalse(a.puedeVender(3, u));
	}

	@Test
	public void testVenderMisilBOOM() {
		Almacen a = Almacen.getAlmacen();
		Usuario u = new Usuario();
		assertEquals(u.getDinero(), 100);
		assertTrue(a.puedeVender(4, u));

		a.venderMisilBOOM(u);

		assertEquals(u.getDinero(), 10);
		assertFalse(a.puedeVender(4, u));
		assertTrue(a.puedeVender(1, u));

	}

}
