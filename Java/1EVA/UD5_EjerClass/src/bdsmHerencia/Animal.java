package bdsmHerencia;

public class Animal {

	private String nombre;

	private int edad;

	public Animal(String nombre, int edad) {

		this.nombre = nombre;

		this.edad = edad;

	}

	public String getNombre() {

		return nombre;

	}

	public int getEdad() {
		return edad;

	}

	public String sonido() {

		return "Sonido genérico";

	}

	@Override

	public String toString() {

		return "Nombre: " + nombre + ", Edad: " + edad;

	}

}
