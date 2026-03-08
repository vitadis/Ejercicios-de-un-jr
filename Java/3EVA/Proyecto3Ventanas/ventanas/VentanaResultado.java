package ventanas;

import javax.swing.*;
import java.awt.event.*;

public class VentanaResultado extends JDialog implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton btnRepetir;
	private JButton btnSalir;

	public VentanaResultado(JFrame padre, String nombre, int aciertos, int total) {

		super(padre, true);

		setTitle("Resultado");
		setSize(350, 200);
		setLocationRelativeTo(padre); // para que la posicion sea relativa al JFrame
		getContentPane().setLayout(null);

		JLabel lbl = new JLabel("Hola " + nombre + " has acertado " + aciertos + " de " + total);
		lbl.setBounds(30, 40, 300, 20);
		getContentPane().add(lbl);

		btnRepetir = new JButton("Repetir Test");
		btnRepetir.setBounds(30, 90, 120, 30);
		btnRepetir.addActionListener(this);
		getContentPane().add(btnRepetir);

		btnSalir = new JButton("Salir");
		btnSalir.setBounds(170, 90, 100, 30);
		btnSalir.addActionListener(this);
		getContentPane().add(btnSalir);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getActionCommand().equals("Repetir Test")) {

			VentanaTest v = new VentanaTest((JFrame) getParent(), "Jugador");
			v.setVisible(true);
			dispose();

		}

		if (e.getActionCommand().equals("Salir")) {
			System.exit(0);
		}
	}
}