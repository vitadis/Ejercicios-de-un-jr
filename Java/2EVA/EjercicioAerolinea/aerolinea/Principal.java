package aerolinea;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Locale;

import trataExcepciones.*;

public class Principal {

	public static void main(String[] args) {
		ArrayList<Trabajador> trabajador = new ArrayList<Trabajador>();
		boolean bucle = true;
		while (bucle) {
			int opcion = menu();
			switch (opcion) {
			case 1 -> menu1(trabajador);
			case 2 -> menu2(trabajador);
			case 3 -> menu3(trabajador);
			case 4 -> menu4(trabajador);
			case 5 -> menu5(trabajador);
			case 6 -> menu6(trabajador);
			case 7 -> menu7(trabajador);
			case 8 -> menu8(trabajador);
			case 9 -> menu9(trabajador);
			case 10 -> menu10(trabajador);
			case 11 -> menu11(trabajador);
			case 12 -> menu12(trabajador);
			case 13 -> menu13(trabajador);
			case 14 -> menu14(trabajador);
			case 15 -> menu15(trabajador);
			case 16 -> menu16(trabajador);
			case 17 -> menu17(trabajador);
			case 18 -> menu18(trabajador);
			case 19 -> menu19(trabajador);
			case 20 -> menu20(trabajador);
			case 21 -> bucle = false;
			default -> System.out.println("Agrega una opcion valida");
			}
		}

	}

	public static int menu() {
		String menu = "1. Alta de trabajadores\n" + "2. Lista de trabajadores\n" + "3. Añadir vuelo a un piloto\n"
				+ "4. Añadir idioma a un auxiliar\n" + "5. Listado de los vuelos de un piloto\n"
				+ "6. Listado de los vuelos realizados entre dos fechas\n"
				+ "7. Listado de los pilotos que han participado en los vuelos de un destino en concreto\n"
				+ "8. Listado de los auxiliares que se manejan en un idioma en concreto\n"
				+ "9. Listado de Trabajadores ordenador por antigüedad\n"
				+ "10. Listado de los pilotos ordenados por horas de vuelo\n"
				+ "11. Calculo de la duración media de los vuelos\n"
				+ "12. Listado agrupado por destinos y nº de vuelos\n"
				+ "13. Mostrar el piloto con más antigüedad y auxiliar mas joven de la empresa\n"
				+ "14. Listado de los pilotos con residencia en un lugar en concreto\n"
				+ "15. Calculo de la edad y de los años que lleva en la empresa un trabajador en concreto\n"
				+ "16. Modificar el cargo de un auxiliar concreto\n" + "17 Modificar un vuelo de un piloto\n"
				+ "18. Listado de los auxiliares con cargo concreto\n"
				+ "19. Media de edad de los pilotos con una residencia concreta\n"
				+ "20. Estadistica de edad de los pilotos ordenada en ascendente\n" + "21. Salir\n" + "Opcion: ";

		int opcion = Util.leerInt(menu);
		return opcion;
	}

	public static ArrayList<Trabajador> menu1(ArrayList<Trabajador> lista) {
		// DNi
		String dni;
		do {
			dni = MetodosRE.comprobarFormatoDni();
			if (dniExisteCiclo(lista, dni) > -1) {
				System.out.println("Este DNI ya esta registrado.");
				continue;
			}
			break;
		} while (true);

		// Nombre y apellido
		String nombre = masDeUnText("Nombre: ");
		String apellido = masDeUnText("Apellido: ");

		// Fecha de nacimiento, alta
		LocalDate fechaNac = MetodosRE.pidoFechaDMA("Fecha de nacimiento");

		boolean hoy = Util.introducirCadena("La fecha de alta es hoy o otra fecha s/n: ").equalsIgnoreCase("s");

		LocalDate fechaAlta;
		if (hoy)
			fechaAlta = LocalDate.now();
		else
			fechaAlta = MetodosRE.pidoFechaDMA("Fecha de alta");

		// en caso de que sea Piloto o Auxiliar
		int tipoTrabajador;
		do {
			tipoTrabajador = Util.leerInt("1. Piloto \n2. Auxiliar\nOpcion: ");
			switch (tipoTrabajador) {

			case 1:
				LocalDate fechaLic = MetodosRE.pidoFechaDMA("Fecha de la licencia");
				String residenciaOfi = masDeUnText("Agrega la residencia Oficial: ");

				Piloto pilot = new Piloto(dni, nombre, apellido, fechaNac, fechaAlta, fechaLic, residenciaOfi);
				lista.add(pilot);
				break;
			case 2:
				CargoAuxiliar cargo = null;
				// bucle para que elija un valor del enum
				while (true) {
					try {
						cargo = CargoAuxiliar.valueOf(
								Util.introducirCadena("Elige las siguientes secciones JUNIOR, SENIOR: ").toUpperCase());
						break;
					} catch (Exception e) {
						System.out.println("Agrega una opcion valida");
					}
				}
				Auxiliar auxi = new Auxiliar(dni, nombre, apellido, fechaNac, fechaAlta, cargo);
				lista.add(auxi);
				break;
			default:
				System.out.println("Agrega un valor valido.");
				break;
			}
		} while (tipoTrabajador != 1 && tipoTrabajador != 2);
		return lista;
	}

	public static void menu2(ArrayList<Trabajador> lista) {
		int indice = -1;
		for (Trabajador p : lista) {
			indice++;
			System.out.println(p);
		}
		if (indice == -1)
			System.out.println("No existen trabajadores");
	}

	// añadir vuelos a piloto
	public static void menu3(ArrayList<Trabajador> lista) {
		int indice = -1;
		boolean existe = false;
		String dni = MetodosRE.comprobarFormatoDni();
		for (Trabajador p : lista) {
			indice++;
			if (p instanceof Piloto) {
				if (dni.equals(p.getDni())) {
					Piloto pilot = (Piloto) p;
					ArrayList<Vuelo> vuel = pilot.getVuelos();
					String origen = text5_10("Agrega el origen del vuelo: ");
					String destino = text5_10("Agrega el destino final: ");

					LocalDateTime fechaIni = MetodosRE.pidoFechaHoraDMA("Añade la hora y fecha de despegue");
					LocalDateTime fechaFin = MetodosRE.pidoFechaHoraDMA("Añade la hora y fecha de llegada al destino");

					String tipoAvi = text5_10("Agrega el tipo de avion: ");

					// agregar los nuevos vuelos
					Vuelo nuevovuelo = new Vuelo(origen, destino, fechaIni, fechaFin, tipoAvi);
					vuel.add(nuevovuelo);
					pilot.setVuelos(vuel);
					lista.set(indice, pilot);

					existe = true;
				}
			}
		}
		if (indice == -1)
			System.out.println("No existe ningun trabajador");
		else if (!existe)
			System.out.println("No existe el dni: " + dni);
	}

	// agregar idioma a auxiliar
	public static void menu4(ArrayList<Trabajador> lista) {
		int indice = -1;
		boolean existe = false;
		String dni = MetodosRE.comprobarFormatoDni();
		for (Trabajador p : lista) {
			indice++;
			if (p instanceof Auxiliar) {
				if (dni.equals(p.getDni())) {
					Auxiliar auxi = (Auxiliar) p;
					String idioma = masDeUnText("Agrega un idioma: ");
					HashSet<String> array = auxi.getIdiomas();
					array.add(idioma);
					auxi.setIdiomas(array);
					lista.set(indice, auxi);
					existe = true;
				}
			}
		}
		if (indice == -1)
			System.out.println("No existe ningun trabajador");
		else if (!existe)
			System.out.println("No existe el dni: " + dni);
	}

	// listado de los vuelos del piloto
	public static void menu5(ArrayList<Trabajador> lista) {
		int indice = -1;
		boolean segunDni = Util.leerInt("1. Ver todos\n2. Ver por DNI") == 2;
		String dni = "";
		boolean existe = false;

		for (Trabajador p : lista) {
			indice++;

			if (p instanceof Piloto) {
				if (!segunDni) {
					System.out.println(p.getDni());
					Piloto p1 = (Piloto) p;
					ArrayList<Vuelo> vuelos = p1.getVuelos();
					for (Vuelo a : vuelos)
						System.out.println(a);

				} else if (segunDni) {
					dni = MetodosRE.comprobarFormatoDni();
					if (dni.equals(p.getDni())) {
						System.out.println(p.getDni());
						Piloto p1 = (Piloto) p;
						ArrayList<Vuelo> vuelos = p1.getVuelos();
						for (Vuelo a : vuelos)
							System.out.println(a);
						existe = true;
					}
				}

			}
		}
		if (indice == -1)
			System.out.println("No existe ningun trabajador");
		else if (!existe && segunDni)
			System.out.println("No existe el dni: " + dni);
	}

	// listado de vuelos en un rango de fechas y horas
	public static void menu6(ArrayList<Trabajador> lista) {

		LocalDateTime fecha1 = MetodosRE.pidoFechaHoraDMA("Primera fecha y hora");
		LocalDateTime fecha2 = MetodosRE.pidoFechaHoraDMA("Segunda fecha y hora");

		boolean existeVuelo = false;

		for (Trabajador t : lista) {
			if (t instanceof Piloto piloto) {
				System.out.println("Piloto: " + piloto.getNombre() + " DNI: " + piloto.getDni());

				for (Vuelo v : piloto.getVuelos()) {
					LocalDateTime fechaVuelo = v.getFechaIni();

					if (!fechaVuelo.isBefore(fecha1) && !fechaVuelo.isAfter(fecha2)) {
						System.out.println("Vuelo: " + v);
						existeVuelo = true;
					}
				}
			}
		}

		if (!existeVuelo) {
			System.out.println("No existen vuelos en ese rango de fechas");
		}
	}

	// Listado de los pilotos que han participado en los vuelos de un destino en
	// concreto
	public static void menu7(ArrayList<Trabajador> lista) {
		String destino = text5_10("Agrega el destino con el que quieres comparar: ");
		boolean existe = false;

		for (Trabajador t : lista) {
			if (t instanceof Piloto piloto) {
				for (Vuelo v : piloto.getVuelos()) {
					if (destino.equalsIgnoreCase(v.getDestino())) {
						System.out.print("Piloto: " + piloto.getNombre() + " DNI: " + piloto.getDni());
						System.out.print(" Vuelo: " + v + "\n");
						existe = true;

					}
				}
			}
		}
		if (!existe)
			System.out.println("No existe ningun destino similar");
	}

	// Listado de los auxiliares que se manejan en un idioma en concreto
	public static void menu8(ArrayList<Trabajador> lista) {
		String idioma = masDeUnText("Agrega el idioma: ");
		boolean existe = false;

		for (Trabajador t : lista) {
			if (t instanceof Auxiliar auxiliar) {
				for (String v : auxiliar.getIdiomas()) {
					if (idioma.equalsIgnoreCase(v)) {
						System.out.println("Auxiliar: " + auxiliar.getNombre() + " DNI: " + auxiliar.getDni());
						existe = true;
					}
				}
			}

		}
		if (!existe)
			System.out.println("No existe ningun auxiliar que se maneje por ese idioma");
	}

	// LISTADO de trabajadores ordenados por antigüedad

	public static void menu9(ArrayList<Trabajador> lista) {
		boolean existe = false;
		for (int i = 0; i < lista.size() - 1; i++) {
			for (int j = 0; j < lista.size() - 1 - i; j++) {

				LocalDate fecha1 = lista.get(j).getFechaalt();
				LocalDate fecha2 = lista.get(j + 1).getFechaalt();

				if (fecha1.isAfter(fecha2)) {
					Trabajador aux = lista.get(j);
					lista.set(j, lista.get(j + 1));
					lista.set(j + 1, aux);
				}
			}
		}

		// Mostrar listado ya ordenado
		System.out.println("Listado de trabajadores por antigüedad:");
		for (Trabajador t : lista) {
			System.out.println(t.getNombre() + " DNi: " + t.getDni() + " Fecha alta: " + t.getFechaalt());
			existe = true;
		}
		if (!existe)
			System.out.println("No existe ningun trabajador");

	}

	// listado de pilotos por horas de vuelo
	public static void menu10(ArrayList<Trabajador> lista) {

		ArrayList<Piloto> pilotos = new ArrayList<>();

		// paso solo los pilotos
		for (Trabajador t : lista) {
			if (t instanceof Piloto p) {
				pilotos.add(p);
			}
		}

		if (pilotos.isEmpty()) {
			System.out.println("No existen pilotos");
			return;
		}

		// ordeno de menor a mayor
		for (int i = 0; i < pilotos.size() - 1; i++) {
			for (int j = 0; j < pilotos.size() - 1 - i; j++) {

				long horas1 = 0;
				long horas2 = 0;

				for (Vuelo v : pilotos.get(j).getVuelos()) {
					horas1 += Duration.between(v.getFechaIni(), v.getFechaFin()).toHours();
				}

				for (Vuelo v : pilotos.get(j + 1).getVuelos()) {
					horas2 += Duration.between(v.getFechaIni(), v.getFechaFin()).toHours();
				}

				if (horas1 > horas2) {
					Piloto aux = pilotos.get(j);
					pilotos.set(j, pilotos.get(j + 1));
					pilotos.set(j + 1, aux);
				}
			}
		}

		System.out.println("Pilotos ordenados por horas de vuelo (descendente):");

		for (int i = pilotos.size() - 1; i >= 0; i--) {
			Piloto p = pilotos.get(i);
			long horas = calcularHorasVuelo(p);

			System.out.println("DNI: " + p.getDni() + "\n	Horas de vuelo: " + horas);

			for (Vuelo v : p.getVuelos()) {
				System.out.println("		Fecha vuelo: " + v.getFechaIni());
			}
		}
	}

	// Calculo de la duración media de los vuelos mostrar el mas largo y el mas
	// corto
	public static void menu11(ArrayList<Trabajador> lista) {
		boolean comoMostrar = Util.leerInt("1. Ver todo en general\n 2. Ver de cada Piloto") == 2;

		ArrayList<Piloto> pilotos = new ArrayList<>();
		boolean existe = false;

		// paso solo los pilotos
		for (Trabajador t : lista) {
			if (t instanceof Piloto p) {
				pilotos.add(p);
			}
		}

		for (Piloto p : pilotos) {
			ArrayList<Vuelo> vuelos = p.getVuelos();
			if (vuelos.isEmpty()) {
				existe = false;
			} else {
				if (comoMostrar) {

					HashMap<String, String> vueloMinMax = maxHVuelo(p.getVuelos());
					System.out.println("Vuelos del piloto " + p.getDni() + "\nMedia: " + mediaHVuelo(p.getVuelos())
							+ "\nVuelo mas corto: " + vueloMinMax.get("min") + "\nvuelo mas largo: "
							+ vueloMinMax.get("max"));

					existe = true;
				} else if (!comoMostrar) {
					HashMap<String, String> todo = estadisticasVuelosPilotos(pilotos);
					existe = true;
					for (String cosa : todo.keySet())
						System.out.println(todo.get(cosa));
					break;
				}
			}

		}
		if (!existe)
			System.out.println("No existe ningun registro de vuelos");

	}

	// media de cada vuelo
	private static long mediaHVuelo(ArrayList<Vuelo> vuelos) {
		long horas = 0;
		for (Vuelo v : vuelos) {
			horas += Duration.between(v.getFechaIni(), v.getFechaFin()).toHours();
		}
		long media = horas / (vuelos.size());
		return media;

	}

	//
	private static HashMap<String, String> maxHVuelo(ArrayList<Vuelo> vuelos) {
		int max = 0, min = 0;
		String codemax = "", codemin = "";

		for (Vuelo v : vuelos) {

			int hora = (int) Duration.between(v.getFechaIni(), v.getFechaFin()).toHours();
			if (max < hora) {
				max = hora;
				codemax = v.getIdentificador();
			} else if (min > hora) {
				min = hora;
				codemin = v.getIdentificador();
			}

		}
		HashMap<String, String> codMax = new HashMap<String, String>();
		codMax.put("max", "Id: " + codemax + " Tiempo de vuelo: " + max);
		codMax.put("min", "Id: " + codemin + " Tiempo de vuelo: " + min);
		return codMax;
	}

	// estadisticas de todos
	private static HashMap<String, String> estadisticasVuelosPilotos(ArrayList<Piloto> pilotos) {

		HashMap<String, String> resultado = new HashMap<>();

		// Caso 1: no hay pilotos
		if (pilotos == null || pilotos.isEmpty()) {
			resultado.put("media", "0");
			resultado.put("max", "0");
			resultado.put("min", "0");
			return resultado;
		}

		long totalHoras = 0;
		long totalVuelos = 0;

		boolean inicializado = false;
		long min = 0;
		long max = 0;

		String idVueloMin = "";
		String idVueloMax = "";
		String dniPilotoMin = "";
		String dniPilotoMax = "";

		for (Piloto p : pilotos) {

			// Si el piloto no tiene vuelos, se ignora
			if (p.getVuelos() == null || p.getVuelos().isEmpty()) {
				continue;
			}

			for (Vuelo v : p.getVuelos()) {

				if (v == null || v.getFechaIni() == null || v.getFechaFin() == null) {
					continue;
				}

				long horas = Duration.between(v.getFechaIni(), v.getFechaFin()).toHours();

				totalHoras += horas;
				totalVuelos++;

				if (!inicializado) {
					min = horas;
					max = horas;
					idVueloMin = v.getIdentificador();
					idVueloMax = v.getIdentificador();
					dniPilotoMin = p.getDni();
					dniPilotoMax = p.getDni();
					inicializado = true;
				} else {

					if (horas > max) {
						max = horas;
						idVueloMax = v.getIdentificador();
						dniPilotoMax = p.getDni();
					}

					if (horas < min) {
						min = horas;
						idVueloMin = v.getIdentificador();
						dniPilotoMin = p.getDni();
					}
				}
			}
		}

		// Caso 2: no hubo ningún vuelo válido
		if (!inicializado) {
			resultado.put("media", "0");
			resultado.put("max", "0");
			resultado.put("min", "0");
			return resultado;
		}

		long media = totalHoras / totalVuelos;

		resultado.put("media", String.valueOf(media));
		resultado.put("max", "Vuelo: " + idVueloMax + "\n\tPiloto DNI: " + dniPilotoMax + "\n\tHoras: " + max);
		resultado.put("min", "Vuelo: " + idVueloMin + "\n\tPiloto DNI: " + dniPilotoMin + "\n\tHoras: " + min);

		return resultado;
	}

	// listado de fechas con un destino en concreto y un mes
	public static void menu12(ArrayList<Trabajador> lista) {
		int mes = validadorMes();
		String lugar = text5_10("Agrega un destino: ").toUpperCase(Locale.ROOT);

		ArrayList<Piloto> pilotos = new ArrayList<>();
		int contador = 0;

		// paso solo los pilotos
		for (Trabajador t : lista) {
			if (t instanceof Piloto p) {
				pilotos.add(p);
			}
		}
		for (Piloto p : pilotos) {
			for (Vuelo v : p.getVuelos()) {
				if (mes == v.getFechaIni().getMonthValue() && lugar.equals(v.getDestino()))
					contador++;
			}
		}
		System.out.println("El destino " + lugar + " tiene " + contador + " vuelos");

	}

	private static int validadorMes() {
		int mes = 0;
		do {
			mes = Util.leerInt("Agrega el nº de mes: ");
			if (mes > 12 && mes < 1)
				System.out.println("Agrega un mes valido");
		} while (mes > 12 && mes < 1);
		return mes;
	}

	// mostrar la edad del mas joven auxiliar y el mas viejo piloto
	// 13. Mostrar el piloto con más antigüedad y el auxiliar más joven
	public static void menu13(ArrayList<Trabajador> lista) {

		Piloto pilotoAntiguo = null;
		Auxiliar auxiliarJoven = null;

		for (Trabajador t : lista) {

			// Si es piloto, buscamos el de fecha de alta más antigua
			if (t instanceof Piloto p) {
				if (pilotoAntiguo == null || p.getFechaalt().isBefore(pilotoAntiguo.getFechaalt())) {
					pilotoAntiguo = p;
				}
			}

			// Si es auxiliar, buscamos el más joven (fecha nacimiento más reciente)
			if (t instanceof Auxiliar a) {
				if (auxiliarJoven == null || a.getFechaNac().isAfter(auxiliarJoven.getFechaNac())) {
					auxiliarJoven = a;
				}
			}
		}

		if (pilotoAntiguo != null) {
			// convierte en un local date time añade la hora y cuenta todo
			long años = Duration.between(pilotoAntiguo.getFechaalt().atStartOfDay(), LocalDate.now().atStartOfDay())
					.toDays() / 365;

			System.out.println("Piloto con más antigüedad:");
			System.out.println("DNI: " + pilotoAntiguo.getDni() + " Años en la empresa: " + años);
		}

		if (auxiliarJoven != null) {
			long edad = Duration.between(auxiliarJoven.getFechaNac().atStartOfDay(), LocalDate.now().atStartOfDay())
					.toDays() / 365;

			System.out.println("Auxiliar más joven:");
			System.out.println("DNI: " + auxiliarJoven.getDni() + " Edad: " + edad);
		}
	}

	// Listado de pilotos con residencia en un lugar concreto
	public static void menu14(ArrayList<Trabajador> lista) {

		String residencia = masDeUnText("Introduce la residencia: ");
		boolean existe = false;

		for (Trabajador t : lista) {
			if (t instanceof Piloto p) {
				if (p.getResidenciaOfi().equalsIgnoreCase(residencia)) {
					System.out.println(p);
					existe = true;
				}
			}
		}

		if (!existe)
			System.out.println("No existen pilotos con esa residencia");
	}

	// Cálculo de edad y años en la empresa de un trabajador concreto
	public static void menu15(ArrayList<Trabajador> lista) {

		String nombre = masDeUnText("Introduce el nombre: ");
		String apellido = masDeUnText("Introduce el apellido: ");

		boolean existe = false;

		for (Trabajador t : lista) {
			if (t.getNombre().equalsIgnoreCase(nombre) && t.getApellidos().equalsIgnoreCase(apellido)) {

				long edad = Duration.between(t.getFechaNac().atStartOfDay(), LocalDate.now().atStartOfDay()).toDays()
						/ 365;

				long antiguedad = Duration.between(t.getFechaalt().atStartOfDay(), LocalDate.now().atStartOfDay())
						.toDays() / 365;

				System.out.println("Trabajador encontrado:");
				System.out.println("Edad: " + edad);
				System.out.println("Años en la empresa: " + antiguedad);
				existe = true;
			}
		}

		if (!existe)
			System.out.println("No existe ese trabajador");
	}

	// Modificar el cargo de un auxiliar concreto
	public static void menu16(ArrayList<Trabajador> lista) {

		String dni = MetodosRE.comprobarFormatoDni();
		boolean existe = false;

		for (int i = 0; i < lista.size(); i++) {

			if (lista.get(i) instanceof Auxiliar aux && aux.getDni().equals(dni)) {

				CargoAuxiliar nuevoCargo = null;
				// bucle para que elija un valor del enum
				while (true) {
					try {
						nuevoCargo = CargoAuxiliar.valueOf(
								Util.introducirCadena("Elige las siguientes secciones JUNIOR, SENIOR: ").toUpperCase());
						aux.setCargo(nuevoCargo);
						lista.set(i, aux);
						System.out.println("Cargo modificado correctamente");
						existe = true;

						break;
					} catch (Exception e) {
						System.out.println("Agrega una opcion valida");
					}
				}
			}
		}

		if (!existe)
			System.out.println("No existe un auxiliar con ese DNI");
	}

	// Modificar un vuelo de un piloto
	public static void menu17(ArrayList<Trabajador> lista) {

		String dni = MetodosRE.comprobarFormatoDni();
		boolean existe = false;

		menu5(lista);

		for (Trabajador t : lista) {

			// Comprobamos que sea piloto y que coincida el DNI
			if (t instanceof Piloto p && p.getDni().equals(dni)) {

				// Pedimos el identificador del vuelo a modificar
				String id = masDeUnText("Introduce el identificador del vuelo a modificar: ");

				for (Vuelo v : p.getVuelos()) {

					// Si encontramos el vuelo por su identificador
					if (v.getIdentificador().equals(id)) {

						// Modificamos los datos del vuelo
						v.setFechaIni(MetodosRE.pidoFechaHoraDMA("Nueva fecha y hora de inicio"));
						v.setFechaFin(MetodosRE.pidoFechaHoraDMA("Nueva fecha y hora de fin"));

						System.out.println("Vuelo modificado correctamente");
						existe = true;
					}
				}
			}
		}

		if (!existe)
			System.out.println("No se ha podido modificar el vuelo");
	}

	// Listado de auxiliares con cargo concreto
	public static void menu18(ArrayList<Trabajador> lista) {

		CargoAuxiliar cargo = CargoAuxiliar.valueOf(Util.introducirCadena("Introduce el cargo: ").toUpperCase());

		boolean existe = false;

		for (Trabajador t : lista) {
			if (t instanceof Auxiliar a && a.getCargo() == cargo) {
				System.out.println(a);
				existe = true;
			}
		}

		if (!existe)
			System.out.println("No existen auxiliares con ese cargo");
	}

	// 19. Media de edad de pilotos con una residencia concreta
	public static void menu19(ArrayList<Trabajador> lista) {

		String residencia = masDeUnText("Introduce la residencia: ");
		long sumaEdades = 0;
		int contador = 0;

		for (Trabajador t : lista) {
			if (t instanceof Piloto p && p.getResidenciaOfi().equalsIgnoreCase(residencia)) {

				long edad = Duration.between(p.getFechaNac().atStartOfDay(), LocalDate.now().atStartOfDay()).toDays()
						/ 365;

				sumaEdades += edad;
				contador++;
			}
		}

		if (contador > 0)
			System.out.println("Media de edad: " + (sumaEdades / contador));
		else
			System.out.println("No existen pilotos con esa residencia");
	}

	// Estadística de edad de pilotos ordenada por edad
	public static void menu20(ArrayList<Trabajador> lista) {

		HashMap<Long, Integer> estadistica = new HashMap<>();

		for (Trabajador t : lista) {
			if (t instanceof Piloto p) {

				long edad = Duration.between(p.getFechaNac().atStartOfDay(), LocalDate.now().atStartOfDay()).toDays()
						/ 365;

				estadistica.put(edad, estadistica.getOrDefault(edad, 0) + 1);
			}
		}

		estadistica.entrySet().stream().sorted(HashMap.Entry.comparingByKey())
				.forEach(e -> System.out.println("Edad: " + e.getKey() + " Nº Pilotos: " + e.getValue()));
	}

	// metodos secundarios
	private static int dniExisteCiclo(ArrayList<Trabajador> lista, String dni) {
		int indice = 0;
		for (Trabajador a : lista) {

			if (a.getDni().equalsIgnoreCase(dni)) {
				return indice;
			}
			indice++;
		}
		return -1;
	}

	private static long calcularHorasVuelo(Piloto piloto) {

		long totalHoras = 0;

		for (Vuelo v : piloto.getVuelos()) {
			LocalDateTime ini = v.getFechaIni();
			LocalDateTime fin = v.getFechaFin();

			totalHoras += Duration.between(ini, fin).toHours();
		}

		return totalHoras;
	}

	private static String masDeUnText(String mensaje) {
		String valor;
		do {
			valor = Util.introducirCadena(mensaje);
			if (valor.length() < 0)
				System.out.println("No puede estar vacio esta cadena");
		} while (valor.length() < 0);
		return valor;
	}

	private static String text5_10(String mensaje) {
		String valor;
		do {
			valor = Util.introducirCadena(mensaje);
			if (valor.length() < 5 || valor.length() > 10)
				System.out.println("No puede estar vacio esta cadena");
		} while (valor.length() < 5 || valor.length() > 10);
		return valor;

	}

}
