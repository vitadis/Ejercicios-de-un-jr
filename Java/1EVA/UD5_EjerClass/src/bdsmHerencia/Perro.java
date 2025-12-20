package bdsmHerencia;

public class Perro extends Animal{

	String raza;
	public Perro(String nombre, int edad, String raza) {
		super(nombre, edad);
		this.raza = raza;
	}
	
	@Override
	public String sonido() {
		return "Guau";
	}
	
    @Override
    public String toString() {
        return super.toString() + ", Raza: " + raza;
    }

}
