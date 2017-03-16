package packControlador;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import packModelo.Battleship;
import packModelo.packCoordenada.Coordenada;
import packVista.Inicio;

public class CBtnsColocar extends MouseAdapter {

	@Override
	public void mouseClicked(MouseEvent e) {
		JButton btn = (JButton)e.getSource();
		String coor[] = btn.getName().split(",");
		Coordenada c = new Coordenada(Integer.parseInt(coor[0]), Integer.parseInt(coor[1]));
		if (!Battleship.getBattleship().colocarBarcoUs(c,
				Inicio.getInicio().getLongitud(), Inicio.getInicio().isVertical())){
			JOptionPane.showMessageDialog(null, 
					"Seleccione un barco valido en unca casilla correcta, porfavor!", "Alerta", JOptionPane.WARNING_MESSAGE);				
		}
		else {
			Inicio.getInicio().pintarBarco(btn);
		}
	}
	
	@Override
	public void mouseExited(MouseEvent e) {
		JButton btn = (JButton)e.getSource();
		Inicio.getInicio().despintarBarco(btn);
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		JButton btn = (JButton)e.getSource();
		Inicio.getInicio().pintarBarco(btn);
	}
}
