package menuFicheroProducto;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.Random;

import ficheros.ObjectInputStreamSinCabecera;
import ficheros.SinCabeceraObjectOutputStream;

public class Principal {

	public static void main(String[] args) throws Exception {

		File archivoPrin = new File("producto.dat");
		File archivoAux = new File("producto.aux");
		File archivoBack = new File("producto.backup");

		int opc;

		do {
			System.out.println(
					"1.-Altas\n2.-Listado\n3.-Consulta\n4.-Modificación\n5.-Borrado\n6.-Listado ordenado por apellido\n9.-SALIR");
			opc = Util.leerInt("Agrega las opcion: ");

			// es para que no siempre gestione los archivos
			boolean gestionar = true;

			switch (opc) {
			case 1:
				/*
				 * Añade 3 productos al fichero productos.dat si no existe el fichero, lo crea
				 * el nombre del producto se lo pide al usuario, el stock es aleatorio
				 */
				alta(archivoAux, archivoPrin);
				break;

			case 2:
				// creo otras vistas para que pueda ver, el principal, auxiliar y backup
				ArrayList<Producto> pri = listado(archivoPrin);
				for (Producto p : pri) {
					System.out.println(p);
				}

				gestionar = false;

				break;

			case 3:
				/*
				 * Pide al usuario el nombre del producto, el programa busca el producto en el
				 * fichero y le muestra por pantalla el stock suponemos que solo hay un producto
				 * con ese nombre
				 */
				consulta(archivoAux);
				break;

			case 4:
				/*
				 * Pide al usuario el nombre del producto, el programa busca el producto en el
				 * fichero y le muestra por pantalla el stock. luego le pide el nuevo stock y
				 * guarda el cambio, suponemos que solo hay un producto con ese nombre usar un
				 * fichero auxiliar
				 */
				modificacion(archivoAux);
				break;

			case 5:
				/*
				 * Pide al usuario el nombre del producto, el programa busca el producto en el
				 * fichero, suponemos que solo hay un producto con ese nombre, se borra usar un
				 * fichero auxiliar
				 */
				borrado(archivoAux);
				break;

			case 6:
				/*
				 * usar un fichero auxiliar para guardar el ArrayList ordenado
				 */
				ordenarPorNombre(archivoAux, archivoPrin);
				break;
			case 7:
				ordenarStock(archivoAux, archivoPrin);
				break;
			default:
				System.out.println("Agrega una opcion valida");
				break;
			}
			if (gestionar)
				gestionArchivo(archivoAux, archivoPrin, archivoBack);

		} while (opc != 9);
	}

	private static void alta(File archivo, File principal) {

		ArrayList<Producto> productos = listado(principal);
		int numPro = Util.leerInt("Dime la cantidad de productos: ");

		// bucle de la cantidad de productos, si esta en la lista se pide un nuevo
		// stock, si no existe se agrega a la lista sin mas
		for (int i = 0; i < numPro; i++) {

			String nombre = Util.introducirCadena("Introduce el nombre del producto: ");
			boolean existe = false;

			for (Producto p : productos) {
				if (p.getNombre().equalsIgnoreCase(nombre)) {
					existe = true;
					System.out.println("Stock actual: " + p.getStock());
					boolean condi = Util.leerInt("1. Sumar stock\n2. Nuevo stock (pordefault)") == 1;
					int nuevo = 0;
					if (!condi)
						nuevo = Util.leerInt("Introduce el nuevo stock: ");
					else
						nuevo = Util.leerInt("Cantidad a sumar: ") + p.getStock();
					p.setStock(nuevo);
					break;
				}
			}

			if (!existe) {
				boolean random = Util.introducirCadena("Deseas introducir el stock random (s/n): ")
						.equalsIgnoreCase("s");

				// tipo de dato = condicion ? si : no; (if y else, tienen que pertenecer al tipo
				// de dato)

				int stock = random ? new Random().nextInt(1000) : Util.leerInt("Agrega el numero del stock: ");

				productos.add(new Producto(nombre, stock));
			}
		}

		sobreEscribirArrayProducto(productos, archivo);
	}

	private static ArrayList<Producto> listado(File archivo) {

		ArrayList<Producto> lista = new ArrayList<>();

		if (!archivo.exists())
			return lista;

		try (ObjectInputStream ois = new ObjectInputStreamSinCabecera(new FileInputStream(archivo))) {

			while (true) {
				Producto p = (Producto) ois.readObject();
				lista.add(p);
			}

		} catch (EOFException e) {
			// fin del fichero sin mas
		} catch (Exception e) {
			System.out.println("Error de lectura (posible cambio de clase): " + e.getMessage());
			return null;

		}

		return lista;
	}

	private static void consulta(File archivo) {

		ArrayList<Producto> productos = listado(archivo);
		String nombre = Util.introducirCadena("Dime el nombre del producto: ");

		for (Producto p : productos) {
			if (p.getNombre().equalsIgnoreCase(nombre)) {
				System.out.println("Stock: " + p.getStock());
				return;
			}
		}

		System.out.println("No existe el producto");
	}

	private static void modificacion(File archivo) {

		ArrayList<Producto> productos = listado(archivo);
		String nombre = Util.introducirCadena("Agrega el producto: ");

		for (Producto p : productos) {
			if (p.getNombre().equalsIgnoreCase(nombre)) {
				System.out.println("Stock actual: " + p.getStock());
				int nuevo = Util.leerInt("Introduce el nuevo stock: ");
				p.setStock(nuevo);
				sobreEscribirArrayProducto(productos, archivo);
				return;
			}
		}

		System.out.println("Producto no encontrado");
	}

	private static void borrado(File archivo) {

		ArrayList<Producto> productos = listado(archivo);
		String nombre = Util.introducirCadena("Agrega el producto: ");

		for (int i = 0; i < productos.size(); i++) {
			if (productos.get(i).getNombre().equalsIgnoreCase(nombre)) {
				productos.remove(i);
				sobreEscribirArrayProducto(productos, archivo);
				System.out.println("Se borro correctamente");
				return;
			}
		}

		System.out.println("Producto no encontrado");
	}

	private static void ordenarPorNombre(File archivo, File principal) {
		ArrayList<Producto> pe = listado(principal);

		CompararString criterio = new CompararString();

		pe = OrdenarNombre.ordenarBurbuja(pe, criterio);
		sobreEscribirArrayProducto(pe, archivo);
		if (pe.size() > 1)
			System.out.println("Se ordeno correctamente");
		else
			System.out.println("Agrega mas datos para comparar");
	}

	private static void sobreEscribirArrayProducto(ArrayList<Producto> array, File archivo) {

		try (SinCabeceraObjectOutputStream oos = new SinCabeceraObjectOutputStream(new FileOutputStream(archivo))) {

			for (Producto p : array) {
				oos.writeObject(p);
			}

		} catch (Exception e) {
			System.out.println("Error de escritura: " + e.getMessage());
		}
	}

	/**
	 * Auxiliar si o si, existe. Partimos de eso, donde auxiliar si esta bien pasara
	 * a ser principal, pero se mantendra auxiliar. Si auxiliar esta mal, se
	 * restaurara el backup.
	 */

	private static void gestionArchivo(File aux, File dat, File backup) {

		try {
			if (!dat.exists())
				dat.createNewFile();
		} catch (IOException e) {
			System.out.println("Error al crear los ficheros: " + e.getMessage());
		}

		if (dat.renameTo(backup)) {
			if (!aux.renameTo(dat)) {
				System.out.println("Error: no se pudo renombrar aux como dat, se intenta renombrar backup como dat");
				if (!backup.renameTo(dat)) {
					System.out.println("Error: no se pudo renombrar backup como dat");
				}
			} else {
				// Borra el fichero de backup
				try {
					Files.deleteIfExists(Paths.get("producto.backup"));
					System.out.println("Fichero borrado");
				} catch (IOException e) {
					System.out.println("Error al borrar el fichero de backup: " + e.getMessage());
				}
			}
		} else {
			System.out.println("Error: no se pudo crear el backup");
		}
	}

	// ordenar por stock
	private static void ordenarStock(File archivo, File principal) {
		ArrayList<Producto> pe = listado(principal);
		for (int i = 0; i < pe.size() - 1; i++) {
			for (int y = i; y < pe.size() - 1 - i; y++) {

				if (pe.get(y).getStock() > pe.get(y + 1).getStock()) {
					Producto aux = pe.get(y);
					Producto producto1 = pe.get(y + 1);
					pe.set(y, producto1);
					pe.set(y + 1, aux);
				}
			}

		}
		sobreEscribirArrayProducto(pe, archivo);

	}
}
