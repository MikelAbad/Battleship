package packTest;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import packModelo.Battleship;
import packModelo.packCoordenada.Coordenada;

public class BattleshipTest {

	@Before
	public void setUp() throws Exception {
		Battleship.getBattleship().inicializar();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testJugar() {
		fail("Not yet implemented");
	}
	
	@Test
	public void testColocarBarcoUs() {		
		
		Battleship.getBattleship().colocarBarcoUs("Portaaviones", new Coordenada(0,0), true);
		assertTrue(Battleship.getBattleship().hayBarcoUsu(new Coordenada(0,0)));
		assertTrue(Battleship.getBattleship().hayBarcoUsu(new Coordenada(1,0)));
		assertTrue(Battleship.getBattleship().hayBarcoUsu(new Coordenada(2,0)));
		assertTrue(Battleship.getBattleship().hayBarcoUsu(new Coordenada(3,0)));
		assertFalse(Battleship.getBattleship().hayBarcoUsu(new Coordenada(4,0)));
		
		Battleship.getBattleship().colocarBarcoUs("Submarino", new Coordenada(4,4), false);
		assertTrue(Battleship.getBattleship().hayBarcoUsu(new Coordenada(4,4)));
		assertTrue(Battleship.getBattleship().hayBarcoUsu(new Coordenada(4,5)));
		assertTrue(Battleship.getBattleship().hayBarcoUsu(new Coordenada(4,6)));	
		assertFalse(Battleship.getBattleship().hayBarcoUsu(new Coordenada(4,3)));
		assertFalse(Battleship.getBattleship().hayBarcoUsu(new Coordenada(4,7)));
		
		Battleship.getBattleship().colocarBarcoUs("Destructor", new Coordenada(6,6), false);
		assertTrue(Battleship.getBattleship().hayBarcoUsu(new Coordenada(6,6)));
		assertTrue(Battleship.getBattleship().hayBarcoUsu(new Coordenada(6,7)));		
		assertFalse(Battleship.getBattleship().hayBarcoUsu(new Coordenada(6,5)));
		assertFalse(Battleship.getBattleship().hayBarcoUsu(new Coordenada(6,8)));
		
		Battleship.getBattleship().colocarBarcoUs("Fragata", new Coordenada(9,9), true);
		assertTrue(Battleship.getBattleship().hayBarcoUsu(new Coordenada(9,9)));	
	}

	@Test
	public void testPuedeColocar() {
		assertTrue(Battleship.getBattleship().puedeColocar("Portaaviones", new Coordenada(0,0), true));
		Battleship.getBattleship().colocarBarcoUs("Portaaviones", new Coordenada(0,0), true);
		assertFalse(Battleship.getBattleship().puedeColocar("Fragata", new Coordenada(2,0),false));
		
		assertTrue(Battleship.getBattleship().puedeColocar("Submarino", new Coordenada(4,4), false));
		Battleship.getBattleship().colocarBarcoUs("Submarino", new Coordenada(4,4), false);
		
		assertTrue(Battleship.getBattleship().puedeColocar("Destructor", new Coordenada(6,6), false));
		Battleship.getBattleship().colocarBarcoUs("Destructor", new Coordenada(6,6), false);
	
		assertFalse(Battleship.getBattleship().puedeColocar("Portaaviones", new Coordenada(5,0),false));
		
		assertTrue(Battleship.getBattleship().puedeColocar("Fragata", new Coordenada(9,9), true));
		Battleship.getBattleship().colocarBarcoUs("Fragata", new Coordenada(9,9), true);
	
	}

	@Test
	public void testBarcosXPonRestantes() {
		assertEquals(Battleship.getBattleship().barcosXPonRestantes("Portaaviones"),1);
		Battleship.getBattleship().colocarBarcoUs("Portaaviones", new Coordenada(0,0), true);
		assertEquals(Battleship.getBattleship().barcosXPonRestantes("Portaaviones"),0);
		
		assertEquals(Battleship.getBattleship().barcosXPonRestantes("Submarino"),2);
		Battleship.getBattleship().colocarBarcoUs("Submarino", new Coordenada(4,4), false);
		assertEquals(Battleship.getBattleship().barcosXPonRestantes("Submarino"),1);
		
		assertEquals(Battleship.getBattleship().barcosXPonRestantes("Destructor"),3);
		Battleship.getBattleship().colocarBarcoUs("Destructor", new Coordenada(6,6), false);
		assertEquals(Battleship.getBattleship().barcosXPonRestantes("Destructor"),2);
		
		assertEquals(Battleship.getBattleship().barcosXPonRestantes("Fragata"),4);
		Battleship.getBattleship().colocarBarcoUs("Fragata", new Coordenada(9,9), true);
		assertEquals(Battleship.getBattleship().barcosXPonRestantes("Fragata"),3);
	}

	@Test
	public void testJuegoAcabado() {
		fail("Not yet implemented");
	}

	@Test
	public void testHasGanado() {
		fail("Not yet implemented");
	}

	@Test
	public void testUsarArmamento() {
		fail("Not yet implemented");
	}

}
