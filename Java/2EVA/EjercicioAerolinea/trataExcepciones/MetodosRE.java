package trataExcepciones;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class MetodosRE {


	// dni comprobar el formato
	public static String comprobarFormatoDni() {
		while (true) {
			String dni = Util.introducirCadena("Agregame el dni: ").toUpperCase();
			String patronDni = "^[0-9]{8}[A-Z]$";
			if (dni.matches(patronDni))
				return dni;
			else
				System.out.println("Agregame el formato NNNNNNNNL");
		}
	}

	// comprobar el formato deo mail
	public static String comprobarEmail() {

		while (true) {
			String mail = Util.introducirCadena("Agregame el email: ").toUpperCase();
			String patronMail = "^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{3,6}$";
			if (mail.matches(patronMail))
				return mail;
			else
				System.out.println("Agregame el formato de mail completo");
		}
	}

	
	
	// comprabar el formato de fecha
	public static LocalDate pidoFechaDMA(String message) {
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
	
	// formato fecha hora y fecha 
	public static LocalDateTime pidoFechaHoraDMA(String message) {
	    String fechaHoraS;
	    boolean hay;
	    LocalDateTime fechaHora = null;
	    DateTimeFormatter formateador = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");

	    do {
	        hay = true;
	        fechaHoraS = Util.introducirCadena(
					message + " en formato dd-mm-aaaa HH:mm: "
	        );
	        try {
	            fechaHora = LocalDateTime.parse(fechaHoraS, formateador);
	        } catch (DateTimeParseException e) {
	            System.out.println("Error... formato de fecha y hora incorrecto.");
	            hay = false;
	        }
	    } while (!hay);

	    return fechaHora;
	}

	

	// comprobar el formato falta
	public static String comprobarDominio() {
		while (true) {

			String dominio = Util.introducirCadena("Agregame el dominio: ").toUpperCase();
			String patronDominio = "^(https?://)?([\\w.-]+\\.)+[a-zA-Z]{2,6}$"; 
			String segundoPatron = "^(https?://)?([\\w-]+\\.)+[a-zA-Z]{2,6}(/\\S*)?$";
			// añadir de la ruta opcional
			if (dominio.matches(patronDominio)) {
				return dominio;
			}
			else
				System.out.println("Agregame el formato compatible con tu web");
		}
	}
	
	

}
