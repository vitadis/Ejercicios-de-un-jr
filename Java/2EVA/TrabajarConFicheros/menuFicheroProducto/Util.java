package menuFicheroProducto;

import java.io.BufferedReader;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import java.util.Optional;

public class Util {

	// -------------datos simples-----------
	public static String introducirCadena(String mensaje) {
		String cadena = "";
		InputStreamReader entrada = new InputStreamReader(System.in);
		BufferedReader teclado = new BufferedReader(entrada);
		try {
			System.out.println(mensaje);
			cadena = teclado.readLine();
		} catch (IOException e) {
			System.out.println("Error en la entrada de datos");
		}
		return cadena;
	}

	public static char leerChar(String mensaje) {
		boolean error = false;
		String letra;

		do {
			error = false;
			letra = introducirCadena(mensaje);
			if (letra.length() != 1) {
				System.out.println("Error, introduce solo un carácter: ");
				error = true;
			}

		} while (error);
		return letra.charAt(0);
	}

	public static int leerInt(String mensaje) {
		int num = 0;
		boolean error;
		do {
			error = false;
			try {
				num = Integer.parseInt(introducirCadena(mensaje));
			} catch (NumberFormatException e) {
				System.out.println("Error al introducir, solo numero enteros.");
				error = true;
			}
		} while (error);
		return num;
	}

	public static float leerFloat(String mensaje) {
		float num = 0;
		boolean error;
		do {
			error = false;
			try {
				num = Float.parseFloat(introducirCadena(mensaje));
			} catch (NumberFormatException e) {
				System.out.println("Error al introducir el número, introduce un decimal");
				error = true;
			}
		} while (error);
		return num;
	}

	public static double leerDouble(String mensaje) {
		double fNumero = 0;
		boolean ok;
		do {
			try {
				ok = true;
				fNumero = Double.parseDouble(introducirCadena(mensaje));
			} catch (NumberFormatException e) {
				System.out.println("Error al introducir el número, introduce un decimal");
				ok = false;
			}
		} while (!ok);
		return fNumero;
	}

	// -----------con expresiones regulares-------------
	// dni
	public static String comprobarFormatoDni() {
		final String letras = "TRWAGMYFPDXBNJZSQVHLCKE";
		while (true) {
			String dni = Util.introducirCadena("Agregame el dni: ").toUpperCase();
			String patronDni = "^[0-9]{8}[A-Z]$";

			if (!dni.matches(patronDni)) {
				System.out.println("Formato incorrecto. Debe ser NNNNNNNNL");
				continue;
			}

			int numero = Integer.parseInt(dni.substring(0, 8));
			char letraIntroducida = dni.charAt(8);
			char letraCorrecta = letras.charAt(numero % 23);

			if (letraIntroducida != letraCorrecta) {
				System.out.println("La letra del DNI es incorrecta. Debería ser: " + letraCorrecta);
				continue;
			}
			return dni;
		}
	}

	// localdate (fecha sin mas) mm/dd/aaaa
	public static LocalDate leerFecha(String message) {
		String fechaS;
		boolean hay;
		LocalDate fecha = null;
		DateTimeFormatter formateador = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		do {
			hay = true;
			fechaS = Util.introducirCadena(message + " en formato dd-mm-aaaa: ");
			try {
				fecha = LocalDate.parse(fechaS, formateador);
			} catch (DateTimeParseException p) {
				System.out.println("Error... formato de fecha incorrecto.");
				hay = false;
			}
		} while (!hay);
		return fecha;
	}

	// localdatetime.- formato fecha hora y fecha
	public static LocalDateTime leerFechaHora(String message) {
		String fechaHoraS;
		boolean hay;
		LocalDateTime fechaHora = null;
		DateTimeFormatter formateador = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");

		do {
			hay = true;
			fechaHoraS = Util.introducirCadena(message + " en formato dd-mm-aaaa HH:mm: ");
			try {
				fechaHora = LocalDateTime.parse(fechaHoraS, formateador);
			} catch (DateTimeParseException e) {
				System.out.println("Error... formato de fecha y hora incorrecto.");
				hay = false;
			}
		} while (!hay);

		return fechaHora;
	}

	// ---------archivos----------------
	// lee y calcula la cantidad del fichero
	public static int calculoFichero(File fich) {
		int cont = 0;
		if (fich.exists()) {
			try (FileInputStream fis = new FileInputStream(fich); ObjectInputStream ois = new ObjectInputStream(fis)) {
				Object aux = ois.readObject();
				while (aux != null) {
					cont++;
					aux = ois.readObject();
				}
			} catch (EOFException e1) {
				System.out.println("Has acabado de leer, tienes " + cont + " objetos");
			} catch (Exception e2) {
				System.out.println("Error al  leer del fichero");
			}
		}
		return cont;
	}

	// ---------UTILES OPCIONALES---------------
	// definir una cadena mayor o igual al tamaño requerido
	/**
	 * Util.tamañoString(1, Optional.empty(),"Nombre: ") Util.tamañoString(1,
	 * Optional.of(10),"Nombre: ")
	 */
	public static String tamañoString(int r1, Optional<Integer> r2, String mensaje) {
		String cadena;
		boolean condicion;

		do {
			cadena = introducirCadena(mensaje);

			if (r2.isPresent()) {
				condicion = cadena.length() < r2.get() || cadena.length() > r1;

				if (condicion) {
					System.out.println("Tienes que cumplir el rango de " + r2.get() + " - " + r1);
				}
			} else {
				condicion = cadena.length() < r1;
				if (condicion) {
					System.out.println("Lo mínimo son " + r1 + " caracteres");
				}
			}

		} while (condicion);

		return cadena;
	}

	// definir el rango de un numero
	public static int tamañoInt(int r1, Optional<Integer> r2, String mensaje) {
		int numero;
		boolean condicion;

		do {
			numero = leerInt(mensaje);

			if (r2.isPresent()) {
				condicion = numero < r1 && numero > r2.get();

				if (condicion) {
					System.out.println("Tienes que cumplir el rango de " + r2.get() + " - " + r1);
				}
			} else {
				condicion = numero < r1;
				if (condicion) {
					System.out.println("Lo mínimo son " + r1 + " caracteres");
				}
			}

		} while (condicion);

		return numero;
	}

}