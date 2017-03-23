package packTest;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import packModelo.packCoordenada.Coordenada;
import packModelo.packCoordenada.ListaCoordenadas;

public class ListaCoordenadasTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}
	
	@Test
	public void testEstaEnLista() {		
		Coordenada c=new Coordenada(3,3);
		ListaCoordenadas l=new ListaCoordenadas();
		assertFalse(l.getCoordenadas().contains(c));
		l.addCoordenada(c);
		assertTrue(l.getCoordenadas().contains(c));		
	}

		
	@Test
	public void testCalcularAdyacentes() {
		//esta probado en barcoTest
	}

	@Test
	public void testFueraDeLimites() {
		ListaCoordenadas l=new ListaCoordenadas();
		assertFalse(l.fueraDeLimites());
		Coordenada c=new Coordenada(3,3);
		l.addCoordenada(c);
		assertFalse(l.fueraDeLimites());
		Coordenada c2=new Coordenada(9,0);
		l.addCoordenada(c2);
		assertFalse(l.fueraDeLimites());
		Coordenada c3=new Coordenada(32,-3);
		l.addCoordenada(c3);
		assertTrue(l.fueraDeLimites());
		Coordenada c4=new Coordenada(-1,-13);
		l.addCoordenada(c4);
		assertTrue(l.fueraDeLimites());
	
		
	}

	
	@Test
	public void testComprobarListas() {
		ListaCoordenadas l=new ListaCoordenadas();
		ListaCoordenadas l2=new ListaCoordenadas();
		Coordenada c=new Coordenada(3,3);
		Coordenada c2=new Coordenada(9,0);
		Coordenada c3=new Coordenada(4,5);
		Coordenada c4=new Coordenada(2,7);
		assertFalse(l.comprobarListas(l2));
		l.addCoordenada(c);
		assertFalse(l.comprobarListas(l2));
		l.addCoordenada(c2);
		l2.addCoordenada(c3);
		l2.addCoordenada(c4);
		assertFalse(l.comprobarListas(l2));
		l.addCoordenada(c3);
		assertTrue(l.comprobarListas(l2));
		assertTrue(l2.comprobarListas(l));
		
		
	}

}
