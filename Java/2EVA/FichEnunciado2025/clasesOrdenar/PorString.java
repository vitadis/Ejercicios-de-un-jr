package clasesOrdenar;

import clases.Persona;

public class PorString implements Ordenar{

	@Override
	public int orden(Persona p1, Persona p2) {
		return p1.getNombre().compareTo(p2.getNombre());
	}

}
