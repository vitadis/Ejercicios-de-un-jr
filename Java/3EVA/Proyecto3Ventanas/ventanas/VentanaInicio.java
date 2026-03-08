package ventanas;

import javax.swing.*;
import java.awt.event.*;

public class VentanaInicio extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtNombre;
	private JButton btnAceptar;
	private JButton btnSalir;

	public VentanaInicio() {

		setTitle("Inicio del Test");
		setSize(350, 200);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);

		JLabel lbl = new JLabel("Introduce tu nombre:");
		lbl.setBounds(30, 30, 200, 20);
		getContentPane().add(lbl);

		txtNombre = new JTextField();
		txtNombre.setBounds(30, 60, 200, 25);
		getContentPane().add(txtNombre);

		btnAceptar = new JButton("Siguiente");
		btnAceptar.setBounds(30, 100, 100, 30);
		btnAceptar.addActionListener(this);
		getContentPane().add(btnAceptar);

		btnSalir = new JButton("Salir");
		btnSalir.setBounds(150, 100, 100, 30);
		btnSalir.addActionListener(this);
		getContentPane().add(btnSalir);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == btnAceptar) {

			String nombre = txtNombre.getText();

			VentanaTest v = new VentanaTest(this, nombre);
			v.setVisible(true);
			dispose();

		}

		if (e.getSource() == btnSalir) {
			System.exit(0);
		}
	}

	public static void main(String[] args) {
		VentanaInicio v = new VentanaInicio();
		v.setVisible(true);
	}
}