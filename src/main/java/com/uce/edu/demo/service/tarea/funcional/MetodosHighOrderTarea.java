package com.uce.edu.demo.service.tarea.funcional;

public class MetodosHighOrderTarea {
	
	public String consumirSupplier(IEstudianteSupplier<String> funcion) {
		
		return funcion.getNombre() + " Se proceso el dato";
	}

	public void consumirConsumer(IEstudianteConsumer<Integer> funcion, Integer valor) {
		funcion.accept(valor);

	}

	public boolean consumirPredicate(IEstudiantePredicate<String> funcion, String valor) {
		return funcion.evaluar(valor);
	}

	public String consumirFunction(IEstudianteFunction<String, Integer> funcion, Integer valor) {
		return funcion.aplicar(valor) + " Se proceso el dato";
	}

}
