package bdsmHerencia;

public class Patinette extends Vehiculo{
	private double autonomiaBateria;
	
	public Patinette(String marca, String modelo,double precioPorHora,double autonomiaBateria) {
		super(marca,modelo,precioPorHora);
		this.setAutonomiaBateria(autonomiaBateria);
	}
	
	@Override
	public String descripcion() {
		return super.descripcion() + " Autonomia Bateria: "+getAutonomiaBateria();
		
	}

	public double getAutonomiaBateria() {
		return autonomiaBateria;
	}

	public void setAutonomiaBateria(double autonomiaBateria) {
		this.autonomiaBateria = autonomiaBateria;
	}
	
}
