package packVista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.omg.PortableServer.ServantLocatorPackage.CookieHolder;

import packControlador.CBtnsColocar;
import packModelo.Battleship;
import packModelo.DatosJuego;
import packModelo.packCoordenada.Coordenada;

import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.Component;
import java.awt.Dimension;

public class TableroJuego extends JFrame {

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
	private JLabel lblNewLabel_2;
	private JButton btnMisil;
	private JButton[][] tableroUs;
	private JButton[][] tableroOrd;
	private int arma;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Battleship.getBattleship().inicializar();
					TableroJuego frame = getTableroJuego();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
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
		
	}

	private void crearTableroUsu() {
		
		tableroUs = new JButton[DatosJuego.FILAS_TABLERO][DatosJuego.COLUMNAS_TABLERO];

		for (int i = 0; i < DatosJuego.FILAS_TABLERO; i++) {
			for (int j = 0; j < DatosJuego.COLUMNAS_TABLERO; j++) {
				JButton btn = new JButton();
				btn.setName(i + "," + j);
				tableroUs[i][j] = btn;
				panelUsuario.add(btn);
				Coordenada c = new Coordenada(i, j);
				if (!Battleship.getBattleship().hayBarcoUsu(c)) btn.setEnabled(false);
				else btn.setBackground(Color.GREEN);
			}
		}
	}
private void crearTableroOrd() {
		
		tableroOrd = new JButton[DatosJuego.FILAS_TABLERO][DatosJuego.COLUMNAS_TABLERO];

		for (int i = 0; i < DatosJuego.FILAS_TABLERO; i++) {
			for (int j = 0; j < DatosJuego.COLUMNAS_TABLERO; j++) {
				JButton btn = new JButton();
				btn.setName(i + "," + j);
				tableroOrd[i][j] = btn;
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
			lblTurno = new JLabel("Tu turno!!");
		}
		return lblTurno;
	}
	private JPanel getPanelArmas() {
		if (panelArmas == null) {
			panelArmas = new JPanel();
			GroupLayout gl_panelArmas = new GroupLayout(panelArmas);
			gl_panelArmas.setHorizontalGroup(
				gl_panelArmas.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_panelArmas.createSequentialGroup()
						.addGap(27)
						.addGroup(gl_panelArmas.createParallelGroup(Alignment.LEADING)
							.addComponent(getLblEscudo())
							.addComponent(getLblNewLabel_2()))
						.addGap(18)
						.addGroup(gl_panelArmas.createParallelGroup(Alignment.LEADING)
							.addComponent(getBtnBomba())
							.addComponent(getBtnEscudo())
							.addComponent(getBtnMisil()))
						.addContainerGap(753, Short.MAX_VALUE))
			);
			gl_panelArmas.setVerticalGroup(
				gl_panelArmas.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_panelArmas.createSequentialGroup()
						.addContainerGap()
						.addComponent(getBtnBomba())
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addGroup(gl_panelArmas.createParallelGroup(Alignment.BASELINE)
							.addComponent(getLblEscudo())
							.addComponent(getBtnEscudo()))
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addGroup(gl_panelArmas.createParallelGroup(Alignment.BASELINE)
							.addComponent(getLblNewLabel_2())
							.addComponent(getBtnMisil()))
						.addContainerGap(215, Short.MAX_VALUE))
			);
			panelArmas.setLayout(gl_panelArmas);
			panelArmas.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{getBtnBomba(), getLblEscudo(), getBtnEscudo(), getLblNewLabel_2(), getBtnMisil()}));
		}
		return panelArmas;
	}
	private JLabel getLblEscudo() {
		if (lblEscudo == null) {
			lblEscudo = new JLabel("numEscudos");
		}
		return lblEscudo;
	}
	private JButton getBtnEscudo() {
		if (btnEscudo == null) {
			btnEscudo = new JButton("Escudo");
			btnEscudo.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
				}
			});
		}
		return btnEscudo;
	}
	private JButton getBtnBomba() {
		if (btnBomba == null) {
			btnBomba = new JButton("Bomba");
		}
		return btnBomba;
	}
	private JLabel getLblNewLabel_2() {
		if (lblNewLabel_2 == null) {
			lblNewLabel_2 = new JLabel("numMisil");
		}
		return lblNewLabel_2;
	}
	private JButton getBtnMisil() {
		if (btnMisil == null) {
			btnMisil = new JButton("Misil");
		}
		return btnMisil;
	}

	public static TableroJuego getTableroJuego() {
		if (miTableroJuego==null) miTableroJuego = new TableroJuego();
		return miTableroJuego;
	}

	public void setArma(int pNum) {
		arma = pNum;
	}
}
