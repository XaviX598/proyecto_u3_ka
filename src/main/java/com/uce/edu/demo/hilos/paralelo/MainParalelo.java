package com.uce.edu.demo.hilos.paralelo;

import java.util.Arrays;

public class MainParalelo {

	public static void main(String[] args) {

		long tiempoInicial = System.currentTimeMillis(); // tiempo en milisegundos

		System.out.println("Nombre Hilo: " + Thread.currentThread().getName());

		CajeroParalelo cajero1 = new CajeroParalelo("Xavier", Arrays.asList("Pepito"));
		CajeroParalelo cajero2 = new CajeroParalelo("Pedro", Arrays.asList("Pepit2"));
		CajeroParalelo cajero3 = new CajeroParalelo("Luis", Arrays.asList("Pepit3"));
		CajeroParalelo cajero4 = new CajeroParalelo("Luis", Arrays.asList("Juan"));
		CajeroParalelo cajero5 = new CajeroParalelo("Luis", Arrays.asList("Juan2"));
		CajeroParalelo cajero6 = new CajeroParalelo("Luis", Arrays.asList("Juan3"));
		

		PCCajeroParalelo gestorAtencion = new PCCajeroParalelo(cajero1);
		gestorAtencion.start(); // este metodo por dentro llama al run

		PCCajeroParalelo gestorAtencion2 = new PCCajeroParalelo(cajero2);
		gestorAtencion2.start();

		PCCajeroParalelo gestorAtencion3 = new PCCajeroParalelo(cajero3);
		gestorAtencion3.start();
		
		PCCajeroParalelo gestorAtencion4 = new PCCajeroParalelo(cajero4);
		gestorAtencion4.start(); // este metodo por dentro llama al run

		PCCajeroParalelo gestorAtencion5 = new PCCajeroParalelo(cajero5);
		gestorAtencion5.start();

		PCCajeroParalelo gestorAtencion6 = new PCCajeroParalelo(cajero6);
		gestorAtencion6.start();

		long tiempoFinal = System.currentTimeMillis(); // tiempo en milisegundos

		long tiempoTranscurrido = (tiempoFinal - tiempoInicial) / 1000;

		System.out.println(tiempoTranscurrido + "seg");

	}

}
