package aerolinea;

import java.time.LocalDate;
import java.util.ArrayList;

public class Piloto extends Trabajador {
	private LocalDate fechaLic;
	private String residenciaOfi;
	private ArrayList<Vuelo> vuelos;
	
	public Piloto(String dni, String nombre, String apellidos, LocalDate fechaNac, LocalDate fechaalt,
			LocalDate fechaLic, String residenciaOfi) {
		super(dni, nombre, apellidos, fechaNac, fechaalt);
		this.fechaLic = fechaLic;
		this.residenciaOfi = residenciaOfi;
		this.vuelos = new ArrayList<Vuelo>();
	}
	
	public LocalDate getFechaLic() {
		return fechaLic;
	}
	public void setFechaLic(LocalDate fechaLic) {
		this.fechaLic = fechaLic;
	}
	public String getResidenciaOfi() {
		return residenciaOfi;
	}
	public void setResidenciaOfi(String residenciaOfi) {
		this.residenciaOfi = residenciaOfi;
	}
	public ArrayList<Vuelo> getVuelos() {
		return vuelos;
	}
	public void setVuelos(ArrayList<Vuelo> vuelos) {
		this.vuelos = vuelos;
	}

	@Override
	public String toString() {
		return super.toString()+", Tipo trabajador: Piloto, Fecha licencia: " + fechaLic + ", Residencia oficial: " + residenciaOfi;
	}
}
