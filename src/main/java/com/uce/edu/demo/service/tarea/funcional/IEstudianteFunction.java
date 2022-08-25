package com.uce.edu.demo.service.tarea.funcional;
@FunctionalInterface
public interface IEstudianteFunction<R,T> {
	
	public R aplicar(T arg1);

}
