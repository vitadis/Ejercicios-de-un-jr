package trataExcepciones;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
// import java.util.ArrayList;

public class Util2do {

	// fechas
	/**
	 * <p>
	 * Retorna boolean según si una fecha está dentro de un rango de fechas.
	 * </p>
	 *
	 * @param fnicio fecha inicio
	 * @param fFinal fecha final
	 * @param fecha  fecha a evaluar
	 * @return true si la fecha está entre fnicio y fFinal (inclusive)
	 */
	public static boolean estaEntreFechas(LocalDate fnicio, LocalDate fFinal, LocalDate fecha) {
		boolean sicumple = false;
		if (fnicio == null || fFinal == null || fecha == null) {
			return sicumple;
		}
		sicumple = (fecha.isEqual(fnicio) || fecha.isAfter(fnicio))
				&& (fecha.isEqual(fFinal) || fecha.isBefore(fFinal));
		return sicumple;
	}

	/**
	 * <p>
	 * Retorna boolean según si una fecha y hora está dentro de un rango.
	 * </p>
	 *
	 * @param fInicio fecha y hora de inicio
	 * @param fFinal  fecha y hora final
	 * @param fecha   fecha y hora a evaluar
	 * @return true si fecha está entre fInicio y fFinal (inclusive)
	 */
	public static boolean estaEntreFechaHora(LocalDateTime fInicio, LocalDateTime fFinal, LocalDateTime fecha) {
		boolean sicumple = false;
		if (fInicio == null || fFinal == null || fecha == null) {
			return sicumple;
		}
		sicumple = (fecha.isEqual(fInicio) || fecha.isAfter(fInicio))
				&& (fecha.isEqual(fFinal) || fecha.isBefore(fFinal));
		return sicumple;
	}

	// retorna los dias entre dos fechas
	public static long diasEntreFechas(LocalDate inicio, LocalDate fin) {
		if (inicio == null || fin == null) {
			return 0;
		}
		long dias = ChronoUnit.DAYS.between(inicio, fin);
		return dias;
	}

	public static long diasEntreFechaHora(LocalDateTime inicio, LocalDateTime fin) {
		if (inicio == null || fin == null) {
			return 0;
		}
		long dias = ChronoUnit.DAYS.between(inicio.toLocalDate(), fin.toLocalDate());
		return dias;
	}

	// ---------------UTILES PARA LOS FICHEROS--------------
	// Son ejemplos en una clasee en especifico pero simplemente es cambiar la clase
	// y ya
	// Primero tengo que leer el archivo y guardarlo
	// en caso de que se modificar simplemente tendre que modificar segun el
	// parametro que me pida, sin usar el return

	/*
	public static int indiceDni(ArrayList<Propietario> propietarios, String dni) {

		int indice = -1;
		for (int i = 0; i < propietarios.size(); i++) {
			if (dni.equalsIgnoreCase(propietarios.get(i).getDni())) {
				return i;
			}
		}
		return indice;
	}
*/
}
