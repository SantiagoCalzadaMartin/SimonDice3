package main;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Clase de lectura de fichero que extiende de la interfaz
 */
public class CustomReadFile extends FileReader implements ICustomReadFile{
	
	private Scanner scanner;
	String direccion = ".\\src\\file\\player.txt";
	File file = new File(direccion);
	
	/**
	 * Este metodo se encarga de leer el contenido del fichero
	 * @param direccion
	 * @throws FileNotFoundException
	 */
	public CustomReadFile(String direccion) throws FileNotFoundException {
		super(direccion);
		this.scanner = new Scanner(this);
	}

	/**
	 * Este metodo se encarga de cerrar la lectura del fichero
	 */
	public void CloseReadFile() throws IOException {
			this.close();
	}

	/**
	 * Este metodo se encarga de insertar en un array list de tipo jugador(objeto) los jugadores del fichero
	 */
	public ArrayList<jugador> LeerJugadores() {
		ArrayList<jugador> jugadores = new ArrayList<>();
			while(scanner.hasNextLine()) {
	            String[] jugador = scanner.nextLine().split(" ");
	            jugador nuevoJugador = new jugador(jugador[0], Integer.parseInt(jugador[1]));
				jugadores.add(nuevoJugador);
			}
		return jugadores;
	}



}