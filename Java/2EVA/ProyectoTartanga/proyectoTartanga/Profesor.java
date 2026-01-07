package proyectoTartanga;

import java.time.LocalDate;

public class Profesor extends Persona {
	private Double salario;
	private LocalDate fechaNac;
	private Cargo cargo;

	public Profesor(String dni, String nombre, String apellido, Double salario, LocalDate fechaNac, Cargo cargo) {
		super(dni, nombre, apellido);
		this.salario = validarDni(salario);
		this.fechaNac = fechaNac;
		this.cargo = cargo;
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

	public LocalDate getFechaNac() {
		return fechaNac;
	}

	public void setFechaNac(LocalDate fechaNac) {
		this.fechaNac = fechaNac;
	}

	public Cargo getCargo() {
		return cargo;
	}

	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
	}

	// calcular que el salario sea mayor que 0

	private Double validarDni(Double salario) {

		if (salario == null || salario <= 0) {
			throw new NumberFormatException("El salario no tiene que estar vacio o ser menor a 0");
		}
		return salario;
	}

}
