package main;

import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

/*
 * Esta es la clase engine de mi programa en la cual se almacena toda la información
 * necesaria para que se ejecute 
 */
public class engine {

	/*
	 * Este es el array de colores del programa
	 */
	public enum tColores {
		Rojo, Verde, Azul, Dorado, Blanco, Marron, Naranja
	}

	public Scanner nombre;
	public int dificultad;
	public int puntuacion;
	public int puntuacionFinal;
	public int puntuacionJugador;
	public int ayuda;
	static int MAX_COLORES_SEC = 15;
	static int MAX_COLORES_FACIL = 4;
	static int MAX_COLORES_DIFICIL = 7;
	static tColores[] secuenciaColores = new tColores[MAX_COLORES_SEC];

	/*
	 * Este es el array de los modos de juego
	 */
	public enum tModo {
		Facil, Dificil
	}

	/**
	 * ESte metodo se encarga de identificar y asignar el modo de juego al play
	 * dependiendo de lo que elija el usuario
	 * 
	 * @param _modo
	 * @return
	 */
	public tModo modo(String _modo) {
		tModo modos = null;

		switch (_modo) {
		case "facil":
			modos = tModo.Facil;
			break;
		case "dificil":
			modos = tModo.Dificil;
			break;
		}
		return modos;
	}

	/**
	 * Este metodo se encarga de relacionar los colores del array con una letra
	 * 
	 * @param _color
	 * @return
	 */
	public tColores charToColor(char _color) {
		tColores seleccion = null;
		char Iniciales = Character.toLowerCase(_color);
		switch (Iniciales) {
		case 'r':
			seleccion = tColores.Rojo;
			break;
		case 'v':
			seleccion = tColores.Verde;
			break;
		case 'a':
			seleccion = tColores.Azul;
			break;
		case 'd':
			seleccion = tColores.Dorado;
			break;
		case 'b':
			seleccion = tColores.Blanco;
			break;
		case 'm':
			seleccion = tColores.Marron;
			break;
		case 'n':
			seleccion = tColores.Naranja;
			break;
		}
		return seleccion;
	}

	/**
	 * Este metodo se encarga de asignarle un numero a cada color para generarlos
	 * aleatoriamente en otro metodo
	 * 
	 * @param _numero
	 * @return
	 */
	private tColores intToColor(int _numero) {
		tColores posicion = null;
		switch (_numero) {
		case 0:
			posicion = tColores.Rojo;
			break;
		case 1:
			posicion = tColores.Verde;
			break;
		case 2:
			posicion = tColores.Azul;
			break;
		case 3:
			posicion = tColores.Dorado;
			break;
		case 4:
			posicion = tColores.Blanco;
			break;
		case 5:
			posicion = tColores.Marron;
			break;
		case 6:
			posicion = tColores.Naranja;
			break;

		}
		return posicion;
	}

	/**
	 * Este metodo se encarga de comprobar si te quedan pistas o no
	 *
	 * @param _index
	 * @return
	 */

	public boolean usarAyuda(int _index) {
		if (ayuda > 0) {
			/*
			 * System.out.println(secuenciaColores[_index]);
			 */
			return true;

		} else {
			return false;
		}
	}

	/**
	 * Este metodo se encarga de generar una secuencia aleatoria de colores del
	 * array
	 * 
	 * @param _NumColores
	 */
	public void generarSecuencia(int _NumColores) {
		for (int i = 0; i < secuenciaColores.length; i++) {
			Random aleatorio = new Random();
			int random = aleatorio.nextInt(0, _NumColores);
			secuenciaColores[i] = intToColor(random);
		}
	}

	/**
	 * Este metodo se encarga de comprobar si la secuencia de colores generada
	 * aleatoriamente y la dicha por el jugador es la misma
	 * 
	 * @param _index
	 * @param _color
	 * @return
	 */
	public boolean comprobarColor(int _index, tColores _color) {
		return secuenciaColores[_index] == _color;
	}

	/**
	 * Este metodo muestra el una parte del array generado
	 * 
	 * @param _numero
	 */
	public void mostrarSecuencia(int _numero) {
		for (int i = 0; i < _numero; i++) {
			System.out.println(secuenciaColores[i] + " ");
		}
	}

	/**
	 * Este metodod se encarga de igualar la puntuacion a 0 si es negativa
	 */
	public void puntuacion() {
		if (puntuacionFinal < 0) {
			this.puntuacionFinal = 0;
		}
		jugador puntaje = new jugador(null, puntuacionFinal);
		puntaje.mostrarjugador();
	}

	/**
	 * Este metodo se encarga de generar el menu del juego
	 */
	public void menu() {
		System.out.println("Ingrese el número para realizar una de las siguientes opciones:");
		System.out.println();
		System.out.println("1: Dejar de jugar");
		System.out.println();
		System.out.println("2: Empezar a jugar modo facil");
		System.out.println();
		System.out.println("3: Empezar a jugar modo dificil");
		System.out.println();
		System.out.println("4: Puntuación");
		System.out.println();
		System.out.println("5: Mostrar jugadores");
		System.out.println();
		System.out.println("6: Mostrar mejores jugadores");
	}

	/**
	 * Este metodo es el que se ejecuta primero al iniciar el juego
	 * @throws IOException 
	 */
	public void start() throws IOException {
		Record record = new Record();
		
		record.cargarRanking();
		
		nombre = new Scanner(System.in);

		System.out.println();
		System.out.println("Welcome to Simon dice!");

		System.out.println("Introduzca su nombre");
		String nombreJugador = nombre.nextLine();
		jugador name = new jugador(nombreJugador, puntuacionFinal);
		record.agregarJugador(name);

		System.out.print("Bienvenido ");
		System.out.print(nombreJugador);
		System.out.print(", Buena suerte");
		System.out.println();
		int n = 0;

		while(n == 0) {
			menu();
			Scanner sc1 = new Scanner(System.in);
			int menu = sc1.nextInt();
			if (menu == 1) {
				System.out.println("Adios");
				n = 1;
			} else if (menu == 2) {
				generarSecuencia(MAX_COLORES_FACIL);
				this.dificultad = 1;
				play(tModo.Facil);
				System.out.println("Has sacado " + puntuacionFinal + " puntos");
				if(puntuacionFinal > name.getPuntuacion()) {
					name.setPuntuacion(puntuacionFinal);
				}
			} else if (menu == 3) {
				generarSecuencia(MAX_COLORES_DIFICIL);
				this.dificultad = 2;
				play(tModo.Dificil);
				System.out.println("Has sacado " + puntuacionFinal + " puntos");
				if(puntuacionFinal > name.getPuntuacion()) {
					name.setPuntuacion(puntuacionFinal);
				}
			} else if (menu == 4) {
				puntuacion();
			}else if (menu == 5) {
				record.mostrarRanking();
			}else if (menu == 6) {
				record.mostrarMejoresRanking();
			} else if (menu != 1 || menu != 2 || menu != 3 || menu != 4 || menu != 5 || menu != 6) {
				System.out.println("Opción no válida");
				System.out.println();
			}
		}
	}

	/**
	 * Este metodo se encarga de ejecutar el juego correctamente
	 */
	public int play(tModo _modos) {
		this.puntuacion = 0;
		this.puntuacionFinal = 0;
		this.ayuda = 3;

		int i = 0;
		int finComprobar = 0;
		while (i < MAX_COLORES_SEC && finComprobar == 0) {

			System.out.println("Pulse ENTER para combrobar su capacidad de memoria");

			Scanner sc3 = new Scanner(System.in);
			String ENTER2 = sc3.nextLine();

			mostrarSecuencia(3 + i);

			/* Limpia la pantalla */
			if (ENTER2.isEmpty()) {

				new Scanner(System.in).nextLine();

				int limpiar = 50;

				for (int i1 = 0; i1 <= limpiar; i1++) {
					System.out.println();
				}

				System.out.println();

				int quesecuencia = i + 1;

				System.out.println("¿Cuál era la secuencia de colores de la secuencia " + quesecuencia + "?");

			}
			// Esta parte del codigo se encarga de decidir que hacer dependiendo de
			// si se ha acertado el resultado, se ha fallado o se ha terminado el
			// juego
			int n = 0;
			do {
				char secuenciaUsuario = new Scanner(System.in).next().charAt(0);
				tColores colorElejido = charToColor(secuenciaUsuario);

				if (comprobarColor(n, colorElejido)) {
					System.out.println("Acertaste, te quedan " + ayuda + " ayudas");
					this.puntuacion = puntuacion + 2;

				} else if ((secuenciaUsuario == 'x' || secuenciaUsuario == 'X') && usarAyuda(ayuda) == true) {
					ayuda--;
					System.out.println("Acertaste, te quedan " + ayuda + " ayudas");
					usarAyuda(i);
					this.puntuacion = puntuacion - 6;

				} else if (!comprobarColor(n, colorElejido) || usarAyuda(ayuda) == false) {
					System.out.println("Fallaste, fin del juego");
					this.puntuacionFinal = puntuacion;
					finComprobar = 1;
				}
				n++;
			} while (n < 3 + i && finComprobar == 0);
			
			if(i > (i - 1)) {
				this.puntuacion = puntuacion + 5;
			}
			
			int fin = 0;
			while (i >= MAX_COLORES_SEC - 3 && fin == 0) {
				System.out.println("Terminaste el juego");
				fin = 1;
				this.puntuacion = puntuacion + 15;
				this.puntuacionFinal = puntuacion;
				if (dificultad == 2) {
					this.puntuacionFinal = puntuacionFinal * 2;
				}
			}
			i++;
		}
		return puntuacionFinal;
	}
}
