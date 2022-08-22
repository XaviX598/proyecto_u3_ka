package com.uce.edu.demo.service;

import com.uce.edu.demo.repository.modelo.DetalleFactura;

public interface IDetalleFacturaservice {

	
	public void insertar(DetalleFactura detalleFactura);

	public void actualizar(DetalleFactura detalleFactura);

	public void eliminar(Integer id);

	public DetalleFactura buscar(Integer id);
}
