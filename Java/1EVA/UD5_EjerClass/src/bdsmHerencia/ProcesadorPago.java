package bdsmHerencia;

public class ProcesadorPago { 
    public boolean validar(double cantidad) { 
        System.out.println("Validación básica del pago"); 
        return cantidad > 0; 
    } 
}