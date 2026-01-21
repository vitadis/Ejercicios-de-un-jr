package classTiposOrden;

import clases.Persona;

public class ManeraOrdenar implements PlantillaOrden {

	/**
	 * Comparo persona 1 con persona 2, ya depende del tipo de dato que se quiera
	 * comparar. en ese caso el metodo cambiara, si necesita comparar dos tipos de
	 * datos, simplemente se crea otro metodo en la interface si si o si necesita
	 * ser comparado.
	 * 
	 * <br>
	 * <p><b>
	 * -1 si p1 va antes que p2 0 si son iguales 1 si p2 va antes que p1
	 * </b></p>
	 */
	@Override
	public int compararString(Persona p1, Persona p2) {

		// para enteros (return dec1.compareTo(dec2);
		return comparacion(p1.getNombre(), p2.getNombre());
	}

	// creare los tipos de comparacion, segun su tipo de dato, int, string y en caso
	// de que sea iguales simplemente ordenar segun el siguiente parametro que sera
	// una str o un int
	// ya que los datos son de tipo string, pues simplemente comparare el string
	private static int comparacion(String str1, String str2) {
		return str1.compareTo(str2);
	}

	/* lo mismo pero con el entero
	private static int comparacion(Integer dec1, Integer dec2) {
		return dec1.compareTo(dec2);
	}*/

	/*
	 * Si quiero comparar dos tipos de datos ejemplo entero y string, digamos si el
	 * string es igual al string comparado, lo que tengo que hacer es comparar con
	 * el entero. y ordenarlo con ese parametro.
	 * 
	 * Aplicacion.- Primero comparo el parametro string, en caso de que el resultado
	 * sea cero, paso al entero y comparo con el entero, si aqui empata simplemente
	 * pasa a la otra comparacion.
	 * 
	 * Notas.- tendria que crear otra comparacion, e implementar el metodo o en la
	 * interface o en esta clase sin mas.
	 */

}
