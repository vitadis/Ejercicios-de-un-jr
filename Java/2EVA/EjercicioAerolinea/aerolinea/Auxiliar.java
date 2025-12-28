package aerolinea;

import java.time.LocalDate;
import java.util.HashSet;

public class Auxiliar extends Trabajador {
	private CargoAuxiliar cargo;
	private HashSet<String> idiomas;

	public Auxiliar(String dni, String nombre, String apellidos, LocalDate fechaNac, LocalDate fechaalt,
			CargoAuxiliar cargo) {
		super(dni, nombre, apellidos, fechaNac, fechaalt);
		this.cargo = cargo;
		this.idiomas = new HashSet<>();
	}

	public CargoAuxiliar getCargo() {
		return cargo;
	}

	public void setCargo(CargoAuxiliar cargo) {
		this.cargo = cargo;
	}

	
	public HashSet<String> getIdiomas() {
		return idiomas;
	}

	public void setIdiomas(HashSet<String> idiomas) {
		this.idiomas = idiomas;
	}

	@Override
	public String toString() {
		return super.toString()+", Tipo de trabajador: Auxiliar, Cargo: " + getCargo();
	}

	
}
