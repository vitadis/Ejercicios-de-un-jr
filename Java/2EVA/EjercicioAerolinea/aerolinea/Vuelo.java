package aerolinea;

import java.time.LocalDateTime;
import java.util.Locale;
import java.util.regex.Pattern;

public class Vuelo {

	private String identificador;
	private String origen;
	private String destino;
	private LocalDateTime fechaIni;
	private LocalDateTime fechaFin;
	private String tipoAvi;

	public Vuelo(String origen, String destino, LocalDateTime fechaIni, LocalDateTime fechaFin, String tipoAvi) {

		this.origen = validarTexto(origen);
		this.destino = validarTexto(destino);
		this.tipoAvi = validarTexto(tipoAvi);

		this.fechaIni = fechaIni;
		this.fechaFin = fechaFin;

		this.identificador = calcularId();
	}

	public String getIdentificador() {
		return identificador;
	}

	public String getOrigen() {
		return origen;
	}

	public void setOrigen(String origen) {
		this.origen = validarTexto(origen);
		this.identificador = calcularId();
	}

	public String getDestino() {
		return destino;
	}

	public void setDestino(String destino) {
		this.destino = validarTexto(destino);
		this.identificador = calcularId();
	}

	public LocalDateTime getFechaIni() {
		return fechaIni;
	}

	public void setFechaIni(LocalDateTime fechaIni) {
		this.fechaIni = fechaIni;
	}

	public LocalDateTime getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(LocalDateTime fechaFin) {
		this.fechaFin = fechaFin;
	}

	public String getTipoAvi() {
		return tipoAvi;
	}

	public void setTipoAvi(String tipoAvi) {
		this.tipoAvi = validarTexto(tipoAvi);
	}

	private String calcularId() {
		return origen.substring(0, 3) + "/" + destino.substring(0, 3);
	}

	// mi metodo con mi excepcion creada
	private String validarTexto(String texto) {
		if (texto == null) {
			throw new IllegalArgumentException("El texto no puede ser null");
		}

		texto = texto.toUpperCase(Locale.ROOT); // Lo uso para especificar el idioma del dispositivo

		Pattern patron = Pattern.compile("[A-ZÑ]{5,10}");

		if (!patron.matcher(texto).matches()) {
			throw new IllegalArgumentException("Texto inválido: debe contener entre 5 y 10 letras");
		}
		return texto;
	}

	@Override
	public String toString() {
		return "Vuelo [identificador=" + identificador + ", origen=" + origen + ", destino=" + destino + ", fechaIni="
				+ fechaIni + ", fechaFin=" + fechaFin + ", tipoAvi=" + tipoAvi + "]";
	}

}
