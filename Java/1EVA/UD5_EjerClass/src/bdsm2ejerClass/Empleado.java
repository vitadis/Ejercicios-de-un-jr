package bdsm2ejerClass;
import java.util.Random;
public class Empleado {
	
	private int dni;
	private String nombre, primerApellido;

	
	public static int asignarDNI() {
		Random rd = new Random();
		int numRandom = rd.nextInt(9999999)+100;
		return numRandom;
	}
	
	public Empleado() {
		this.setDni(asignarDNI());
		this.setNombre(null);
		this.setPrimerApellido(null);
	}
	
	public Empleado(String nombre, String primerApellido) {
		this.setDni(asignarDNI());
		this.setNombre(nombre);
		this.setPrimerApellido(primerApellido);
	}

	public int getDni() {
		return dni;
	}

	public void setDni(int dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPrimerApellido() {
		return primerApellido;
	}

	public void setPrimerApellido(String primerApellido) {
		this.primerApellido = primerApellido;
	}
	
	public String toString() {
		return "Empleado(DNI: "+getDni()+" Nombre:"+getNombre()+" PrimerApellido: "+getPrimerApellido();
	}
	
	public char letraDNI() {
		char[] tabla = {'T', 'R', 'W', 'A', 'G', 'M', 'Y', 'F', 'P', 'D', 'X', 'B', 'N', 'J', 'Z', 'S', 'Q', 'V', 'H', 'L', 'C', 'K', 'E'};
		char letraDNI = tabla[getDni()%23];
		return letraDNI;
	}
	public String dniCompleto() {
		String dniCompleto = getDni()+letraDNI()+"";
		return dniCompleto;
	}
}
