package proyectoTartanga;

import java.util.ArrayList;

public class Alumno extends Persona {
	private Ciclo ciclo;
	private boolean repetidor;
	private ArrayList<Modulo> modulos;

	public Alumno(String dni, String nombre, String apellido, Ciclo ciclo, boolean repetidor,
			ArrayList<Modulo> modulos) {
		super(dni, nombre, apellido);
		this.ciclo = ciclo;
		this.repetidor = repetidor;
		this.modulos = modulos;
	}

	public Ciclo getCiclo() {
		return ciclo;
	}

	public void setCiclo(Ciclo ciclo) {
		this.ciclo = ciclo;
	}

	public boolean isRepetidor() {
		return repetidor;
	}

	public void setRepetidor(boolean repetidor) {
		this.repetidor = repetidor;
	}

	public ArrayList<Modulo> getModulos() {
		return modulos;
	}

	public void setModulos(ArrayList<Modulo> modulos) {
		this.modulos = modulos;
	}

	@Override
	public String visualizar() {
		String info = super.visualizar() + "\n	Tipo: Estudiante\n	Ciclo: " + getCiclo() + "\n	Es repetidor: "
				+ isRepetidor();
		return info;
	}

}
