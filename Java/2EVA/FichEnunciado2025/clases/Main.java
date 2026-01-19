package clases;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;

import trataExcepciones.*;
import clasesOrdenar.*;

public class Main {
	// Iniciamos creando el fichero persona, donde agregamos los entrenamientos del
	// usuario, y los trabajadores
	private static void crearFichero(File fichP) {
		ObjectOutputStream oos = null;
		try {
			oos = new ObjectOutputStream(new FileOutputStream(fichP));
			HashMap<String, Entrenamiento> entrenamientos = new HashMap<String, Entrenamiento>();
			Entrenamiento ent;
			Cliente cliente;
			Trabajador trabajador;

			ent = new Entrenamiento("WOD-100", LocalDate.now(), "Sentadillas", 100);
			entrenamientos.put(ent.getCodigo(), ent);
			ent = new Entrenamiento("WOD-101", LocalDate.now(), "Flexiones", 200);
			entrenamientos.put(ent.getCodigo(), ent);
			ent = new Entrenamiento("WOD-102", LocalDate.now(), "Abdominales", 500);
			entrenamientos.put(ent.getCodigo(), ent);
			cliente = new Cliente("60654812A", "Pedro", LocalDate.now(), entrenamientos);
			oos.writeObject(cliente);

			entrenamientos.clear();
			ent = new Entrenamiento("WOD-101", LocalDate.now(), "Sentadillas", 400);
			entrenamientos.put(ent.getCodigo(), ent);
			ent = new Entrenamiento("WOD-102", LocalDate.now(), "Planchas", 250);
			entrenamientos.put(ent.getCodigo(), ent);
			ent = new Entrenamiento("WOD-103", LocalDate.now(), "Burpees", 500);
			entrenamientos.put(ent.getCodigo(), ent);
			cliente = new Cliente("76543214A", "Laura", LocalDate.now(), entrenamientos);
			oos.writeObject(cliente);

			trabajador = new Trabajador("65432173A", "Sandra", "usuarioS", "1234", Cargo.MONITOR);
			oos.writeObject(trabajador);
			trabajador = new Trabajador("85432173A", "Jorge", "usuarioJ", "1234", Cargo.MONITOR);
			oos.writeObject(trabajador);
		} catch (FileNotFoundException e1) {
			System.out.println("Error, fichero no encontrado, consulta la ruta especificada");
		} catch (IOException e2) {
			System.out.println("Error en la entrada salida de datos");
		} finally {
			try {
				oos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	// leer fichero, leer con cabeceras ya que el fichero tiene cabeceras
	private static ArrayList<Persona> leerFichero(File archivo) {

		ArrayList<Persona> lista = new ArrayList<>();

		if (!archivo.exists()) {
			return lista;
		}

		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(archivo))) {

			while (true) {
				Persona p = (Persona) ois.readObject();
				lista.add(p);
			}

		} catch (EOFException e) {
			// Fin de fichero
		} catch (Exception e) {
			System.out.println("Error de lectura: " + e.getMessage());
		}

		return lista;
	}

	public static void main(String[] args) {
		File fichP = new File("personas.obj");
		crearFichero(fichP);
		for (Persona p : leerFichero(fichP))
			System.out.println(p.visualizar());
		// RESTO DE LA APLICACIÓN
		
		boolean comprobarUser = usuarioValido(fichP);
		if(!comprobarUser) {
			System.out.println("USUARIO NO VALIDO");
			return;}
		else {
			System.out.println("BIENVENIDO");
		}
		int opcion;
		do {
			opcion = menu();
			switch (opcion) {
			case 1 -> menu1(fichP);
			case 2 -> menu2(fichP);
			case 3 -> menu3(fichP);
			case 4 -> menu4(fichP);
			case 5 -> System.out.println("Saliste del programa");
			}

		} while (opcion != 5);

	}

	public static int menu() {
		String menu = "1. Ver trabajadores" + "\n2. Ver clientes ordenados por nombre"
				+ "\n3. Añadir entrenamiento a un cliente" + "\n4. Añadir trabajador" + "\n5. Salir"
				+ "\nElige una opcion: ";
		return Util.leerInt(menu);

	}

	// usuario y contraseña
	private static boolean usuarioValido(File archivo) {
		ArrayList<Persona> person = leerFichero(archivo);
		String usuario = Util.introducirCadena("Agrega el nombre del usuario: ");
		String pw = Util.introducirCadena("Introduce la contraseña: ");
		for (Persona p : person) {
			if (p instanceof Trabajador) {
				Trabajador t = (Trabajador) p;
				if (t.getUsuario().equals(usuario) && t.getContraseña().equals(pw)) {
					return true;
				}

			}
		}

		return false;
	}

	// visualizar todos los trabajadores sin mas
	public static void menu1(File archivo) {
		ArrayList<Persona> personas = leerFichero(archivo);
		for (Persona p : personas) {
			if (p instanceof Trabajador) {
				System.out.println(p.visualizar());
			}
		}

	}

	// visualizar todos los cloientes ordenados por nombre
	public static void menu2(File archivo) {
		ArrayList<Persona> personas = leerFichero(archivo);
		ArrayList<Cliente> clienteOrdenados = new ArrayList<Cliente>();
		for (Persona p : personas) {
			if (p instanceof Cliente) {
				Cliente c = (Cliente) p;
				clienteOrdenados.add(c);
			}
		}

		PorString parametro = new PorString();
		BurbujaOrdenar.ordenarBurbuja(clienteOrdenados, parametro);

		for (Cliente c : clienteOrdenados) {
			System.out.println(c.visualizar());
			;
		}

	}

	// añadir entrenamiento a un cliente
	public static void menu3(File archivo) {
		ArrayList<Persona> persona = leerFichero(archivo);
		String dni = Util.comprobarFormatoDni();
		for (Persona p : persona) {
			if (dni.equalsIgnoreCase(p.getDni()) && p instanceof Cliente) {
				Cliente cliente = (Cliente) p;
				String nomEjer = Util.introducirCadena("Introduce el ejercicio: ");
				int numRep = Util.leerInt("Introduce las repeticiones: ");

				Entrenamiento entra = new Entrenamiento(codCliente(cliente), LocalDate.now(), nomEjer, numRep);
				HashMap<String, Entrenamiento> hasEn = cliente.getEntrenamientos();
				hasEn.put(codCliente(cliente), entra);
				cliente.setEntrenamientos(hasEn);
				p = cliente;
				sobreEscribir(persona,archivo);
				System.out.println("Se agrego correctamente");
				return;
				
			}
			}
		System.out.println("No se encontro el dni");
	}

	// numero del codigo
	private static String codCliente(Cliente c) {
		return "WOD-" + (c.getEntrenamientos().size() + 101);
	}

	// sobreescribir segun una arraylist
	private static void sobreEscribir(ArrayList<Persona> array, File archivo) {
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(archivo))) {

			for (Persona p : array) {
				oos.writeObject(p);
			}

		} catch (Exception e) {
			System.out.println("Error de escritura: " + e.getMessage());
		}
	}

	// añadir trabajador
	public static void menu4(File archivo) {
		ArrayList<Persona> pe = leerFichero(archivo);
		String dni = Util.comprobarFormatoDni();
		int indice = indexTrabajador(pe, dni);
		if (indice == -1) {
			String nombre = Util.introducirCadena("Introduce el nombre: ");
			String usuario = Util.introducirCadena("Introduce el usuario: ");
			String contraseña = Util.introducirCadena("Introduce la contraseña: ");
			Cargo carguillo = comCargo();

			Trabajador traba = new Trabajador(dni, nombre, usuario, contraseña, carguillo);
			pe.add(traba);

			// agregamos la clase al archivo
			sobreEscribir(pe, archivo);
			System.out.println("Se agrego correctamente el usuario");

		} else
			System.out.println("Ya existe el trabajador");

	}

	// enum de cargo
	private static Cargo comCargo() {
		Cargo ciclo = null;
		boolean valido = false;
		do {
			try {
				String ciclillini = Util.introducirCadena("Ciclo (MONITOR, RECEPCIONISTA)").toUpperCase();
				ciclo = Cargo.valueOf(ciclillini);
				valido = true;

			} catch (IllegalArgumentException e) {
				System.out.println("Cargo no válido. Introduce MONITOR o RECEPCIONISTA.");
			}
		} while (!valido);

		return ciclo;
	}

	// comprobar si existe el trabajador
	private static int indexTrabajador(ArrayList<Persona> pe, String dni) {
		int indice = 0;
		for (Persona p : pe) {
			if (p instanceof Trabajador && p.getDni().equalsIgnoreCase(dni)) {
				return indice;
			}
			indice++;
		}
		return -1;
	}

}
