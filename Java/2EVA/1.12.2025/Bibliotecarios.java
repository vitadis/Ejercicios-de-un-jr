
package bibliotecasYSocios;

import java.time.LocalDate;



public class Bibliotecarios extends Socios {
	private final int plusFijo = 30;
	private NomSeccion seccion;

	// seccionElegida = NomSeccion.valueOf(entrada.toUpperCase());

	public Bibliotecarios(String dni, String nombreCompleto, LocalDate fechaAlta, int limiteLibros, NomSeccion seccion) {
		super(dni, nombreCompleto, fechaAlta, limiteLibros);
		this.seccion=seccion;
	}

	public NomSeccion getSeccion() {
		return seccion;
	}

	public void setSeccion(NomSeccion seccion) {
		this.seccion = seccion;
	}

	public int getPlusFijo() {
		return plusFijo;
	}

	@Override
	public String toString() {
		return super.toString()+"  Bibliotecarios [plusFijo=" + plusFijo + ", seccion=" + seccion + "]";
	}
	
}