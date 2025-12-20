package bibliotecasYSocios;

import java.time.LocalDate;
import java.util.regex.Pattern;

import java.util.ArrayList;

import trataExcepciones.Util;

public class Principal {

	public static void main(String[] args) {

		ArrayList<Socios> biblioteca = new ArrayList<>();

		boolean noSalir = true;
		while (noSalir) {
			int opcion = menu();
			switch (opcion) {
			case 1 -> menu1(biblioteca);
			case 2 -> menu2(biblioteca);
			case 3 -> menu3(biblioteca);
			case 4 -> menu4(biblioteca);
			case 5 -> menu5(biblioteca);
			case 6 -> menu6(biblioteca);
			case 7 -> menu7(biblioteca);
			case 8 -> menu8(biblioteca);
			case 9 -> noSalir = false;
			default -> System.out.println("Agrega una opcion valido");
			}

		}

	}

	public static int menu() {
		String menu = "1. Introducir datos de socios y/o bibliotecarios\n" + "2. Visualizar todos los datos\n"
				+ "3. Visualizar unicamente los biblotecarios\n" + "4. Visualizar bibliotecarios una seccion concreta\n"
				+ "5. Visualizar un socio en especifico\n" + "6. Mirar segun las cuotas\n"
				+ "7. Ver usuarios con la fecha\n" + "8. Dar de baja a un socio\n" + "9. Salir\n"
				+ "Elige una opcion: ";
		int opcion = Util.leerInt(menu);
		return opcion;
	}

	public static ArrayList<Socios> menu1(ArrayList<Socios> lista) {
		// le pregunto de nuevo si quiere continuar
		String pregunta1 = Util.introducirCadena("¿Quieres dar de alta? (s/n): ");
		if (!"s".equalsIgnoreCase(pregunta1)) {
			System.out.println("Volviendo al menú...");
			return lista;
		}

		// RE para solo permitir el formato dni

		// le pido el dni y si existe no agrego
		String dni;
		while (true) {
			dni = dniFormato();
			if (dniExisteCiclo(lista, dni) > -1) {
				System.out.println("Este DNI ya esta registrado.");
				continue;
			}
			break;
		}

		// Nombre obligatorio
		String nombreCompleto;
		do {
			nombreCompleto = Util.introducirCadena("Nombre del alumno: ");
			if (nombreCompleto.length() == 0)
				System.out.println("El nombre no puede quedar vacío.");
		} while (nombreCompleto.length() == 0);

		// fecha de alta
		LocalDate fechaAlta = LocalDate.now();

		// limites de libros
		int limiteLibros = Util.leerInt("Dime el limite de libros");

		// EN CASO DE QUE SEA BIBLIOTECARIO
		boolean esBibliotecario = Util.introducirCadena("Es bibliotecario s/n: ").equalsIgnoreCase("s");

		NomSeccion seccionElegida = null;

		while (true) {
			try {
				if (esBibliotecario) {
					seccionElegida = NomSeccion.valueOf(Util
							.introducirCadena("Elige las siguientes secciones INFANTIL, HISTORIA, COMIC, TECNOLOGIA: ")
							.toUpperCase());
				}
				break;
			} catch (Exception e) {
				System.out.println("Agrega una opcion valida");
			}
		}
		Socios socio = null;
		if (esBibliotecario)
			socio = new Bibliotecarios(dni, nombreCompleto, fechaAlta, limiteLibros, seccionElegida);
		else
			socio = new Socios(dni, nombreCompleto, fechaAlta, limiteLibros);
		lista.add(socio);

		System.out.println("Socio de alta correctamente");

		return lista;
	}

	// visualizar todos los elementos
	public static void menu2(ArrayList<Socios> lista) {
		boolean existe = false;
		for (Socios a : lista) {
			System.out.println(a);
			existe = true;
		}
		if (!existe)
			System.out.println("No existe ningun usuario registrado");
	}

	// visualizar unicamente los bibliotecarios
	public static void menu3(ArrayList<Socios> lista) {
		boolean existe = false;
		for (Socios a : lista) {
			if (a instanceof Bibliotecarios) {
				System.out.println(a);
				existe = true;
			}
		}
		if (!existe)
			System.out.println("No existe bibliotecarios");
	}

	// visualizar usuarios en usa seccion en concreta

	public static void menu4(ArrayList<Socios> lista) {
		NomSeccion seccionElegida = null;

		while (true) {
			try {
				seccionElegida = NomSeccion.valueOf(
						Util.introducirCadena("Elige las siguientes secciones INFANTIL, HISTORIA, COMIC, TECNOLOGIA: ")
								.toUpperCase());
				boolean existe = false;
				for (Socios a : lista) {
					if (a instanceof Bibliotecarios) {
						Bibliotecarios b = (Bibliotecarios) a;
						if (b.getSeccion() == seccionElegida) {
							System.out.println(a);
							existe = true;
						}
					}
				}
				if (!existe)
					System.out.println("No existe bibliotecarios en esta sección");
				break;
			} catch (Exception g) {
				System.out.println("Selecciona una seccion valida");
			}
		}
	}

	// visualizar un socio en especifico
	public static void menu5(ArrayList<Socios> lista) {
		String dni = dniFormato();
		int anios = Util.leerInt("Dime los años que estas de alta: ");
		boolean existe = false;

		for (Socios a : lista) {
			if (a.getDni().equals(dni) && LocalDate.now().getYear() - a.getFechaAlta().getYear() == anios) {
				System.out.println(a);
				existe = true;
				break;
			}
		}
		if (!existe)
			System.out.println("No existe Socios con sus especificaciones");
	}

	// mirar segun las cuotas
	public static void menu6(ArrayList<Socios> lista) {
		double cuotaComp = Util.leerDouble("Introduce la cantidad de cuota a comparar: ");
		boolean existe = false;
		for (Socios a : lista) {
			if (a.cuotaFinal() >= cuotaComp) {
				System.out.println(a);
				existe = true;
			}
		}
		if (!existe)
			System.out.println("No existe personas con mas o igual de la cuota introducida");
	}

	// pedir año y mostrarte bibliotecarios que lleven mas o ese tiempo en la
	// biblioteca
	public static void menu7(ArrayList<Socios> lista) {
		int anios = Util.leerInt("Introduce los años que quieres comparar: ");
		boolean existe = false;
		for (Socios e : lista) {
			if (LocalDate.now().getYear() - e.getFechaAlta().getYear() == anios) {
				System.out.println(e);
				existe = true;
			}
		}
		if (!existe)
			System.out.println("No existe ningun usuario con tus indicaciones");
	}

	// dar de baja a un socio a partir de su dni

	public static ArrayList<Socios> menu8(ArrayList<Socios> lista) {
		// buscar el dni
		boolean existe = false;
		String dni = dniFormato();
		int indice = dniExisteCiclo(lista, dni);
		if (indice > -1) {
			lista.remove(indice);
			existe = true;
		}
		if (!existe)
			System.out.println("No existe este usuario");
		return lista;
	}

	// metodos secundarios
	private static int dniExisteCiclo(ArrayList<Socios> lista, String dni) {
		int indice = 0;
		for (Socios a : lista) {

			if (a.getDni().equalsIgnoreCase(dni)) {
				return indice;
			}
			indice++;
		}
		return -1;
	}

	// formato dni ya que lo uso multiples veces lo guardo en una clase sin mas
	private static String dniFormato() {
		String dni;
		while (true) {
			dni = Util.introducirCadena("Ingresa tu DNI (9 caracteres): ").toUpperCase().replace(" ", ""); // blancos
			String regex = "^[0-9]{8}[A-Z]$";
			/*
			 * ^ indica el inicio de la cadena [0-9] formato de numeros de 0 a 9 {8} indica
			 * el tamaño del rango que se indica a la izquierda [A-Z] indica del char A - Z,
			 * en aqui no le indico el rango ya que es solo uno $ es el final de la cadena
			 */

			if (!Pattern.matches(regex, dni)) { // le pregunto si mi cadena cumple con esta RE
				System.out.println("Tiene que ponder el formato DNI (NNNNNNNNL) ");
				continue;
			}

			if (dni.length() != 9) {
				System.out.println("El NIF debe tener 9 caracteres.");
				continue;
			}

			break;
		}
		return dni;

	}

}