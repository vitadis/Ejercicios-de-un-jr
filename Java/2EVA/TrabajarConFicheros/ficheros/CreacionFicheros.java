package ficheros;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class CreacionFicheros {

	/**
	 * Crea un fichero auxiliar a partir del fichero principal. Si todo va bien, el
	 * auxiliar pasa a ser el principal.
	 */
	public static void crearFicheroAuxiliar() {

		File proDat = new File("personas.dat");
		File proAux = new File("personas.aux");
		File proBackup = new File("personas.backup");

		try {
			// 1. Crear o sobrescribir el fichero auxiliar
			if (proAux.exists()) {
				proAux.delete();
			}
			proAux.createNewFile();

			/*
			 * AQUÍ DEBES: - Leer el contenido de personas.dat - Escribirlo en personas.aux
			 * - Usar ObjectInputStream / ObjectOutputStream o el mecanismo que estés
			 * empleando
			 */

			// 2. Renombrar dat a backup
			if (!proDat.renameTo(proBackup)) {
				throw new IOException("No se pudo crear el backup del fichero principal");
			}

			// 3. Renombrar aux a dat
			if (!proAux.renameTo(proDat)) {
				// Intento de recuperación
				proBackup.renameTo(proDat);
				throw new IOException("No se pudo renombrar el auxiliar como principal");
			}

			// 4. Borrar el backup si todo ha ido bien
			Files.deleteIfExists(proBackup.toPath());

			System.out.println("Proceso completado correctamente");

		} catch (IOException e) {
			System.out.println("Error en la creación del fichero auxiliar: " + e.getMessage());
		}
	}

	
	
	
	/**
	 * Cambia la extensión de un fichero a .backup
	 * 
	 * @param nombreFichero nombre del fichero original
	 */
	public static void backup(String nombreFichero) {

		File ficheroOriginal = new File(nombreFichero);

		if (!ficheroOriginal.exists()) {
			System.out.println("El fichero no existe");
			return;
		}

		int punto = nombreFichero.lastIndexOf('.');
		String nombreBackup;

		if (punto != -1) {
			nombreBackup = nombreFichero.substring(0, punto) + ".backup";
		} else {
			nombreBackup = nombreFichero + ".backup";
		}

		File ficheroBackup = new File(nombreBackup);

		if (ficheroOriginal.renameTo(ficheroBackup)) {
			System.out.println("Backup creado: " + nombreBackup);
		} else {
			System.out.println("No se pudo crear el backup");
		}
	}
}

/*
 * 
 * 
 * */
