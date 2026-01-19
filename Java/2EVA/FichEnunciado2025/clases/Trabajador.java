package clases;

public class Trabajador extends Persona {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String usuario, contraseña;
	private Cargo cargo;

	public Trabajador(String dni, String nombre, String usuario, String contraseña, Cargo cargo) {
		super(dni, nombre);
		this.usuario = usuario;
		this.contraseña = contraseña;
		this.cargo = cargo;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getContraseña() {
		return contraseña;
	}

	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}

	public Cargo getCargo() {
		return cargo;
	}

	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
	}

	@Override
	public String visualizar() {
		return super.visualizar() + "\n\tTipo persona: Trabajador\n\tUsuario: " + getUsuario() + "\n\tCargo: "
				+ getCargo();

	}

}
