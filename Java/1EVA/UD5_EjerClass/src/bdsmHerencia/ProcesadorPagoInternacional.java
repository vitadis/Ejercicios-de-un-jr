package bdsmHerencia;

public class ProcesadorPagoInternacional extends ProcesadorPago { 
 
    @Override 
    public boolean validar(double cantidad) { 
        System.out.println("Validación internacional más estricta"); 
        return cantidad > 0 && cantidad < 5000; 
    } 
 
    // Método que expone la validación original del padre 
    public boolean validarBasico(double cantidad) { 
        return super.validar(cantidad); 
    } 
} 
