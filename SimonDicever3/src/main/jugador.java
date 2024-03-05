package main;

import java.util.Scanner;

/*
 * Esta es la clase engine de mi programa en la cual se almacena toda la información
 * relacionada con los jugadores
 */

public class jugador {

	private String nombre;
	public int puntuacion;

	/**
	 * Este metodo devuelve el nombre del jugador
	 * 
	 * @return
	 */
	public String getNombre() {
		return this.nombre;
	}

	/**
	 * Este metodo registra la puntuación
	 * 
	 * @return
	 */
	public int getPuntuacion() {
		return this.puntuacion;
	}
	
	public void setPuntuacion(int puntuacion) {
		this.puntuacion = puntuacion;
	}

	/**
	 * Este metodo registra el nombre del jugador
	 * @param nombre
	 */
	public jugador(String nombre) {
		this.nombre = nombre;
		this.puntuacion = 0;
	}

	/**
	 * Este metodo registra la puntuación del jugador
	 * 
	 * @param nombre
	 */

	public jugador(String nombre, int puntuacion) {
		this.nombre = nombre;
		this.puntuacion = puntuacion;
	}

	/**
	 * Este metodo devuelve y muestra la información del jugador
	 */
	public void mostrarjugador() {
		System.out.println("Tu puntuación es de " + this.puntuacion);
	}
}