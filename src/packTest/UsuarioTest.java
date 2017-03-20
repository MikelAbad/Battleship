package packTest;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import packModelo.packBarcos.Barco;
import packModelo.packCoordenada.Coordenada;
import packModelo.packJugador.Jugador;
import packModelo.packJugador.Usuario;

public class UsuarioTest {

	@Test
	public void testPuedePonerUs() {
		Usuario u = new Usuario();
		Barco unBarco;
		
		// Puede poner un barco de longitud 4 sin tener más barcos de 4
		unBarco = new Barco(new Coordenada(0,0), 4, true);
		assertTrue(u.puedePonerUs(unBarco));
		u.colocarBarco(unBarco);
		// No puede poner otro barco de longitud 4
		unBarco = new Barco(new Coordenada(2,0), 4, false);
		assertFalse(u.puedePonerUs(unBarco));
		
		u = new Usuario();
		
		// Puede poner dos barcos de longitud 3
		unBarco = new Barco(new Coordenada(4,2), 3, true);
		assertTrue(u.puedePonerUs(unBarco));
		u.colocarBarco(unBarco);
		unBarco = new Barco(new Coordenada(6,2), 3, true);
		assertTrue(u.puedePonerUs(unBarco));
		u.colocarBarco(unBarco);
		// No puede poner otro de tamaño 3
		unBarco = new Barco(new Coordenada(0,0), 3, false);
		assertFalse(u.puedePonerUs(unBarco));
		
		u = new Usuario();
		
		// Puede poner tres barcos de longitud 2
		unBarco = new Barco(new Coordenada(0,0), 2, true);
		assertTrue(u.puedePonerUs(unBarco));
		u.colocarBarco(unBarco);
		unBarco = new Barco(new Coordenada(2,0), 2, true);
		assertTrue(u.puedePonerUs(unBarco));
		u.colocarBarco(unBarco);
		unBarco = new Barco(new Coordenada(4,0), 2, true);
		assertTrue(u.puedePonerUs(unBarco));
		u.colocarBarco(unBarco);
		// No puede poner otro de tamaño 2
		unBarco = new Barco(new Coordenada(6,0), 2, false);
		assertFalse(u.puedePonerUs(unBarco));
		
		u = new Usuario();
		
		// Puede poner cuatro barcos de longitud 1
		unBarco = new Barco(new Coordenada(0,0), 1, true);
		assertTrue(u.puedePonerUs(unBarco));
		u.colocarBarco(unBarco);
		unBarco = new Barco(new Coordenada(2,0), 1, true);
		assertTrue(u.puedePonerUs(unBarco));
		u.colocarBarco(unBarco);
		unBarco = new Barco(new Coordenada(4,0), 1, true);
		assertTrue(u.puedePonerUs(unBarco));
		u.colocarBarco(unBarco);
		unBarco = new Barco(new Coordenada(6,0), 1, true);
		assertTrue(u.puedePonerUs(unBarco));
		u.colocarBarco(unBarco);
		// No puede poner otro de tamaño 1
		unBarco = new Barco(new Coordenada(8,0), 1, false);
		assertFalse(u.puedePonerUs(unBarco));
	}

}
