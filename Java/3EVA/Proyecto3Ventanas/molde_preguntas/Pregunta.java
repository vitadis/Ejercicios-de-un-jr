
package molde_preguntas;

import java.util.ArrayList;

public class Pregunta {

	private String enunciado;
	private ArrayList<String> opciones;
	private int correcta;

	public Pregunta(String enunciado, ArrayList<String> opciones, int correcta) {
		this.enunciado = enunciado;
		this.opciones = opciones;
		this.correcta = correcta;
	}

	public String getEnunciado() {
		return enunciado;
	}

	public void setEnunciado(String enunciado) {
		this.enunciado = enunciado;
	}

	public ArrayList<String> getOpciones() {
		return opciones;
	}

	public void setOpciones(ArrayList<String> opciones) {
		this.opciones = opciones;
	}

	public int getCorrecta() {
		return correcta;
	}

	public void setCorrecta(int correcta) {
		this.correcta = correcta;
	}

}