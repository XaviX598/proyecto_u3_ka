package com.uce.edu.demo.hilos.paralelo;

import java.util.List;

public class CallCenter {

	private String nombre;

	private List<String> numerosLlamada;

	public CallCenter(String nombre, List<String> numerosLlamada) {

		this.nombre = nombre;
		this.numerosLlamada = numerosLlamada;
	}

	@Override
	public String toString() {
		return "CallCenter [nombre=" + nombre + ", numerosLlamada=" + numerosLlamada + "]";
	}

	//get y set
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<String> getNumerosLlamada() {
		return numerosLlamada;
	}

	public void setNumerosLlamada(List<String> numerosLlamada) {
		this.numerosLlamada = numerosLlamada;
	}

}
