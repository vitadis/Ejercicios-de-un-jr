package bdsmHerencia;

public class Vehiculo {
	private int idVehiculo;
	private String marca,modelo;
	private double precioPorHora;
	private static int contador = 1;
	
	public Vehiculo() {
		this.idVehiculo=contador;
		this.setMarca(null);
		this.setModelo(null);
		this.setPrecioPorHora(0);
		contador++;
	}
	
	public Vehiculo(String marca, String modelo,double precioPorHora) {
		this.idVehiculo=contador;
		this.marca=marca;
		this.modelo= modelo;
		this.precioPorHora= precioPorHora;
		contador++;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public double getPrecioPorHora() {
		return precioPorHora;
	}

	public void setPrecioPorHora(double precioPorHora) {
		this.precioPorHora = precioPorHora;
	}
	
	/**
	 * Redondea las horas
	 * */
	public double calcularPrecioAlquiler(int horas) {
		double precioTotal = getPrecioPorHora()*horas;
		return precioTotal;
	}
	
	public String descripcion() {
		return "IdVehiculo: "+getIdVehiculo()+" Marca: "+getMarca()+" Modelo: "+getModelo()+" Precio por hora: "+getPrecioPorHora();
		
	}

	public int getIdVehiculo() {
		return idVehiculo;
	}

	public void setIdVehiculo(int idVehiculo) {
		this.idVehiculo = idVehiculo;
	}

	public static int getContador() {
		return contador;
	}

	public static void setContador(int contador) {
		Vehiculo.contador = contador;
	}

	
}
