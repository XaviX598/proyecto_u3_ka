package com.uce.edu.demo.repository;

import com.uce.edu.demo.repository.modelo.Producto;

public interface IProductoRepository {

	public void insertar(Producto producto);

	public void actualizar(Producto producto);

	public void eliminar(Integer id);

	public Producto buscar(Integer id);

	public Producto buscarCodigo(String codigo);

}
