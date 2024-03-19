package main;

import java.io.IOException;

/**
 * Interfaz de la escritura de ficheros con sus dos metodos declarados
 */
public interface ICustomWriteFile {

	public void CloseWriteFile() throws IOException;
	
	public void WriteFile(String cadena) throws IOException;
}
