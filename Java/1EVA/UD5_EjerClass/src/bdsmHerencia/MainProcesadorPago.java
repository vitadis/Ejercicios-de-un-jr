package bdsmHerencia;

public class MainProcesadorPago {
	public static void main(String[] args) { 
		/*¿Por qué podría necesitarse?
		 * Imagina que:
		 * 		Para pagos normales quieres la validación estricta.
		 * 		Pero para pruebas, operaciones internas o auditorias necesitas la validacion basica del padre.
		 */
        ProcesadorPagoInternacional proc = new ProcesadorPagoInternacional(); 
 
        // ya que se sobreEscribe la clase, el metodo cambia algunas funciones
        System.out.println("Validación estricta:"); 
        System.out.println(proc.validar(6000));  // Falla por validación de la hija 
        
        // 
        System.out.println("\nValidación básica:"); 
        System.out.println(proc.validarBasico(6000));  // Usa validación del padre (pasa) 
    }
	
	

}
