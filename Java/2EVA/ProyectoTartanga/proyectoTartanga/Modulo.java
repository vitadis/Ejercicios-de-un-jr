package proyectoTartanga;

public class Modulo {
	private String codigo, nombre;
	private Integer nota;
	private static int contador = 1;

	public Modulo(String nombre, Integer nota) {
		super();
		this.codigo = generarCod(nombre);
		this.nombre = nombre;
		this.nota = nota;
		contador++;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getNota() {
		return nota;
	}

	public void setNota(Integer nota) {
		this.nota = nota;
	}

	public String visualizar() {
		return "Cod: "+getCodigo()+"\n	Nombre: "+getNombre()+"\n	Nota: "+getNota();
	}
	// generar codigo
	private static String generarCod(String nombre) {
		String cod = nombre.substring(0, 3) + "-" + contador;
		return cod;
	}

}
