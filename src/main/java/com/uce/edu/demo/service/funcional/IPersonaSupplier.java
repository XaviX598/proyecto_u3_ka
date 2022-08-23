package com.uce.edu.demo.service.funcional;
@FunctionalInterface
public interface IPersonaSupplier<T> {
	//como no conocemos el tipo debemos poner el T en la clase ya que es un tipo generico
	//get simpre en supplier
	public T getNombre();

}
