package com.uce.edu.demo.hilos.paralelo;

import java.util.concurrent.TimeUnit;

import com.uce.edu.demo.hilos.tradicional.Cajero;

//La clase que querems paralelizar debe extender Thread
public class PCCajeroParalelo extends Thread{
	
	//cuando extendemos de un thread siempre debemos sobresscribir el metodo run
	//El Metodo Run es el que debe lanzar el metodo a paralelilzar
	
	private CajeroParalelo cajero; //debemos instanciar la variable necesaria
	
	//para enviar algo se hace en el constructor
	public PCCajeroParalelo(CajeroParalelo cajero) { //en el constructor recibimos los parametros si necesitamos en este caso si recibe cajero
		// TODO Auto-generated constructor stub
		this.cajero=cajero;
	}
	
	//cuando modificamos la firma (recibe algo) ya no se usa override porque no hay sobreescritua
	@Override
	public void run() {
		// TODO Auto-generated method stub
		this.procesar(this.cajero); //metodo a procesar
	}
	
	public void procesar(CajeroParalelo cajero) {
		long tiempoInicial = System.currentTimeMillis();
		System.out.println("Nombre Hilo procesar: " + Thread.currentThread().getName()); 
		System.out.println("Procesando cajero: " + cajero);
		
		for(String cliente : cajero.getClientes()) {
		this.atenderCliente(cliente);	
		}
		long tiempoFinal = System.currentTimeMillis(); // tiempo en milisegundos

		long tiempoTranscurrido = (tiempoFinal - tiempoInicial) / 1000;

		

		System.out.println("Termino: " + cajero.getNombre() + " en " + tiempoTranscurrido + " seg");
	}
	
	private void atenderCliente(String cliente) {
		System.out.println("Atendiendo a: "+  cliente);
		//mandamos a dormir (demoramos el hilo o metodo 10 segundos
		try {
			TimeUnit.SECONDS.sleep(5);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
