package main;

import java.io.IOException;

import java.util.ArrayList;

/**
 * Interfaz de la lectura del fichero con sus dos metodos declarados
 */
public interface ICustomReadFile {

	public void CloseReadFile() throws IOException;
	
	public ArrayList<jugador> LeerJugadores();
}
