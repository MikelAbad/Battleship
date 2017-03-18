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
		if (Inicio.getInicio().getLongitud()>0){
			JButton btn = (JButton)e.getSource();
			String coor[] = btn.getName().split(",");
			Coordenada c = new Coordenada(Integer.parseInt(coor[0]), Integer.parseInt(coor[1]));
			if (!Battleship.getBattleship().colocarBarcoUs(c,
					Inicio.getInicio().getLongitud(), Inicio.getInicio().isVertical())){
				JOptionPane.showMessageDialog(null, 
						"Seleccione una casilla correcta, porfavor!", "Alerta", JOptionPane.WARNING_MESSAGE);				
			}
			else {
				Inicio.getInicio().decrementarCont(Battleship.getBattleship().barcosXPonRestantes(Inicio.getInicio().getLongitud()));
				Inicio.getInicio().deshabilitarBotones(btn);
				Inicio.getInicio().pintarBarco(btn);
				
				
			}
		}
		else JOptionPane.showMessageDialog(null, 
				"Seleccione algun barco para comenzar la colocacion, porfavor!", "Alerta", JOptionPane.WARNING_MESSAGE);
	}
	
	@Override
	public void mouseExited(MouseEvent e) {
		if (Inicio.getInicio().getLongitud()>0){
			JButton btn = (JButton)e.getSource();
			Inicio.getInicio().despintarBarco(btn);
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		if (Inicio.getInicio().getLongitud()>0){
			JButton btn = (JButton)e.getSource();
			Inicio.getInicio().pintarBarco(btn);
		}
	}
}
