package packTest;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import packModelo.Battleship;
import packModelo.packBarcos.Barco;
import packModelo.packBarcos.Destructor;
import packModelo.packBarcos.Fragata;
import packModelo.packBarcos.Portaaviones;
import packModelo.packBarcos.Submarino;
import packModelo.packCoordenada.Coordenada;
import packModelo.packJugador.Usuario;

public class UsuarioTest {
	
	@Before
	public void setUp() throws Exception {
		Battleship.getBattleship().inicializar();
	}


	@Test
	public void testPuedePonerUs() {
		Usuario u = new Usuario();
		Barco unBarco;
		
		// Puede poner un barco de longitud 4 sin tener más barcos de 4
		unBarco = new Portaaviones(new Coordenada(0,0), true);
		assertTrue(u.puedePonerUs(unBarco));
		u.colocarBarco(unBarco);
		// No puede poner otro barco de longitud 4
		unBarco = new Portaaviones(new Coordenada(2,0), false);
		assertFalse(u.puedePonerUs(unBarco));
		
		u = new Usuario();
		
		// Puede poner dos barcos de longitud 3
		unBarco = new Submarino(new Coordenada(4,2), true);
		assertTrue(u.puedePonerUs(unBarco));
		u.colocarBarco(unBarco);
		unBarco = new Submarino(new Coordenada(6,2), true);
		assertTrue(u.puedePonerUs(unBarco));
		u.colocarBarco(unBarco);
		// No puede poner otro de tamaño 3
		unBarco = new Submarino(new Coordenada(0,0), false);
		assertFalse(u.puedePonerUs(unBarco));
		
		u = new Usuario();
		
		// Puede poner tres barcos de longitud 2
		unBarco = new Destructor(new Coordenada(0,0), true);
		assertTrue(u.puedePonerUs(unBarco));
		u.colocarBarco(unBarco);
		unBarco = new Destructor(new Coordenada(2,0), true);
		assertTrue(u.puedePonerUs(unBarco));
		u.colocarBarco(unBarco);
		unBarco = new Destructor(new Coordenada(4,0), true);
		assertTrue(u.puedePonerUs(unBarco));
		u.colocarBarco(unBarco);
		// No puede poner otro de tamaño 2
		unBarco = new Destructor(new Coordenada(6,0), true);
		assertFalse(u.puedePonerUs(unBarco));
		
		u = new Usuario();
		
		// Puede poner cuatro barcos de longitud 1
		unBarco = new Fragata(new Coordenada(0,0));
		assertTrue(u.puedePonerUs(unBarco));
		u.colocarBarco(unBarco);
		unBarco = new Fragata(new Coordenada(2,0));
		assertTrue(u.puedePonerUs(unBarco));
		u.colocarBarco(unBarco);
		unBarco = new Fragata(new Coordenada(4,0));
		assertTrue(u.puedePonerUs(unBarco));
		u.colocarBarco(unBarco);
		unBarco = new Fragata(new Coordenada(6,0));
		assertTrue(u.puedePonerUs(unBarco));
		u.colocarBarco(unBarco);
		// No puede poner otro de tamaño 1
		unBarco = new Fragata(new Coordenada(8,0));
		assertFalse(u.puedePonerUs(unBarco));
	}

}
