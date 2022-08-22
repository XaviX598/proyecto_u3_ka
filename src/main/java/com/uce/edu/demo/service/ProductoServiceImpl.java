package com.uce.edu.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.repository.IProductoRepository;
import com.uce.edu.demo.repository.modelo.Producto;

@Service
public class ProductoServiceImpl implements IProductoService{

	@Autowired
	private IProductoRepository iProductoRepository;
	@Override
	public void insertar(Producto producto) {
		// TODO Auto-generated method stub
		this.iProductoRepository.insertar(producto);
	}

	@Override
	public void actualizar(Producto producto) {
		// TODO Auto-generated method stub
		this.iProductoRepository.actualizar(producto);
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		this.iProductoRepository.eliminar(id);
	}

	@Override
	public Producto buscar(Integer id) {
		// TODO Auto-generated method stub
		return this.iProductoRepository.buscar(id);
	}

	@Override
	public Producto buscarCodigo(String codigo) {
		// TODO Auto-generated method stub
		return this.iProductoRepository.buscarCodigo(codigo);
	}

}
