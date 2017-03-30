package packVista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import packControlador.CBtnEscudo;
import packControlador.CBtnsUsuario;
import packModelo.Almacen;
import packModelo.Battleship;
import packModelo.DatosJuego;
import packModelo.packCoordenada.Coordenada;
import packModelo.packJugador.Jugador;

import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.util.Observable;
import java.util.Observer;
import java.awt.Component;
import java.awt.Dimension;
import javax.swing.SwingConstants;

public class TableroJuego extends JFrame implements Observer {

	private static TableroJuego miTableroJuego;
	private JPanel contentPane;
	private JPanel panelUsuario;
	private JPanel panelOrdenador;
	private JPanel panelBotones;
	private JPanel panelInformacion;
	private JLabel lblTurno;
	private JPanel panelArmas;
	private JLabel lblEscudo;
	private JButton btnEscudo;
	private JButton btnBomba;
	private JLabel lblMisil;
	private JButton btnMisil;
	private JButton[][] tableroUs;
	private JButton[][] tableroOrd;
	private int arma;
	private JLabel lblMisilEO;
	private JButton btnMisilEO;
	private JLabel lblMisilNS;
	private JButton btnMisilns;
	private JLabel lblMisilBOOM;
	private JButton btnMisilboom;
	private JLabel lblBomba;

	private TableroJuego() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		contentPane.add(getPanelUsuario(), BorderLayout.WEST);
		contentPane.add(getPanelOrdenador(), BorderLayout.EAST);
		contentPane.add(getPanelBotones(), BorderLayout.SOUTH);
		contentPane.add(getPanelInformacion(), BorderLayout.NORTH);
		contentPane.add(getPanelArmas(), BorderLayout.CENTER);
		crearTableroOrd();
		crearTableroUsu();
		int ancho = 950;
		int alto = 400;
		Dimension d = new Dimension(ancho, alto);
		this.setMinimumSize(d);
		this.setMaximumSize(d);
		this.setSize(d);
		arma = DatosJuego.NUM_BOMBA;
		Battleship.getBattleship().addObserver(this);
		Battleship.getBattleship().getUsuario().addObserver(this);;
	}

	private void crearTableroUsu() {
		tableroUs = new JButton[DatosJuego.COLUMNAS_TABLERO][DatosJuego.FILAS_TABLERO];

		for (int i = 0; i < DatosJuego.FILAS_TABLERO; i++) {
			for (int j = 0; j < DatosJuego.COLUMNAS_TABLERO; j++) {
				JButton btn = new JButton();
				btn.setName(j + "," + i);
				tableroUs[j][i] = btn;
				panelUsuario.add(btn);
				Coordenada c = new Coordenada(j, i);
				if (!Battleship.getBattleship().hayBarcoUsu(c))
					btn.setEnabled(false);
				else {
					btn.setBackground(Color.GREEN);
					btn.addMouseListener(new CBtnsUsuario());
				}
			}
		}
	}

	private void crearTableroOrd() {
		tableroOrd = new JButton[DatosJuego.COLUMNAS_TABLERO][DatosJuego.FILAS_TABLERO];

		for (int i = 0; i < DatosJuego.FILAS_TABLERO; i++) {
			for (int j = 0; j < DatosJuego.COLUMNAS_TABLERO; j++) {
				JButton btn = new JButton();
				btn.setName(j + "," + i);
				tableroOrd[j][i] = btn;
				panelOrdenador.add(btn);
			}
		}
	}

	private JPanel getPanelUsuario() {
		if (panelUsuario == null) {
			panelUsuario = new JPanel();
			panelUsuario.setLayout(new GridLayout(DatosJuego.FILAS_TABLERO, DatosJuego.COLUMNAS_TABLERO, 0, 0));
		}
		return panelUsuario;
	}

	private JPanel getPanelOrdenador() {
		if (panelOrdenador == null) {
			panelOrdenador = new JPanel();
			panelOrdenador.setLayout(new GridLayout(DatosJuego.FILAS_TABLERO, DatosJuego.COLUMNAS_TABLERO, 0, 0));
		}
		return panelOrdenador;
	}

	private JPanel getPanelBotones() {
		if (panelBotones == null) {
			panelBotones = new JPanel();
		}
		return panelBotones;
	}

	private JPanel getPanelInformacion() {
		if (panelInformacion == null) {
			panelInformacion = new JPanel();
			panelInformacion.add(getLblTurno());
		}
		return panelInformacion;
	}

	private JLabel getLblTurno() {
		if (lblTurno == null) {
			lblTurno = new JLabel("Tienes " + DatosJuego.DINERO_INICIAL + "$");
		}
		return lblTurno;
	}

	private JPanel getPanelArmas() {
		if (panelArmas == null) {
			panelArmas = new JPanel();
			GroupLayout gl_panelArmas = new GroupLayout(panelArmas);
			gl_panelArmas.setHorizontalGroup(gl_panelArmas.createParallelGroup(Alignment.LEADING).addGroup(gl_panelArmas
					.createSequentialGroup().addGap(27)
					.addGroup(gl_panelArmas.createParallelGroup(Alignment.LEADING).addComponent(getLblEscudo())
							.addComponent(getLblMisil()).addComponent(getLblMisilEO()).addComponent(getLblMisilNS())
							.addComponent(getLblMisilBOOM()).addComponent(getLblBomba()))
					.addGap(43)
					.addGroup(gl_panelArmas.createParallelGroup(Alignment.LEADING).addComponent(getBtnEscudo())
							.addComponent(getBtnBomba()).addComponent(getBtnMisil()).addComponent(getBtnMisilns())
							.addComponent(getBtnMisilboom()).addComponent(getBtnMisilEO()))
					.addContainerGap(702, Short.MAX_VALUE)));
			gl_panelArmas.setVerticalGroup(gl_panelArmas.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_panelArmas.createSequentialGroup().addContainerGap()
							.addGroup(gl_panelArmas.createParallelGroup(Alignment.BASELINE).addComponent(getLblBomba())
									.addComponent(getBtnBomba()))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_panelArmas.createParallelGroup(Alignment.BASELINE).addComponent(getLblEscudo())
									.addComponent(getBtnEscudo()))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_panelArmas.createParallelGroup(Alignment.BASELINE).addComponent(getLblMisil())
									.addComponent(getBtnMisil()))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panelArmas.createParallelGroup(Alignment.BASELINE)
									.addComponent(getLblMisilEO()).addComponent(getBtnMisilEO()))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_panelArmas.createParallelGroup(Alignment.BASELINE)
									.addComponent(getLblMisilNS()).addComponent(getBtnMisilns()))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_panelArmas.createParallelGroup(Alignment.BASELINE)
									.addComponent(getLblMisilBOOM()).addComponent(getBtnMisilboom()))
							.addContainerGap(118, Short.MAX_VALUE)));
			gl_panelArmas.linkSize(SwingConstants.VERTICAL,
					new Component[] { getLblEscudo(), getLblMisil(), getLblMisilEO(), getLblMisilNS(),
							getLblMisilBOOM(), getLblBomba(), getBtnEscudo(), getBtnBomba(), getBtnMisil(),
							getBtnMisilns(), getBtnMisilboom(), getBtnMisilEO() });
			panelArmas.setLayout(gl_panelArmas);
		}
		return panelArmas;
	}

	private JLabel getLblEscudo() {
		if (lblEscudo == null) {
			lblEscudo = new JLabel("Stock: " + DatosJuego.CANT_ESCUDO);
		}
		return lblEscudo;
	}

	private JButton getBtnEscudo() {
		if (btnEscudo == null) {
			btnEscudo = new JButton("Escudo: " + DatosJuego.PRECIO_ESCUDO + "$");
			btnEscudo.addMouseListener(new CBtnEscudo());
		}
		return btnEscudo;
	}

	private JButton getBtnBomba() {
		if (btnBomba == null) {
			btnBomba = new JButton("Bomba");
		}
		return btnBomba;
	}

	private JLabel getLblMisil() {
		if (lblMisil == null) {
			lblMisil = new JLabel("Stock: " + DatosJuego.CANT_MISIL);
		}
		return lblMisil;
	}

	private JButton getBtnMisil() {
		if (btnMisil == null) {
			btnMisil = new JButton("Misil: " + DatosJuego.PRECIO_MISIL + "$");
		}
		return btnMisil;
	}

	public static TableroJuego getTableroJuego() {
		if (miTableroJuego == null)
			miTableroJuego = new TableroJuego();
		return miTableroJuego;
	}

	public void setArma(int pNum) {arma = pNum;}
	public int getArma() {return arma;}

	private JLabel getLblMisilEO() {
		if (lblMisilEO == null) {
			lblMisilEO = new JLabel("Stock: " + DatosJuego.CANT_MISIL_EO);
		}
		return lblMisilEO;
	}

	private JButton getBtnMisilEO() {
		if (btnMisilEO == null) {
			btnMisilEO = new JButton("MisilEO " + DatosJuego.PRECIO_MISIL_EO + "$");
		}
		return btnMisilEO;
	}

	private JLabel getLblMisilNS() {
		if (lblMisilNS == null) {
			lblMisilNS = new JLabel("Stock: " + DatosJuego.CANT_MISIL_NS);
		}
		return lblMisilNS;
	}

	private JButton getBtnMisilns() {
		if (btnMisilns == null) {
			btnMisilns = new JButton("MisilNS " + DatosJuego.PRECIO_MISIL_NS + "$");
		}
		return btnMisilns;
	}

	private JLabel getLblMisilBOOM() {
		if (lblMisilBOOM == null) {
			lblMisilBOOM = new JLabel("Stock: " + DatosJuego.CANT_MISIL_BOOM);
		}
		return lblMisilBOOM;
	}

	private JButton getBtnMisilboom() {
		if (btnMisilboom == null) {
			btnMisilboom = new JButton("MisilBOOM " + DatosJuego.PRECIO_MISIL_BOOM + "$");
		}
		return btnMisilboom;
	}

	private JLabel getLblBomba() {
		if (lblBomba == null) {
			lblBomba = new JLabel("Ilimitado");
		}
		return lblBomba;
	}

	@Override
	public void update(Observable observable, Object parametro) {
		if (observable instanceof Battleship) {
			String[] splitted = ((String) parametro).split(";");
			int pArma = Integer.parseInt(splitted[0]);
			if (pArma == DatosJuego.NUM_ESCUDO) {
				int i, j;
				for (int k = 1; k < splitted.length; k++) {
					i = Integer.parseInt(splitted[k].split(",")[0]);
					j = Integer.parseInt(splitted[k].split(",")[1]);
					tableroUs[i][j].setBorder(BorderFactory.createLineBorder(Color.MAGENTA, 3));
				}
				lblTurno.setText("Tienes " + Battleship.getBattleship().getDineroUsuario() + "$");
			}
		} else if (observable instanceof Almacen) {
			int[] stock = (int[]) parametro;
			switch (stock[0]) {
			case DatosJuego.NUM_ESCUDO:
				lblEscudo.setText("Stock: " + stock[1]);
				break;
			case DatosJuego.NUM_MISIL:
				lblMisil.setText("Stock: " + stock[1]);
				break;
			case DatosJuego.NUM_MISIL_NS:
				lblMisilNS.setText("Stock: " + stock[1]);
				break;
			case DatosJuego.NUM_MISIL_EO:
				lblMisilEO.setText("Stock: " + stock[1]);
				break;
			case DatosJuego.NUM_MISIL_BOOM:
				lblMisilBOOM.setText("Stock: " + stock[1]);
				break;
			}
		} else if (observable instanceof Jugador) {
			if (Battleship.getBattleship().getTurno()) {
				// Actualizar etiquetas de Jugador
			} else {
				// Actualizar etiquetas de Ordenador
			}
			
		}
	}
}
