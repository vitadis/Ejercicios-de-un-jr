package ficheros;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

import clases.*;

public class Append {

	public static void main(String[] args) {
		// archivo sin mas
		File archivo = new File("personas.dat");

		// añadir objetos
		try (SinCabeceraObjectOutputStream personaOStream = new SinCabeceraObjectOutputStream(
				new FileOutputStream(archivo, true))) {

			// añadimos el objeto
			personaOStream.writeObject(new Persona("Peio", "Laza", 100));

		} catch (IOException e) {
			System.out.println("Error de escritura: " + e.getMessage());
		}

		// leer para ver si esta bien
		// Lee el fichero

		if (!archivo.exists()) {
			System.out.println("Fichero no existente");
		} else {
			try (FileInputStream fileIStream = new FileInputStream(archivo);
					ObjectInputStream personaIStream = new ObjectInputStream(fileIStream)) {
				try {
					while (true) {
						Persona aux = (Persona) personaIStream.readObject();
						System.out.println(aux);
					}

				} catch (EOFException eof) {
				}

			} catch (Exception e) {
				System.out.println("Error de lectura: " + e.getMessage());
			}

		}

		//
		if (!archivo.exists()) {
			System.out.println("Fichero no existente");
		} else {
			try (FileInputStream fileIStream = new FileInputStream(archivo);
					ObjectInputStream personaIStream = new ObjectInputStreamSinCabecera(fileIStream)) {

				try {
					while (true) {
						Persona aux = (Persona) personaIStream.readObject();
						System.out.println(aux);
					}
				} catch (EOFException eof) {
					// Fin del fichero
				}

			} catch (Exception e) {
				System.out.println("Error de lectura: " + e.getMessage());
			}
		}
		
		/*package principal;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class BorrarYRenombrarFichero {

	public static void main(String[] args) {
		File dat = new File("personas.dat");
		File backup = new File("personas.backup");
		File aux = new File("personas.aux");

		if (dat.renameTo(backup)) {
		    if (!aux.renameTo(dat)) {
		        System.out.println("Error: no se pudo renombrar aux como dat, se intenta renombrar backup como dat");
		        if (!backup.renameTo(dat)) {
		            System.out.println("Error: no se pudo renombrar backup como dat");
		        }
		    }else
		    {
		    	// Borra el fichero	de backup
				try {
					Files.deleteIfExists(Paths.get("personas.backup"));
					System.out.println("Fichero borrado");
				} catch (IOException e) {
					System.out.println("Error al borrar el fichero de backup: "+e.getMessage());
				}
		    }
		} else {
		    System.out.println("Error: no se pudo crear el backup");
		}
/*
		// Borra el fichero	
		try {
			Files.deleteIfExists(Paths.get("personas.dat"));
			System.out.println("Fichero borrado");
		} catch (IOException e) {
			System.out.println("Error al borrar el fichero: "+e.getMessage());
		}
		
		
		// Renombra el fichero
		Path origen = Paths.get("personas2.dat");
		Path destino = Paths.get("personas.dat");
		
		try {
		    Files.move(origen, destino);
		    System.out.println("Fichero renombrado");
		} catch (IOException e) {
			System.out.println("Error al renombrar el fichero: "+e.getMessage());
		}
		
		
	}
} */

	}
}