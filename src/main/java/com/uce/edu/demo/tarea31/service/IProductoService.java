package com.uce.edu.demo.tarea31.service;

import com.uce.edu.demo.tarea31.repository.modelo.Producto;

public interface IProductoService {
	
	public void insertar(Producto producto);

	public void actualizar(Producto producto);

	public Producto buscar(String numero);

}
