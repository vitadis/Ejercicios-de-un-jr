package bdsmHerencia;

public class MainVehiculos {

	public static void main(String[] args) {
		//Bicicleta
		Bicicleta[] bicis = {
			new Bicicleta("rojilla","rally",179.90,"manual"),
			new Bicicleta("azule","rally",290.90,"automatico"),
			new Bicicleta("blackout","ross",179.90,"manual"),
			new Bicicleta("Pelagarto","ross",189.90,"automatico")
		};
		
		for(Bicicleta x: bicis) {
			System.out.println(x.descripcion());
		}
		
		
		//Coche
		Coche[] coches = {
			new Coche("Toyota","X12",20.90,5,true),
			new Coche("Hilux","P13",29.99,9,false)
		};
		
		for(Coche x: coches) {
			System.out.println(x.descripcion());
		}
		//Patinette
		Patinette[] patiness = {
			new Patinette("PeloBrocoli","enano",12.3,20),
			new Patinette("Segarro","PosteLuz",12.3,10),
			new Patinette("Porrero","morat",12.3,20),
			new Patinette("PeloBrocoli","enano",12.3,20)	
		};
		
		for(Patinette x: patiness) {
			System.out.println(x.descripcion());
		}
		
		Vehiculo[] vehiculos = {	
			new Patinette("PeloBrocoli","enano",(double)12.3,20)
				
		};
	}

}
