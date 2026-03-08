package ventanas;

import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;
import molde_preguntas.*;

public class VentanaTest extends JDialog implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String nombre;
	private ArrayList<Pregunta> preguntas;

	private int indice = 0;
	private int aciertos = 0;

	private JLabel lblPregunta;
	private JComboBox<String> combo;
	private JButton btnComprobar;

	public VentanaTest(JFrame padre, String nombre) {

		super(padre, true);

		this.nombre = nombre;

		preguntas = BancoPreguntas.cargarPreguntas();

		setTitle("Test de Java");
		setSize(400, 200);
		setLocationRelativeTo(padre);
		getContentPane().setLayout(null);

		lblPregunta = new JLabel("");
		lblPregunta.setBounds(30, 20, 300, 20);
		getContentPane().add(lblPregunta);

		combo = new JComboBox<>();
		combo.setBounds(30, 60, 200, 25);
		getContentPane().add(combo);

		btnComprobar = new JButton("Comprobar");
		btnComprobar.setBounds(30, 100, 120, 30);
		btnComprobar.addActionListener(this);
		getContentPane().add(btnComprobar);

		cargarPregunta();
	}

	private void cargarPregunta() {

		Pregunta p = preguntas.get(indice);

		lblPregunta.setText(p.getEnunciado());

		combo.removeAllItems();

		for (String op : p.getOpciones()) {
			combo.addItem(op);
		}

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		Pregunta p = preguntas.get(indice);

		if (combo.getSelectedIndex() == p.getCorrecta()) {
			aciertos++;
		}

		indice++;

		if (indice < preguntas.size()) {

			cargarPregunta();

		} else {

			VentanaResultado vr = new VentanaResultado((JFrame) getParent(), nombre, aciertos, preguntas.size());
			vr.setVisible(true);
			dispose();

		}
	}
}