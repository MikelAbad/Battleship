package packVista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import packControlador.ContTablero.CBtnCompEscudo;
import packControlador.ContTablero.CBtnCompMisil;
import packControlador.ContTablero.CBtnCompMisilBoom;
import packControlador.ContTablero.CBtnCompMisilEO;
import packControlador.ContTablero.CBtnCompMisilNS;
import packControlador.ContTablero.CBtnUsarBomba;
import packControlador.ContTablero.CBtnUsarEscudo;
import packControlador.ContTablero.CBtnUsarMisil;
import packControlador.ContTablero.CBtnUsarMisilBoom;
import packControlador.ContTablero.CBtnUsarMisilEO;
import packControlador.ContTablero.CBtnUsarMisilNS;
import packControlador.ContTablero.CBtnUsarRadar;
import packControlador.ContTablero.CBtnsOrdenador;
import packControlador.ContTablero.CBtnsUsuario;
import packModelo.Almacen;
import packModelo.Battleship;
import packModelo.DatosJuego;
import packModelo.packCoordenada.Coordenada;
import packModelo.packJugador.Jugador;

import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.BorderFactory;
import java.util.Observable;
import java.util.Observer;
import java.awt.Dimension;
import javax.swing.SwingConstants;
import javax.swing.BoxLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TableroJuego extends JFrame implements Observer {

	private static TableroJuego miTableroJuego;
	private JPanel contentPane;
	private JPanel panelUsuario;
	private JPanel panelOrdenador;
	private JPanel panelArmamentoEne;
	private JPanel panelTienda;
	private JLabel lblTurno;
	private JPanel panelArmamento;
	private JLabel lblEscudo;
	private JButton btnCompEscudo;
	private JButton btnUsarBomba;
	private JLabel lblMisil;
	private JButton btnCompMisil;
	private JButton[][] tableroUs;
	private JButton[][] tableroOrd;
	private int arma;
	private JLabel lblMisilEO;
	private JButton btnCompMisilEO;
	private JLabel lblMisilNS;
	private JButton btnCompMisilNS;
	private JLabel lblMisilBOOM;
	private JButton btnCompMisilBOOM;
	private JLabel lblCantBomba;
	private JLabel lblRadar;
	private JButton btnUsarRadar;
	private JLabel lblCompras;
	private JPanel panel;
	private JPanel panel_1;
	private JPanel panel_2;
	private JPanel panel_3;
	private JPanel panel_4;
	private JPanel panel_5;
	private JPanel panel_6;
	private JPanel panel_7;
	private JPanel panel_8;
	private JPanel panel_9;
	private JPanel panel_10;
	private JLabel lblCantMisil;
	private JLabel lblCantMisilEO;
	private JLabel lblCantMisilNS;
	private JPanel panel_11;
	private JPanel panel_12;
	private JLabel lblCantMisilBOOM;
	private JButton btnUsarMisil;
	private JButton btnUsarMisilEO;
	private JButton btnUsarMisilNS;
	private JButton btnUsarMisilBOOM;
	private JPanel panelTienda1;
	private JPanel panelDinero;
	private JPanel panelTienda2;
	private JPanel panelArmamento2;
	private JPanel panelArmamento1;
	private JLabel lblArmamento;
	private JLabel lblArmamentoEnemigo;
	private JLabel lblMisilesEne;
	private JLabel lblMisilesEOEne;
	private JLabel lblMisilesNSEne;
	private JLabel lblMisilesBOOMEne;
	private JLabel lblRadarEne;
	private JPanel panel_13;
	private JPanel panel_14;
	private JLabel lblCantEscudo;
	private JButton btnUsarEscudo;
	private JButton btnMoverRadar;
	private int[] radar;

	public int[] getRadar() {
		return radar;
	}

	public void setRadar(int[] radar) {
		this.radar = radar;
	}

	private TableroJuego() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		contentPane.add(getPanelUsuario(), BorderLayout.WEST);
		contentPane.add(getPanelOrdenador(), BorderLayout.EAST);
		contentPane.add(getPanelArmamentoEne(), BorderLayout.SOUTH);
		contentPane.add(getPanelTienda(), BorderLayout.NORTH);
		contentPane.add(getPanelArmamento(), BorderLayout.CENTER);
		crearTableroOrd();
		crearTableroUsu();
		int ancho = 950;
		int alto = 500;
		Dimension d = new Dimension(ancho, alto);
		this.setMinimumSize(d);
		this.setMaximumSize(d);
		this.setSize(d);
		arma = DatosJuego.NUM_BOMBA;
		Battleship.getBattleship().addObserver(this);
		Battleship.getBattleship().getUsuario().addObserver(this);
		int [] i = new int[2];
		i[0] = 1;
		i[1] = 1;
		setRadar(i);
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
				btn.addMouseListener(new CBtnsOrdenador());
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

	private JPanel getPanelArmamentoEne() {
		if (panelArmamentoEne == null) {
			panelArmamentoEne = new JPanel();
			panelArmamentoEne.setLayout(new BorderLayout(0, 0));
			panelArmamentoEne.add(getPanel(), BorderLayout.SOUTH);
		}
		return panelArmamentoEne;
	}

	private JPanel getPanelTienda() {
		if (panelTienda == null) {
			panelTienda = new JPanel();
			panelTienda.setLayout(new BorderLayout(0, 0));
			panelTienda.add(getPanelTienda1(), BorderLayout.CENTER);
			panelTienda.add(getPanelDinero(), BorderLayout.NORTH);
			panelTienda.add(getPanelTienda2(), BorderLayout.SOUTH);
		}
		return panelTienda;
	}

	private JLabel getLblTurno() {
		if (lblTurno == null) {
			lblTurno = new JLabel("Tienes " + DatosJuego.DINERO_INICIAL + "$");
		}
		return lblTurno;
	}

	private JPanel getPanelArmamento() {
		if (panelArmamento == null) {
			panelArmamento = new JPanel();
			panelArmamento.setLayout(new BorderLayout(0, 0));
			panelArmamento.add(getPanelArmamento1(), BorderLayout.CENTER);
			panelArmamento.add(getPanelArmamento2(), BorderLayout.NORTH);
		}
		return panelArmamento;
	}

	private JLabel getLblEscudo() {
		if (lblEscudo == null) {
			lblEscudo = new JLabel("Stock: " + DatosJuego.CANT_ESCUDO);
		}
		return lblEscudo;
	}

	private JButton getBtnCompEscudo() {
		if (btnCompEscudo == null) {
			btnCompEscudo = new JButton("Escudo: " + DatosJuego.PRECIO_ESCUDO + "$");
			btnCompEscudo.addMouseListener(new CBtnCompEscudo());
		}
		return btnCompEscudo;
	}

	private JButton getBtnUsarBomba() {
		if (btnUsarBomba == null) {
			btnUsarBomba = new JButton("Bomba");
			btnCompEscudo.addMouseListener(new CBtnUsarBomba());
			btnUsarBomba.setHorizontalAlignment(SwingConstants.LEFT);
		}
		return btnUsarBomba;
	}

	private JLabel getLblMisil() {
		if (lblMisil == null) {
			lblMisil = new JLabel("Stock: " + DatosJuego.CANT_MISIL);
		}
		return lblMisil;
	}

	private JButton getBtnCompMisil() {
		if (btnCompMisil == null) {
			btnCompMisil = new JButton("Misil: " + DatosJuego.PRECIO_MISIL + "$");
			btnCompEscudo.addMouseListener(new CBtnCompMisil());
		}
		return btnCompMisil;
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

	private JButton getBtnCompMisilEO() {
		if (btnCompMisilEO == null) {
			btnCompMisilEO = new JButton("numMisilEO " + DatosJuego.PRECIO_MISIL_EO + "$");
			btnCompEscudo.addMouseListener(new CBtnCompMisilEO());
		}
		return btnCompMisilEO;
	}

	private JLabel getLblMisilNS() {
		if (lblMisilNS == null) {
			lblMisilNS = new JLabel("Stock: " + DatosJuego.CANT_MISIL_NS);
		}
		return lblMisilNS;
	}

	private JButton getBtnCompMisilNS() {
		if (btnCompMisilNS == null) {
			btnCompMisilNS = new JButton("MisilNS " + DatosJuego.PRECIO_MISIL_NS + "$");
			btnCompEscudo.addMouseListener(new CBtnCompMisilNS());
		}
		return btnCompMisilNS;
	}

	private JLabel getLblMisilBOOM() {
		if (lblMisilBOOM == null) {
			lblMisilBOOM = new JLabel("Stock: " + DatosJuego.CANT_MISIL_BOOM);
		}
		return lblMisilBOOM;
	}

	private JButton getBtnCompMisilBOOM() {
		if (btnCompMisilBOOM == null) {
			btnCompMisilBOOM = new JButton("MisilBOOM " + DatosJuego.PRECIO_MISIL_BOOM + "$");
			btnCompEscudo.addMouseListener(new CBtnCompMisilBoom());
		}
		return btnCompMisilBOOM;
	}

	private JLabel getLblCantBomba() {
		if (lblCantBomba == null) {
			lblCantBomba = new JLabel("Ilimitado  ");
			lblCantBomba.setHorizontalAlignment(SwingConstants.RIGHT);
		}
		return lblCantBomba;
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
	private JLabel getLblRadar() {
		if (lblRadar == null) {
			lblRadar = new JLabel("Usos : ");
			lblRadar.setHorizontalAlignment(SwingConstants.RIGHT);
		}
		return lblRadar;
	}
	private JButton getBtnUsarRadar() {
		if (btnUsarRadar == null) {
			btnUsarRadar = new JButton("Radar");
			btnCompEscudo.addMouseListener(new CBtnUsarRadar());
			btnUsarRadar.setAlignmentY(0.52f);
			btnUsarRadar.setHorizontalAlignment(SwingConstants.LEFT);
		}
		return btnUsarRadar;
	}
	private JLabel getLblCompras() {
		if (lblCompras == null) {
			lblCompras = new JLabel("Tienda: ");
			lblCompras.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return lblCompras;
	}
	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.add(getLblArmamentoEnemigo());
			panel.add(getLblMisilesEne());
			panel.add(getLblMisilesEOEne());
			panel.add(getLblMisilesNSEne());
			panel.add(getLblMisilesBOOMEne());
			panel.add(getLblRadarEne());
		}
		return panel;
	}
	private JPanel getPanel_1() {
		if (panel_1 == null) {
			panel_1 = new JPanel();
			panel_1.setLayout(new BorderLayout(0, 0));
			panel_1.add(getLblCantBomba(), BorderLayout.EAST);
		}
		return panel_1;
	}
	private JPanel getPanel_2() {
		if (panel_2 == null) {
			panel_2 = new JPanel();
			panel_2.setLayout(new BoxLayout(panel_2, BoxLayout.X_AXIS));
			panel_2.add(getBtnUsarBomba());
		}
		return panel_2;
	}
	private JPanel getPanel_3() {
		if (panel_3 == null) {
			panel_3 = new JPanel();
			panel_3.setLayout(new BorderLayout(0, 0));
			panel_3.add(getLblCantMisil(), BorderLayout.EAST);
		}
		return panel_3;
	}
	private JPanel getPanel_4() {
		if (panel_4 == null) {
			panel_4 = new JPanel();
			panel_4.setLayout(new BoxLayout(panel_4, BoxLayout.X_AXIS));
			panel_4.add(getBtnUsarMisil());
		}
		return panel_4;
	}
	private JPanel getPanel_5() {
		if (panel_5 == null) {
			panel_5 = new JPanel();
			panel_5.setLayout(new BorderLayout(0, 0));
			panel_5.add(getLblCantMisilEO(), BorderLayout.EAST);
		}
		return panel_5;
	}
	private JPanel getPanel_6() {
		if (panel_6 == null) {
			panel_6 = new JPanel();
			panel_6.setLayout(new BoxLayout(panel_6, BoxLayout.X_AXIS));
			panel_6.add(getBtnUsarMisilEO());
		}
		return panel_6;
	}
	private JPanel getPanel_7() {
		if (panel_7 == null) {
			panel_7 = new JPanel();
			panel_7.setLayout(new BorderLayout(0, 0));
			panel_7.add(getLblCantMisilNS(), BorderLayout.EAST);
		}
		return panel_7;
	}
	private JPanel getPanel_8() {
		if (panel_8 == null) {
			panel_8 = new JPanel();
			panel_8.setLayout(new BoxLayout(panel_8, BoxLayout.X_AXIS));
			panel_8.add(getBtnUsarMisilNS());
		}
		return panel_8;
	}
	private JPanel getPanel_9() {
		if (panel_9 == null) {
			panel_9 = new JPanel();
			panel_9.setLayout(new BorderLayout(0, 0));
			panel_9.add(getLblCantMisilBOOM(), BorderLayout.EAST);
		}
		return panel_9;
	}
	private JPanel getPanel_10() {
		if (panel_10 == null) {
			panel_10 = new JPanel();
			panel_10.setLayout(new BorderLayout(0, 0));
			panel_10.add(getLblRadar(), BorderLayout.EAST);
		}
		return panel_10;
	}
	private JLabel getLblCantMisil() {
		if (lblCantMisil == null) {
			lblCantMisil = new JLabel("Cantidad: ");
		}
		return lblCantMisil;
	}
	private JLabel getLblCantMisilEO() {
		if (lblCantMisilEO == null) {
			lblCantMisilEO = new JLabel("Cantidad: ");
		}
		return lblCantMisilEO;
	}
	private JLabel getLblCantMisilNS() {
		if (lblCantMisilNS == null) {
			lblCantMisilNS = new JLabel("Canditad: ");
		}
		return lblCantMisilNS;
	}
	private JPanel getPanel_11() {
		if (panel_11 == null) {
			panel_11 = new JPanel();
			panel_11.setLayout(new BoxLayout(panel_11, BoxLayout.X_AXIS));
			panel_11.add(getBtnUsarMisilBOOM());
		}
		return panel_11;
	}
	private JPanel getPanel_12() {
		if (panel_12 == null) {
			panel_12 = new JPanel();
			panel_12.setLayout(new BoxLayout(panel_12, BoxLayout.X_AXIS));
			panel_12.add(getBtnUsarRadar());
			panel_12.add(getBtnMoverRadar());
		}
		return panel_12;
	}
	private JLabel getLblCantMisilBOOM() {
		if (lblCantMisilBOOM == null) {
			lblCantMisilBOOM = new JLabel("Cantidad: ");
		}
		return lblCantMisilBOOM;
	}
	private JButton getBtnUsarMisil() {
		if (btnUsarMisil == null) {
			btnUsarMisil = new JButton("Misil");
			btnCompEscudo.addMouseListener(new CBtnUsarMisil());
		}
		return btnUsarMisil;
	}
	private JButton getBtnUsarMisilEO() {
		if (btnUsarMisilEO == null) {
			btnUsarMisilEO = new JButton("MisilEO");
			btnCompEscudo.addMouseListener(new CBtnUsarMisilEO());
		}
		return btnUsarMisilEO;
	}
	private JButton getBtnUsarMisilNS() {
		if (btnUsarMisilNS == null) {
			btnUsarMisilNS = new JButton("MisilNS");
			btnCompEscudo.addMouseListener(new CBtnUsarMisilNS());
		}
		return btnUsarMisilNS;
	}
	private JButton getBtnUsarMisilBOOM() {
		if (btnUsarMisilBOOM == null) {
			btnUsarMisilBOOM = new JButton("MisilBOOM");
			btnCompEscudo.addMouseListener(new CBtnUsarMisilBoom());
		}
		return btnUsarMisilBOOM;
	}
	private JPanel getPanelTienda1() {
		if (panelTienda1 == null) {
			panelTienda1 = new JPanel();
			panelTienda1.add(getLblCompras());
		}
		return panelTienda1;
	}
	private JPanel getPanelDinero() {
		if (panelDinero == null) {
			panelDinero = new JPanel();
			panelDinero.add(getLblTurno());
		}
		return panelDinero;
	}
	private JPanel getPanelTienda2() {
		if (panelTienda2 == null) {
			panelTienda2 = new JPanel();
			panelTienda2.add(getLblEscudo());
			panelTienda2.add(getBtnCompEscudo());
			panelTienda2.add(getLblMisil());
			panelTienda2.add(getBtnCompMisil());
			panelTienda2.add(getLblMisilEO());
			panelTienda2.add(getBtnCompMisilEO());
			panelTienda2.add(getLblMisilNS());
			panelTienda2.add(getBtnCompMisilNS());
			panelTienda2.add(getLblMisilBOOM());
			panelTienda2.add(getBtnCompMisilBOOM());
		}
		return panelTienda2;
	}
	private JPanel getPanelArmamento2() {
		if (panelArmamento2 == null) {
			panelArmamento2 = new JPanel();
			panelArmamento2.add(getLblArmamento());
		}
		return panelArmamento2;
	}
	private JPanel getPanelArmamento1() {
		if (panelArmamento1 == null) {
			panelArmamento1 = new JPanel();
			panelArmamento1.setLayout(new GridLayout(8, 0, 0, 0));
			panelArmamento1.add(getPanel_1());
			panelArmamento1.add(getPanel_2());
			panelArmamento1.add(getPanel_3());
			panelArmamento1.add(getPanel_4());
			panelArmamento1.add(getPanel_5());
			panelArmamento1.add(getPanel_6());
			panelArmamento1.add(getPanel_7());
			panelArmamento1.add(getPanel_8());
			panelArmamento1.add(getPanel_9());
			panelArmamento1.add(getPanel_11());
			panelArmamento1.add(getPanel_10());
			panelArmamento1.add(getPanel_12());
			panelArmamento1.add(getPanel_13());
			panelArmamento1.add(getPanel_14());
		}
		return panelArmamento1;
	}
	private JLabel getLblArmamento() {
		if (lblArmamento == null) {
			lblArmamento = new JLabel("Armamento: ");
		}
		return lblArmamento;
	}
	private JLabel getLblArmamentoEnemigo() {
		if (lblArmamentoEnemigo == null) {
			lblArmamentoEnemigo = new JLabel("Armamento Enemigo: ");
		}
		return lblArmamentoEnemigo;
	}
	private JLabel getLblMisilesEne() {
		if (lblMisilesEne == null) {
			lblMisilesEne = new JLabel("Misiles ");
		}
		return lblMisilesEne;
	}
	private JLabel getLblMisilesEOEne() {
		if (lblMisilesEOEne == null) {
			lblMisilesEOEne = new JLabel("MisilesEO ");
		}
		return lblMisilesEOEne;
	}
	private JLabel getLblMisilesNSEne() {
		if (lblMisilesNSEne == null) {
			lblMisilesNSEne = new JLabel("MisilesNS ");
		}
		return lblMisilesNSEne;
	}
	private JLabel getLblMisilesBOOMEne() {
		if (lblMisilesBOOMEne == null) {
			lblMisilesBOOMEne = new JLabel("MisilesBOOM ");
		}
		return lblMisilesBOOMEne;
	}
	private JLabel getLblRadarEne() {
		if (lblRadarEne == null) {
			lblRadarEne = new JLabel("Radar ");
		}
		return lblRadarEne;
	}
	private JPanel getPanel_13() {
		if (panel_13 == null) {
			panel_13 = new JPanel();
			panel_13.setLayout(new BorderLayout(0, 0));
			panel_13.add(getLblCantEscudo(), BorderLayout.EAST);
		}
		return panel_13;
	}
	private JPanel getPanel_14() {
		if (panel_14 == null) {
			panel_14 = new JPanel();
			panel_14.setLayout(new BoxLayout(panel_14, BoxLayout.X_AXIS));
			panel_14.add(getBtnUsarEscudo());
		}
		return panel_14;
	}
	private JLabel getLblCantEscudo() {
		if (lblCantEscudo == null) {
			lblCantEscudo = new JLabel("Cantidad: ");
		}
		return lblCantEscudo;
	}
	private JButton getBtnUsarEscudo() {
		if (btnUsarEscudo == null) {
			btnUsarEscudo = new JButton("Escudo");
			btnCompEscudo.addMouseListener(new CBtnUsarEscudo());
		}
		return btnUsarEscudo;
	}
	public JButton getBtnMoverRadar() {
		if (btnMoverRadar == null) {
			btnMoverRadar = new JButton("Mover");
			btnMoverRadar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
		}
		return btnMoverRadar;
	}
}