package packVista;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JToggleButton;
import javax.swing.ImageIcon;

public class inicio extends JFrame {

	private JPanel contentPane, panel;
	private final int filas = 10, columnas = 10;
	private JButton[][] tablero;
	private JPanel panel_1;
	private JLabel lblFragata;
	private JButton btnBtnfragata;
	private JLabel lblDestructor;
	private JButton btnBtndestructor;
	private JLabel lblSubmarino;
	private JButton btnBtnsubmarino;
	private JLabel lblPortaviones;
	private JButton btnBtnportaviones;
	private JPanel panel_2;
	private JLabel lblColoqueTodosLos;
	private JToggleButton tglbtnNewToggleButton;
	private JLabel lblHorientacion;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					inicio frame = new inicio();
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
	public inicio() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 540, 370);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		crearTablero();
	}

	private void crearTablero() {
		if (panel != null)
			contentPane.remove(panel);
		panel = new JPanel();
		panel.setLayout(new GridLayout(filas, columnas, 0, 0));
		contentPane.add(panel, BorderLayout.CENTER);
		contentPane.add(getPanel_1(), BorderLayout.EAST);
		contentPane.add(getPanel_2(), BorderLayout.NORTH);
		tablero = new JButton[filas][columnas];

		for (int i = 0; i < filas; i++) {
			for (int j = 0; j < columnas; j++) {
				JButton btn = new JButton();
				btn.setName(i + " " + j);
				tablero[i][j] = btn;

				panel.add(btn);
			}
		}
	}

	private JPanel getPanel_1() {
		if (panel_1 == null) {
			panel_1 = new JPanel();
			{
				lblFragata = new JLabel("Fragata");
			}
			{
				btnBtnfragata = new JButton("btnFragata");
			}
			lblDestructor = new JLabel("Destructor");
			GroupLayout gl_panel_1 = new GroupLayout(panel_1);
			gl_panel_1.setHorizontalGroup(gl_panel_1.createParallelGroup(Alignment.LEADING).addGroup(gl_panel_1
					.createSequentialGroup().addGap(5)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_panel_1.createSequentialGroup().addComponent(getLblSubmarino())
									.addPreferredGap(ComponentPlacement.UNRELATED).addComponent(getBtnBtnsubmarino()))
							.addGroup(gl_panel_1
									.createSequentialGroup()
									.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING).addComponent(lblFragata)
											.addComponent(lblDestructor))
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
											.addComponent(btnBtnfragata).addComponent(getBtnBtndestructor())))
							.addGroup(gl_panel_1.createSequentialGroup().addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(getLblHorientacion()).addGap(24).addComponent(
											getTglbtnNewToggleButton(), GroupLayout.PREFERRED_SIZE, 66, GroupLayout.PREFERRED_SIZE))
							.addGroup(gl_panel_1.createSequentialGroup().addComponent(getLblPortaviones())
									.addPreferredGap(ComponentPlacement.RELATED).addComponent(getBtnBtnportaviones())))
					.addContainerGap(37, Short.MAX_VALUE)));
			gl_panel_1.setVerticalGroup(gl_panel_1.createParallelGroup(Alignment.LEADING).addGroup(gl_panel_1
					.createSequentialGroup()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_panel_1.createSequentialGroup().addGap(9).addComponent(lblFragata))
							.addGroup(gl_panel_1.createSequentialGroup().addGap(5).addComponent(btnBtnfragata)))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE).addComponent(lblDestructor)
							.addComponent(getBtnBtndestructor()))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE).addComponent(getLblSubmarino())
							.addComponent(getBtnBtnsubmarino()))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE).addComponent(getLblPortaviones())
							.addComponent(getBtnBtnportaviones()))
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_panel_1.createSequentialGroup().addGap(49).addComponent(getLblHorientacion()))
							.addGroup(gl_panel_1.createSequentialGroup().addGap(32).addComponent(
									getTglbtnNewToggleButton(), GroupLayout.PREFERRED_SIZE, 47,
									GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(88, Short.MAX_VALUE)));
			panel_1.setLayout(gl_panel_1);
		}
		return panel_1;
	}

	private JButton getBtnBtndestructor() {
		if (btnBtndestructor == null) {
			btnBtndestructor = new JButton("btnDestructor");
		}
		return btnBtndestructor;
	}

	private JLabel getLblSubmarino() {
		if (lblSubmarino == null) {
			lblSubmarino = new JLabel("Submarino");
		}
		return lblSubmarino;
	}

	private JButton getBtnBtnsubmarino() {
		if (btnBtnsubmarino == null) {
			btnBtnsubmarino = new JButton("btnSubmarino");
		}
		return btnBtnsubmarino;
	}

	private JLabel getLblPortaviones() {
		if (lblPortaviones == null) {
			lblPortaviones = new JLabel("Portaviones");
		}
		return lblPortaviones;
	}

	private JButton getBtnBtnportaviones() {
		if (btnBtnportaviones == null) {
			btnBtnportaviones = new JButton("btnPortaviones");
		}
		return btnBtnportaviones;
	}

	private JPanel getPanel_2() {
		if (panel_2 == null) {
			panel_2 = new JPanel();
			panel_2.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
			panel_2.add(getLblColoqueTodosLos());
		}
		return panel_2;
	}

	private JLabel getLblColoqueTodosLos() {
		if (lblColoqueTodosLos == null) {
			lblColoqueTodosLos = new JLabel("Coloque TODOS los barcos");
		}
		return lblColoqueTodosLos;
	}

	private JToggleButton getTglbtnNewToggleButton() {
		if (tglbtnNewToggleButton == null) {
			tglbtnNewToggleButton = new JToggleButton("");
			tglbtnNewToggleButton.setSelectedIcon(new ImageIcon(inicio.class.getResource("/packVista/vertical.png")));
			tglbtnNewToggleButton.setIcon(new ImageIcon(inicio.class.getResource("/packVista/horizontal.png")));
			tglbtnNewToggleButton.setToolTipText("");
		}
		return tglbtnNewToggleButton;
	}

	private JLabel getLblHorientacion() {
		if (lblHorientacion == null) {
			lblHorientacion = new JLabel("Horientacion:");
		}
		return lblHorientacion;
	}
}
