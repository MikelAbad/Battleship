package packControlador.ContTablero;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import packModelo.DatosJuego;
import packVista.TableroJuego;

public class CBtnUsarMisilEO implements MouseListener{
	@Override
	public void mousePressed(MouseEvent e) {
		TableroJuego.getTableroJuego().setArma(DatosJuego.NUM_MISIL_EO);
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {}

	@Override
	public void mouseEntered(MouseEvent e) {}

	@Override
	public void mouseExited(MouseEvent e) {}

	@Override
	public void mouseReleased(MouseEvent e) {}
}
