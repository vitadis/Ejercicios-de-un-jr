package ficheros;
import java.io.ObjectInputStream;
import java.io.IOException;
import java.io.InputStream;

public class ObjectInputStreamSinCabecera extends ObjectInputStream {

    public ObjectInputStreamSinCabecera(InputStream in) throws IOException {
        super(in);
    }

    @Override
    protected void readStreamHeader() throws IOException {
        // Se ignora la cabecera
    }
}
