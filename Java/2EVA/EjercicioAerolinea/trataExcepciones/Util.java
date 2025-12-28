package trataExcepciones;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Util {

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
				System.out.println(
						"Error al introducir el número, introduce un decimal");
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
				System.out.println(
						"Error al introducir el número, introduce un decimal");
				ok = false;
			}
		} while (!ok);
		return fNumero;
	}

}