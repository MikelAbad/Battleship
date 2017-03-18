package packVista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import packControlador.CBtnDest;
import packControlador.CBtnFrag;
import packControlador.CBtnOrient;
import packControlador.CBtnPort;
import packControlador.CBtnSub;
import packControlador.CBtnsColocar;
import packModelo.Battleship;

import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JToggleButton;
import javax.swing.ImageIcon;

public class Inicio extends JFrame {

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
	private JLabel lblOrientacion;
	private int longitud;
	private boolean vertical;
	private static Inicio miInicio;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Inicio frame = getInicio();
					frame.setVisible(true);
					Battleship.getBattleship().inicializar();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	private Inicio() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 540, 370);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		crearTablero();
		vertical=false;
		longitud=0;
	}
	
	public boolean isVertical() {
		return vertical;
	}

	public void setVertical() {
		this.vertical = !vertical;
	}

	public static Inicio getInicio() {
		if (miInicio==null)miInicio=new Inicio();
		return miInicio;
	}

	public int getLongitud() {
		return longitud;
	}

	public void setLongitud(int longitud) {
		this.longitud = longitud;
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
				btn.setName(i + "," + j);
				tablero[i][j] = btn;
				btn.addMouseListener(new CBtnsColocar());
				panel.add(btn);
			}
		}
	}

	private JPanel getPanel_1() {
		if (panel_1 == null) {
			panel_1 = new JPanel();
			{
				lblFragata = new JLabel("4");
			}
			{
				btnBtnfragata = new JButton("Fragata");
				btnBtnfragata.addMouseListener(new CBtnFrag());
			}
			lblDestructor = new JLabel("3");
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
									.addComponent(getLblOrientacion()).addGap(24).addComponent(
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
							.addGroup(gl_panel_1.createSequentialGroup().addGap(49).addComponent(getLblOrientacion()))
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
			btnBtndestructor = new JButton("Destructor");
			btnBtndestructor.addMouseListener(new CBtnDest());
		}
		return btnBtndestructor;
	}

	private JLabel getLblSubmarino() {
		if (lblSubmarino == null) {
			lblSubmarino = new JLabel("2");
		}
		return lblSubmarino;
	}

	private JButton getBtnBtnsubmarino() {
		if (btnBtnsubmarino == null) {
			btnBtnsubmarino = new JButton("Submarino");
			btnBtnsubmarino.addMouseListener(new CBtnSub());
		}
		return btnBtnsubmarino;
	}

	private JLabel getLblPortaviones() {
		if (lblPortaviones == null) {
			lblPortaviones = new JLabel("1");
		}
		return lblPortaviones;
	}

	private JButton getBtnBtnportaviones() {
		if (btnBtnportaviones == null) {
			btnBtnportaviones = new JButton("Portaviones");
			btnBtnportaviones.addMouseListener(new CBtnPort());
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
			tglbtnNewToggleButton.setSelectedIcon(new ImageIcon(Inicio.class.getResource("/packVista/vertical.png")));
			tglbtnNewToggleButton.setIcon(new ImageIcon(Inicio.class.getResource("/packVista/horizontal.png")));
			tglbtnNewToggleButton.setToolTipText("");
			vertical=false;
			tglbtnNewToggleButton.addMouseListener(new CBtnOrient());
		}
		return tglbtnNewToggleButton;
	}

	private JLabel getLblOrientacion() {
		if (lblOrientacion == null) {
			lblOrientacion = new JLabel("Orientacion:");
		}
		return lblOrientacion;
	}

	public void pintarBarco(JButton pBtn) {
		String coor[] = pBtn.getName().split(",");
		int i = Integer.parseInt(coor[0]);
		int j =	Integer.parseInt(coor[1]);
		int k=0;
		if (vertical){
			while (k<longitud && i<10){
				tablero[i][j].setBackground(Color.BLUE);
				i++;
				k++;
			}
		}
		else{
			while (k<longitud && j<10){

				tablero[i][j].setBackground(Color.BLUE);
				j++;
				k++;
			}
		}	
	}

	public void despintarBarco(JButton pBtn) {
		String coor[] = pBtn.getName().split(",");
		int i = Integer.parseInt(coor[0]);
		int j =	Integer.parseInt(coor[1]);
		int k=0;
		if (vertical){
			while (k<longitud && i<10){
				if (tablero[i][j].isEnabled()) tablero[i][j].setBackground(null);
				i++;
				k++;
			}
		}
		else{
			while (k<longitud && j<10){
				if (tablero[i][j].isEnabled()) tablero[i][j].setBackground(null);
				j++;
				k++;
			}
		}
	}
	public void decrementarCont(int i){
		switch (longitud){
		case 1:
			lblFragata.setText(i+"");
			if (i<1) {
				btnBtnfragata.setEnabled(false);
				longitud=0;
			}
			break;
		case 2:
			lblDestructor.setText(i+"");
			if (i<1) {
				btnBtndestructor.setEnabled(false);
				longitud=0;
			}
			break;
		case 3:
			lblSubmarino.setText(i+"");
			if (i<1){
				btnBtnsubmarino.setEnabled(false);
				longitud=0;
			}
			break;
		case 4:
			lblPortaviones.setText(i+"");
			btnBtnportaviones.setEnabled(false);
			longitud=0;
			break;
		}
	}

	public void deshabilitarBotones(JButton pBtn) {
		String coor[] = pBtn.getName().split(",");
		int i = Integer.parseInt(coor[0]);
		int j =	Integer.parseInt(coor[1]);
		int k=0;
		if (vertical){
			while (k<longitud && i<10){
				tablero[i][j].setEnabled(false);;
				i++;
				k++;
			}
		}
		else{
			while (k<longitud && j<10){
				tablero[i][j].setEnabled(false);
				j++;
				k++;
			}
		}
		
	}

}
