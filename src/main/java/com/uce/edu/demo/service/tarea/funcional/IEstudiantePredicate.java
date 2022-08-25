package com.uce.edu.demo.service.tarea.funcional;
@FunctionalInterface
public interface IEstudiantePredicate<T> {
	
	public boolean evaluar(T arg1);

}
