package clases;

import java.io.Serializable;

public abstract class Persona implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected String dni, nombre;
	
	public Persona(String dni, String nombre) {
		this.dni = validarDni(dni);
		this.nombre = nombre;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String visualizar() {
		return "DNI: "+getDni()+"\n\tNombre: "+getNombre();
	}
	
	// validar el dni
	// metodos para excepciones
		private String validarDni(String dni) {
			dni = dni.toUpperCase();
			if (dni == null || !dni.matches("[0-9]{8}[A-Z]")) {
				throw new IllegalArgumentException("El DNI debe tener el formato NNNNNNNNL");
			}
			return dni;
		}

}
