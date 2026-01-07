package proyectoTartanga;

import proyectoTartangaComparacion.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Optional;

import trataExcepciones.*;

public class Main {
	public static void main(String[] args) {
		ArrayList<Persona> persTar = new ArrayList<Persona>();
		int opcion = 0;
		do {
			opcion = menu();
			switch (opcion) {
			case 1 -> menu1(persTar);
			case 2 -> menu2(persTar);
			case 3 -> menu3(persTar);
			case 4 -> menu4(persTar);
			case 5 -> menu5(persTar);
			case 6 -> menu6(persTar);
			case 7 -> menu7(persTar);
			case 8 -> menu8(persTar);
			case 9 -> menu9(persTar);
			case 10 -> menu10(persTar);
			case 11 -> menu11(persTar);
			case 12 -> menu12(persTar);
			default -> System.out.println("Agrega opciones validas");
			}
		} while (opcion != 13);

	}

	public static int menu() {
		String menu = "----Proyecto tartanga-------" + "\n1. Matricular alumno/s" + "\n2. Listado de alumno/s"
				+ "\n3. Añadir profesor" + "\n4. Listado de profesor/es"
				+ "\n5. Listado de toda la información disponible de un alumno" + "\n6. Introducir nota/s de un alumno"
				+ "\n7. Modificar la nota de un modulo" + "\n8. Dar de vaja a un alumno"
				+ "\n9. Dar de baja un modulo de un alumno" + "\n10. Mostrar todas las personas ordenadas por apellido"
				+ "\n11. Mostrar los alumnos que hayan suspendido un módulo concreto"
				+ "\n12. Listado de los repetidores" + "\n13. Salir" + "\nElige una opcion: ";

		int opcion = Util.leerInt(menu);
		return opcion;
	}

	// matricular a un alumno
	public static void menu1(ArrayList<Persona> array) {
		String dni;
		do {
			dni = Util.comprobarFormatoDni();
			if (!noSeRepite(array, dni, Alumno.class)) // es para indicar una clase el class
				System.out.println("Este dni ya esta matriculado");
		} while (!noSeRepite(array, dni, Alumno.class));
		String nombre = Util.tamañoString(1, Optional.empty(), "Nombre: ");
		String apellido = Util.tamañoString(1, Optional.empty(), "Apellido: ");
		Ciclo ciclo = ciclillo();
		boolean esRepetidor = Util.introducirCadena("Es repetidor (s/n)").equalsIgnoreCase("s");

		// modulo
		ArrayList<Modulo> modulos = new ArrayList<Modulo>();
		int numMod = rangoNum(1, 13, "Cuantos modulos tienes : ");
		for (int m = 0; m < numMod; m++) {
			String nombreMod = Util.tamañoString(3, Optional.empty(), m + 1 + " NomModulo: ");
			Integer nota = null;
			modulos.add(new Modulo(nombreMod, nota));
		}
		Alumno alum = new Alumno(dni, nombre, apellido, ciclo, esRepetidor, modulos);
		array.add(alum);
	}

	// metodos secundarios para el menu1 (el ultimpo parametro, es para mandar la
	// clase con la que quiero comparar)
	private static boolean noSeRepite(ArrayList<Persona> array, String dni, Class<? extends Persona> tipo) {

		for (Persona p : array) {
			if (dni.equalsIgnoreCase(p.getDni()) && tipo.isInstance(p)) { // si ya esta y es de la clase que dije pues
																			// es false
				return false;
			}
		}
		return true; // de lo contrario false
	}

	// gestion ciclo
	private static Ciclo ciclillo() {
		Ciclo ciclo = null;
		boolean valido = false;
		do {
			try {
				String ciclillini = Util.introducirCadena("Ciclo (DAM, DAW)").toUpperCase();
				ciclo = Ciclo.valueOf(ciclillini);
				valido = true;

			} catch (IllegalArgumentException e) {
				System.out.println("Ciclo no válido. Introduce DAM o DAW.");
			}
		} while (!valido);

		return ciclo;
	}

	// Listado de alumno
	public static void menu2(ArrayList<Persona> array) {
		boolean condicion = Util.introducirCadena("Quieres visualizar todo¿? (s/n): ").equalsIgnoreCase("s");
		String dni = "";
		boolean existAll = false, existDni = false;
		if (!condicion)
			dni = Util.comprobarFormatoDni();
		for (Persona p : array) {
			if (p instanceof Alumno) {
				Alumno a = (Alumno) p;
				if (condicion) {
					System.out.println(a.visualizar());
				} else {
					if (dni.equalsIgnoreCase(a.getDni())) {
						System.out.println(a.visualizar());
						existDni = true;
					}
				}
			}
			existAll = true;
		}
		if (!existDni && !existAll)
			System.out.println("No existe ningun registro");
		else if (!existDni)
			System.out.println("No existe el dni");

	}

	// añadir a un profesor
	public static void menu3(ArrayList<Persona> array) {
		String dni;
		do {
			dni = Util.comprobarFormatoDni();
			if (!noSeRepite(array, dni, Profesor.class)) // es para indicar una clase el class
				System.out.println("Este dni ya esta matriculado");
		} while (!noSeRepite(array, dni, Profesor.class));
		String nombre = Util.tamañoString(1, Optional.empty(), "Nombre: ");
		String apellido = Util.tamañoString(1, Optional.empty(), "Apellido: ");
		double salario;
		do {
			salario = Util.leerDouble("Salario: ");
			if (salario <= 0)
				System.out.println("El salario tiene que ser mayor a 0");
		} while (salario <= 0);
		LocalDate fechaNac = Util.leerFecha("Introduce tus cumpleaños ");
		Cargo cargo = carguillo();

		Profesor profe = new Profesor(dni, nombre, apellido, salario, fechaNac, cargo);
		array.add(profe);
	}

	// gestionar el cargo
	private static Cargo carguillo() {
		Cargo ciclo = null;
		boolean valido = false;
		do {
			try {
				String ciclillini = Util.introducirCadena("Ciclo (PROFESOR, DIRECTOR, ADMINISTRATIVO)").toUpperCase();
				ciclo = Cargo.valueOf(ciclillini);
				valido = true;

			} catch (IllegalArgumentException e) {
				System.out.println("Ciclo no válido. Introduce PROFESOR, DIRECTOR o ADMINISTRATIVO");
			}
		} while (!valido);

		return ciclo;
	}

	// 4. Listado de profesor
	public static void menu4(ArrayList<Persona> array) {
		boolean condicion = Util.introducirCadena("Quieres visualizar todo¿? (s/n): ").equalsIgnoreCase("s");
		String dni = "";
		boolean existAll = false, existDni = false;

		if (!condicion)
			dni = Util.comprobarFormatoDni();
		for (Persona p : array) {
			if (p instanceof Profesor) {
				Profesor pr = (Profesor) p;
				if (condicion) {
					System.out.println(pr.visualizar());
				} else {
					if (dni.equalsIgnoreCase(pr.getDni())) {
						System.out.println(pr.visualizar());
						existDni = true;
					}
				}
			}
			existAll = true;
		}
		if (!existDni && !existAll)
			System.out.println("No existe ningun registro");
		else if (!existDni)
			System.out.println("No existe el DNI");
	}

	// Listado de toda la información disponible de un alumno (mostrar las notas de
	// los modulos)
	public static void menu5(ArrayList<Persona> array) {
		String dni = Util.comprobarFormatoDni();
		boolean existeDni = false, existeMod = false;

		// busco la informacion para mostrar
		for (Persona p : array) {
			if (p instanceof Alumno) {
				Alumno a = (Alumno) p;
				if (dni.equalsIgnoreCase(a.getDni())) {
					existeDni = true;
					if (a.getModulos().size() != 0) {
						for (Modulo m : a.getModulos()) {
							String mensaje = m.getNombre() + ": ";
							if (m.getNota() != 0)
								mensaje += m.getNota();
							else
								mensaje += "SIN NOTA";
							System.out.println(mensaje);
							existeMod = true;
						}
					}
				}
			}
		}
		if (!existeDni)
			System.out.println("No existe el Dni " + dni);
		else if (!existeMod)
			System.out.println("No existe ningun modulo agregado");
	}

	// -------------EN PROCESO, EL ALUMNO NO SE SI PUEDE MATRICULARCE A MAS CICLOS
	// 6. Introducir nota/s de un alumno (segun el nombre y apellido)s
	public static void menu6(ArrayList<Persona> array) {
		String nombre = Util.tamañoString(1, Optional.empty(), "Nombre: ");
		String apellido = Util.tamañoString(1, Optional.empty(), "Apellido: ");

		ArrayList<Integer> nombresIdenticos = indNomRep(array, nombre, apellido, "Alumno");

		boolean existAl = false;
		int c = 0;
		for (int i : nombresIdenticos) {
			c++;
			Alumno a = (Alumno) array.get(i);
			String dni = a.getDni();
			System.out.printf("%dº DNI: %s \n", c, dni);
			// nota si no quiere poner la nota se puede dejar vacio
			ArrayList<Modulo> modulos = a.getModulos();

			for (int y = 0; y < modulos.size(); y++) {
				boolean notaEmpty = Util.introducirCadena(modulos.get(y).getNombre() + " nota (s/n): ")
						.equalsIgnoreCase("s");
				if (notaEmpty) {
					int nota = rangoNum(1, 10, "Agrega una nota entre 1-10: ");
					modulos.get(i).setNota(nota);
				}
			}
			a.setModulos(modulos);
			array.set(i, a);
			existAl = true;
		}
		if (!existAl)
			System.out.println("No existe ningun alumno " + nombre + " " + apellido);
	}

	// arraylist en caso de que se repita los nombre y apellido
	private static ArrayList<Integer> indNomRep(ArrayList<Persona> array, String nombre, String apellido,
			String tipoPerson) {
		ArrayList<Integer> indices = new ArrayList<Integer>();
		int indice = 0;
		for (Persona p : array) {
			if (p instanceof Alumno && tipoPerson.equalsIgnoreCase("Alumno")) {
				if (nombre.equalsIgnoreCase(p.getNombre()) && apellido.equalsIgnoreCase(p.getApellido()))
					indices.add(indice);

			}
			if (p instanceof Alumno && tipoPerson.equalsIgnoreCase("Profesor")) {
				if (nombre.equalsIgnoreCase(p.getNombre()) && apellido.equalsIgnoreCase(p.getApellido()))
					indices.add(indice);
			}
			indice++;
		}
		return indices;
	}

	// nota entre 0-10 (cambiarlo al util)
	private static int rangoNum(int r1, int r2, String mensaje) {
		int num;

		do {
			num = Util.leerInt(mensaje);
		} while (num < r1 || num > r2);

		return num;
	}

	// Modificar la nota de un modulo, se pedita el dni y el modulo
	public static void menu7(ArrayList<Persona> array) {
		String dni = Util.comprobarFormatoDni();
		ArrayList<Integer> indice = indicePer(array, dni);
		boolean existe = false, existeMod = false;
		for (int i : indice) {
			if (array.get(i) instanceof Alumno) {
				Alumno a = (Alumno) array.get(i);
				String nomMod = Util.tamañoString(3, Optional.empty(), "Nombre del Modulo: ");
				ArrayList<Modulo> modulos = a.getModulos();
				for (int y = 0; y < modulos.size(); y++) {
					if (modulos.get(y).getNombre().equalsIgnoreCase(nomMod)) {
						int nota = rangoNum(1, 10, "Agrega una nota entre 1-10: ");
						modulos.get(y).setNota(nota);
						existeMod = true;
						break;
					}
				}
				existe = true;
			}
		}
		if (!existe)
			System.out.println("No existe el dni: " + dni);
		else if (!existeMod)
			System.out.println("No existe ese modulo");
	}

	// dar de baja a un alumno a partir de su dni, y confirmacion si no se encuentra
	// error
	public static void menu8(ArrayList<Persona> array) {
		String dni = Util.comprobarFormatoDni();
		ArrayList<Integer> indices = indicePer(array, dni);
		for (int i : indices) {
			if (array.get(i) instanceof Alumno) {
				boolean darBaja = Util.introducirCadena("En serio quieres dar de baja el dni " + dni + " (s/n): ")
						.equalsIgnoreCase("s");
				if (darBaja)
					array.remove(i);
			}
		}
	}

	private static ArrayList<Integer> indicePer(ArrayList<Persona> array, String dni) {
		ArrayList<Integer> indices = new ArrayList<Integer>();

		int indice = -1;
		for (Persona p : array) {
			indice++;
			if (dni.equalsIgnoreCase(p.getDni())) {
				indices.add(indice);
			}
		}
		return indices;
	}

	// 9. dart de baja a un modulo a partir del dni se mostrar la lista de modulos y
	// se pedira el modulo y se confirmara
	public static void menu9(ArrayList<Persona> array) {
		String dni = Util.comprobarFormatoDni();
		ArrayList<Integer> indice = indicePer(array, dni);
		boolean existe = false;
		for (int i : indice) {
			if (array.get(i) instanceof Alumno) {
				Alumno a = (Alumno) array.get(i);
				ArrayList<Modulo> modulos = a.getModulos();
				System.out.println("--------TODOS LOS MODULOS------");
				for (Modulo m : modulos)
					System.out.println(m.getNombre());
				String nomMod = Util.tamañoString(3, Optional.empty(), "Cual quieres dar de baja: ");
				for (int y = 0; y < modulos.size(); y++) {
					if (modulos.get(y).getNombre().equalsIgnoreCase(nomMod)) {
						boolean confirmacion = Util.introducirCadena("Seguro que quieres eliminar este modulo (s/n): ")
								.equalsIgnoreCase("s");
						if (confirmacion)
							modulos.remove(y);
						else
							System.out.println("No se eliminara nada");
						break;
					}
				}
				existe = true;
			}
		}
		if (!existe)
			System.out.println("No existe el dni: " + dni);

	}

	// 10. Mostrar todas las personas ordenadas por apellido lo hare con una
	// interface
	public static void menu10(ArrayList<Persona> array) {
		ComparacionApellido criterio = new ComparacionApellido();
		OrdenarPersonas.ordenarBurbuja(array, criterio);

		// despues de ordenar mi array segun el apellido muestro el criterio
		for (Persona p : array) {
			System.out.println(p.visualizar());
		}

	}

	// mostrar los alumnos que hayan suspendido un modulo en con reto y si es null
	// no se muestra
	public static void menu11(ArrayList<Persona> array) {
		String nomMod = Util.tamañoString(3, Optional.empty(), "Cual es modulo que quieres ver de los repetidores: ");
		ArrayList<Integer> indices = indicesRepe(array, nomMod);
		for (int i : indices) {
			if (array.get(i) instanceof Alumno) {
				Alumno a = (Alumno) array.get(i);
				System.out.printf("DNI: %s Nombre: %s", a.getDni(), a.getNombre());
			}
		}
		if (indices.isEmpty())
			System.out.println("No reprobo ningun alumno en ese modulo");
	}

	private static ArrayList<Integer> indicesRepe(ArrayList<Persona> array, String modulo) {
		ArrayList<Integer> indices = new ArrayList<Integer>();
		for (int i = 0; i < array.size(); i++) {
			if (array.get(i) instanceof Alumno) {
				Alumno a = (Alumno) array.get(i);
				ArrayList<Modulo> modulos = a.getModulos();
				for (Modulo m : modulos) {
					if (m.getNota() != null) {
						if (m.getNombre().equalsIgnoreCase(modulo) && m.getNota() < 5) {
							indices.add(i);
						}
					}
				}
			}
		}
		return indices;

	}

	// listado de repetidores de un ciclo en concreto
	public static void menu12(ArrayList<Persona> array) {
		Ciclo cicli = ciclillo();
		for (Persona p : array) {
			if (p instanceof Alumno) {
				Alumno a = (Alumno) p;
				if (cicli == a.getCiclo() && a.isRepetidor() == true) {
					System.out.println(a.visualizar());
				}
			}
		}
	}

}
