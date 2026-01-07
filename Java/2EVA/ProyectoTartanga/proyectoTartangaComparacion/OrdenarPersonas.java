package proyectoTartangaComparacion;

import java.util.ArrayList;

import proyectoTartanga.Persona;

public class OrdenarPersonas {

	// T es una variable generica para cualquiera que herede de persona
	public static <H extends Persona> void ordenarBurbuja(ArrayList<H> personas, ComparacionApellido criterio) {

		for (int i = 0; i < personas.size() - 1; i++) {
			for (int j = 0; j < personas.size() - 1 - i; j++) {

				// si el indice x+1 va antes que x, se intercambian de valor ya que quiero
				// ordenar de la A a Z
				if (criterio.comparar(personas.get(j), personas.get(j + 1)) > 0) {
					H aux = personas.get(j);
					personas.set(j, personas.get(j + 1));
					personas.set(j + 1, aux);
				}
			}
		}
	}
}
