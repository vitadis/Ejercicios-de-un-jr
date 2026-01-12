package menuFicheroProducto;

import java.util.ArrayList;

public class OrdenarNombre {

	public static ArrayList<Producto> ordenarBurbuja(ArrayList<Producto> producto, CompararString criterio) {

		for (int i = 0; i < producto.size() - 1; i++) {
			for (int j = 0; j < producto.size() - 1 - i; j++) {

				// si el indice x+1 va antes que x, se intercambian de valor ya que quiero
				// ordenar de la A a Z
				if (criterio.comparar(producto.get(j), producto.get(j + 1)) > 0) {
					Producto aux = producto.get(j);
					producto.set(j, producto.get(j + 1));
					producto.set(j + 1, aux);
				}
			}
		}
		return producto;
	}
}
