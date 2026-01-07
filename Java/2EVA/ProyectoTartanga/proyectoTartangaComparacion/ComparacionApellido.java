package proyectoTartangaComparacion;

import proyectoTartanga.Persona;

public class ComparacionApellido implements Comparar {

	/**
	 *  @return 0 (si son iguales)
	 *  <0 (si p1 va antes que p2)
	 *  >0 (si p2 va antes que p1)
	 * */
	
	@Override
	public int comparar(Persona p1, Persona p2) {
		return p1.getApellido().compareToIgnoreCase(p2.getApellido());
	}

	@Override
	public int sumar(Persona p1, Persona p2) {
		// TODO Auto-generated method stub
		return 0;
	}
	
}