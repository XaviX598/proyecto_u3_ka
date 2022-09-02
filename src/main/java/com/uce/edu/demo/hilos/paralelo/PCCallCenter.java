package com.uce.edu.demo.hilos.paralelo;

import java.util.concurrent.TimeUnit;

public class PCCallCenter extends Thread {

	private CallCenter asesor;

	public PCCallCenter(CallCenter asesor) {

		this.asesor = asesor;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		this.comunicar(this.asesor); 
	}

	public void comunicar(CallCenter asesor) {

		long tiempoInicial = System.currentTimeMillis();

		System.out.println("Numero de Hilo: " + Thread.currentThread().getName());
		System.out.println("Trabajador del callCenter comunicandose: " + asesor);

		for (String cliente : asesor.getNumerosLlamada()) {
			this.llamarCliente(cliente);
		}
		long tiempoFinal = System.currentTimeMillis();

		long tiempoTranscurrido = (tiempoFinal - tiempoInicial) / 1000;

		System.out.println("Termino: " + asesor.getNombre() + " en " + tiempoTranscurrido + " seg");
	}

	private void llamarCliente(String cliente) {
		System.out.println("Atendiendo a: " + cliente);
		
		try {
			TimeUnit.SECONDS.sleep(7);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
