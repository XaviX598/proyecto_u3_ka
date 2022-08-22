package com.uce.edu.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.repository.IClienteRepository;
import com.uce.edu.demo.repository.modelo.Cliente;

@Service
public class ClienteServiceImpl implements IClienteService{
	
	@Autowired
	private IClienteRepository iClienteRepository;

	@Override
	public void insertar(Cliente cliente) {
		// TODO Auto-generated method stub
		this.iClienteRepository.insertar(cliente);
	}

	@Override
	public void actualizar(Cliente cliente) {
		// TODO Auto-generated method stub
		this.iClienteRepository.actualizar(cliente);
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		this.iClienteRepository.eliminar(id);
	}

	@Override
	public Cliente buscar(Integer id) {
		// TODO Auto-generated method stub
		return this.iClienteRepository.buscar(id);
	}

	@Override
	public Cliente buscarCedula(String cedula) {
		// TODO Auto-generated method stub
		return this.iClienteRepository.buscarCedula(cedula);
	}

}
