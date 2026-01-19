package clases;

import java.time.LocalDate;
import java.util.HashMap;

public class Cliente extends Persona {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private LocalDate fechaAlt;
	private HashMap<String, Entrenamiento> entrenamientos;

	public Cliente(String dni, String nombre, LocalDate fechaAlt, HashMap<String, Entrenamiento> entrenamientos) {
		super(dni, nombre);
		this.fechaAlt = fechaAlt;
		this.entrenamientos = new HashMap<String, Entrenamiento>(entrenamientos);
	}

	public LocalDate getFechaAlt() {
		return fechaAlt;
	}

	public void setFechaAlt(LocalDate fechaAlt) {
		this.fechaAlt = fechaAlt;
	}

	public HashMap<String, Entrenamiento> getEntrenamientos() {
		return entrenamientos;
	}

	public void setEntrenamientos(HashMap<String, Entrenamiento> entrenamientos) {
		this.entrenamientos = new HashMap<String, Entrenamiento>(entrenamientos);
	}

	@Override
	public String visualizar() {
		return super.visualizar() + "\n\tTipo persona: Cliente\n\tFecha alta: " + getFechaAlt()
				+ visualizarEntrenamiento();
	}

	// visualizar entrenamiento
	private String visualizarEntrenamiento() {
		String cadena = "\n\t------Entrenamientos--------";
		for (String k : entrenamientos.keySet()) {
			cadena += "\n\t" + entrenamientos.get(k);

		}
		return cadena;
	}
}
