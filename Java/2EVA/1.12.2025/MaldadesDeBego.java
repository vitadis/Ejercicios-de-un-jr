package masDeberes;

import java.time.LocalDate;
import java.util.ArrayList;
import bibliotecasYSocios.*;

// librerias para realizar la comparacion y ordenar
import java.util.Comparator;

public class MaldadesDeBego {
	public static void main(String[] args) {

		ArrayList<Socios> lista = new ArrayList<>();

		lista.add(new Socios("12345678A", "Ana Pérez", LocalDate.of(2018, 5, 10), 6));
		lista.add(new Socios("23456789B", "Luis Gómez", LocalDate.of(2020, 1, 20), 3));
		lista.add(new Socios("34567890C", "Ana Pérez", LocalDate.of(2017, 9, 1), 6)); // mismo nombre, distinto dni
		lista.add(new Socios("45678901D", "María Ruiz", LocalDate.of(2015, 3, 12), 10));
		lista.add(new Bibliotecarios("234", "Luis", LocalDate.of(2019, 3, 12), 3, NomSeccion.TECNOLOGIA));
		lista.add(new Bibliotecarios("345", "Pedro", LocalDate.of(2020, 1, 20), 4, NomSeccion.INFANTIL));

		// Ordeno segun la comparacion de mi atributo de tipo int
		lista.sort(Comparator.comparingInt(Socios::getLimiteLibros));

		// ordenar enums
		//lista.sort(Comparator.comparing(Socios::getSeccion));

		// enums, pero si no tiene enum, lo que hago es comparar con el nombre
		Comparator<Socios> comp = (s1, s2) -> { // son los objetos del socio que se comparan entre si

			// Si ambos son Bibliotecarios, comparo por seccion
			if (s1 instanceof Bibliotecarios b1 && s2 instanceof Bibliotecarios b2) { // b1 y b2 son bariables locales que se crean para comparar, muy similar a la clase Exception, da igual el nombre 
				int cmp = b1.getSeccion().compareTo(b2.getSeccion()); // guardo la comparacion de las secciones en un int
				if (cmp != 0)
					return cmp; // si no empatan, devuelvo el resultado
			}

			// Si solo uno es Bibliotecario, pongo primero al que tiene seccion
			if (s1 instanceof Bibliotecarios && !(s2 instanceof Bibliotecarios))
				return -1; // a<b
			if (!(s1 instanceof Bibliotecarios) && s2 instanceof Bibliotecarios)
				return 1; // a>b

			// Si no son bibliotecarios o secciones iguales, comparo por nombre
			return s1.getNombreCompleto().compareTo(s2.getNombreCompleto());
		};
		// comparateTo.- string, integer, double, long, float, localdate, enum
		
		

		// ordenamos sin mas
		lista.sort(comp);

		// Primero dni luego el nombre
		Comparator<Socios> DniNombre = Comparator.comparing(Socios::getDni).thenComparing(Socios::getNombreCompleto); // en

		// segun los parametros de este comparador ordenara de forma ascendente
		lista.sort(DniNombre);
		// ordeno de forma descendente
		lista.sort(DniNombre.reversed());

		// Cuando coincide la primera cadena, y tengo que ordenar segun el nombre
		// si por ejemplo podemos comparar las fechas
		lista.sort(Comparator.comparing(Socios::getFechaAlta));

	}

}