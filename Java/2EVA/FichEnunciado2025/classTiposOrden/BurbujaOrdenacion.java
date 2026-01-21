package classTiposOrden;

import java.util.ArrayList;

import clases.Persona;

public class BurbujaOrdenacion {

	/**
	 * Este es el metodo por default, el cual ordena por el nombre.
	 * 
	 * Se puede modificar este metodo burbuja segun sea ascendente por defaul y DESC
	 * si se quiere descendente.
	 * 
	 * Para ordenar con un entero lo mismo pero con el metodo que retorne el entero;
	 * 
	 */
	public static <H extends Persona> void burbujaString(ArrayList<H> personas, ManeraOrdenar criterio,
			String tipoOrden) {

		for (int i = 0; i < personas.size() - 1; i++) {
			for (int j = 0; j < personas.size() - 1 - i; j++) {

				boolean condicion = criterio.compararString(personas.get(j), personas.get(j + 1)) > 0;

				if (tipoOrden.equalsIgnoreCase("desc"))
					condicion = criterio.compararString(personas.get(j), personas.get(j + 1)) < 0;

				// si el indice x+1 va antes que x, se intercambian de valor ya que quiero
				// ordenar de la A a Z
				if (condicion) {
					H aux = personas.get(j);
					personas.set(j, personas.get(j + 1));
					personas.set(j + 1, aux);
				}
			}
		}
	}
	
	// en caso de que tenga que ordenar teniendo en cuenta dos parametros
	/* 
	for (int i = 0; i < personas.size() - 1; i++) {
		for (int j = 0; j < personas.size() - 1 - i; j++) {

			boolean condicion = criterio.compararString(personas.get(j), personas.get(j + 1)) > 0;
			boolean condicion2 = criterio.compararString(personas.get(j), personas.get(j + 1)) == 0; 
			if (tipoOrden.equalsIgnoreCase("desc"))
				condicion = criterio.compararString(personas.get(j), personas.get(j + 1)) < 0;

			// si el indice x+1 va antes que x, se intercambian de valor ya que quiero
			// ordenar de la A a Z
			if (condicion) {
				H aux = personas.get(j);
				personas.set(j, personas.get(j + 1));
				personas.set(j + 1, aux);
			}
			if (condicion2 && criterio.compararString(personas.get(j), personas.get(j + 1)) > 0) {
				H aux = personas.get(j);
				personas.set(j, personas.get(j + 1));
				personas.set(j + 1, aux);
			}
				
			
			
		}
	}
	
	*/
}
