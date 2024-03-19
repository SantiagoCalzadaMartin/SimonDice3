package main;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Clase de la escritura de ficheros que extiende de la interfaz de escritura de ficheros
 */
public class CustomWriteFile extends FileReader implements ICustomWriteFile{

	String direccion = ".\\src\\file\\player.txt";
	File file = new File(direccion);
	
	/**
	 * Este metodo se encarga de escribir en el fichero
	 * @param direccion
	 * @throws FileNotFoundException
	 */
	public CustomWriteFile(String direccion) throws FileNotFoundException {
		super(direccion);
	}
	
	/**
	 * Este metodo se encarfa de escribir en el fichero el String dado
	 */
	public void WriteFile(String cadena) throws IOException {
        this.WriteFile(cadena);
    }

	/**
	 * Este metodo se encarga de cerrar la escritura de ficheros	 */
	public void CloseWriteFile() throws IOException {
		this.close();
	}
}