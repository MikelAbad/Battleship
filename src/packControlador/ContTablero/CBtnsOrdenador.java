package packControlador.ContTablero;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import packModelo.Battleship;
import packModelo.DatosJuego;
import packModelo.packCoordenada.Coordenada;
import packVista.TableroJuego;

public class CBtnsOrdenador implements MouseListener {
	@Override
	public void mousePressed(MouseEvent e) {
		JButton btn = (JButton) e.getSource();
		String coor[] = btn.getName().split(",");
		if(TableroJuego.getTableroJuego().getArma()==DatosJuego.NUM_MOVER_RADAR){
			TableroJuego.getTableroJuego().setRadar(Integer.parseInt(coor[0]), Integer.parseInt(coor[1]));
		}
		else if (btn.isEnabled()) {
			Coordenada c = new Coordenada(Integer.parseInt(coor[0]), Integer.parseInt(coor[1]));
			if (TableroJuego.getTableroJuego().getArma() != DatosJuego.NUM_ESCUDO) {
				if (!Battleship.getBattleship().usarArmamento(TableroJuego.getTableroJuego().getArma(), c)) {
					JOptionPane.showMessageDialog(null, "¡No es posible utilizar!", "Alerta",
							JOptionPane.WARNING_MESSAGE);
				}
			} else {
				JOptionPane.showMessageDialog(null, "¡Seleccione armamento correcto!", "Alerta",
						JOptionPane.WARNING_MESSAGE);
			}
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
	}

	@Override
	public void mouseEntered(MouseEvent e) {
	}

	@Override
	public void mouseExited(MouseEvent e) {
	}

	@Override
	public void mouseReleased(MouseEvent e) {
	}
}