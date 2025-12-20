package bdsm;

public class Productos {

	private String producto;
	private double precio;
	private Integer stock;
	
	public Productos(String producto, double precio, Integer stock) {
		this.producto=producto;
		this.precio = precio;
		this.stock = stock;
	}
	
	
	public double getPrecio() {
		return precio;
	}


	public void setPrecio(double precio) {
		this.precio = precio;
	}


	public String getProducto() {
		return producto;
	}


	public void setProducto(String producto) {
		this.producto = producto;
	}


	public Integer getStock() {
		return stock;
	}


	public void setStock(Integer stock) {
		this.stock = stock;
	}


}
