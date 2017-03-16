package packControlador;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import packVista.Inicio;

public class CBtnPort extends MouseAdapter {

	@Override
	public void mouseClicked(MouseEvent e) {
		Inicio.getInicio().setLongitud(4);
	}
}
