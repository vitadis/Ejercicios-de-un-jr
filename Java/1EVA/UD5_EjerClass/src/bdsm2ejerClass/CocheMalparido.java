package bdsm2ejerClass;

public class CocheMalparido {

	private String matricula, color, modelo, marca;
	private static int nCoches =0;
	
	public CocheMalparido() {
		this.matricula = null;
		this.color = null;
		this.modelo = null;
		this.marca = null;
		nCoches++;
	}

	public CocheMalparido(String matricula, String color, String modelo, String marca) {
		this.matricula = matricula;
		this.color = color;
		this.modelo = modelo;
		this.marca = marca;
		nCoches++;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	@Override
	public String toString() {
		return "CocheMalparido(" + "Matricula: " + getMatricula() + " Color: " + getColor() + " Modelo: " + getModelo()
				+ " Marca: " + getMarca() + ")";
	}

	public static int getnCoches() {
		return nCoches;
	}

	public static void setnCoches(int nCoches) {
		CocheMalparido.nCoches = nCoches;
	}
	
	
}
