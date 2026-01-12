package menuFicheroProducto;

public class CompararString implements InterfaceOrdenar{

	// 0 si son iguales, >0 si p1 va antes <0 si p2 va antes
	@Override
	public int comparar(Producto p1, Producto p2) {
		return p1.getNombre().compareTo(p2.getNombre());
	}

}
