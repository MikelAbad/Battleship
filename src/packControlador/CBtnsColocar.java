package packControlador;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import packModelo.Battleship;
import packModelo.packCoordenada.Coordenada;
import packVista.Inicio;

public class CBtnsColocar implements MouseListener {

	@Override
	public void mousePressed(MouseEvent e) {
		if (Inicio.getInicio().getTipo() != null) {
			JButton btn = (JButton) e.getSource();
			String coor[] = btn.getName().split(",");
			Coordenada c = new Coordenada(Integer.parseInt(coor[0]), Integer.parseInt(coor[1]));
			if (!Battleship.getBattleship().colocarBarcoUs(Inicio.getInicio().getTipo(), c, Inicio.getInicio().isVertical())) {
				JOptionPane.showMessageDialog(null, "¡Seleccione una posición correcta, por favor!", "Alerta",
						JOptionPane.WARNING_MESSAGE);
			} else {
				Inicio.getInicio().deshabilitarBotones(btn);
				Inicio.getInicio().pintarBarcoPuesto(btn);
				Inicio.getInicio().decrementarCont(Battleship.getBattleship().barcosXPonRestantes(Inicio.getInicio().getTipo()));
			}
		} else {
			JOptionPane.showMessageDialog(null, "¡Seleccione algún barco para comenzar la colocación, por favor!",
					"Alerta", JOptionPane.WARNING_MESSAGE);
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		if (Inicio.getInicio().getTipo() != null) {
			JButton btn = (JButton) e.getSource();
			Inicio.getInicio().pintarBarcoMoviendo(btn);
		}
	}

	@Override
	public void mouseExited(MouseEvent e) {
		if (Inicio.getInicio().getTipo() != null) {
			JButton btn = (JButton) e.getSource();
			Inicio.getInicio().despintarBarco(btn);
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {}
	
	@Override
	public void mouseReleased(MouseEvent e) {}
}
