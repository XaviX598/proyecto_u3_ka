package com.uce.edu.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.repository.modelo.DetalleFactura;

@Service
public class DetalleFacturaServiceImpl implements IDetalleFacturaservice{

	@Autowired
	private IDetalleFacturaservice iDetalleFacturaservice;
	@Override
	public void insertar(DetalleFactura detalleFactura) {
		// TODO Auto-generated method stub
		this.iDetalleFacturaservice.insertar(detalleFactura);
	}

	@Override
	public void actualizar(DetalleFactura detalleFactura) {
		// TODO Auto-generated method stub
		this.iDetalleFacturaservice.actualizar(detalleFactura);
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		this.iDetalleFacturaservice.eliminar(id);
	}

	@Override
	public DetalleFactura buscar(Integer id) {
		// TODO Auto-generated method stub
		return this.iDetalleFacturaservice.buscar(id);
	}

}
