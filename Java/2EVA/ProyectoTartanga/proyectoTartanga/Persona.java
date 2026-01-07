package proyectoTartanga;

public abstract class Persona {
	protected String dni, nombre, apellido;

	public Persona(String dni, String nombre, String apellido) {
		super();
		this.dni = validarDni(dni);
		this.nombre = nombre;
		this.apellido = apellido;
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

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String visualizar() {
		String info = "DNI: " + getDni() + "\n	Nombre: " + getNombre() + "\n	Apellido: " + getApellido();
		return info;
	}

	// metodos para excepciones
	private String validarDni(String dni) {
		dni = dni.toUpperCase();
		if (dni == null || !dni.matches("[0-9]{8}[A-Z]")) {
			throw new IllegalArgumentException("El DNI debe tener el formato NNNNNNNNL");
		}

		if (!letraDniValida(dni)) {
			throw new IllegalArgumentException("La letra del dni no es valida");
		}

		return dni;
	}

	// letra valida
	private boolean letraDniValida(String dni) {
		int numero = Integer.parseInt(dni.substring(0, 8)); // la subcadena del dni lo trasformo en numero
		char letra = Character.toUpperCase(dni.charAt(8)); // la letra lo transformo en caracter

		String letras = "TRWAGMYFPDXBNJZSQVHLCKE"; // String con las letras permitidas
		char letraCorrecta = letras.charAt(numero % 23); // saco la letra correcta

		if (letra == letraCorrecta) // comparo los caracteres
			return true;
		else
			return false;

	}

}
