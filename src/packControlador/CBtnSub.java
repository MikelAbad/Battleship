package packControlador;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import packVista.Inicio;

public class CBtnSub extends MouseAdapter {

	@Override
	public void mouseClicked(MouseEvent e) {
		Inicio.getInicio().setLongitud(3);
	}
}
