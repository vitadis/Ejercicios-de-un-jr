package bibliotecasYSocios;

import java.time.LocalDate;

public class Socios {

	private final String nombreBiblioteca = "Lectura Viva";
	private String dni, nombreCompleto;

	private LocalDate fechaAlta;

	private int limiteLibros;

	private final double cuotaMes = 12.0;

	public Socios(String dni, String nombreCompleto, LocalDate fechaAlta, int limiteLibros) {
		this.dni = dni;
		this.nombreCompleto = nombreCompleto;
		this.fechaAlta = fechaAlta;
		this.limiteLibros = limiteLibros;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNombreCompleto() {
		return nombreCompleto;
	}

	public void setNombreCompleto(String nombreCompleto) {
		this.nombreCompleto = nombreCompleto;
	}

	public LocalDate getFechaAlta() {
		return fechaAlta;
	}

	public void setFechaAlta(LocalDate fechaAlta) {
		this.fechaAlta = fechaAlta;
	}

	public int getLimiteLibros() {
		return limiteLibros;
	}

	public void setLimiteLibros(int limiteLibros) {
		this.limiteLibros = limiteLibros;
	}

	public String getNombreBiblioteca() {
		return nombreBiblioteca;
	}

	public double getCuotaMes() {
		return cuotaMes;
	}
	
	

	@Override
	public String toString() {
		return "Socios [nombreBiblioteca=" + nombreBiblioteca + ", dni=" + dni + ", nombreCompleto=" + nombreCompleto
				+ ", fechaAlta=" + fechaAlta + ", limiteLibros=" + limiteLibros + ", cuotaMes=" + cuotaMes + "]";
	}

	public double cuotaFinal() {
		int cantidad = getLimiteLibros() / 3;
		double precioFinal = getCuotaMes() + cantidad;
		if (LocalDate.now().getYear() - fechaAlta.getYear() >= 8) {
			precioFinal -= 2;
		}
		return precioFinal;
	}
}