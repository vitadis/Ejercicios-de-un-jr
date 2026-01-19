package clases;

import java.io.Serializable;
import java.time.LocalDate;

public class Entrenamiento implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String codigo;
	private LocalDate fechaEntrenamiento;
	private String nombreEjercicio;
	private int numRep;
	
	public Entrenamiento(String codigo, LocalDate fechaEntrenamiento, String nombreEjercicio, int numRep) {
		this.codigo = codigo;
		this.fechaEntrenamiento = fechaEntrenamiento;
		this.nombreEjercicio = nombreEjercicio;
		this.numRep = numRep;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public LocalDate getFechaEntrenamiento() {
		return fechaEntrenamiento;
	}
	public void setFechaEntrenamiento(LocalDate fechaEntrenamiento) {
		this.fechaEntrenamiento = fechaEntrenamiento;
	}
	public String getNombreEjercicio() {
		return nombreEjercicio;
	}
	public void setNombreEjercicio(String nombreEjercicio) {
		this.nombreEjercicio = nombreEjercicio;
	}
	public int getNumRep() {
		return numRep;
	}
	public void setNumRep(int numRep) {
		this.numRep = numRep;
	}
	@Override
	public String toString() {
		return "Entrenamiento [codigo=" + codigo + ", fechaEntrenamiento=" + fechaEntrenamiento + ", nombreEjercicio="
				+ nombreEjercicio + ", numRep=" + numRep + "]";
	}
}	
