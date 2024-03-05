package main;

import java.util.ArrayList;
import java.util.List;

public class Record {

	public enum tMejoresJugadores {
	};

	private List<jugador> Mjugadores = new ArrayList<>();

	public void ordenarRanking() {

		for (int i = 0; i < Mjugadores.size(); i++) {
			for (int j = 0; j < Mjugadores.size() - i - 1; j++) {
				if (Mjugadores.get(j).getPuntuacion() > Mjugadores.get(j + 1).getPuntuacion()) {
					jugador temp = Mjugadores.get(j);
					Mjugadores.set(j, Mjugadores.get(j + 1));
					Mjugadores.set(j + 1, temp);
				}
			}
		}
	}

	public void mostrarRanking() {

		ordenarRanking();

		for (int i = 0; i < Mjugadores.size(); i++) {
			jugador jugadorActual = Mjugadores.get(i);
			System.out.println(
					(i + 1) + ". " + jugadorActual.getNombre() + " - Puntuación: " + jugadorActual.getPuntuacion());
		}
	}
	
	public void mostrarMejoresRanking() {
		
		ordenarRanking();
		int mejoresJ = Mjugadores.size() >= 3 ? 3 : Mjugadores.size();
		
		for (int i = 0; i < mejoresJ; i++) {
			jugador jugadorActual = Mjugadores.get(i);
			System.out.println(
					(i + 1) + ". " + jugadorActual.getNombre() + " - Puntuación: " + jugadorActual.getPuntuacion());
		}
	}

	public void agregarJugador(jugador nuevoJugador) {
		Mjugadores.add(nuevoJugador);
	}
}

//Crear un array que vaya añadiendo a los jugadores
//mostrar el array de jugadores ordenado (showRanking, metodo de burbuja)
//mostrar los 10 mejores jugadores
//metodo de actualización de puntuación