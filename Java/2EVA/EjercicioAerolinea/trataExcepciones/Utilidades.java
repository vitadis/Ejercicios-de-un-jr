package trataExcepciones;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Utilidades {

	// Scanner único

	private static final Scanner sc = new Scanner(System.in);

	// Utilidad para leer cadenas

	public static String introducirCadena(String mensaje) {

		String cadena = "";

		System.out.println(mensaje);

		try {

			cadena = sc.nextLine();

		} catch (NoSuchElementException er) {

			System.out.println("Error al introducir datos");

			// No salimos de la aplicación; devolvemos cadena vacía

			return "";

		}

		return cadena;

	}

	// Leer float

	public static float leerFloat(String message) {

		float n = 0;

		boolean ok;

		do {

			try {

				ok = true;

				n = Float.parseFloat(introducirCadena(message));

			} catch (NumberFormatException e) {

				System.out.println("Te equivocaste, inténtalo otra vez:");

				ok = false;

			}

		} while (!ok);

		return n;

	}

	// Leer int

	public static int leerInt(String message) {

		int n = -1;

		boolean ok;

		do {

			try {

				ok = true;

				n = Integer.parseInt(introducirCadena(message));

			} catch (NumberFormatException e) {

				System.out.println("No has introducido un entero, inténtalo otra vez:");

				ok = false;

			}

		} while (!ok);

		return n;

	}

	// Leer String con longitud máxima

	public static String leerString(int x, String message) {

		String cadena;

		boolean ok;

		do {

			ok = true;

			cadena = introducirCadena(message);

			if (cadena.length() > x) {

				System.out.println("Error: longitud demasiado grande.");

				ok = false;

			}

		} while (!ok);

		return cadena;

	}

	// Leer respuesta tipo sí/no

	public static boolean leerRespuesta(String message) {

		String respu;

		do {

			respu = introducirCadena(message).toLowerCase();

		} while (!respu.equals("0") && !respu.equals("1") &&

				!respu.equals("si") && !respu.equals("no") &&

				!respu.equals("s") && !respu.equals("n") &&

				!respu.equals("true") && !respu.equals("false"));

		return respu.equals("1") || respu.equals("si") || respu.equals("s") || respu.equals("true");

	}

	// Leer int entre rango

	public static int leerInt(int x, int y, String message) {

		int num = 0;

		boolean ok;

		do {

			try {

				ok = true;

				num = Integer.parseInt(introducirCadena(message));

			} catch (NumberFormatException e) {

				System.out.println("Hay que introducir números");

				ok = false;

				num = x;

			}

			if (num < x || num > y) {

				System.out.println("Dato fuera de rango, introduce entre " + x + " y " + y);

				ok = false;

			}

		} while (!ok);

		return num;

	}

	// Leer float entre rango

	public static float leerFloat(float x, float y, String message) {

		float fNumero = 0;

		boolean ok;

		do {

			try {

				ok = true;

				fNumero = Float.parseFloat(introducirCadena(message));

			} catch (NumberFormatException e) {

				System.out.println("Hay que introducir números, vuelve a introducir:");

				ok = false;

				fNumero = x;

			}

			if (fNumero < x || fNumero > y) {

				System.out.println("Dato fuera de rango, introduce entre " + x + " y " + y);

				ok = false;

			}

		} while (!ok);

		return fNumero;

	}

	// Leer char

	public static char leerChar(String message) {

		String letra;

		boolean error;

		do {

			error = false;

			letra = introducirCadena(message);

			if (letra.length() != 1) {

				System.out.println("Error, introduce un único carácter:");

				error = true;

			}

		} while (error);

		return letra.charAt(0);

	}

	// Leer fecha dd-MM-yyyy

	public static LocalDate pidoFechaDMA(String message) {

		String fechaS;

		boolean hay;

		LocalDate fecha = null;

		DateTimeFormatter formateador = DateTimeFormatter.ofPattern("dd-MM-yyyy");

		do {

			hay = true;

			fechaS = introducirCadena(message + " en formato dd-mm-aaaa: ");

			try {

				fecha = LocalDate.parse(fechaS, formateador);

			} catch (DateTimeParseException p) {

				System.out.println("Error... formato de fecha incorrecto.");

				hay = false;

			}

		} while (!hay);

		return fecha;

	}

	// Leer char dentro de un array válido

	public static char leerCharArray(char caracteres[], String message) {

		int i;

		boolean error = false;

		String letra;

		char aux = 0;

		do {

			error = false;

			letra = introducirCadena(message);

			if (letra.length() != 1) {

				System.out.println("Error, introduce un único carácter:");

				error = true;

			} else {

				aux = Character.toUpperCase(letra.charAt(0));

				for (i = 0; i < caracteres.length; i++) {

					if (Character.toUpperCase(caracteres[i]) == aux) {

						break;

					}

				}

				if (i == caracteres.length) {

					System.out.println("Error, carácter no válido.");

					error = true;

				}

			}

		} while (error);

		return aux;

	}

	// Cuenta objetos en un fichero

	public static int calculoFichero(File fich) {

		int cont = 0;

		if (fich.exists()) {

			try (FileInputStream fis = new FileInputStream(fich);

					ObjectInputStream ois = new ObjectInputStream(fis)) {

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

}