package ficheros;
import java.io.*;
/**
 * <h1>¿Qué hace este metodo?</h1>
 * <p>Elimina la cabecera</p>
 * <h3>Cuando se necesita</h3>
 * <p>Solo se usa para archivos genericos, ejemplo dat, donde no son necesarios como el nombre, el dia de creación, etc...</p>
 * */
public class SinCabeceraObjectOutputStream extends ObjectOutputStream{
	
		//Sobrescribimos el método que crea la cabecera 
		protected void writeStreamHeader() throws IOException {
		 reset();	
	 }

		//Constructores
	public SinCabeceraObjectOutputStream () throws IOException{ 
		super();
		}
		public SinCabeceraObjectOutputStream(OutputStream out) throws IOException{
		super(out);
		}
	}