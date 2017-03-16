package packControlador;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import packVista.Inicio;

public class CBtnDest extends MouseAdapter {

	@Override
	public void mouseClicked(MouseEvent e) {
		Inicio.getInicio().setLongitud(2);
	}
}
