package main;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Record {

	public int MAX_JUGADORES;
	public int cont;
	jugador[] Mjugadores;
	String direccion;

	public Record() {
		this.MAX_JUGADORES = 10;
		this.cont = 0;
		this.Mjugadores = new jugador[MAX_JUGADORES];
		this.direccion = ".\\src\\file\\player.txt";
	}

	/**
	 * Este metodo agrega cada nuevo jugadore al array
	 * 
	 * @param nuevoJugador
	 */
	public void agregarJugador(jugador nuevoJugador) {
		if (cont < MAX_JUGADORES) {
			Mjugadores[cont] = nuevoJugador;
			cont++;
		}
		else {
			Mjugadores[MAX_JUGADORES - 1] = nuevoJugador;
		}
	}

	/**
	 * Este método se encarga de ordenar de forma descendente los jugadores
	 */
	public void ordenarRanking() {
		for (int i = 0; i < cont - 1; i++) {
			for (int j = 0; j < cont - i - 1; j++) {
				if (Mjugadores[j].getPuntuacion() < Mjugadores[j + 1].getPuntuacion()) {
					jugador temp = Mjugadores[j];
					Mjugadores[j] = Mjugadores[j + 1];
					Mjugadores[j + 1] = temp;
				}
			}
		}
	}

	/**
	 * Este metodo se encarga de mostrar el ranking de todos los jugadores ordenados
	 */
	public void mostrarRanking() {
		ordenarRanking();
		for (int i = 0; i < cont; i++) {
			System.out.println((i + 1) + ". " + Mjugadores[i].getNombre() + " - Puntuación: " + Mjugadores[i].getPuntuacion());
		}
	}

	/**
	 * Este metodo muestra los x mejores jugadores
	 */
	public void mostrarMejoresRanking() {
		ordenarRanking();
		for (int i = 0; i < 3; i++) {
			System.out.println(
					(i + 1) + ". " + Mjugadores[i].getNombre() + " - Puntuación: " + Mjugadores[i].getPuntuacion());
		}
	}

	/**
	 * Este metodo se encarga de escribir los jugadores en el fichero
	 * @throws IOException
	 */
	public void escribirRanking() throws IOException {
		String cadenaArray = "";
		CustomWriteFile customw = new CustomWriteFile(this.direccion);

		for (int i = 0; i < cont; i++) {
			cadenaArray += Mjugadores[i].getNombre() + " " + Mjugadores[i].getPuntuacion() + "\n";
		}

		customw.WriteFile(cadenaArray);
		customw.CloseWriteFile();
	}
	
	/**
	 * Este metodo se encarga de escribir los jugadores del fichero en el array
	 * @throws IOException
	 */
	public void cargarRanking() throws IOException {
		CustomReadFile customr = new CustomReadFile(this.direccion);
		ArrayList<jugador> jugadorR = customr.LeerJugadores();

		if(jugadorR == null) {
			return;
		}
		for (int i = 0; i < jugadorR.size(); i++) {
	        agregarJugador(jugadorR.get(i));
	    }
	}
}
//Crear un array que vaya añadiendo a los jugadores
//mostrar el array de jugadores ordenado (showRanking, metodo de burbuja)
//mostrar los 10 mejores jugadores
//metodo de actualización de puntuación

//Crear objeto tipo CustomReadFile