package bdsmHerencia;

public class Coche extends Vehiculo{
	private int numPuertas;
	private boolean esElectrico;
	
	public Coche(String marca, String modelo,double precioPorHora,int numPuertas,boolean esElectrico) {
		super(marca,modelo,precioPorHora);
		this.setNumPuertas(numPuertas);
		this.setEsElectrico(esElectrico);
	}
	
	@Override
	public double calcularPrecioAlquiler(int horas) {
		double descuento = super.calcularPrecioAlquiler(horas);
		if (isEsElectrico())
			descuento = descuento*0.9;
		
		return descuento;
	}

	public int getNumPuertas() {
		return numPuertas;
	}

	public void setNumPuertas(int numPuertas) {
		this.numPuertas = numPuertas;
	}

	public boolean isEsElectrico() {
		return esElectrico;
	}

	public void setEsElectrico(boolean esElectrico) {
		this.esElectrico = esElectrico;
	}
	
	
}
