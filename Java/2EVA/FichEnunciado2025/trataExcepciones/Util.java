package trataExcepciones;

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
		while (true) {
			String dni = Util.introducirCadena("Agregame el dni: ").toUpperCase();
			String patronDni = "^[0-9]{8}[A-Z]$";

			if (!dni.matches(patronDni)) {
				System.out.println("Formato incorrecto. Debe ser NNNNNNNNL");
				continue;
			}

			return dni;
		}
	}
	
	// comprobar el formato del numero
	public static int formatoTelf(String mensaje) {
		while(true) {
			int telf = leerInt(mensaje);
			String patronTelf = "[0-9]{9}";
			String telfStr =String.valueOf(telf);
			if(!telfStr.matches(patronTelf)) {
				System.out.println("agrega el formato XXXXXXXXX");
				continue;
			}
			else {
				return telf;
			}
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

	// metodos para comprobar el tamaño del string
	public static String tamañoString(int r1, int r2, String mensaje) {
		String cadena;

		do {
			cadena = introducirCadena(mensaje);
			if (cadena.length() < r1 || cadena.length() > r2)
				System.out.println("Agrega una cadena en el rango " + r1 + "-" + r2);
		} while (cadena.length() < r1 || cadena.length() > r2);

		return cadena;
	}

	public static String tamañoString(int r1, String mensaje) {
		String cadena;

		do {
			cadena = introducirCadena(mensaje);
			if (cadena.length() < r1)
				System.out.println("Agrega una cadena tiene tener mas de " + r1 + " caracter");
		} while (cadena.length() < r1);

		return cadena;
	}

	// tamaño del numero entero
	public static int tamañoInt(int r1, int r2, String mensaje) {
		int numero;

		do {
			numero = leerInt(mensaje);
			if (numero < r1 || numero > r2)
				System.out.println("Tu numero tiene que estar entre " + r1 + "-" + r2);

		} while (numero < r1 || numero > r2);

		return numero;
	}
	public static int tamañoInt(int r1, String mensaje) {
		int numero;

		do {
			numero = leerInt(mensaje);
			if (numero < r1)
				System.out.println("Tu numero tiene que ser mayor o igual a " + r1);

		} while (numero < r1);

		return numero;
	}
	
	
	
	
}