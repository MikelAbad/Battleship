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
		Coordenada c = new Coordenada(Integer.parseInt(coor[0]), Integer.parseInt(coor[1]));
		if(TableroJuego.getTableroJuego().getArma()==DatosJuego.NUM_MOVER_RADAR){
			TableroJuego.getTableroJuego().setRadar(Integer.parseInt(coor[0]), Integer.parseInt(coor[1]));
			Battleship.getBattleship().moverRadar(c);
		}
		else if (btn.isEnabled()) {
			if (TableroJuego.getTableroJuego().getArma() != DatosJuego.NUM_ESCUDO) {
				if (Battleship.getBattleship().puedeUsar(TableroJuego.getTableroJuego().getArma())) {
					switch (TableroJuego.getTableroJuego().getArma()){
					case DatosJuego.NUM_BOMBA:
						Battleship.getBattleship().usarBomba(c);
						break;
					case DatosJuego.NUM_MISIL:
						Battleship.getBattleship().usarMisil(c);
						break;
					case DatosJuego.NUM_MISIL_NS:
						Battleship.getBattleship().usarMisilNS(c);
						break;
					case DatosJuego.NUM_MISIL_EO:
						Battleship.getBattleship().usarMisilEO(c);
						break;
					case DatosJuego.NUM_MISIL_BOOM:
						Battleship.getBattleship().usarMisilBOOM(c);
						break;	
					}
				}else JOptionPane.showMessageDialog(null, "¡No dispone de unidades de armamento suficiente!", "Alerta",
						JOptionPane.WARNING_MESSAGE);
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