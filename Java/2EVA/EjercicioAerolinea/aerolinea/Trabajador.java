package aerolinea;

import java.time.LocalDate;

public abstract class Trabajador {
	protected String dni, nombre, apellidos;
	protected LocalDate fechaNac, fechaalt;

	public Trabajador(String dni, String nombre, String apellidos, LocalDate fechaNac, LocalDate fechaalt) {
		this.dni = dni;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.fechaNac = fechaNac;
		this.fechaalt = fechaalt;
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

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public LocalDate getFechaNac() {
		return fechaNac;
	}

	public void setFechaNac(LocalDate fechaNac) {
		this.fechaNac = fechaNac;
	}

	public LocalDate getFechaalt() {
		return fechaalt;
	}

	public void setFechaalt(LocalDate fechaalt) {
		this.fechaalt = fechaalt;
	}

	@Override
	public String toString() {
		return "Trabajador: DNI: " + getDni() + ", Nombres: " + getNombre() + ", Apellidos: " + getApellidos()
				+ ", Fecha nacimiento: " + getFechaNac()+", Fecha alta: "+getFechaalt();
	}

}
