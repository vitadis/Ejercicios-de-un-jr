package trataExcepciones;

public class Tecnico {
	private Equipo e;
	private Cargo c;
	
	public Tecnico(Equipo e, Cargo c) {
		super();
		this.e = e;
		this.c = c;
	}
	
	public Equipo getE() {
		return e;
	}
	public void setE(Equipo e) {
		this.e = e;
	}
	public Cargo getC() {
		return c;
	}
	public void setC(Cargo c) {
		this.c = c;
	}
	
	
	
	
}
