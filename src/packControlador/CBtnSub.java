package packControlador;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import packVista.Inicio;

public class CBtnSub implements MouseListener {

	@Override
	public void mousePressed(MouseEvent e) {
		Inicio.getInicio().setLongitud(3);
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
