package packVista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

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
	private JLabel lblNummisileo;
	private JButton btnMisilEO;
	private JLabel lblNummisilns;
	private JButton btnMisilns;
	private JLabel lblNummisilboom;
	private JButton btnMisilboom;
	private JLabel lblBomba;

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
		
		tableroUs = new JButton[DatosJuego.COLUMNAS_TABLERO][DatosJuego.FILAS_TABLERO];

		for (int i = 0; i < DatosJuego.FILAS_TABLERO; i++) {
			for (int j = 0; j < DatosJuego.COLUMNAS_TABLERO; j++) {
				JButton btn = new JButton();
				btn.setName(j + "," + i);
				btn.setText(j + "," + i);
				tableroUs[j][i] = btn;
				panelUsuario.add(btn);
				Coordenada c = new Coordenada(j, i);
				if (!Battleship.getBattleship().hayBarcoUsu(c)) btn.setEnabled(false);
				else btn.setBackground(Color.GREEN);
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
							.addComponent(getLblNewLabel_2())
							.addComponent(getLblNummisileo())
							.addComponent(getLblNummisilns())
							.addComponent(getLblNummisilboom())
							.addComponent(getLblBomba()))
						.addGap(43)
						.addGroup(gl_panelArmas.createParallelGroup(Alignment.LEADING)
							.addComponent(getBtnEscudo())
							.addComponent(getBtnBomba())
							.addComponent(getBtnMisil())
							.addComponent(getBtnMisilEO())
							.addComponent(getBtnMisilns())
							.addComponent(getBtnMisilboom()))
						.addContainerGap(704, Short.MAX_VALUE))
			);
			gl_panelArmas.setVerticalGroup(
				gl_panelArmas.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_panelArmas.createSequentialGroup()
						.addContainerGap()
						.addGroup(gl_panelArmas.createParallelGroup(Alignment.BASELINE)
							.addComponent(getLblBomba())
							.addComponent(getBtnBomba()))
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addGroup(gl_panelArmas.createParallelGroup(Alignment.BASELINE)
							.addComponent(getLblEscudo())
							.addComponent(getBtnEscudo()))
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addGroup(gl_panelArmas.createParallelGroup(Alignment.BASELINE)
							.addComponent(getLblNewLabel_2())
							.addComponent(getBtnMisil()))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(gl_panelArmas.createParallelGroup(Alignment.BASELINE)
							.addComponent(getLblNummisileo())
							.addComponent(getBtnMisilEO(), GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addGroup(gl_panelArmas.createParallelGroup(Alignment.BASELINE)
							.addComponent(getLblNummisilns())
							.addComponent(getBtnMisilns()))
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addGroup(gl_panelArmas.createParallelGroup(Alignment.BASELINE)
							.addComponent(getLblNummisilboom())
							.addComponent(getBtnMisilboom()))
						.addContainerGap(132, Short.MAX_VALUE))
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
	private JLabel getLblNummisileo() {
		if (lblNummisileo == null) {
			lblNummisileo = new JLabel("numMisilEO");
		}
		return lblNummisileo;
	}
	private JButton getBtnMisilEO() {
		if (btnMisilEO == null) {
			btnMisilEO = new JButton("MisilEO");
		}
		return btnMisilEO;
	}
	private JLabel getLblNummisilns() {
		if (lblNummisilns == null) {
			lblNummisilns = new JLabel("numMisilNS");
		}
		return lblNummisilns;
	}
	private JButton getBtnMisilns() {
		if (btnMisilns == null) {
			btnMisilns = new JButton("MisilNS");
		}
		return btnMisilns;
	}
	private JLabel getLblNummisilboom() {
		if (lblNummisilboom == null) {
			lblNummisilboom = new JLabel("numMisilBOOM");
		}
		return lblNummisilboom;
	}
	private JButton getBtnMisilboom() {
		if (btnMisilboom == null) {
			btnMisilboom = new JButton("MisilBOOM");
		}
		return btnMisilboom;
	}
	private JLabel getLblBomba() {
		if (lblBomba == null) {
			lblBomba = new JLabel("Ilimitado");
		}
		return lblBomba;
	}
}
