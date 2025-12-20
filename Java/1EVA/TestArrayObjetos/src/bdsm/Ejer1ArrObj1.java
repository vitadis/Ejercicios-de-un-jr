package bdsm;

public class Ejer1ArrObj1 {
	public static void cantidadVocales(String cadena) {
		char[] arrayVocales = {'a','e','i','o','u'};
		int contador = 0;
		for (int i = 0; i < cadena.length(); i++) {
				for (char vocal : arrayVocales) {
				if (cadena.toLowerCase().charAt(i) == vocal) {
		        	contador++;
		    	}
		    }
		}
		System.out.println(contador);
	}
	
	public static void mostrarNombre(Productos nombre) {
		System.out.println(nombre.getProducto());
	}
	
	public static void main(String[] args) {
		Productos[] inventario= {
				new Productos("Diago",299,10),
				new Productos("Aitor",0.1,9)				
		};
		int arrTamaño = inventario.length;
		// primer ejercicio
		double total = 0;
		for (int i = 0; i < arrTamaño; i++){ 
			
			if(validarStock(inventario[i].getStock())) {
				total += inventario[i].getPrecio();
				
			}
			
		}
		System.out.println(total);
		// segundo ejercicio
		Productos pMasCaro=inventario[0];
		for (int x = 0; x<arrTamaño; x++) {
			if (inventario[x].getStock()>5 && inventario[x].getPrecio()>pMasCaro.getPrecio()) {
				pMasCaro=inventario[x];
			}
		}
		System.out.println(pMasCaro);
		
		//tercer ejercicio
		
		
		
		
		
		
	}

	static boolean validarStock(Integer stock) {
		boolean condicion = stock%2!=0 && stock!=null;
		return condicion;
	}
}
