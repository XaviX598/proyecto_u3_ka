package com.uce.edu.demo.hilos.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

public class MainStream {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long tiempoInicial = System.currentTimeMillis(); // tiempo en milisegundos
		List<Integer> listaNumerosAlumnos = new ArrayList<Integer>();
		for (int i = 1; i < 5000; i++) {
			listaNumerosAlumnos.add(i);
		}
		// .map decuelve un function
		// collect convertir a una lista y en argumentos se envian collector. tolist
		List<String> listaProcesada = listaNumerosAlumnos.stream().map(numero -> convertirIdAlumno(numero))
				.collect(Collectors.toList());
		listaProcesada.forEach(cadena -> System.out.println(cadena));
		
		long tiempoFinal = System.currentTimeMillis(); // tiempo en milisegundos

		long tiempoTranscurrido = (tiempoFinal - tiempoInicial) / 1000;

		System.out.println(tiempoTranscurrido + "seg");
	}

	private static String convertirIdAlumno(Integer id) {
		try {
			TimeUnit.MILLISECONDS.sleep(10);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "ID: " + id.toString();
	}

}
