package empleadosyjefes;

public class Empleado {

	private String nombreEmpresa, nombreEmpleado, dni;
	private int porcentajeIncrementoSueldo, mes, año;
	private double sueldoBase;
	private final int contEmpleados = 150;
	private static int contador = 0;

	public Empleado(String nombreEmpresa, String nombreEmpleado, String dni, int porcentajeIncrementoSueldo, int mes,
		int año, double sueldoBase) {
		this.nombreEmpresa = nombreEmpresa;
		this.nombreEmpleado = nombreEmpleado;
		this.dni = dni;
		this.porcentajeIncrementoSueldo = porcentajeIncrementoSueldo;
		this.mes = mes;
		this.año = año;
		this.sueldoBase = sueldoBase;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
