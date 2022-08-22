package com.uce.edu.demo.repository;

import com.uce.edu.demo.repository.modelo.DetalleFactura;

public interface IDetalleFacturaRepository {

	public void insertar(DetalleFactura detalleFactura);

	public void actualizar(DetalleFactura detalleFactura);

	public void eliminar(Integer id);

	public DetalleFactura buscar(Integer id);

	

}
