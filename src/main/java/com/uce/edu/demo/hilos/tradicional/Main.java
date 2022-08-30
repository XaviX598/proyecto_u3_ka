package com.uce.edu.demo.hilos.tradicional;

import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		long tiempoInicial = System.currentTimeMillis(); //tiempo en milisegundos 

		Cajero cajero1 = new Cajero("Xavier", Arrays.asList("Pepito","Juan","Daniela","Pedro"));
		Cajero cajero2 = new Cajero("Pedro", Arrays.asList("Pepit2","Juan2","Daniela2"));
		Cajero cajero3 = new Cajero("Luis", Arrays.asList("Pepit3","Juan3"));
		
		PCCajero gestorAtencion = new PCCajero();
		gestorAtencion.procesar(cajero1);
		gestorAtencion.procesar(cajero2);
		gestorAtencion.procesar(cajero3);
		
		long tiempoFinal = System.currentTimeMillis(); //tiempo en milisegundos
		
		long tiempoTranscurrido = (tiempoFinal-tiempoInicial)/1000;
		
		System.out.println(tiempoTranscurrido + "seg");
	}

}
